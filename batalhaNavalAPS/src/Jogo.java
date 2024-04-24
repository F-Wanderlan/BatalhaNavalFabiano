import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
    private boolean vezJogador;

    public void jogar(Tabuleiro tabuleiro1, Tabuleiro tabuleiro2) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println((vezJogador ? "J1" : "J2") + "> ");
            try {
                int linha = scanner.nextInt();
                int coluna = scanner.nextInt();
                if (!Tabuleiro.isValidCoordinate(linha, coluna)) {
                    System.out.println("JOGADA INVALIDA");
                    continue;
                }
                Tabuleiro tabuleiroAtual = vezJogador ? tabuleiro2 : tabuleiro1;
                // Verifica se a posição já foi atingida
                if (tabuleiroAtual.posicaoAtingida(linha, coluna)) {
                    System.out.println("TIRO JA EXECUTADO");
                    continue;
                }
                char resultado = tabuleiroAtual.getCaractere(linha, coluna);
                if (resultado == '~') {
                    System.out.println("AGUA");
                } else if (resultado == ' ') {
                    System.out.println("TIRO JA EXECUTADO");
                } else {
                    System.out.println("ACERTOU");
                    char codigoEmbarcacao = resultado;
                    tabuleiroAtual.setCaractere(linha, coluna, ' '); // Marca o tiro no tabuleiro
                    if (tabuleiroAtual.embarcacaoAfundada(codigoEmbarcacao)) {
                        System.out.println("AFUNDOU " + Embarcacao.getByCodigo(codigoEmbarcacao).getNome());
                    }
                }
                // Verifica se todas as embarcações foram afundadas
                if (tabuleiroAtual.todasEmbarcacoesAfundadas()) {
                    System.out.println("FIM DE JOGO");
                    System.out.println("VENCEDOR: Jogador " + (vezJogador ? "1" : "2"));
                    break;
                }
                vezJogador = !vezJogador; // Passa a vez para o outro jogador
            } catch (InputMismatchException e) {
                System.out.println("JOGADA INVALIDA");
                scanner.nextLine(); // Descarta a entrada inválida
            }
        }
        scanner.close();
    }
}
