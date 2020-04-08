/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinventoribarang.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import programinventoribarang.DAO.db_Config;

/**
 *
 * @author MohamadEsa
 */
public class dbUtilities implements db_Config{
    private static Connection con;
    
    public static Connection config(){
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(link, user, pass);
            if(con==null){
                System.err.println("Koneksi Hilang/Tidak Ada");
            } else{
                System.out.println("Berhasil Tersambung");
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println("Kode Akses Error : "+e);
        }
        return con;
    }
    
}
