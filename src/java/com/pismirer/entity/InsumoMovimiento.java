package com.pismirer.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_insumov")
public class InsumoMovimiento implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idInsuMov")
    private int idInsumoMovimiento;
    
    @ManyToOne
    @JoinColumn(name = "FK_idMovimiento", referencedColumnName = "PK_idMovimiento")
    private Movimiento FK_idMovimiento;
    
    @ManyToOne
    @JoinColumn(name = "FK_idInsumo", referencedColumnName = "PK_idInsumo")
    private Insumo FK_idInsumo;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "venInsumo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimientoInsumo;
    
    @Column(name = "estado")
    private boolean estadoInsuMov;

    public InsumoMovimiento() {
    }

    public InsumoMovimiento(int idInsumoMovimiento, Movimiento FK_idMovimiento, Insumo FK_idInsumo, int cantidad, Date vencimientoInsumo, boolean estadoInsuMov) {
        this.idInsumoMovimiento = idInsumoMovimiento;
        this.FK_idMovimiento = FK_idMovimiento;
        this.FK_idInsumo = FK_idInsumo;
        this.cantidad = cantidad;
        this.vencimientoInsumo = vencimientoInsumo;
        this.estadoInsuMov = estadoInsuMov;
    }

    public int getIdInsumoMovimiento() {
        return idInsumoMovimiento;
    }

    public void setIdInsumoMovimiento(int idInsumoMovimiento) {
        this.idInsumoMovimiento = idInsumoMovimiento;
    }

    public Movimiento getFK_idMovimiento() {
        return FK_idMovimiento;
    }

    public void setFK_idMovimiento(Movimiento FK_idMovimiento) {
        this.FK_idMovimiento = FK_idMovimiento;
    }

    public Insumo getFK_idInsumo() {
        return FK_idInsumo;
    }

    public void setFK_idInsumo(Insumo FK_idInsumo) {
        this.FK_idInsumo = FK_idInsumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getVencimientoInsumo() {
        return vencimientoInsumo;
    }

    public void setVencimientoInsumo(Date vencimientoInsumo) {
        this.vencimientoInsumo = vencimientoInsumo;
    }

    public boolean isEstadoInsuMov() {
        return estadoInsuMov;
    }

    public void setEstadoInsuMov(boolean estadoInsuMov) {
        this.estadoInsuMov = estadoInsuMov;
    }

    
}
