/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package modelo;

import java.util.HashMap;

/**
 *
 * @author lucas
 */
public class Pedido {

    private String usuario_id;
    private HashMap<String, Float[]> listaDiscos;
    private float precio;
    
    public Pedido(){}

    public Pedido(String usuario_id, HashMap<String, Float[]> listaDiscos, float precio) {
        this.usuario_id = usuario_id;
        this.listaDiscos = listaDiscos;
        this.precio = precio;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public HashMap<String, Float[]> getListaDiscos() {
        return listaDiscos;
    }

    public void setListaDiscos(HashMap<String, Float[]> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    
    
}
