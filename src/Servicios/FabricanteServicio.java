package Servicios;

import Entidades.Fabricante;
import Persistencia.FabricanteDAO;
import static Servicios.ProductoServicio.espacios;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author river
 */
public class FabricanteServicio {

    FabricanteDAO dao = new FabricanteDAO();
 public void listarFabricantes() throws Exception{
        FabricanteDAO dao = new FabricanteDAO();
        try {
            List<Fabricante> fabricantes = dao.listarFabricantes();
            if(fabricantes.isEmpty()){
                throw new Exception("No existen productos para imprimir");
            }else{
                System.out.println("Código:\t\t"+espacios("Nombre:"));
                for (Fabricante aux : fabricantes) {
                    System.out.println(aux.getCodigo()+"\t\t" + aux.getNombre());
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
    } 
    
    public void cargarFabricante() throws Exception {
        FabricanteDAO dao = new FabricanteDAO();
        Scanner sc = new Scanner(System.in);
        Fabricante nuevoFabricante = new Fabricante();
        System.out.println("Ingrese el nombre del Fabricante:");
        nuevoFabricante.setNombre(sc.nextLine());
        dao.guardarFabricante(nuevoFabricante);
        System.out.println("Fabricante Cargado con éxito!!!");

    }

}
