/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class koneksiDB {
    public static Connection koneksi=null;
    
    public static Connection getKoneksi(){
        if(koneksi==null){
            try{
                String url="jdbc:mysql://localhost/LogBook";
                String user="root";
                String pass="";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(url, user, pass);
            }catch(Exception Ex){
                
            }
        }
        return koneksi;
    }
}
