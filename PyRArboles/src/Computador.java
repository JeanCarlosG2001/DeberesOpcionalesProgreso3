public class Computador {
    private int codigo;
    private String marca;
    private String procesador;
    private int ram;

    public Computador(int codigo, String marca, String procesador, int ram) {
        this.codigo = codigo;
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Computador" +
                "codigo=" + codigo +
                ", marca='" + marca +
                ", procesador='" + procesador +
                ", ram:" + ram +"GB\n";
    }
}
