

import java.util.List;

public class Cliente extends Pessoa {
	private List<Pedido> listaPedidosRealizados;

	public List<Pedido> getListaPedidosRealizados() {
		return listaPedidosRealizados;
	}

	public void setListaPedidosRealizados(List<Pedido> listaPedidosRealizados) {
		this.listaPedidosRealizados = listaPedidosRealizados;
	}
}
