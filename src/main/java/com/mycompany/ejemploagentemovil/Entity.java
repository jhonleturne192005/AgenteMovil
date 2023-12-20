/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploagentemovil;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Entity implements Serializable
{
    private String procesador;
    private String tipo_disco;
    private String velocidad_red;
    private String version_tarjeta_wifi;
    private String sistema_operativo;
    private String servidor;

    public Entity(String procesador, String tipo_disco, String velocidad_red, String version_tarjeta_wifi, String sistema_operativo, String servidor) {
        this.procesador = procesador;
        this.tipo_disco = tipo_disco;
        this.velocidad_red = velocidad_red;
        this.version_tarjeta_wifi = version_tarjeta_wifi;
        this.sistema_operativo = sistema_operativo;
        this.servidor = servidor;
    }

    
    public String getProcesador() 
    {
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

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    
    
    
    
    
    
    
}
