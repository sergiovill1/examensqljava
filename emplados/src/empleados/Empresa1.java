package empleados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Empresa1 {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        
        try {
            cn = conexion.conectar();
            stm = cn.createStatement();            
            rs = stm.executeQuery("SELECT empresa.nombre, empleado.nombre, empleado.ap_paterno, empleado.ap_materno, empleado.edad FROM empleado , empresa WHERE empleado.id_empresa = empresa.id_empresa AND empresa.nombre LIKE 'empresa_1'");

            
            while (rs.next()) {
                String nombre_empresa = rs.getString(1);
                String id_empresa = rs.getString(2);
                String ap_paterno = rs.getString(3);
                String ap_materno = rs.getString(4);
                int edad = rs.getInt(5);
                
                System.out.println(nombre_empresa + " - " + id_empresa + " - " + ap_paterno + " - " + ap_materno + " - " + edad );
                
            }
            
            System.out.println('\n');
            
           
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (rs!= null) {
                    rs.close();
                }
                
                if (stm != null) {
                    stm.close();
                }
                
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
    }
}
