package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.enums.Cor;

public abstract class PecaDeXadrez extends Peca {

	private Cor cor;
	private int quantidadeDeMovimentos;

	public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getQuantidadeDeMovimentos() {
		return quantidadeDeMovimentos;
	}
	
	public void incrementarQuantidadeDeMovimentos() {
		quantidadeDeMovimentos++;
	}
	
	public void decrementarQuantidadeDeMovimentos() {
		quantidadeDeMovimentos--;
	}
	
	public PosicaoDeXadrez getPosicaoDeXadrez() {
		return PosicaoDeXadrez.paraPosicaoDeXadrez(posicao);
	}
	
	protected boolean existePecaDoOponente(Posicao posicao) {
		PecaDeXadrez peca = (PecaDeXadrez) getTabuleiro().peca(posicao);
		
		return peca != null && peca.getCor() != cor;
	}

}
