package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PecaDeXadrez;
import xadrez.enums.Cor;

public class Peao extends PecaDeXadrez {

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
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
		}
		
		return posicoesPossiveis;
	}
	
	@Override
	public String toString() {
		return "P";
	}
	
}
