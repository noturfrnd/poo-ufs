

public class Subcategoria extends Categoria {

	private String nomeSubcategoria;
	private Categoria categoriaBase;

	public String getNomeSubcategoria() {
		return nomeSubcategoria;
	}

	public void setNomeSubcategoria(String nomeSubcategoria) {
		this.nomeSubcategoria = nomeSubcategoria;
	}

	public Categoria getCategoriaBase() {
		return categoriaBase;
	}

	public void setCategoriaBase(Categoria categoriaBase) {
		this.categoriaBase = categoriaBase;
	}
}
