package com.example.myapplication;

/*
    DBPops.java
    Grupo 6, proyecto semestral.
    Última modificación: 2020-11-4

    Interfaz que permite leer, escribir
    y modificar en una base de datos.
*/


import java.lang.annotation.ElementType;
import java.util.ArrayList;

public interface DBOps {

    //Metodo para escibir en la base de datos.
    public void addElements(Object n);

    //Método para consultar todos los elementos de la base de datos.
    public ArrayList<Object> getElements();

    //Método para modificar un elemento de la base de datos.
    public void modificarElemento(Object n);

}
