import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAtividade {

	private static Scanner scanner = new Scanner(System.in);

	private static String escolha;
	public static ArrayList<Categoria> listaCategorias = new ArrayList<>(10);
	public static ArrayList<Subcategoria> listaSubCategorias = new ArrayList<>(10);

	public static ArrayList<Produto> estoque = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(" ----------------------- Bem vinto a loja! -----------------------");
		String escolha = loadMenu();
		while (!escolha.trim().equals("10")) {
			switch (escolha) {
				case "1":
					System.out.println("Digite o nome do categoria: ");
					cadastrarCategorias(scanner.nextLine());
					escolha = loadMenu();
				case "2":
					System.out.println("Digite o nome do subcategoria: ");
					String subcategoria = scanner.nextLine();
					System.out.println("Digite o nome da Categoria Base: ");
					String categoriaBase = scanner.nextLine();
					cadastrarSubcategoria(subcategoria, categoriaBase);
					escolha = loadMenu();
				case "3":
					System.out.println("Digite o codigo do produto: ");
					int codigoProduto = scanner.nextInt();
					System.out.println("Digite o nome do produto: ");
					scanner.nextLine();
					String produto = scanner.nextLine();
					System.out.println("Digite a quantidade do produto: ");
					int quantidadeProduto = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Digite a categoria do produto: ");
					String categoria = scanner.nextLine();
					cadastrarProduto(codigoProduto,produto,categoria,quantidadeProduto);
					escolha = loadMenu();
				case "4":
			}
		}

	}

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

	public static ArrayList<String> listarSubcategorias(){
		ArrayList<String> subcategorias = new ArrayList<>();
		for (Subcategoria subc: listaSubCategorias){
			subcategorias.add(subc.getNomeSubcategoria());
		}
		return subcategorias;
	}

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

	public static void cadastrarCategorias(String categoriaNome){
		Categoria categoria = new Categoria();
		if (buscarCategoria(categoriaNome) == null){
			categoria.setNomeCategoria(categoriaNome);
			System.out.println("Agora adicione as sub-categorias que deseja separadas por ',' essas sao as categorias disponíveis: ");
			System.out.println(listarSubcategorias().toString());
			String subcategorias = scanner.nextLine();
			String[] subcategoriasArray = subcategorias.split(",");
			ArrayList<Subcategoria> subcategoriasLista = new ArrayList<>();
			for (String subcategoria: subcategoriasArray){
				subcategoriasLista.add(buscarSubCategoria(subcategoria));
			}
			categoria.setListaSubcategorias(subcategoriasLista);
			System.out.println("Sub-categorias adicionadas: " + categoria.getListaSubcategorias().toString());
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
			if (cat.getNomeCategoria().equals(subcategoria.getNomeCategoria())){
				List<Subcategoria> subcategoriasLista = cat.getListaSubcategorias();
				subcategoriasLista.add(subcategoria);
				cat.setListaSubcategorias(subcategoriasLista);
			}
		}
		System.out.println("Sub-categoria cadastrada com sucesso.");
	}

	public static void cadastrarProduto(int codigo, String nome, String categoria, int qtdEstoque){
		for (Produto prod : estoque){
			if(prod.getCodigo() == codigo){
				System.out.println("Produto ja existe, deseja atualizar o cadastro? Y/N");
				String resposta = scanner.nextLine();
				if(resposta.toUpperCase().equals("Y")){
					prod.setQtdEstoque(qtdEstoque);
					prod.setCategoria(buscarCategoria(categoria));
					prod.setNome(nome);
				}
			}
		}
		Produto produto = new Produto(codigo, nome, buscarCategoria(categoria), qtdEstoque);
		estoque.add(produto);
	}
}
