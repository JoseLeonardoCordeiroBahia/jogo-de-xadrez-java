package tabuleiro;

import tabuleiro.exception.TabuleiroException;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro ao criar tabuleiro: "
					+ "é necessário que haja pelo menos uma linha e uma coluna");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if (!existePosicao(linha, coluna)) {
			throw new TabuleiroException("Essa posição não existe no tabuleiro");
		}
		
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Essa posição não existe no tabuleiro");
		}
		
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void colocarPeca(Peca peca, Posicao posicao) {
		if (existePecaNaPosicao(posicao)) {
			throw new TabuleiroException("Já existe uma peça nessa posição " + posicao);
		}
		
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca retirarPeca(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Essa posição não existe no tabuleiro");
		}
		
		if (peca(posicao) == null) {
			return null;
		}
		
		Peca pecaParaSerRetirada = peca(posicao);
		pecaParaSerRetirada.posicao = null;
		
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		
		return pecaParaSerRetirada;
	}
	
	private boolean existePosicao(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean existePecaNaPosicao(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Essa posição não existe no tabuleiro");
		}
		
		return peca(posicao) != null;
	}
	
	
	
}
