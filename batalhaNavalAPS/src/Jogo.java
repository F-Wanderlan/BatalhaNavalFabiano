import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo extends Tabuleiro {

    public void jogar(Tabuleiro j1, Tabuleiro j2) {
        Tabuleiro tabuleiroAtual = j2;
        Scanner leitor = new Scanner(System.in);

        while (!tabuleiroAtual.todasEmbarcacoesAfundadas()) {
            tabuleiroAtual.imprimirTabuleiro();
            if (tabuleiroAtual.equals(j2)) {
                System.out.println("J1>");
                String input = leitor.nextLine();
                while (!entradaUsuario(input)) {
                    System.out.println("J1>");
                    input = leitor.nextLine();
                }
                String[] parts = input.split(" ");
                char caractere = tabuleiroAtual.getCaractere(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                if(caractere == '~'){
                    System.out.println("AGUA");
                    tabuleiroAtual = j1;
                }
                else if(caractere == ' '){
                    System.out.println("TIRO JA EXECUTADO");
                }
                else {
                    tabuleiroAtual.setCaractere(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),' ');
                    if(tabuleiroAtual.embarcacaoAfundada(caractere)){
                        System.out.println("AFUNDOU " + Embarcacao.getNome(caractere));
                    }
                    if(!tabuleiroAtual.embarcacaoAfundada(caractere)){
                        System.out.println("ACERTOU");
                        tabuleiroAtual = j1;
                    }

                }
            }
            else{
                System.out.println("J2>");
                String input = leitor.nextLine();
                while (!entradaUsuario(input)) {
                    System.out.println("J2>");
                    input = leitor.nextLine();
                }
                String[] parts = input.split(" ");
                char caractere = tabuleiroAtual.getCaractere(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                if(caractere == '~'){
                    System.out.println("AGUA");
                    tabuleiroAtual = j2;
                }
                else if(caractere == ' '){
                    System.out.println("TIRO JA EXECUTADO");
                }
                else {
                    if(!tabuleiroAtual.embarcacaoAfundada(caractere)){
                        System.out.println("ACERTOU");
                        tabuleiroAtual.setCaractere(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),' ');
                        tabuleiroAtual = j2;
                    }
                    else{
                        System.out.println("AFUNDOU" + Embarcacao.getNome(caractere) );
                    }
                }

            }

        }

    }


    public boolean entradaUsuario(String input) {

        // Dividir a entrada em partes usando o espaço como delimitador
        String[] parts = input.split(" ");

        // Se a entrada não tiver exatamente duas partes, ou se não for possível converter as partes em números inteiros, pedir ao usuário para inserir novamente
        if (parts.length != 2) {
            System.out.println("Entrada inválida.");
            return false;
        }

        try {
            // Tentar converter as partes em números inteiros
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            if (isValidCoordinate(x, y)) {
                return true;
            }

        } catch (NumberFormatException e) {
            // Se não for possível converter as partes em números inteiros, pedir ao usuário para inserir novamente
            System.out.println("Entrada inválida.");
        }
        return false;
    }

}