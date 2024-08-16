import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class Lista<T> implements ILista<T>, Iterable<T>{

    public ArrayList<T> valores = new ArrayList<>();

    @Override
    public boolean adicionar(T valor) {
        return valores.add(valor);
    }

    @Override
    public boolean adicionar(int posicao, T valor) {
        if (valores.size() < posicao){
            for (int i = valores.size(); i <= posicao-1; i++){
                valores.add(null);
            }
            return valores.add(valor);
        }
        valores.add(posicao, valor);
        return valores.indexOf(valor) == posicao;
    }

    @Override
    public T obter(int posicao) {
        return valores.get(posicao);
    }

    @Override
    public T remover(int posicao) {
        return valores.remove(posicao);
    }

    @Override
    public boolean remover(T valor) {
        return valores.remove(valor);
    }

    @Override
    public boolean remover(Collection<T> colecaoValores) {
        return valores.removeAll(colecaoValores);
    }

    @Override
    public boolean contem(T valor) {
        return valores.contains(valor);
    }

    @Override
    public int tamanho() {
        return valores.size();
    }

    @Override
    public void limpar() {
        for (int i = 0; i < valores.size(); i++){
            valores.remove(i);
        }
    }

    @Override
    public String toString(){
        String valorString = "[";
        for (T valor: valores){
            if(valor == valores.get(valores.size() -1 )){
                valorString += valor + "";
            }else valorString += valor + ", ";
        }
        return valorString + "]";
    }

    @Override
    public Iterator<T> iterator() {
        return valores.listIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
