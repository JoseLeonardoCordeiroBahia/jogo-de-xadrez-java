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
    
    - Matriz.
    
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

  - Matriz.
  
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

- Métodos: Tabuleiro.posicaoExiste(posição), Tabuleiro.existePecaNaPosicao(posição)

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

- Método: Tela.lerPosicaoDeXadrez(scanner)

- Método: PartidaDeXadrez.executarMovimento(posição de origem, posição de destino) [PosicaoDeXadrez]

  - Método: PartidaDeXadrez.fazerMovimento(posição de origem, posição de destino)
  
  - Método: PartidaDeXadrez.validarPosicaoDeOrigem(posição de origem)
  
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
  
  - movimentoPossivel(posição)
  
  - existeAlgumMovimentoPossivel()
  
- Implementação básica do movimentosPossiveis() para Torre e Rei

- Atualizar PartidaDeXadrez.validarPosicaoDeOrigem(posição de origem)

- Tópicos:

  - Método abstrato / classe
  
  - Exceções
  
##### Implementando possíveis movimentos da Torre

###### Lista de controle:

- Método: PecaDeXadrez.existePecaDoOponente(posição) [protected]

- Implementar Torre.movimentosPossiveis()

- Método: PartidaDeXadrez.validarPosicaoDeDestino(posição de origem, posição de destino)

- Tópicos:

  - Polimorfismo
  
  - Modificadores de encapsulamento/acesso [protected]
  
  - Exceções
  
##### Imprimindo movimentos possíveis

###### Lista de controle:

- Método: PartidaDeXadrez.movimentosPossiveis(posição de origem) [PosicaoDeXadrez]

- Método: Tela.imprimirTabuleiro(peças de xadres, movimentosPossiveis) [overload]

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

  - Atualizar executarMovimento(posição de origem, posição de destino) [PosicaoDeXadrez]

  - Atualizar validarPosicaoDeOrigem(posição de origem)

- Método: Tela.imprimirPartida(partida de xadrez)

- Tópicos:

  - Encapsulamento
  
  - Exceções