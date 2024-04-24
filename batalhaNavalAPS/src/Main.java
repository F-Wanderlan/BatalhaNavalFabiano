import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LeitorArquivo leitor = new LeitorArquivo();

        Tabuleiro j1 = new Tabuleiro();
        List<Resultado> listaEmbarcacoes = leitor.lerArquivo("j1.txt");
        for (Resultado embarcacao : listaEmbarcacoes) {
            j1.inserirCaractere(embarcacao.getEmbarcacao().getCodigo(), embarcacao);
        }

        Tabuleiro j2 = new Tabuleiro();
        listaEmbarcacoes = leitor.lerArquivo("j2.txt");
        for (Resultado embarcacao : listaEmbarcacoes) {
            j2.inserirCaractere(embarcacao.getEmbarcacao().getCodigo(), embarcacao);
        }

        System.out.println("prompt> java batalhaNaval.Batalha j1.txt j2.txt\n" +
                "TABULEIROS CARREGADOS COM SUCESSO");




        Jogo jogo = new Jogo();
        jogo.jogar(j1,j2);

    }




}