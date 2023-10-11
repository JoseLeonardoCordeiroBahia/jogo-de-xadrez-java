package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PecaDeXadrez;
import xadrez.enums.Cor;

public class Rei extends PecaDeXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
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
		
		return posicoesPossiveis;
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
