public class Transformer
{
    private int id;
    private String faccion;
    private String nombre;
    private Float nivelPoder;


    public Transformer(int id, String faccion, String nombre, Float nivelPoder) {
        this.id = id;
        this.faccion = faccion;
        this.nombre = nombre;
        this.nivelPoder = nivelPoder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaccion() {
        return faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public Float getNivelPoder() {
        return nivelPoder;
    }

    public void setNivelPoder(Float nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Transformer " +
                "id= " + id +
                ", faccion= " + faccion + '\'' +
                ", nombre= " + nombre + '\'' +
                ", nivelPoder= " + nivelPoder;
    }
}
