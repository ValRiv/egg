package Servicios;

import java.util.Scanner;

/**
 *
 * @author river
 */
public class MenuServicio {

    public void Menu() throws Exception {

        Scanner sc = new Scanner(System.in);
        ProductoServicio producto = new ProductoServicio();
        FabricanteServicio fabricante = new FabricanteServicio();
        int opcion = 0;
        boolean salir = true;
        while (salir) {
            System.out.println("----------MENU----------");
            System.out.println("1) Listar nombre de productos\n2) Listar nombre y precio de productos\n3) Listar productos cuyo precio esta entre $120 y $202\n4) Listar portatiles\n5) Nombre y precio del producto mas baratao\n6) Ingresar producto\n7) Ingresar fabricante\n8) Editar producto\n9) Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    producto.listarNombreProductos();
                    break;
                case 2:
                    producto.listarNombrePrecioProductos();
                    break;
                case 3:
                    producto.listarRangoPrecios();
                    break;
                case 4:
                    producto.listarPortatil();
                    break;
                case 5:
                    producto.listarProductoBarato();
                    break;
                case 6:
                    producto.cargarProducto();
                    break;
                case 7:
                    fabricante.cargarFabricante();
                    break;
                case 8:
                    producto.modificarProducto();
                    break;
                case 9:
                    salir = false;
                    break;
                default:
                    System.out.println("Elija una opción valida");
                    break;
            }
        }

    }

}
