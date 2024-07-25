public class Guitarra {
    private String serialNumber;
    private Double preco;
    private String fabricante;
    private String tipo;
    private String modelo;

    public Guitarra(String serialNumber, Double preco, String fabricante, String tipo, String modelo) {
        this.serialNumber = serialNumber;
        this.preco = preco;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
