
package Persistencia;

import Entidades.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author river
 */
public class ProductoDAO extends DAO{
     public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }

            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)"
                    + "VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre() + "', '" + producto.getPrecio() + "', '" + producto.getCodigoFabricante() + "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE producto SET nombre = '" + producto.getNombre() + "',precio='" + producto.getPrecio() + "',codigo_fabricante='" + producto.getCodigoFabricante() + "' WHERE codigo = '" + producto.getCodigo() + "';";

            insertarModificarEliminar(sql);
            System.out.println("Producto modificado con éxito!!!!!");
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorId(Integer id) throws Exception {
        try {
            String sql = "SELECT * FROM producto"
                    + "WHERE codigo ='" + id + "'";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    // a) Lista el nombre de todos los productos que hay en la tabla producto.

    public List<Producto> listarNombreProductos() throws Exception {
        try {
            String sql = " SELECT * FROM producto";
            consultarBase(sql);
            Producto producto = null;
            List<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    // b) Lista los nombres y los precios de todos los productos de la tabla producto. 

    public List<Producto> listarProducto() throws Exception {
        try {
            String sql = "SELECT * FROM ";
            consultarBase(sql);
            Producto producto = null;
            List<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    //c) Listar aquellos productos que su precio esté entre 120 y 202. 
    public List<Producto> listaRangoPrecio() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BEETWEEN 120 AND 200";
            consultarBase(sql);
            Producto producto = null;
            List<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

    //d) Buscar y listar todos los Portátiles de la tabla producto
    public List<Producto> listaDePortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto  WHERE LIKE \"port%\"";
            consultarBase(sql);
            Producto producto = null;
            List<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    //e) Listar el nombre y el precio del producto más barato.
    public List<Producto>listaDeProductoBarato() throws Exception{
        try {
            String sql ="SELECT * FROM producto ORDER BY precio ASC LIMIT 1 ";
            consultarBase(sql);
            Producto producto = null;
            List<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
       
}


