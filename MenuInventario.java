import java.util.ArrayList;
import java.util.Scanner;

public class MenuInventario {
    public static void main (String[] args){
        Inventario inventario = new Inventario(new ArrayList<Guitarra>(10));
        String escolha = exibirMenu();
        Scanner entrada = new Scanner(System.in);
        while (!escolha.equals("6")){
            if (escolha.equals("1")){
                System.out.println("Digite o numero de serie da guitarra:");
                String nrSerial = entrada.nextLine();
                System.out.println("Digite o preço da guitarra:");
                Double preco = entrada.nextDouble();
                System.out.println("Digite o fabricante da guitarra:");
//                apos nextDouble o scanner pula uma entrada nextLine
                String temp = entrada.nextLine();
                String fabricante = entrada.nextLine();
                System.out.println("Digite o tipo da guitarra:");
                String tipo = entrada.nextLine();
                System.out.println("Digite o modelo da guitarra:");
                String modelo = entrada.nextLine();
                Guitarra guitarra = new Guitarra(nrSerial, preco, fabricante, tipo, modelo);
                inventario.adicionarGuitarra(guitarra);
                escolha = exibirMenu();
            }
            else if (escolha.equals("2")){
                System.out.println("Digite o numero de serie da guitarra:");
                String nrSerial = entrada.nextLine();
                inventario.removerGuitarra(nrSerial);
                escolha = exibirMenu();
            }
            else if (escolha.equals("3")){
                System.out.println("Digite o numero de serie da guitarra:");
                String nrSerial = entrada.nextLine();
                System.out.println("Digite o preço da guitarra:");
                Double preco = entrada.nextDouble();
                System.out.println("Digite o fabricante da guitarra:");
                String temp = entrada.nextLine();
                String fabricante = entrada.nextLine();
                System.out.println("Digite o tipo da guitarra:");
                String tipo = entrada.nextLine();
                System.out.println("Digite o modelo da guitarra:");
                String modelo = entrada.nextLine();
                Guitarra guitarra = new Guitarra(nrSerial, preco, fabricante, tipo, modelo);
                inventario.editarGuitarra(guitarra);
                escolha = exibirMenu();
            }
            else if (escolha.equals("4")){
                ArrayList<Guitarra> listaGuitarras = inventario.getListaGuitarra();
                for (Guitarra guitarra : listaGuitarras){
                    System.out.println("{ Numero de Serie: "+ guitarra.getSerialNumber());
                    System.out.println("Tipo: "+ guitarra.getTipo());
                    System.out.println("Modelo: "+ guitarra.getModelo());
                    System.out.println("Fabricante: "+ guitarra.getFabricante());
                    System.out.println("Preço: "+ guitarra.getPreco().toString() + " },");
                }
                escolha = exibirMenu();
            }
            else if (escolha.equals("5")){
                System.out.println("Digite o numero de serie da guitarra:");
                String nrSerial = entrada.nextLine();
                inventario.obterGuitarra(nrSerial);
                escolha = exibirMenu();
            }
        }
    }

    public static String exibirMenu(){
        String addGuitar = "1 - adicionar guitarra";
        String excluirGuitarra = "2 - Excluir guitarra.";
        String editarGuitarra = "3 - Editar guitarra";
        String consultGuitarra = "4 - Consultar todas as guitarras";
        String obterGuitarra = "5 - Obter uma guitarra";
        String sair = "6 - Sair";

        Scanner entrada = new Scanner(System.in);
        System.out.println(" Digite o numero da ação que deseja: ");
        System.out.println(addGuitar);
        System.out.println(excluirGuitarra);
        System.out.println(editarGuitarra);
        System.out.println(consultGuitarra);
        System.out.println(obterGuitarra);
        System.out.println(sair);
        return entrada.nextLine();
    }
}
