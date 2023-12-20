/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejemploagentemovil;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class EjemploAgenteMovil {

    public static List<String> lst_nodos;
    
    public static void main(String[] args) 
    {
        lst_nodos=new ArrayList<String>();
        lst_nodos.add("serviceInfo1");
        lst_nodos.add("serviceInfo2");
        lst_nodos.add("serviceInfo3");
        try
        {
        
            Thread thread_response=new Thread(new Runnable() {
                @Override
                public void run() 
                {
                    try
                    {
                        Entity epc1,epc2,epc3;
                        
                        System.out.print("Moviendose a el primer nodo...\n");
                        Iespecificaciones dd1=(Iespecificaciones) Naming.lookup("//localhost:3331/"+lst_nodos.get(0));
                        epc1= dd1.imprimir();
                     
                        
               
                        Thread.sleep(3000);
                        
                        System.out.print("Moviendose a el segudo nodo...\n");
                        Iespecificaciones dd2=(Iespecificaciones) Naming.lookup("//localhost:3332/"+lst_nodos.get(1));
                        epc2 = dd2.imprimir();
                        
                        Thread.sleep(3000);
                        
                        System.out.print("Moviendose a el tercer nodo...\n");
                        Iespecificaciones dd3=(Iespecificaciones) Naming.lookup("//localhost:3333/"+lst_nodos.get(2));
                        epc3 = dd3.imprimir();
                        
                        
                        Thread.sleep(3000);
                        
                        System.out.print("Moviendose a el nodo central para guardar informacion...\n");
                        Iespecificaciones dd4=(Iespecificaciones) Naming.lookup("//localhost:3334/serviceCental");
                        List<Entity> lst_epc=new ArrayList<>();
                        lst_epc.add(epc1);
                        lst_epc.add(epc2);
                        lst_epc.add(epc3);
                        dd4.guardar_base_dato(lst_epc);
                        dd4.mostrarTodo();
   
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                }
            });
 
            thread_response.start();
            Thread.sleep(5000);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
