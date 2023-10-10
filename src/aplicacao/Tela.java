package aplicacao;

import xadrez.PecaDeXadrez;

public class Tela {

	public static void imprimirTabuleiro(PecaDeXadrez[][] pecasDeXadrez) {
		System.out.println("  a b c d e f g h");
		
		for (int i = 0; i < pecasDeXadrez.length; i++) {
			System.out.print((8 - i) + " ");
			
			for (int j = 0; j < pecasDeXadrez.length; j++) {
				imprimirPeca(pecasDeXadrez[i][j]);
			}
			
			System.out.print((8 - i) + " ");
			
			System.out.println();
		}
		
		System.out.println("  a b c d e f g h");
	}
	
	private static void imprimirPeca(PecaDeXadrez pecaDeXadrez) {
		if (pecaDeXadrez == null) {
			System.out.print("-");
		} else {
			System.out.print(pecaDeXadrez);
		}
		System.out.print(" ");
	}
	
}
