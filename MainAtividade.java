import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAtividade {

	private static Scanner scanner = new Scanner(System.in);

	private static String escolha;
	public static ArrayList<Categoria> listaCategorias = new ArrayList<>(10);
	public static ArrayList<Subcategoria> listaSubCategorias = new ArrayList<>(10);
	public static ArrayList<Cliente> listaClientes = new ArrayList<>(10);

	public static ArrayList<Produto> estoque = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(" ----------------------- Bem vinto a loja! -----------------------");
		String escolha = loadMenu();
		while (!escolha.trim().equals("10")) {
				if(escolha.equals("1")) {
					System.out.println("Digite o nome do categoria: ");
					cadastrarCategorias(scanner.nextLine());
					escolha = loadMenu();
				}
				if(escolha.equals("2")) {
					System.out.println("Digite o nome do subcategoria: ");
					String subcategoria = scanner.nextLine();
					System.out.println("Digite o nome da Categoria Base: ");
					String categoriaBase = scanner.nextLine();
					cadastrarSubcategoria(categoriaBase, subcategoria);
					escolha = loadMenu();
				}
				if(escolha.equals("3")) {
					cadastrarProduto();
					escolha = loadMenu();
				}
				if(escolha.equals("4")) {
					System.out.println("Digite o nome do cliente: ");
					String cliente = scanner.nextLine();
					cadastrarCliente(cliente);
					escolha = loadMenu();
				}
				if(escolha.equals("5")) {
					System.out.println("Digite o nome do cliente que ira fazer o pedido: ");
					cadastrarPedido(scanner.nextLine());
					escolha = loadMenu();
				}
				if (escolha.equals("6")) {
					System.out.println("Digite o numero ID do pedido: ");
					consultarPedido(scanner.nextInt());
					escolha = loadMenu();
				}
				if (escolha.equals("7")) {
					System.out.println("Digite o nome do cliente: ");
					System.out.println(listarPedidosCliente(scanner.nextLine()).toString());
					escolha = loadMenu();
				}
				if (escolha.equals("8")) {
					System.out.println(listarProduto(estoque).toString());
					escolha = loadMenu();
				}
				if (escolha.equals("9")) {
					System.out.println("Qual produto deseja repor? ");
					System.out.println(listarProduto(estoque).toString());
					System.out.println("Digite o nome do produto: ");
					String produto = scanner.nextLine();
					System.out.println("Digite o quantidade do produto: ");
					int quantidadeProduto = scanner.nextInt();
					reporProduto(produto, quantidadeProduto);
					escolha = loadMenu();
				}
				else {
					escolha = loadMenu();
				}
		}

	}

	// Bloco dedicado a buscas
	public static Categoria buscarCategoria(String busca){
		for (Categoria cat: listaCategorias){
			if(cat.getNomeCategoria().equals(busca)){
				return cat;
			}
		}
		return null;
	}

	public static Subcategoria buscarSubCategoria(String busca){
		for (Subcategoria cat: listaSubCategorias){
			if(cat.getNomeSubcategoria().equals(busca)){
				return cat;
			}
		}
		return null;
	}

	public static Cliente buscarCliente(String nome){
		for (Cliente cat: listaClientes){
			if(cat.getNome().equals(nome)){
				return cat;
			}
		}
		return null;
	}

	public static List<Produto> buscarProduto(String nome){
		List<Produto> produtos = new ArrayList<>();
		for (Produto prod : estoque){
			if(prod.getNome().equals(nome)){
				produtos.add(prod);
			} else if ((prod.getCodigo() + "0").equals(nome+"0")) {
				produtos.add(prod);
			} else if (prod.getCategoria().getNomeCategoria().equals(nome)) {
				produtos.add(prod);
			}
		}
		return produtos;
	}

	public static void consultarPedido (int id){
		// quando scanner.nextInt() é executado, pular um scanner.nextLine()
		scanner.nextLine();
		for(Cliente cliente: listaClientes){
			if (!cliente.getListaPedidosRealizados().isEmpty()){
				List<Pedido> pedidos = cliente.getListaPedidosRealizados();
				for (Pedido pedido: pedidos){
					if (pedido.getId() == id){
						double total = 0.0;
						System.out.println("Pedido id: " + pedido.getId());
						System.out.println("Cliente: " + cliente.getNome());
						for (Produto produto: pedido.getListaProdutos()){
							System.out.println("Produto: " + produto.getNome() + " Preço: " + produto.getPreco() + " Quantidade: " + produto.getQtdEstoque());
							total += produto.getPreco() * produto.getQtdEstoque();
						}
						System.out.println("Total: " + total);
						return;
					}
				}
			}
		}
		System.out.println("Pedido id: " + id + " não existe");
	}

	// Bloco dedicado a conversoes
	public static ArrayList<String> listarSubcategorias(List<Subcategoria> subcategoriasList){
		ArrayList<String> subcategorias = new ArrayList<>();
		for (Subcategoria subc: subcategoriasList){
			if(subc != null){
			subcategorias.add(subc.getNomeSubcategoria());}
		}
		return subcategorias;
	}

	public static ArrayList<String> listarCategoria(){
		ArrayList<String> categorias = new ArrayList<>();
		for (Categoria cat: listaCategorias){
			categorias.add(cat.getNomeCategoria());
		}
		return categorias;
	}

	public static ArrayList<String> listarProduto(List<Produto> produtoList){
		ArrayList<String> produtos = new ArrayList<>();
		for (Produto prod: produtoList){
			produtos.add(prod.getNome());
		}
		return produtos;
	}

	public static List<String> listarPedidosCliente(String nomeCliente){
		List<String> pedidos = new ArrayList<>();
		Cliente cliente = buscarCliente(nomeCliente);
		for (Pedido ped: cliente.getListaPedidosRealizados()){
			String pedido = "Pedido id: " + ped.getId();
			pedidos.add(pedido);
		}
		return pedidos;
	}

	// Bloco dedicado a cadastro
	public static void cadastrarCliente(String nome){
		if (buscarCliente(nome) != null) {
			System.out.println("Esse cliente ja existe!");
			return;
		}
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setId((int) (Math.random() * 100));
		cliente.setListaPedidosRealizados(new ArrayList<>());
		listaClientes.add(cliente);
		System.out.println("Cliente " + nome + " cadastrado com sucesso sob o ID: " + cliente.getId());
	}

	public static void cadastrarCategorias(String categoriaNome){
		Categoria categoria = new Categoria();
		if (buscarCategoria(categoriaNome) == null){
			categoria.setNomeCategoria(categoriaNome);
			System.out.println("Agora adicione as sub-categorias que deseja separadas por ',' essas sao as categorias disponíveis: ");
			System.out.println(listarSubcategorias(listaSubCategorias).toString());
			String subcategorias = scanner.nextLine();
			String[] subcategoriasArray = subcategorias.split(",");
			ArrayList<Subcategoria> subcategoriasLista = new ArrayList<>();
			for (String subcategoria: subcategoriasArray){
				subcategoriasLista.add(buscarSubCategoria(subcategoria));
			}
			categoria.setListaSubcategorias(subcategoriasLista);
			System.out.println("Sub-categorias adicionadas: " + listarSubcategorias(categoria.getListaSubcategorias()).toString());
			listaCategorias.add(categoria);
			return;
		}
		System.out.println("Categoria já existe");
	}

	public static void cadastrarSubcategoria(String nomeCategoria, String nomeSubcategoria){
		if(buscarCategoria(nomeCategoria) == null){
			System.out.println("Categoria base não existe.");
			return;
		}
		if(buscarSubCategoria(nomeSubcategoria) != null){
			System.out.println("Sub-categoria ja existe.");
		}
		Subcategoria subcategoria = new Subcategoria();
		subcategoria.setNomeSubcategoria(nomeSubcategoria);
		subcategoria.setCategoriaBase(buscarCategoria(nomeCategoria));
		for (Categoria cat: listaCategorias){
			if (cat.getNomeCategoria().equals(nomeCategoria)){
				List<Subcategoria> subcategoriasLista = cat.getListaSubcategorias();
				subcategoriasLista.add(subcategoria);
				cat.setListaSubcategorias(subcategoriasLista);
			}
		}
		listaSubCategorias.add(subcategoria);
		System.out.println("Sub-categoria cadastrada com sucesso.");
	}

	public static void cadastrarProduto(){
		System.out.println("Digite o codigo do produto: ");
		int codigoProduto = scanner.nextInt();
		System.out.println("Digite o nome do produto: ");
		scanner.nextLine();
		String nomeProduto = scanner.nextLine();
		System.out.println("Digite a quantidade do produto: ");
		int quantidadeProduto = scanner.nextInt();
		// quando scanner.nextInt() é executado, pular um scanner.nextLine()
		scanner.nextLine();
		System.out.println("Digite a categoria do produto: ");
		String categoria = scanner.nextLine();
		System.out.println("Digite o Preço do produto: ");
		double precoProduto = scanner.nextDouble();
		if(!estoque.isEmpty()){
			for (Produto prod : estoque){
				if(prod.getCodigo() == codigoProduto){
					System.out.println("Produto ja existe, deseja atualizar o cadastro? S/N");
					String resposta = scanner.nextLine();
					if(resposta.toUpperCase().equals("S")){
						prod.setQtdEstoque(quantidadeProduto);
						prod.setCategoria(buscarCategoria(categoria));
						prod.setNome(nomeProduto);
						prod.setPreco(precoProduto);
						return;
					}else {return;}
				}
			}
		}
		Produto produto = new Produto();
		produto.setCodigo(codigoProduto);
		produto.setNome(nomeProduto);
		produto.setPreco(precoProduto);
		produto.setQtdEstoque(quantidadeProduto);
		produto.setCategoria(buscarCategoria(categoria));
		estoque.add(produto);
	}

	public static void cadastrarPedido (String nome){
		Cliente cliente = buscarCliente(nome);
		if (cliente == null){
			System.out.println("Cliente não existe!");
			return;
		}
		Scanner entradaProduto = new Scanner(System.in);
		Boolean addProduto = true;
		List<Produto> listaProdutos = new ArrayList<>();
		while (addProduto){
			System.out.println("Buscar um produto por nome, codigo ou categoria:");
			String nomeProduto = entradaProduto.nextLine();
			List<Produto> produtos = buscarProduto(nomeProduto);
			Produto produto =  new Produto();
			if (produtos == null){
				System.out.println("Produto em falta. :(");
			}else{
				System.out.println("Esses produtos foram encontrados: " + listarProduto(produtos).toString());
				System.out.println("Digite o nome do produto que deseja adicionar: ");
				String nomeProduto1 = entradaProduto.nextLine();
				produto = buscarProduto(nomeProduto1).get(0);
				System.out.println("Quantidade do produto");
				int quantidade = entradaProduto.nextInt();
				if (quantidade > produto.getQtdEstoque()){
					System.out.println("Sinto muito, quantidade excede o estoque atual :(");
					quantidade = produto.getQtdEstoque();
				}
				Produto produtoPedido = produto;
				produtoPedido.setQtdEstoque(quantidade);
				listaProdutos.add(produtoPedido);
				for (Produto produtoProduto: estoque){
					if (produtoProduto.getCodigo() == produtoPedido.getCodigo()){
						produtoProduto.setQtdEstoque(produtoProduto.getQtdEstoque() - quantidade);
					}
				}
				}
			System.out.println("Finalizar pedido? S/N");
			// quando scanner.nextInt() é executado, pular um scanner.nextLine()
			String temp = entradaProduto.nextLine();
			String finalizarPedido = entradaProduto.nextLine();
			if (finalizarPedido.toUpperCase().equals("S")){
				addProduto = false;
			}
			}
		Pedido pedido = new Pedido();
		pedido.setListaProdutos(listaProdutos);
		pedido.setPedidoFechado(true);
		pedido.setId((int) (Math.random() * 100));
		cliente.getListaPedidosRealizados().add(pedido);
		System.out.println("Pedido realizado com ID: " + pedido.getId());
	}

	public static void reporProduto(String nomeProduto, int qntProduto){
		for (Produto produto : estoque){
			if (produto.getNome().equals(nomeProduto)){
				produto.setQtdEstoque(qntProduto);
				return;
			}
		}
		System.out.println("Produto nao encontrado!");
	}

	// Bloco dedicado a impressão
	public static String loadMenu (){
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o numero da ação que deseja:");
		System.out.println("1 - Cadastrar categoria.");
		System.out.println("2 - Cadastrar subcategoria.");
		System.out.println("3 - Cadastrar produto.");
		System.out.println("4 - Cadastrar cliente.");
		System.out.println("5 - Realizar pedido.");
		System.out.println("6 - Consultar pedido.");
		System.out.println("7 - Listar pedidos.");
		System.out.println("8 - Consultar estoque.");
		System.out.println("9 - Repor estoque.");
		System.out.println("10 - Sair.");
		return scanner.nextLine();
	}
}
