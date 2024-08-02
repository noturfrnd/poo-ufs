import java.util.ArrayList;
import java.util.Scanner;

public class MainAtividade {

	private static Scanner scanner = new Scanner(System.in);

	private static String escolha;
	public static ArrayList<Categoria> listaCategorias = new ArrayList<>(10);
	public static ArrayList<Subcategoria> listaSubCategorias = new ArrayList<>(10);

	public static ArrayList<Produto> estoque = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Fa�a aqui o seu programa

	}

	public static Categoria buscarCategoria(String busca){
		for (Categoria cat: listaCategorias){
			if(cat.getNomeCategoria().equals(busca)){
				return cat;
			}
		}
		return null;
	}

	public static void loadMenu (){
		System.out.println("Bem vinto a loja! Digite o numero da ação que deseja:");
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
	}

	public static void cadastrarCategorias(Categoria categoria, Pessoa pessoa){
		if (!listaCategorias.contains(categoria) || buscarCategoria(categoria.getNomeCategoria()) != null){
			listaCategorias.add(categoria);
			return;
		}
		System.out.println("Categoria já existe");
	}

	public static void cadastrarSubcategoria(String nomeCategoria, String nomeSubcategoria){
		if(buscarCategoria(nomeCategoria) == null){
			System.out.println("Categoria base não existe");
			return;
		}
		for(Subcategoria sub: listaSubCategorias){
			if(sub.getNomeSubcategoria().equals(nomeSubcategoria)){
				System.out.println("Essa subcategoria ja existe");
				return;
			}
		}
		Subcategoria subcategoria = new Subcategoria();
		subcategoria.setNomeSubcategoria(nomeSubcategoria);
		subcategoria.setCategoriaBase(buscarCategoria(nomeCategoria));
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
