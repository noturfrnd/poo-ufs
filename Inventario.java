import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Guitarra> listaGuitarra;
    public Inventario(ArrayList<Guitarra> listaGuitarra) {
        this.listaGuitarra = listaGuitarra;
    }
    public ArrayList<Guitarra> getListaGuitarra() {
        return listaGuitarra;
    }
    public void setListaGuitarra(ArrayList<Guitarra> listaGuitarra) {
        this.listaGuitarra = listaGuitarra;
    }
    public void adicionarGuitarra(Guitarra guitarra) {
        if (listaGuitarra.contains(guitarra)) {
            System.out.println("Guitarra ja adicionada");
            return;
        }
        listaGuitarra.add(guitarra);
    }
    public Guitarra obterGuitarra(String serialNumber) {
        for (Guitarra guitarra : listaGuitarra) {
            if (guitarra.getSerialNumber().equals(serialNumber)) {
                return guitarra;
            }
        }
        return null;
    }

    public ArrayList<Guitarra> listarGuitarras (String fabricante){
        ArrayList<Guitarra> listaGuitarraTemp = new ArrayList<>();
        for (Guitarra guitarra : listaGuitarra) {
            if (guitarra.getFabricante().equals(fabricante)) {
                listaGuitarraTemp.add(guitarra);
            }
        }
        return listaGuitarraTemp;
    }

    public void editarGuitarra (Guitarra guitarra){
        if (listaGuitarra.contains(guitarra)){
            int index = listaGuitarra.indexOf(guitarra);
            listaGuitarra.set(index, guitarra);
            return;
        }
        System.out.println("Essa guitarra não existe");
    }
}
