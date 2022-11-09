package com.pismirer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_insumos")
public class Insumo implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idInsumo")
    private int idInsumo;
    
    @Column(name = "fecRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    
    @Column(name = "nomInsumo")
    private String nombreInsumo;
    
    @Column(name = "desInsumo")
    private String descripcionInsumo;
    
    @Column(name = "preInsumo")
    private double precioInsumo;
    
    @Column(name = "canDisponible")
    private int cantidadDisponible;
    
    @Column(name = "estado")
    private boolean estadoInsumo;
    
    @ManyToOne
    @JoinColumn(name = "FK_idCategoria", referencedColumnName = "PK_idCategoria")
    private Categoria FK_idCategoria;
    
    @OneToMany(mappedBy = "FK_idInsumo")
    private List<InsumoPlato> lstInsumosPlato;

    @OneToMany(mappedBy = "FK_idInsumo")
    private List<InsumoMovimiento> lstInsumosMovimiento;

    public Insumo() {
    }

    public Insumo(int idInsumo, Date fechaRegistro, String nombreInsumo, String descripcionInsumo, double precioInsumo, int cantidadDisponible, boolean estadoInsumo, Categoria FK_idCategoria, List<InsumoPlato> lstInsumosPlato, List<InsumoMovimiento> lstInsumosMovimiento) {
        this.idInsumo = idInsumo;
        this.fechaRegistro = fechaRegistro;
        this.nombreInsumo = nombreInsumo;
        this.descripcionInsumo = descripcionInsumo;
        this.precioInsumo = precioInsumo;
        this.cantidadDisponible = cantidadDisponible;
        this.estadoInsumo = estadoInsumo;
        this.FK_idCategoria = FK_idCategoria;
        this.lstInsumosPlato = lstInsumosPlato;
        this.lstInsumosMovimiento = lstInsumosMovimiento;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public String getDescripcionInsumo() {
        return descripcionInsumo;
    }

    public void setDescripcionInsumo(String descripcionInsumo) {
        this.descripcionInsumo = descripcionInsumo;
    }

    public double getPrecioInsumo() {
        return precioInsumo;
    }

    public void setPrecioInsumo(double precioInsumo) {
        this.precioInsumo = precioInsumo;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public boolean isEstadoInsumo() {
        return estadoInsumo;
    }

    public void setEstadoInsumo(boolean estadoInsumo) {
        this.estadoInsumo = estadoInsumo;
    }

    public Categoria getFK_idCategoria() {
        return FK_idCategoria;
    }

    public void setFK_idCategoria(Categoria FK_idCategoria) {
        this.FK_idCategoria = FK_idCategoria;
    }

    public List<InsumoPlato> getLstInsumosPlato() {
        return lstInsumosPlato;
    }

    public void setLstInsumosPlato(List<InsumoPlato> lstInsumosPlato) {
        this.lstInsumosPlato = lstInsumosPlato;
    }

    public List<InsumoMovimiento> getLstInsumosMovimiento() {
        return lstInsumosMovimiento;
    }

    public void setLstInsumosMovimiento(List<InsumoMovimiento> lstInsumosMovimiento) {
        this.lstInsumosMovimiento = lstInsumosMovimiento;
    }

    
}
