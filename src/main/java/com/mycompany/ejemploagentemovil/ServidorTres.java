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
public class ServidorTres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            Registry rs = LocateRegistry.createRegistry(3333);
            rs.rebind("serviceInfo3", new EspecificacionesPC()
                                                .especificaciones("AMD", "SSD", 
                                                        "10MB/S", "4.0", 
                                                        "CentOS","serviceInfo3"));
            System.out.println("Servidor tres activo"+InetAddress.getLocalHost().getHostName());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
}
