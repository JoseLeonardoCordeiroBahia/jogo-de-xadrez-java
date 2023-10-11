package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PecaDeXadrez;
import xadrez.enums.Cor;

public class Torre extends PecaDeXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] posicoesPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao posicaoAuxiliar = new Posicao(0, 0);

		// acima
		posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna());
		
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setLinha(posicaoAuxiliar.getLinha() - 1);
		}
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		// abaixo
		posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna());
		
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setLinha(posicaoAuxiliar.getLinha() + 1);
		}
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// esquerda
		posicaoAuxiliar.setValores(posicao.getLinha(), posicao.getColuna() - 1);
		
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setColuna(posicaoAuxiliar.getColuna() - 1);
		}
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// direita
		posicaoAuxiliar.setValores(posicao.getLinha(), posicao.getColuna() + 1);
		
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setColuna(posicaoAuxiliar.getColuna() + 1);
		}
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		return posicoesPossiveis;
	}

	@Override
	public String toString() {
		return "T";
	}

}
