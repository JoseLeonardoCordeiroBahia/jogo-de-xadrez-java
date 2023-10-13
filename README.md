# Jogo de xadrez com Java e orientação a objetos

##### Primeira classe: Posição (posição tabuleiro)

###### Lista de controle:

- Classe: Posicao

- Tópicos:

  - Encapsulamento

  - Construtores

  - ToString (Object / overrinding)
  
##### Começando a implementar Tabuleiro e Peça

###### Lista de controle:

- Classes: Peca, Tabuleiro

- Tópicos:
  
  - Associações
  
  - Modificadores de encapsulamento e acessos
  
  - Estrutura de dados - tópicos:
    
    - Matriz
    
##### Camada de xadrez e impressão do tabuleiro

![image](https://github.com/JoseLeonardoCordeiroBahia/assets/blob/main/jogo-de-xadrez-java/tabuleiro-impreso.png)

###### Lista de controle:

- Métodos: Tabuleiro.peca(linha, coluna) e Tabuleiro.peca(posição)

- Enum: Cor

- Classe: PecaDeXadrez

- Classe: PartidaDeXadrez

- Classe: Tela

- Tópicios:

  - Enumerações
  
  - Modificadores de encapsulamento/acesso
  
  - Herança
  
  - Downcasting
  
  - Membros estáticos
  
  - Padrão de camadas
  
- Estruturas de dados - tópicos:

  - Matriz
  
##### Colocando as peças no tabuleiro

###### Lista de controle:

- Método Tabuleiro.colocarPeca(peça, posição)

- Classes: Torre, Rei

- Método: PartidaDeXadrez.iniciarPartidaDeXadrezColocandoPecasNoTabuleiro()

- Tópicos:

  - Herança
  
  - Substituindo (Overrriding)
  
  - Poliformismo (ToString
  
##### TabuleiroException e programação defensiva

###### Lista de controle:

- Classe: TabuleiroException

- Métodos: Tabuleiro.posicaoExiste(), Tabuleiro.existePecaNaPosicao()

- Implementar programação defensiva em métodos do tabuleiro

- Tópicos:

  - Exceções (Exceptions)
  
  - Construtores (uma string deve ser informada para a exceção)
  
##### XadrezException e PosicaoDeXadrez

###### Lista de controle:

- Classe: XadrezException

- Classe: PosicaoDeXadrez

- Refatorar PartidaDeXadrez.iniciarPartidaDeXadrezColocandoPecasNoTabuleiro()

- Tópicos:

  - Exceções (Exceptions)
  
  - Encapsulamento
  
  - Construtores (uma string deve ser informada para a exceção)
  
  - Substituindo (Overrriding)
  
  - Membros estáticos
  
  - Padrão de camadas
  
##### Melhoria na impressão do tabuleiro

###### Cor no terminal:

- Windows: Git Bash

- Mac: Google "osx terminal color"

###### Lista de controle:

- Colocar mais peças no tabuleiro

- Distinguir as cores das peças no método Tela.imprimirPeca()

##### Movendo as peças

###### Lista de controle:

- Método: Tabuleiro.retirarPeca()

- Método: Tela.lerPosicaoDeXadrez()

- Método: PartidaDeXadrez.executarMovimento()

  - Método: PartidaDeXadrez.fazerMovimento()
  
  - Método: PartidaDeXadrez.validarPosicaoDeOrigem()
  
- Escrever a lógica básica no Programa

- Tópicos:

  - Exceções
  
  - Encapsulamento
  
##### Manipulando exceções e limpando a tela
  
###### Limpar tela usando Java:
```bash
// https://stackoverflow.com/questions/2979383/java-clear-the-console
public static void limparTela() {
  System.out.print("\033[H\033[2J");
  System.out.flush();
}
```

###### Lista de controle:

- XadrezException

- InputMismatchException

##### Possíveis movimentos de uma peça

###### Lista de controle:

- Métodos das peças (tabuleiro.Peca):

  - movimentosPossiveis() [abstract]
  
  - movimentoPossivel()
  
  - existeAlgumMovimentoPossivel()
  
- Implementação básica do movimentosPossiveis() para Torre e Rei

- Atualizar PartidaDeXadrez.validarPosicaoDeOrigem()

- Tópicos:

  - Método abstrato / classe
  
  - Exceções
  
##### Implementando possíveis movimentos da Torre

###### Lista de controle:

- Método: PecaDeXadrez.existePecaDoOponente(posição) [protected]

- Implementar Torre.movimentosPossiveis()

- Método: PartidaDeXadrez.validarPosicaoDeDestino()

- Tópicos:

  - Polimorfismo
  
  - Modificadores de encapsulamento/acesso [protected]
  
  - Exceções
  
##### Imprimindo movimentos possíveis

###### Lista de controle:

- Método: PartidaDeXadrez.movimentosPossiveis()

- Método: Tela.imprimirTabuleiro() [overload]

- Refatorar a lógica do programa principal

- Tópico:

  - Sobrecarga (Overloading)
  
##### Implementando possíveis movimentos de Rei

###### Lista de controle:

- Método: Rei.podeMover(posição) [private]

- Implementar Rei.movimentosPossiveis()

- Tópicos:
  
  - Encapsulamento
  
  - Polimorfismo
  
##### Trocar de jogador a cada turno

###### Lista de controle:

- Classe PartidaDeXadrez:

  - Propriedades: turno, jogadorAtual [private get]

  - Método: trocarDeJogador() [private]

  - Atualizar executarMovimento()

  - Atualizar validarPosicaoDeOrigem()

- Método: Tela.imprimirPartida()

- Tópicos:

  - Encapsulamento
  
  - Exceções

##### Manipulando peças capturadas

###### Lista de controle:

- Método: Tela.imprimirPecasCapturadas(peças capturadas) [List<PecaDeXadrez>]

- Atualizar e Tela.imprimirPartida()

- Atualizar a lógica da classe Programa

- Listas na PartidaDeXadrez: pecasNoTabuleiro, pecasCapturadas
  
  - Atualizar colocarNovaPeca()
  
  - Atualizar fazerMovimento()
  
- Tópicos:

  - Encapsulamento
  
  - Construtores
  
- Estrutura de dados - tópicos:
    
  - Lista

##### Lógica de xeque

###### Regras

- Xeque significa que seu rei está sob ameaça de pelo menos uma peça do oponente

- Você não pode se colocar em cheque

###### Lista de controle:

- Propriedade PosicaoDeXadrez.getPosicaoDeXadrez()

- Classe PartidaDeXadrez:

  - Método: desfazerMovimento()
  
  - Propriedade xeque [private is]
  
  - Método: oponente() [private]
  
  - Método: rei(cor) [private]
  
  - Método testarXeque()
  
  - Atualizar executarMovimento()

- Atualizar Tela.imprimirPartida()

##### Lógica do xeque-mate

###### Lista de controle:

- Classe PartidaDeXadrez:

  - Propriedade xequeMate [private is]
  
  - Método: testarXequeMate() [private]
  
  - Atualizar executarMovimento()
  
- Atualizar Tela.imprimirPartida()

- Atualizar a lógica da classe Programa

##### Quantidade de movimentos das peças

###### Lista de controle:

- Classe PecaDeXadrez:

  - Propriedade quantidadeDeMovimentos [private get]
  
  - Método: incrementarQuantidadeDeMovimentos()
  
  - Método: decrementarQuantidadeDeMovimentos()
  
- Classe PartidaDeXadrez:

  - Atualizar fazerMovimento()
  
  - Atualizar desfazerMovimento()
  
- Tópicos:

  - Encapsulamento
  
##### Criando a peça do Peão

###### Lista de controle:

- Classe Peao

- Atualizar PartidaDeXadrez.iniciarPartidaDeXadrezColocandoPecasNoTabuleiro()

- Tópicos:

  - Encapsulamento
  
  - Herança
  
  - Polimorfismo
  
##### Criando a peça do Bispo

###### Lista de controle:

- Classe Bispo

- Atualizar PartidaDeXadrez.iniciarPartidaDeXadrezColocandoPecasNoTabuleiro()

- Tópicos:

  - Encapsulamento
  
  - Herança
  
  - Polimorfismo
  
##### Criando a peça do Cavalo

###### Lista de controle:

- Classe Cavalo

- Atualizar PartidaDeXadrez.iniciarPartidaDeXadrezColocandoPecasNoTabuleiro()

- Tópicos:

  - Encapsulamento
  
  - Herança
  
  - Polimorfismo

##### Criando a peça da Dama/Rainha

###### Lista de controle:

- Classe Dama

- Atualizar PartidaDeXadrez.iniciarPartidaDeXadrezColocandoPecasNoTabuleiro()

- Tópicos:

  - Encapsulamento
  
  - Herança
  
  - Polimorfismo
 
##### Jogada especial roque

###### Lista de controle:

- Atualizar Rei

- Atualizar PartidaDeXadrez.fazerMovimento()

- Atualizar PartidaDeXadrez.desfazerMovimento()

##### Jogada especial en passant

###### Lista de controle:

- Registre um peão que pode ser capturado por en passant no próximo turno

  - Propriedade PartidaDeXadrez.vulneravelAoEnPassant
  
  - Atualizar PartidaDeXadrez.executarMovimento()
  
- Atualizar Peao.movimentosPossiveis()

- Atualizar PartidaDeXadrez.fazerMovimento()

- Atualizar PartidaDeXadrez.desfazerMovimento()

- Atualizar PartidaDeXadrez.iniciarPartidaDeXadrezColocandoPecasNoTabuleiro()

##### Jogada especial promoção

###### Lista de controle:

- Propriedade PartidaDeXadrez.promocao

- Atualizar PartidaDeXadrez.executarMovimento()

- Método: PartidaDeXadrez.trocarPecaPromovida()

- Atualizar a lógica da classe Programa