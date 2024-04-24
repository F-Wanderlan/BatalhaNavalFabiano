import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo extends ValidadorEmbarcacao{

    public static class ErroLeitura {
        private String mensagem;
        private int numeroLinha;

        public ErroLeitura(String mensagem, int numeroLinha) {
            this.mensagem = mensagem;
            this.numeroLinha = numeroLinha;
        }

        public String getMensagem() {
            return mensagem;
        }

        public int getNumeroLinha() {
            return numeroLinha;
        }
    }

    public List<Resultado> lerArquivo(String nomeArquivo) {
        List<Resultado> listaEmbarcacoes = new ArrayList<>();
        List<ErroLeitura> erros = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int numeroLinha = 0;
            while ((linha = bufferedReader.readLine()) != null) {
                numeroLinha++;
                Resultado embarcacao = criarEmbarcacao(linha, numeroLinha, erros);
                if (embarcacao != null) {
                    listaEmbarcacoes.add(embarcacao);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        if (!erros.isEmpty()) {
            for (ErroLeitura erro : erros) {
                System.err.println("Erro na linha " + erro.getNumeroLinha() + ": " + erro.getMensagem());
            }
            System.exit(1); // Encerra o programa com código de erro
        }
        if (validarCoordenadas(listaEmbarcacoes))return listaEmbarcacoes;
        else {
            System.err.print("Embarcações sobrepostas ou adjacentes");
            System.exit(1);
            return null;
        }
    }

    private static Resultado criarEmbarcacao(String linha, int numeroLinha, List<ErroLeitura> erros) {
        String[] partes = linha.split("\\s+");
        if (partes.length != 5) {
            erros.add(new ErroLeitura("Formato inválido", numeroLinha));
            return null;
        }

        String tipo = partes[0];
        int colunaInicio = Integer.parseInt(partes[1]);
        int linhaInicio = Integer.parseInt(partes[2]);
        int colunaFim = Integer.parseInt(partes[3]);
        int linhaFim = Integer.parseInt(partes[4]);

        try {
            int tamanho = Math.abs(colunaFim - colunaInicio) + Math.abs(linhaFim - linhaInicio) + 1;
            return validarEmbarcacao(tipo, colunaInicio, linhaInicio, colunaFim, linhaFim);
        } catch (IllegalArgumentException e) {
            erros.add(new ErroLeitura(e.getMessage(), numeroLinha));
            return null;
        }
    }

}
