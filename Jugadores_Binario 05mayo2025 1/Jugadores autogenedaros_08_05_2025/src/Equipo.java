import java.util.ArrayList;
import java.util.List;

public class Equipo {
    //vamos a trabajar con array list con la interfaz list

    List<Jugador> lista;

    //como es un atributo
    private int secuencia = 0;

    public Equipo ()
    {
        lista = new ArrayList<>();
    }

    //metodo agregar jugador
    public void agregarJugador(Jugador nuevo)
    {
        //como empieza en 0, voy a hacer secuencia +++
        secuencia++;
        //setteo el codigo con secuencia, para actualizar el codigo
        nuevo.setCodigo((secuencia));
        lista.add(nuevo);
    }

    //ahora listar todos los jugadores
    public String listarTodos()
    {
      StringBuilder sb = new StringBuilder();
      //recorrido con todos los jugadores con el for mejorado

        for(Jugador j: lista)
        //a medida que voy recorriendo todo jugador, lo voy acumulando
        {
            sb.append(j.toString());
        }
        return sb.toString();
    }
    //hay que colocar throws excetpcion para manejo de errores
    public Jugador buscarJugador (int codigo) throws Exception
    {
        if (codigo < lista.getFirst().getCodigo() || codigo > lista.getLast().getCodigo())
        {
            throw new Exception("Codigo no esta en la lista");
        }

        int inf = 0;
        int sup = lista.size()-1;
        int cen;


        while(inf <= sup)
        {
            cen = (inf + sup)/2;
            //verificar en el centro si
            if(lista.get(cen).getCodigo()==codigo)
            {
                return lista.get(cen);
            } else if (codigo < lista.get(cen).getCodigo())
            {
                sup = cen-1;
            } else {
                inf = cen+1;
            }
        }

        //si sale del while no existio ese codigo en la lista, entonces se lanza otra exception
        throw new Exception("El codigo no esta dentro de la lista");

    }

}
//esto es el algoritmo de la busqueda binaria//