public class Computador {
    private int memoria;
    private int disco;

    public Computador(int disco, int memoria) {
        this.memoria = memoria;
        this.disco = disco;
    }

    public int getDisco() {
        return disco;
    }
    public void setDisco(int disco) {
        this.disco = disco;
    }
    public int getMemoria() {
        return memoria;
    }
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
}
