package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.enums.Cor;
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
	
	private void iniciarPartidaDeXadrezColocandoPecasNoTabuleiro() {
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCA), new Posicao(2, 1));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETA), new Posicao(0, 4));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRANCA), new Posicao(7, 4));
	}
	
}
