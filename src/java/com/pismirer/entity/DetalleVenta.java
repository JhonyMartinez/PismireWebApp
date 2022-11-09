package com.pismirer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_detalleventas")
public class DetalleVenta implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idDetalle")
    private int idDetalle;
    
    @ManyToOne
    @JoinColumn(name = "FK_idVenta", referencedColumnName = "PK_idVenta")
    private Venta FK_idVenta;
    
    @ManyToOne
    @JoinColumn(name = "FK_idPlato", referencedColumnName = "PK_idPlato")
    private Plato FK_idPlato;
    
    @Column(name = "canPlato")
    private int cantidadPlato;
    
    @Column(name = "totPlato")
    private double totalPlato;

    @Column(name = "estado")
    private boolean estadoDetalle;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalle, Venta FK_idVenta, Plato FK_idPlato, int cantidadPlato, double totalPlato, boolean estadoDetalle) {
        this.idDetalle = idDetalle;
        this.FK_idVenta = FK_idVenta;
        this.FK_idPlato = FK_idPlato;
        this.cantidadPlato = cantidadPlato;
        this.totalPlato = totalPlato;
        this.estadoDetalle = estadoDetalle;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Venta getFK_idVenta() {
        return FK_idVenta;
    }

    public void setFK_idVenta(Venta FK_idVenta) {
        this.FK_idVenta = FK_idVenta;
    }

    public Plato getFK_idPlato() {
        return FK_idPlato;
    }

    public void setFK_idPlato(Plato FK_idPlato) {
        this.FK_idPlato = FK_idPlato;
    }

    public int getCantidadPlato() {
        return cantidadPlato;
    }

    public void setCantidadPlato(int cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
    }

    public double getTotalPlato() {
        return totalPlato;
    }

    public void setTotalPlato(double totalPlato) {
        this.totalPlato = totalPlato;
    }

    public boolean isEstadoDetalle() {
        return estadoDetalle;
    }

    public void setEstadoDetalle(boolean estadoDetalle) {
        this.estadoDetalle = estadoDetalle;
    }
    
    
}
