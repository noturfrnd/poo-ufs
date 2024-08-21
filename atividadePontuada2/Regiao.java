package atividadePontuada2;

public class Regiao {
    private String codigo;
    private String nome;
    private String descricao;
    private Double valorMetroQuadrado;

    public Regiao(String codigo, String nome, String descricao, Double valorMetroQuadrado) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valorMetroQuadrado = valorMetroQuadrado;
    }

    public Regiao() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorMetroQuadrado() {
        return valorMetroQuadrado;
    }

    public void setValorMetroQuadrado(Double valorMetroQuadrado) {
        this.valorMetroQuadrado = valorMetroQuadrado;
    }

    @Override
    public String toString(){
        return "[ " + codigo + ", " + nome + ", " + descricao + ", " + valorMetroQuadrado + " ]";
    }
}
