package tabuleiro;

public abstract class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	
	public abstract boolean[][] movimentosPossiveis();
	
	public boolean movimentoPossivel(Posicao posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean existeAlgumMovimentoPossivel() {
		boolean[][] movimentosPossiveis = movimentosPossiveis();
		
		for (int i = 0; i < movimentosPossiveis.length; i++) {
			for (int j = 0; j < movimentosPossiveis.length; j++) {
				if (movimentosPossiveis[i][j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
