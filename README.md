# Jogo de xadrez com Java e orientação a objetos

##### Primeira classe: Posição (posição tabuleiro)

- Classe: Posicao

- Tópicos:

  - Encapsulamento

  - Construtores

  - ToString (Object / overrinding)
  
##### Começando a implementar Tabuleiro e Peça

- Classes: Peca, Tabuleiro

- Tópicos:
  
  - Associações
  
  - Modificadores de encapsulamento e acessos
  
  - Estrutura de dados - tópicos:
    
    - Matriz.
    
##### Camada de xadrez e impressão do tabuleiro

![image](https://github.com/JoseLeonardoCordeiroBahia/assets/blob/main/jogo-de-xadrez-java/tabuleiro-impreso.png)

- Métodos: Tabuleiro.peca(linha, coluna) e Tabuleiro.peca(posição)

- Enum: xadrez.enums.Cor

- Classe: xadrez.PecaDeXadrez

- Classe: xadrez.PartidaDeXadrez

- Classe: aplicacao.Tela

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

- Método: Tabuleiro.colocarPeca(peça, posição)

- Classes: Torre, Rei

- Método: PartidaDeXadrez.iniciarPartidaDeXadrezColocandoPecasNoTabuleiro()

- Tópicos:

  - Herança
  
  - Substituindo (Overrriding)
  
  - Poliformismo (ToString
  
##### TabuleiroException e programação defensiva

- Classe tabuleiro.exception.TabuleiroException

- Métodos: Tabuleiro.existePosicao(posição), Tabuleiro.existePecaNaPosicao(posição)

- Implementar programação defensiva em métodos do tabuleiro

- Tópicos:

  - Exceções (Exceptions)
  
  - Construtores (uma string deve ser informada para a exceção)