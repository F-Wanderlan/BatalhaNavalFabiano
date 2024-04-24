import java.util.List;

public class ValidadorEmbarcacao {



    public static Resultado validarEmbarcacao(String tipo, int colunaInicio, int linhaInicio, int colunaFim, int linhaFim) {
        int tamanho = Math.abs(colunaFim - colunaInicio) + Math.abs(linhaFim - linhaInicio) + 1;
        switch (tipo) {
            case "PORTA_AVIOES":
                if (tamanho != 5) {
                    throw new IllegalArgumentException("Tamanho inválido para o porta-aviões na linha " + linhaInicio + ".");
                }

                return new Resultado(Embarcacao.PORTA_AVIOES, colunaInicio,linhaInicio,colunaFim,linhaFim);
            case "DESTROYER":
                if (tamanho != 4) {
                    throw new IllegalArgumentException("Tamanho inválido para o destroyer na linha " + linhaInicio + ".");
                }
                return new Resultado(Embarcacao.DESTROYER, colunaInicio,linhaInicio,colunaFim,linhaFim);
            case "CRUZADOR":
                if (tamanho != 4) {
                    throw new IllegalArgumentException("Tamanho inválido para o cruzador na linha " + linhaInicio + ".");
                }
                return new Resultado(Embarcacao.CRUZADOR, colunaInicio,linhaInicio,colunaFim,linhaFim);
            case "SUBMARINO":
                if (tamanho != 3) {
                    throw new IllegalArgumentException("Tamanho inválido para o submarino na linha " + linhaInicio + ".");
                }
                return new Resultado(Embarcacao.SUBMARINO, colunaInicio,linhaInicio,colunaFim,linhaFim);
            case "PATRULHA":
                if (tamanho != 2) {
                    throw new IllegalArgumentException("Tamanho inválido para a patrulha na linha " + linhaInicio + ".");
                }
                return new Resultado(Embarcacao.PATRULHA, colunaInicio,linhaInicio,colunaFim,linhaFim);
            default:
                throw new IllegalArgumentException("Tipo de embarcação desconhecido: " + tipo);
        }    }

    public static boolean validarCoordenadas(List<Resultado> embarcacoes) {
        for (int i = 0; i < embarcacoes.size(); i++) {
            Resultado embarcacaoA = embarcacoes.get(i);
            for (int j = i + 1; j < embarcacoes.size(); j++) {
                Resultado embarcacaoB = embarcacoes.get(j);
                if (coordenadasSobrepostas(embarcacaoA, embarcacaoB)) {
                    return false;
                }
                if (coordenadasAdjacentes(embarcacaoA, embarcacaoB)) {
                    return false;
                }
            }
        }
        return true; // Não foram encontradas sobreposições ou adjacências
    }

    private static boolean coordenadasSobrepostas(Resultado embarcacaoA, Resultado embarcacaoB) {
        // Verifica se as coordenadas se sobrepõem
        return embarcacaoA.getLinhaInicio() == embarcacaoB.getLinhaInicio() &&
                ((embarcacaoA.getColunaInicio() <= embarcacaoB.getColunaFim() && embarcacaoA.getColunaFim() >= embarcacaoB.getColunaInicio()) ||
                        (embarcacaoB.getColunaInicio() <= embarcacaoA.getColunaFim() && embarcacaoB.getColunaFim() >= embarcacaoA.getColunaInicio()));
    }

    private static boolean coordenadasAdjacentes(Resultado embarcacaoA, Resultado embarcacaoB) {
        // Verifica se as coordenadas são adjacentes
        return Math.abs(embarcacaoA.getLinhaInicio() - embarcacaoB.getLinhaInicio()) <= 1 &&
                Math.abs(embarcacaoA.getColunaInicio() - embarcacaoB.getColunaInicio()) <= 1;
    }
}
