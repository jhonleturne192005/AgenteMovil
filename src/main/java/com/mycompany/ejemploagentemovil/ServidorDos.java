/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejemploagentemovil;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author USUARIO
 */
public class ServidorDos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try
        {
            Registry rs = LocateRegistry.createRegistry(3332);
            rs.rebind("serviceInfo2", new EspecificacionesPC()
                                                .especificaciones("I9", "HDD", 
                                                        "5MB/S", "2.0", 
                                                        "Windows 11","serviceInfo2"));
            System.out.println("Servidor dos activo"+InetAddress.getLocalHost().getHostName());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
}
