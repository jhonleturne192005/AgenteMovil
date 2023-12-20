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
public class ServidorUno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            Registry rs = LocateRegistry.createRegistry(3331);
            rs.rebind("serviceInfo1", new EspecificacionesPC()
                                                .especificaciones("I7", "SSD", 
                                                        "1MB/S", "3.0", 
                                                        "Windows 10","serviceInfo1"));
            System.out.println("Servidor uno activo"+InetAddress.getLocalHost().getHostName());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
}
