package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.enums.Cor;

public class Rei extends PecaDeXadrez {

	private PartidaDeXadrez partidaDeXadrez;

	public Rei(Tabuleiro tabuleiro, Cor cor, PartidaDeXadrez partidaDeXadrez) {
		super(tabuleiro, cor);
		this.partidaDeXadrez = partidaDeXadrez;
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] posicoesPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao posicaoAuxiliar = new Posicao(0, 0);

		// acima
		posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna());

		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// abaixo
		posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna());

		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// esquerda
		posicaoAuxiliar.setValores(posicao.getLinha(), posicao.getColuna() - 1);

		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// direita
		posicaoAuxiliar.setValores(posicao.getLinha(), posicao.getColuna() + 1);

		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// diagonal noroeste
		posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);

		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// diagonal nordeste
		posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);

		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// diagonal sudoeste
		posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);

		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// diagonal sudeste
		posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);

		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// #jogadaespecial roque
		if (getQuantidadeDeMovimentos() == 0 && !partidaDeXadrez.isXeque()) {
			// #jogadaespecial roque pequeno
			Posicao posicaoDaTorre1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);
			
			if (testarSeTorreEstaAptoAoRoque(posicaoDaTorre1)) {
				Posicao posicao1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				Posicao posicao2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);
				
				if (getTabuleiro().peca(posicao1) == null && getTabuleiro().peca(posicao2) == null) {
					posicoesPossiveis[posicao.getLinha()][posicao.getColuna() + 2] = true;
				}
			}
			
			// #jogadaespecial roque grande
			Posicao posicaoDaTorre2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);
			if (testarSeTorreEstaAptoAoRoque(posicaoDaTorre2)) {
				Posicao posicao1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				Posicao posicao2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
				Posicao posicao3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);
				
				if (getTabuleiro().peca(posicao1) == null && getTabuleiro().peca(posicao2) == null 
						&& getTabuleiro().peca(posicao3) == null) {
					posicoesPossiveis[posicao.getLinha()][posicao.getColuna() - 2] = true;
				}
			}
		}
		
		return posicoesPossiveis;
	}

	private boolean testarSeTorreEstaAptoAoRoque(Posicao posicao) {
		PecaDeXadrez pecaDeXadrez = (PecaDeXadrez)getTabuleiro().peca(posicao);
		return pecaDeXadrez != null && pecaDeXadrez instanceof Torre 
				&& pecaDeXadrez.getCor() == getCor() 
				&& pecaDeXadrez.getQuantidadeDeMovimentos() == 0;
	}
	
	private boolean podeMover(Posicao posicao) {
		PecaDeXadrez peca = (PecaDeXadrez) getTabuleiro().peca(posicao);

		return !getTabuleiro().existePecaNaPosicao(posicao) || peca.getCor() != getCor();
	}
	
	@Override
	public String toString() {
		return "R";
	}

}
