package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PecaDeXadrez;
import xadrez.enums.Cor;

public class Bispo extends PecaDeXadrez {

	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] posicoesPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao posicaoAuxiliar = new Posicao(0, 0);

		// diagonal noroeste
		posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setValores(posicaoAuxiliar.getLinha() -1, posicaoAuxiliar.getColuna() - 1);
		}
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		// diagonal nordeste
		posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setValores(posicaoAuxiliar.getLinha() -1, posicaoAuxiliar.getColuna() + 1);
		}
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// diagonal sudeste
		posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setValores(posicaoAuxiliar.getLinha() + 1, posicaoAuxiliar.getColuna() + 1);
		}
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// diagonal sudoeste
		posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setValores(posicaoAuxiliar.getLinha() + 1, posicaoAuxiliar.getColuna() - 1);
		}
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		return posicoesPossiveis;
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
