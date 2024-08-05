

import java.util.List;

public class Pedido {
	private int id;
	private List<Produto> listaProdutos;
	private Boolean pedidoFechado;

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Boolean getPedidoFechado() {
		return pedidoFechado;
	}

	public void setPedidoFechado(Boolean pedidoFechado) {
		this.pedidoFechado = pedidoFechado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
