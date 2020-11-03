package com.example.myapplication;

import java.lang.annotation.ElementType;
import java.util.ArrayList;

public interface DBOps {
    public void addElements(Object n);

    public ArrayList<Object> getElements();

    public void modificarElemento(Object n);

}
