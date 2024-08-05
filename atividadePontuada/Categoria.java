package atividadePontuada;

import java.util.List;

public class Categoria {

	private String nomeCategoria;
	private List<Subcategoria> listaSubcategorias;

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<Subcategoria> getListaSubcategorias() {
		return listaSubcategorias;
	}

	public void setListaSubcategorias(List<Subcategoria> listaSubcategorias) {
		this.listaSubcategorias = listaSubcategorias;
	}
}
