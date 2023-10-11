package xadrez.enums;

public enum Cor {
	
	PRETA("Preta"),
	BRANCA("Branca");
	
	private String descricao;
	
	private Cor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
