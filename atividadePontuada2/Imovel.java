package atividadePontuada2;

public class Imovel {
//    Numero da inscrição imobiliaria
    private Integer numeroInscricaoImob;
    private String nome;
    private String endereço;
    private Regiao regiaoImovel;
//    M² do imovel
    private Double area;
    private Contribuinte proprietario;

    public Integer getNumeroInscricaoImob() {
        return numeroInscricaoImob;
    }

    public void setNumeroInscricaoImob(Integer numeroInscricaoImob) {
        this.numeroInscricaoImob = numeroInscricaoImob;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Regiao getRegiaoImovel() {
        return regiaoImovel;
    }

    public void setRegiaoImovel(Regiao regiaoImovel) {
        this.regiaoImovel = regiaoImovel;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Contribuinte getProprietario() {
        return proprietario;
    }

    public void setProprietario(Contribuinte proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString(){
        return "[Numero de inscricao: " + numeroInscricaoImob + ", Nome:" + nome + ", Endereco: " + endereço + ", Regiao: " + regiaoImovel.toString() + ", Area: " + area + ", Proprietario: " + proprietario.toString();
    }
}
