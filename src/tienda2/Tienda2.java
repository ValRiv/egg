
package tienda2;

import Servicios.MenuServicio;
import java.sql.SQLException;

/**
 *
 * @author river
 */
public class Tienda2 {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {

        MenuServicio nuevoMenu = new MenuServicio();
        nuevoMenu.Menu();
  }
}

