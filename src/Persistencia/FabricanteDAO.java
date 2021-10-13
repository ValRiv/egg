
package Persistencia;

import Entidades.Fabricante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author river
 */
public class FabricanteDAO extends DAO{
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un usuario");
            }
            String sql = "INSERT INTO fabricante (nombre)"
                    + "VALUES ('" + fabricante.getNombre() + "' );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }
            String sql = "UPDATE fabricante SET"
                    + "nombre= '" + fabricante.getNombre() + "' WHERE codigo= '" + fabricante.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Fabricante buscarFabricantePorId(Integer id) throws Exception {
        try {
            String sql = "SELECT * FROM fabricante"
                    + "WHERE codigo='" + id + "'";

            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(0));
                fabricante.setNombre(resultado.getString(1));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

    public List<Fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT codigo,nombre FROM fabricante";

            consultarBase(sql);
            Fabricante fabricante = null;
            List<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

}


