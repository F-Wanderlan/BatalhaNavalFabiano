import java.util.List;

public class Tabuleiro {

    private char[][] tabuleiro;
    private static int tamanho = 15;


    public Tabuleiro() {
        // Inicializa a matriz do tabuleiro com tamanho 15x15
        this.tabuleiro = new char[15][15];
        // Preenche o tabuleiro com o caractere 'a' de água
        inicializarTabuleiro();
    }

    public static boolean isValidCoordinate(int linha, int coluna) {
        return (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho);
    }

    // Método privado para preencher o tabuleiro com '-'
    private void inicializarTabuleiro() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                tabuleiro[i][j] = '~';
            }
        }
    }


    public Boolean confirmarEspacoLivre(Resultado result) {

        // Verifica se as coordenadas de início e fim estão dentro dos limites do tabuleiro
        if (result.getColunaInicio() < 0 || result.getLinhaInicio() >= 15 || result.getColunaFim() < 0 || result.getLinhaFim() >= 15 ||
                result.getColunaFim() < 0 || result.getColunaFim() >= 15 || result.getLinhaFim() < 0 || result.getLinhaFim() >= 15) {
            // Coordenadas fora do tabuleiro, retorna false
            return false;
        }

        // Percorre o intervalo entre as coordenadas de início e fim
        for (int i = result.getLinhaInicio(); i <= result.getLinhaFim(); i++) {
            for (int j = result.getColunaInicio(); j <= result.getColunaFim(); j++) {
                // Verifica se a posição no tabuleiro está ocupada
                if (tabuleiro[i][j] != '~') {
                    // Posição ocupada, retorna false
                    return false;
                }
            }
        }
        // Se todas as posições estiverem livres, retorna true
        return true;
    }

    public void inserirCaractere(char caractere, Resultado result) {
        // Verifica se o espaço está livre usando o método confirmarEspacoLivre
        if (confirmarEspacoLivre(result)) {
            // Percorre o intervalo entre as coordenadas de início e fim
            for (int i = result.getLinhaInicio(); i <= result.getLinhaFim(); i++) {
                for (int j = result.getColunaInicio(); j <= result.getColunaFim(); j++) {
                    // Insere o caractere nos espaços livres
                    tabuleiro[i][j] = caractere;
                }
            }
        } else {
            System.out.println("Espaço não está livre, caractere não inserido.");
            System.exit(1);
        }
    }



    // Método para imprimir o tabuleiro no console
    public void imprimirTabuleiro() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                // Imprime o caractere na posição (i, j) do tabuleiro, seguido de um espaço
                System.out.print(tabuleiro[i][j] + " ");
            }
            // Imprime uma nova linha para separar as linhas do tabuleiro
            System.out.println();
        }
    }

    public char getCaractere(int linha, int coluna) {
        if (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho) {
            return tabuleiro[linha][coluna];
        } else {
            System.out.println("Posição inválida!");
            return ' ';
        }
    }

    public void setCaractere(int linha, int coluna, char caractere) {
        if (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho) {
            tabuleiro[linha][coluna] = caractere;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public boolean embarcacaoAfundada(char codigo) {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == codigo) {
                    return false; // Ainda há partes da embarcação no tabuleiro
                }
            }
        }
        return true; // Não há mais partes da embarcação no tabuleiro
    }

    public boolean todasEmbarcacoesAfundadas() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] != '~' && tabuleiro[i][j] != ' ') {
                    return false; // Ainda há pelo menos uma embarcação no tabuleiro
                }
            }
        }
        return true; // Não há mais embarcações no tabuleiro
    }

    public boolean posicaoAtingida(int linha, int coluna) {
        return tabuleiro[linha][coluna] == ' ';
    }
}
