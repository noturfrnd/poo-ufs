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
        System.out.println("Guitarra adicionada com sucesso");
    }

    public void removerGuitarra(String nrSerial) {
        for (int i = 0; i < listaGuitarra.size(); i++) {
            if (listaGuitarra.get(i).getSerialNumber().equals(nrSerial)){
                listaGuitarra.remove(i);
                System.out.println("Guitarra removida com sucesso");
                return;
            }
        }
        System.out.println("Essa guitarra nao foi encontrada");
    }
    public Guitarra obterGuitarra(String serialNumber) {
        for (Guitarra guitarra : listaGuitarra) {
            if (guitarra.getSerialNumber().equals(serialNumber)) {
                return guitarra;
            }
        }
        System.out.println("Essa guitarra nao foi encontrada");
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
        Guitarra guitarra1 = obterGuitarra(guitarra.getSerialNumber());
        if (guitarra1 != null) {
            int index = listaGuitarra.indexOf(guitarra1);
            listaGuitarra.set(index, guitarra);
            System.out.println("Guitarra editada");
        }
        System.out.println("Guitarra não encontrada");
    }
}
