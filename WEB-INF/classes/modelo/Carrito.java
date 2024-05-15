package modelo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Carrito implements Serializable {

    private HashMap<String, Float[]> listaDiscos = new HashMap<>();

    public Carrito() {
    }

    public void setDisco(String disco, Float cantidad, Float precio) {
        if (disco != null && cantidad > 0 && precio > 0) {
            Float[] valores = new Float[2];
            valores[0] = cantidad;
            valores[1] = precio;
            listaDiscos.put(disco, valores);
        }
    }

    public void removeDisco(String disco) {
        if (disco != null) {
            listaDiscos.remove(disco);
        }
    }

    public HashMap<String, Float[]> getListaDiscos() {
        return listaDiscos;
    }

    public void setListaDiscos(HashMap<String, Float[]> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }

    public float calcularPrecio() {
        float precioFinal = 0;
        
        if (!listaDiscos.isEmpty()) {
            for (Map.Entry<String, Float[]> entry : listaDiscos.entrySet()) {
                precioFinal += entry.getValue()[1];
            }
        }

        return precioFinal;
    }

}
