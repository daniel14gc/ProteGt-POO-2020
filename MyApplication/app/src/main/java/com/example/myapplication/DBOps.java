package com.example.myapplication;

import java.lang.annotation.ElementType;
import java.util.ArrayList;

public interface DBOps {
    public abstract void addElements(Object n);

    public abstract ArrayList<Object> getElements();

    public abstract void modificarElemento(Object n);

}
