package atividadePontuada;

public class Produto {
	private int codigo;
	private String nome;
	private Categoria categoria;
	private int qtdEstoque;
	private double preco;

	public Produto(int codigo, String nome, Categoria categoria, int qtdEstoque, double preco){
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.qtdEstoque = qtdEstoque;
		this.preco = preco;
	}
	public Produto(){}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
