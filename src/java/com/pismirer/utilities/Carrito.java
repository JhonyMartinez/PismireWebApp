package com.pismirer.utilities;

public class Carrito {
    
    int producto;
    int idPlato;
    int cantidad;
    String nombrePlato;
    String descripcion;
    double precio;
    double subTotal;

    public Carrito() {
    }

    public Carrito(int producto, int idPlato, int cantidad, double precio, double subTotal) {
        this.producto = producto;
        this.idPlato = idPlato;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
