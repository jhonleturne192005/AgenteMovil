/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploagentemovil;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class EspecificacionesPC extends UnicastRemoteObject implements Iespecificaciones{
    
    private String procesador;
    private String tipo_disco;
    private String velocidad_red;
    private String version_tarjeta_wifi;
    private String sistema_operativo;
    private Boolean estado;
    private String servidor;

    private ResultSet rs;

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    
    
    
    
    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    
    
    
    
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getTipo_disco() {
        return tipo_disco;
    }

    public void setTipo_disco(String tipo_disco) {
        this.tipo_disco = tipo_disco;
    }

    public String getVelocidad_red() {
        return velocidad_red;
    }

    public void setVelocidad_red(String velocidad_red) {
        this.velocidad_red = velocidad_red;
    }

    public String getVersion_tarjeta_wifi() {
        return version_tarjeta_wifi;
    }

    public void setVersion_tarjeta_wifi(String version_tarjeta_wifi) {
        this.version_tarjeta_wifi = version_tarjeta_wifi;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }
    
    
    
    public EspecificacionesPC()throws RemoteException{};

    @Override
    public Entity imprimir()  throws RemoteException{
        System.out.println("PROCESADOR: "+this.getProcesador());
        System.out.println("TIPO DISCO: "+this.getTipo_disco());
        System.out.println("VELOCIDAD DE RED: "+this.getVelocidad_red());
        System.out.println("VERSION DE TARJETA WIFI: "+this.getProcesador());
        System.out.println("SISTEMA OPERATIVO: "+this.getProcesador());
        return new Entity(this.getProcesador(),this.getTipo_disco(),this.getVelocidad_red(),this.getProcesador(),this.getProcesador(),this.getServidor());
    }

    @Override
    public EspecificacionesPC especificaciones(String procesador, String tipo_disco, 
            String velocidad_red, String version_tarjeta_wifi, String sistema_operativo,String servidor) throws RemoteException {
        try {
            EspecificacionesPC epc=new EspecificacionesPC();
            epc.setEstado(false);
            epc.setProcesador(procesador);
            epc.setTipo_disco(tipo_disco);
            epc.setVelocidad_red(velocidad_red);
            epc.setVersion_tarjeta_wifi(version_tarjeta_wifi);
            epc.setSistema_operativo(sistema_operativo);
            epc.setServidor(servidor);
            epc.setEstado(true);
            return epc;
        } catch (RemoteException ex) {
            Logger.getLogger(EspecificacionesPC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean guardar_base_dato(List<Entity> lst_epc) throws RemoteException {
        try
        {
            conexionPostgres postg=new conexionPostgres();
            for(Entity lepc : lst_epc)
                postg.query(lepc);
            setRs(postg.mostrar_inst());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public void mostrarTodo() throws RemoteException 
    {
        try
        {
            ResultSet rs=getRs();
            while(rs.next())
                System.out.println("ID= "+rs.getInt("id_c")+
                        " PROCESADOR= "+rs.getString("procesador")+
                        " Tipo Disco= "+rs.getString("velocidad_red")+
                        " Version Tarjeta wifi= "+rs.getString("v_tarj_wifi")+
                        " Sistema operativo= "+rs.getString("sistema_opertivo")+
                        " Servidor= "+rs.getString("servidor"));
            rs.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
