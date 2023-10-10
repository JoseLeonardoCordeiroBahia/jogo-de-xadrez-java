package xadrez.pecas;

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
		
		return posicoesPossiveis;
	}
	
	@Override
	public String toString() {
		return "R";
	}

}
