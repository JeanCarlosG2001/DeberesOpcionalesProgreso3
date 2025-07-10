import java.util.ArrayList;
import java.util.List;

public class Lista
{
    private List<Transformer> lista;


    public Lista()
    {
        lista = new ArrayList<>();
    }

    public void agregar(Transformer dato)
    {
        lista.add(dato);
    }

    public float sumarPoder()
    {
        return sumarRecursiva(0);

    }


    //METODO RECURSIVO
    private float sumarRecursiva(int indice)
    {
        if (indice >= lista.size())
            return 0;
        else
            return lista.get(indice).getNivelPoder() + sumarRecursiva(indice+1);

    }

    public String listar()
    {
        StringBuilder sb=new StringBuilder();
        for (Transformer t:lista)
        {
         sb.append(t.toString()+ "\n");
        }
        return sb.toString();
    }
}
