package com.example.quecocinohoy;

public class ListElement {
    public String color;
    public String name;
    public String descripcion;
    public String tipo;


    public ListElement(String color, String name, String descripcion, String tipo) {
        this.color = color;
        this.name = name;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String city) {
        this.descripcion = city;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


