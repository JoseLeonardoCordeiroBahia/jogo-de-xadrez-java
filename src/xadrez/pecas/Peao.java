package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.enums.Cor;

public class Peao extends PecaDeXadrez {

	private PartidaDeXadrez partidaDeXadrez;

	public Peao(Tabuleiro tabuleiro, Cor cor, PartidaDeXadrez partidaDeXadrez) {
		super(tabuleiro, cor);
		this.partidaDeXadrez = partidaDeXadrez;
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] posicoesPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao posicaoAuxiliar = new Posicao(0, 0);

		if (getCor() == Cor.BRANCA) {
			posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna());

			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
				posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}

			posicaoAuxiliar.setValores(posicao.getLinha() - 2, posicao.getColuna());

			Posicao posicaoAuxiliar2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());

			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)
					&& getTabuleiro().posicaoExiste(posicaoAuxiliar2)
					&& !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar2) && getQuantidadeDeMovimentos() == 0) {
				posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}

			posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);

			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
				posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}

			posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);

			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
				posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}

			// #jogadaespecial en passant peça branca
			if (posicao.getLinha() == 3) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				
				if (getTabuleiro().posicaoExiste(esquerda) && existePecaDoOponente(esquerda)
						&& getTabuleiro().peca(esquerda) == partidaDeXadrez.getVulneravelAoEnPassant()) {
					posicoesPossiveis[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
				}
				
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				
				if (getTabuleiro().posicaoExiste(direita) && existePecaDoOponente(direita)
						&& getTabuleiro().peca(direita) == partidaDeXadrez.getVulneravelAoEnPassant()) {
					posicoesPossiveis[direita.getLinha() - 1][direita.getColuna()] = true;
				}
			}
		} else {
			posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna());

			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)) {
				posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}

			posicaoAuxiliar.setValores(posicao.getLinha() + 2, posicao.getColuna());

			Posicao posicaoAuxiliar2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());

			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar)
					&& getTabuleiro().posicaoExiste(posicaoAuxiliar2)
					&& !getTabuleiro().existePecaNaPosicao(posicaoAuxiliar2) && getQuantidadeDeMovimentos() == 0) {
				posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}

			posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);

			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
				posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}

			posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);

			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && existePecaDoOponente(posicaoAuxiliar)) {
				posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}

			// #jogadaespecial en passant peça preta
			if (posicao.getLinha() == 4) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				
				if (getTabuleiro().posicaoExiste(esquerda) && existePecaDoOponente(esquerda)
						&& getTabuleiro().peca(esquerda) == partidaDeXadrez.getVulneravelAoEnPassant()) {
					posicoesPossiveis[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
				}
				
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				
				if (getTabuleiro().posicaoExiste(direita) && existePecaDoOponente(direita)
						&& getTabuleiro().peca(direita) == partidaDeXadrez.getVulneravelAoEnPassant()) {
					posicoesPossiveis[direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}
		}

		return posicoesPossiveis;
	}

	@Override
	public String toString() {
		return "P";
	}

}
