import java.util.ArrayList;
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
        Collection<Integer> collection = new ArrayList<>();
        collection.add(listaTeste.obter(1));
        collection.add(listaTeste.obter(5));
        listaTeste.remover(collection);
        System.out.println("Nova lista: " + listaTeste.toString());
        System.out.println("Valor existente na lista? Valor: " + listaTeste.obter(0) + " Existe? " + (listaTeste.contem(listaTeste.obter(0)) ? "Sim" : "Não"));
        System.out.println("Valor existente na lista? Valor: " + 99 + " Existe? " + (listaTeste.contem(99) ? "Sim" : "Não"));
        System.out.println("Tamanho da lista: " + listaTeste.tamanho());
        System.out.println("Limpar lista");
        System.out.println("Lista: " + listaTeste.toString());
        listaTeste.limpar();
        System.out.println("Nova lista: " + listaTeste.toString());
    }
}
