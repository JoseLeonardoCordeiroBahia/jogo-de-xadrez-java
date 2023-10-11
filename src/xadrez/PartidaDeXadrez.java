package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.enums.Cor;
import xadrez.exception.XadrezException;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciarPartidaDeXadrezColocandoPecasNoTabuleiro();
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
		
		return (PecaDeXadrez) pecaCapturada;
	}

	private Peca fazerMovimento(Posicao posicaoDeOrigem, Posicao posicaoDeDestino) {
		Peca peca = tabuleiro.retirarPeca(posicaoDeOrigem);
		Peca pecaCapturada = tabuleiro.retirarPeca(posicaoDeDestino);
		
		tabuleiro.colocarPeca(peca, posicaoDeDestino);
		
		return pecaCapturada;
	}
	
	private void validarPosicaoDeOrigem(Posicao posicaoDeOrigem) {
		if (!tabuleiro.existePecaNaPosicao(posicaoDeOrigem)) {
			throw new XadrezException("Não existe peça na posição de origem");
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
	
	private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez pecaDeXadrez) {
		tabuleiro.colocarPeca(pecaDeXadrez, new PosicaoDeXadrez(coluna, linha).paraPosicao());
	}
	
	private void iniciarPartidaDeXadrezColocandoPecasNoTabuleiro() {
		colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCA));

		colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETA));
	}
	
}
