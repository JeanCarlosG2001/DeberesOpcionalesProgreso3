public class Jugador {

    //atributos
    private int codigo;
    private String nombre;
    private float rendimiento;
    private String posicion;

        //se crea el constructor con los 4 atributos
    public Jugador(int codigo, String nombre, float rendimiento, String posicion)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.rendimiento = rendimiento;
        this.posicion = posicion;
    }
    //se generar getters y setters de codigo porque se hace actuliazaciones del codigo
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //se genera un to string de toto

    @Override
    public String toString() {
        return "Jugador " +
                "codigo: " + codigo +
                ", nombre: " + nombre +
                ", rendimiento: " + rendimiento +
                ", posicion: " + posicion + "\n";
    }
}
