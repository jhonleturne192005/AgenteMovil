/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploagentemovil;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author USUARIO
 */
public class ServidorCentral {

    public static void main(String[] args)  
    {
        try
        {
            Registry rs = LocateRegistry.createRegistry(3334);
            rs.rebind("serviceCental", new EspecificacionesPC());
            System.out.println("Servidor central activo"+InetAddress.getLocalHost().getHostName());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}