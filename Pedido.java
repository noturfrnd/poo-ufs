

import java.util.List;

public class Pedido {
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
}
