package aplicacao;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDeXadrez;
import xadrez.enums.Cor;

public class Tela {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static PosicaoDeXadrez lerPosicaoDeXadrez(Scanner scanner) {
		try {
			String posicao = scanner.nextLine();
			char coluna = posicao.charAt(0);
			int linha = Integer.parseInt(posicao.substring(1));

			return new PosicaoDeXadrez(coluna, linha);
		} catch (RuntimeException e) {
			throw new InputMismatchException(
					"Erro ao lear a posição de xadrez. " + "Os valores válidos são de a1 até h8");
		}

	}

	public static void imprimirPartida(PartidaDeXadrez partidaDeXadrez, List<PecaDeXadrez> pecasCapturadas) {
		imprimirTabuleiro(partidaDeXadrez.getPecasDeXadrezDaPartida());

		System.out.println("");

		imprimirPecasCapturadas(pecasCapturadas);

		System.out.println();

		System.out.println("Turno: " + partidaDeXadrez.getTurno());

		if (!partidaDeXadrez.isXequeMate()) {
			System.out.println("Aguardando jogador da peça " + partidaDeXadrez.getJogadorAtual().getDescricao());

			if (partidaDeXadrez.isXeque()) {
				System.out.println(ANSI_RED + "Você está em XEQUE!" + ANSI_RESET);
			}
		} else {
			System.out.println(ANSI_RED + "XEQUE-MATE!" + ANSI_RESET);
			System.out.println("Vencedor: peça " + partidaDeXadrez.getJogadorAtual().getDescricao());
		}

	}

	public static void imprimirTabuleiro(PecaDeXadrez[][] pecasDeXadrez) {
		System.out.println("  a b c d e f g h");

		for (int i = 0; i < pecasDeXadrez.length; i++) {
			System.out.print((8 - i) + " ");

			for (int j = 0; j < pecasDeXadrez.length; j++) {
				imprimirPeca(pecasDeXadrez[i][j], false);
			}

			System.out.print((8 - i) + " ");

			System.out.println();
		}

		System.out.println("  a b c d e f g h");
	}

	public static void imprimirTabuleiro(PecaDeXadrez[][] pecasDeXadrez, boolean[][] movimentosPossiveis) {
		System.out.println("  a b c d e f g h");

		for (int i = 0; i < pecasDeXadrez.length; i++) {
			System.out.print((8 - i) + " ");

			for (int j = 0; j < pecasDeXadrez.length; j++) {
				imprimirPeca(pecasDeXadrez[i][j], movimentosPossiveis[i][j]);
			}

			System.out.print((8 - i) + " ");

			System.out.println();
		}

		System.out.println("  a b c d e f g h");
	}

	private static void imprimirPeca(PecaDeXadrez pecaDeXadrez, boolean colorirFundo) {
		if (colorirFundo) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}

		if (pecaDeXadrez == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (pecaDeXadrez.getCor() == Cor.BRANCA) {
				System.out.print(ANSI_WHITE + pecaDeXadrez + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + pecaDeXadrez + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}

	private static void imprimirPecasCapturadas(List<PecaDeXadrez> pecasCapturadas) {
		List<PecaDeXadrez> pecasBranca = pecasCapturadas.stream()
				.filter(pecaCapturada -> pecaCapturada.getCor() == Cor.BRANCA).collect(Collectors.toList());

		List<PecaDeXadrez> pecasPreta = pecasCapturadas.stream()
				.filter(pecaCapturada -> pecaCapturada.getCor() == Cor.PRETA).collect(Collectors.toList());

		System.out.println("Peças capturadas:");
		System.out.print("Branca: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(pecasBranca.toArray()));
		System.out.print(ANSI_RESET);

		System.out.print("Preta: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(pecasPreta.toArray()));
		System.out.print(ANSI_RESET);
	}

}
