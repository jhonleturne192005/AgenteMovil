/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploagentemovil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author USUARIO
 */
public class conexionPostgres 
{
    static String login="postgres";
    static String password ="123";
    static String url="jdbc:postgresql://localhost/agenteMovil";
    
    
    private Statement statement;
    private Connection conexion;

    
    public conexionPostgres() throws ClassNotFoundException, SQLException
    {
        conexion=null;
        statement=null;

        Class.forName("org.postgresql.Driver"); // se hace referencia al driver
        conexion=DriverManager.getConnection(url,login,password);
        
        
        if(conexion!=null)
        {
            statement = conexion.createStatement();
            System.out.println("Conexion a la base de datos "+url+" ......OK");
        }   
    }
    
    
    public long query(Entity epc) throws Exception
    {
        return statement.executeUpdate("insert into server_central_info (procesador,tipo_disco,velocidad_red,v_tarj_wifi,sistema_opertivo,servidor) values ('"+epc.getProcesador()+"','"+epc.getTipo_disco()+"','"+epc.getVelocidad_red()+"','"+epc.getVersion_tarjeta_wifi()+"','"+epc.getSistema_operativo()+"','"+epc.getServidor()+"')");
    }

    
    public ResultSet mostrar_inst() throws Exception
    {
        return statement.executeQuery("select * from server_central_info");
    }    
  

}
