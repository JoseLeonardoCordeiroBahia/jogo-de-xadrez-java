package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDeXadrez;
import xadrez.exception.XadrezException;

public class Programa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		List<PecaDeXadrez> pecasCapturadas = new ArrayList<>();

		while (!partidaDeXadrez.isXequeMate()) {
			try {
				Tela.limparTela();
				Tela.imprimirPartida(partidaDeXadrez, pecasCapturadas);

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
				
				if (pecaCapturada != null) {
					pecasCapturadas.add(pecaCapturada);
				}
				
				if (partidaDeXadrez.getPromocao() != null) {
					System.out.print("Insira a peça para pomoção (T/C/B/R): ");
					String tipo = scanner.nextLine();
					
					partidaDeXadrez.trocarPecaPromovida(tipo);
				}
				
			} catch (XadrezException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}
		
		Tela.limparTela();
		Tela.imprimirPartida(partidaDeXadrez, pecasCapturadas);
	}

}
