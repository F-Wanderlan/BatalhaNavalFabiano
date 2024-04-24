public class Resultado {
    private Embarcacao embarcacao;
    private int linhaInicio;
    private int colunaInicio;
    private int linhaFim;
    private int colunaFim;
    public Resultado(Embarcacao embarcacao, int linhaInicio, int colunaInicio, int linhaFim, int colunaFim) {
        this.embarcacao = embarcacao;
        this.linhaInicio = linhaInicio;
        this. colunaInicio =  colunaInicio;
        this.linhaFim = linhaFim;
        this.colunaFim = colunaFim;
    }
    public Embarcacao getEmbarcacao() {
        return embarcacao;
    }
    public void setEmbarcacao(Embarcacao embarcacao) {
        this.embarcacao = embarcacao;
    }

    public int getLinhaInicio() {
        return linhaInicio;
    }

    public void setLinhaInicio(int linhaInicio) {
        this.linhaInicio = linhaInicio;
    }

    public int getColunaInicio() {
        return colunaInicio;
    }

    public void setColunaInicio(int colunaInicio) {
        this.colunaInicio = colunaInicio;
    }

    public int getLinhaFim() {
        return linhaFim;
    }

    public void setLinhaFim(int linhaFim) {
        this.linhaFim = linhaFim;
    }

    public int getColunaFim() {
        return colunaFim;
    }

    public void setColunaFim(int colunaFim) {
        this.colunaFim = colunaFim;
    }
}