package atividadePontuada2;

public class Contribuinte {
//    CPF/CNPJ
    private String codigoPessoal;
    private String nome;

    public Contribuinte(String codigoPessoal, String nome) {
        this.codigoPessoal = codigoPessoal;
        this.nome = nome;
    }

    public Contribuinte() {
    }

    public String getCodigoPessoal() {
        return codigoPessoal;
    }

    public void setCodigoPessoal(String codigoPessoal) {
        this.codigoPessoal = codigoPessoal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return " Contribuinte: CPF/CNPJ:" + codigoPessoal + ", Nome: " + nome;
    }
}
