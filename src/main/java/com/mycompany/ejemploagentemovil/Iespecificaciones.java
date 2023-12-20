/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ejemploagentemovil;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface Iespecificaciones extends Remote
{
    public EspecificacionesPC especificaciones(String procesador,
            String tipo_disco,String velocidad_red,
            String version_tarjeta_wifi,String sistema_operativo,String servidor) throws RemoteException;
        public Entity imprimir() throws RemoteException;
    
    public Boolean guardar_base_dato(List<Entity> lst_epc) throws RemoteException;
    
    public void mostrarTodo() throws RemoteException;
    
    
}
