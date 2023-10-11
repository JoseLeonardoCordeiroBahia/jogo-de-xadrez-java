package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDeXadrez;
import xadrez.exception.XadrezException;

public class Programa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();

		while (true) {
			try {
				Tela.limparTela();
				Tela.imprimirTabuleiro(partidaDeXadrez.getPecasDeXadrezDaPartida());

				System.out.println();

				System.out.print("Posição de origem: ");
				PosicaoDeXadrez posicaoDeOrigem = Tela.lerPosicaoDeXadrez(scanner);
				
				boolean[][] movimentosPossiveis = partidaDeXadrez.movimentosPossiveis(posicaoDeOrigem);
				
				Tela.limparTela();
				Tela.imprimirTabuleiro(partidaDeXadrez.getPecasDeXadrezDaPartida(), movimentosPossiveis);

				System.out.println();

				System.out.print("Posição de destino: ");
				PosicaoDeXadrez posicaoDeDestino = Tela.lerPosicaoDeXadrez(scanner);

				PecaDeXadrez pecaCapturada = partidaDeXadrez.executarMovimento(posicaoDeOrigem, posicaoDeDestino);
			} catch (XadrezException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}
	}

}
