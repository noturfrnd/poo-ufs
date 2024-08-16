import java.util.Collection;

public class TestarLista {
    public static void main(String[] args){
        Lista<Integer> listaTeste = new Lista<>();
        System.out.println("Iniciando Testes Lista");
        System.out.println("Adicionar 1 item a lista");
        System.out.println("Lista inicial: " + listaTeste.toString());
        listaTeste.adicionar((int) (Math.random()*100));
        System.out.println("Nova lista: " + listaTeste.toString());
        System.out.println("Adicionar valor em posição nao existenete");
        listaTeste.adicionar(5, (int) (Math.random()*100));
        System.out.println("Nova lista: " + listaTeste.toString());
        System.out.println("Adicionar valor em posição existente");
        listaTeste.adicionar(2, (int) (Math.random()*100));
        System.out.println("Nova lista: " + listaTeste.toString());
        System.out.println("Obter valor aleatorio na lista: " + listaTeste.obter((int) (Math.random() * listaTeste.tamanho())));
        System.out.println("Remover valor da lista");
        listaTeste.remover(listaTeste.obter(5));
        System.out.println("Nova lista: " + listaTeste.toString());
        System.out.println("Remover valores da lista");
        Lista<Integer> listaTemp = new Lista<>();
        listaTemp.adicionar(listaTeste.obter(1));
        listaTemp.adicionar(listaTeste.obter(5));
        listaTeste.remover((Collection<Integer>) listaTemp);
    }
}
