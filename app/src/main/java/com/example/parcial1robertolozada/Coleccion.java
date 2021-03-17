package com.example.parcial1robertolozada;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Coleccion {
    private List<String> vectorDatos;
    public Coleccion() {
        vectorDatos = new ArrayList<String>();
    }

    public void AgregarDato(String n) {
        this.vectorDatos.add(n);
    }
    public String GetDatos(){
        String datosColeccion="";
        String datoFinal="Resultado: ";
        for(String i : vectorDatos){
            datosColeccion += " " + i;
        }
        datoFinal += datosColeccion;
        return datoFinal;
    }

    public String getDatoMayor(){
        String datoMayor="";
        datoMayor = Collections.max(vectorDatos);

        return datoMayor;
    }
    public String getDatoMenor(){
        String datoMenor="";
        datoMenor = Collections.min(vectorDatos);

        return datoMenor;
    }

    public void OrdenarArreglo(){
        Collections.sort(vectorDatos);
    }

    public float getPromedio(){
        float Promedio = 0;
        int aux = 0;
        int cont = 0;
        for(String i : vectorDatos){
            aux += Integer.parseInt(i);
            cont++;
        }

        Promedio = aux / cont;
        return Promedio;
    }

    public void BorrarDatos(String dato){
        vectorDatos.remove(dato);
    }

}
