package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.enums.Cor;
import xadrez.exception.XadrezException;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Peao;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	private boolean xeque;
	private boolean xequeMate;
	
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.BRANCA;
		iniciarPartidaDeXadrezColocandoPecasNoTabuleiro();
	}
	
	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}
	
	public boolean isXeque() {
		return xeque;
	}
	
	public boolean isXequeMate() {
		return xequeMate;
	}

	public PecaDeXadrez[][] getPecasDeXadrezDaPartida() {
		PecaDeXadrez[][] pecasDeXadrez = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				pecasDeXadrez[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		
		return pecasDeXadrez;
	}
	
	public boolean[][] movimentosPossiveis(PosicaoDeXadrez posicaoDeOrigem) {
		Posicao posicao = posicaoDeOrigem.paraPosicao();
		
		validarPosicaoDeOrigem(posicao);
		
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}
	
	public PecaDeXadrez executarMovimento(PosicaoDeXadrez posicaoDeOrigem, PosicaoDeXadrez posicaoDeDestino) {
		Posicao origem = posicaoDeOrigem.paraPosicao();
		Posicao destino = posicaoDeDestino.paraPosicao();
		
		validarPosicaoDeOrigem(origem);
		
		validarPosicaoDeDestino(origem, destino);
		
		Peca pecaCapturada = fazerMovimento(origem, destino);
		
		if (testarXeque(jogadorAtual)) {
			desfazerMovimento(origem, destino, pecaCapturada);
			
			throw new XadrezException("Você não pode se colocar em xeque");
		}
		
		xeque = (testarXeque(oponente(jogadorAtual))) ? true : false;
		
		if (testarXequeMate(oponente(jogadorAtual))) {
			xequeMate = true;
		} else {
			trocarDeJogador();
		}
		
		return (PecaDeXadrez) pecaCapturada;
	}

	private Peca fazerMovimento(Posicao posicaoDeOrigem, Posicao posicaoDeDestino) {
		PecaDeXadrez peca = (PecaDeXadrez) tabuleiro.retirarPeca(posicaoDeOrigem);
		peca.incrementarQuantidadeDeMovimentos();
		
		Peca pecaCapturada = tabuleiro.retirarPeca(posicaoDeDestino);
		
		tabuleiro.colocarPeca(peca, posicaoDeDestino);
		
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		return pecaCapturada;
	}
	
	private void desfazerMovimento(Posicao posicaoDeOrigem, Posicao posicaoDeDestino, Peca pecaCapturada) {
		PecaDeXadrez peca = (PecaDeXadrez) tabuleiro.retirarPeca(posicaoDeDestino);
		peca.decrementarQuantidadeDeMovimentos();
		
		tabuleiro.colocarPeca(peca, posicaoDeOrigem);
		
		if (pecaCapturada != null) {
			tabuleiro.colocarPeca(pecaCapturada, posicaoDeDestino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}
	}
	
	private void validarPosicaoDeOrigem(Posicao posicaoDeOrigem) {
		if (!tabuleiro.existePecaNaPosicao(posicaoDeOrigem)) {
			throw new XadrezException("Não existe peça na posição de origem");
		}
		
		if (jogadorAtual != ((PecaDeXadrez) tabuleiro.peca(posicaoDeOrigem)).getCor()) {
			throw new XadrezException("A peça escolhida não é sua");
		}
		
		if (!tabuleiro.peca(posicaoDeOrigem).existeAlgumMovimentoPossivel()) {
			throw new XadrezException("Não existe movimentos possíveis para a peça escolhida");
		}
	}
	
	private void validarPosicaoDeDestino(Posicao posicaoDeOrigem, Posicao posicaoDeDestino) {
		if (!tabuleiro.peca(posicaoDeOrigem).movimentoPossivel(posicaoDeDestino)) {
			throw new XadrezException("A peça escolhida não pode se mover para a posição de destino");
		}
	}
	
	private void trocarDeJogador() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
	}
	
	private Cor oponente(Cor cor) {
		return (cor == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
	}
	
	private PecaDeXadrez rei(Cor cor) {
		List<Peca> todasPecasDaMesmaCor = pecasNoTabuleiro.stream()
				.filter(peca -> ((PecaDeXadrez) peca).getCor() == cor)
				.collect(Collectors.toList());
		
		for (Peca peca : todasPecasDaMesmaCor) {
			if (peca instanceof Rei) {
				return (PecaDeXadrez) peca;
			}
		}
		
		throw new IllegalStateException("Não existe rei da cor " + cor + "no tabuleiro");
	}
	
	private boolean testarXeque(Cor cor) {
		Posicao posicaoDoRei = rei(cor).getPosicaoDeXadrez().paraPosicao();
		
		List<Peca> pecasDoOponente = pecasNoTabuleiro.stream()
				.filter(peca -> ((PecaDeXadrez) peca).getCor() == oponente(cor))
				.collect(Collectors.toList());
		
		for (Peca peca : pecasDoOponente) {
			boolean[][] movimentosPossiveis = peca.movimentosPossiveis();
			
			if (movimentosPossiveis[posicaoDoRei.getLinha()][posicaoDoRei.getColuna()]) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean testarXequeMate(Cor cor) {
		if (!testarXeque(cor)) {
			return false;
		}
		
		List<Peca> todasPecasDaMesmaCor = pecasNoTabuleiro.stream()
				.filter(peca -> ((PecaDeXadrez) peca).getCor() == cor)
				.collect(Collectors.toList());
		
		for (Peca peca : todasPecasDaMesmaCor) {
			boolean[][] movimentosPossiveis = peca.movimentosPossiveis();
			
			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getColunas(); j++) {
					if (movimentosPossiveis[i][j]) {
						Posicao posicaoDeOrigem = ((PecaDeXadrez) peca).getPosicaoDeXadrez().paraPosicao();
						Posicao posicaoDeDestino = new Posicao(i, j);
						Peca pecaCapturada = fazerMovimento(posicaoDeOrigem, posicaoDeDestino);
						boolean testarXeque = testarXeque(cor);
						
						desfazerMovimento(posicaoDeOrigem, posicaoDeDestino, pecaCapturada);
						
						if (!testarXeque) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez pecaDeXadrez) {
		tabuleiro.colocarPeca(pecaDeXadrez, new PosicaoDeXadrez(coluna, linha).paraPosicao());
		pecasNoTabuleiro.add(pecaDeXadrez);
	}
	
	private void iniciarPartidaDeXadrezColocandoPecasNoTabuleiro() {
		colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('a', 2, new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('b', 2, new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('c', 2, new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('d', 2, new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('e', 2, new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('f', 2, new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('g', 2, new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('h', 2, new Peao(tabuleiro, Cor.BRANCA));

        colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETA));
        colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('a', 7, new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('b', 7, new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('c', 7, new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('d', 7, new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('e', 7, new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('f', 7, new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('g', 7, new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('h', 7, new Peao(tabuleiro, Cor.PRETA));
	}
	
}
