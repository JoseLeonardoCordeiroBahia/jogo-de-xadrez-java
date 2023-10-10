package xadrez.pecas;

import tabuleiro.Tabuleiro;
import xadrez.PecaDeXadrez;
import xadrez.enums.Cor;

public class Torre extends PecaDeXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}
	
}
