import java.util.Random;

public class Upgrade {
    public static void main(String[] args) {
        Computador comp = new Computador(1, (int) (Math.random() * 10));

        System.out.println("Disco: " + comp.getDisco() + " Memoria: " + comp.getMemoria());
        upgradeMemory(comp, comp.getDisco() +1, comp.getMemoria() +1);
        System.out.println("Disco: " + comp.getDisco() + " Memoria: " + comp.getMemoria());
    }

    public static void upgradeMemory(Computador comp, int disco, int memoria){
        comp.setDisco(disco);
        comp.setMemoria(memoria);
    }
}
