package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PecaDeXadrez;
import xadrez.enums.Cor;

public class Cavalo extends PecaDeXadrez {

	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] posicoesPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao posicaoAuxiliar = new Posicao(0, 0);
		
		posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() - 2);
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValores(posicao.getLinha() - 2, posicao.getColuna() - 1);
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValores(posicao.getLinha() - 2, posicao.getColuna() + 1);
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() + 2);
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() + 2);
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValores(posicao.getLinha() + 2, posicao.getColuna() + 1);
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValores(posicao.getLinha() + 2, posicao.getColuna() - 1);
		
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			posicoesPossiveis[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() - 2);
		
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
		return "C";
	}

}
