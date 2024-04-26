public enum Embarcacao {
    PORTA_AVIOES("PORTA_AVIOES", 'A', 5, 5),
    DESTROYER("DESTROYER",'D',4,4),
    CRUZADOR("CRUZADOR", 'C', 4, 4),
    SUBMARINO("SUBMARINO", 'S', 3, 3),
    PATRULHA("PATRULHA", 'P', 2, 2);

    private final String nome;
    private final Character codigo;
    private final Integer vida;
    private final Integer tamanho;


    // Constructor for each enum constant
    Embarcacao(String nome, Character codigo, Integer vida, Integer tamanho) {
        this.nome = nome;
        this.codigo = codigo;
        this.vida = vida;
        this.tamanho = tamanho;
    }

    // Método para verificar se um nome de embarcação é válido
    public static boolean isValid(String nomeEmbarcacao) {
        for (Embarcacao embarcacao : Embarcacao.values()) {
            if (embarcacao.name().equalsIgnoreCase(nomeEmbarcacao)) {
                return true;
            }
        }
        return false;
    }
    public static Embarcacao getByCodigo(Character codigo) {
        for (Embarcacao embarcacao : Embarcacao.values()) {
            if (embarcacao.getCodigo().equals(codigo)) {
                return embarcacao;
            }
        }
        return null;
    }

    public static String getNome(char codigo) {
        for (Embarcacao tipo : Embarcacao.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo.getNome();
            }
        }
        // Se nenhum tipo de navio corresponder ao código fornecido, retorna uma string vazia
        return "";
    }

    // Getters for properties
    public String getNome() {
        return nome;
    }

    public Character getCodigo() {
        return codigo;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer getTamanho() {
        return tamanho;
    }
}
