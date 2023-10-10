package aplicacao;

import xadrez.PartidaDeXadrez;

public class Programa {

	public static void main(String[] args) {
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		Tela.imprimirTabuleiro(partidaDeXadrez.getPecasDeXadrezDaPartida());
	}
	
}
