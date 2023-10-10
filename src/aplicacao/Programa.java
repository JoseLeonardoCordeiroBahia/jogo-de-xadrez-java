package aplicacao;

import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDeXadrez;

public class Programa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		
		while (true) {
			Tela.imprimirTabuleiro(partidaDeXadrez.getPecasDeXadrezDaPartida());
			
			System.out.println();
			
			System.out.print("Posição de origem: ");
			PosicaoDeXadrez posicaoDeOrigem = Tela.lerPosicaoDeXadrez(scanner);
			
			System.out.println();
			
			System.out.print("Posição de destino: ");
			PosicaoDeXadrez posicaoDeDestino = Tela.lerPosicaoDeXadrez(scanner);
			
			PecaDeXadrez pecaCapturada = partidaDeXadrez.executarMovimento(posicaoDeOrigem, posicaoDeDestino);
		}
	}
	
}
