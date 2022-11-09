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
@Table(name = "tbl_platos")
public class Plato implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idPlato")
    private int idPlato;
    
    @Column(name = "nomPlato")
    private String nombrePlato;
    
    @Column(name = "desPlato")
    private String descripcionPlato;
    
    @Column(name = "fecCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Column(name = "prePlato")
    private double precioPlato;
    
    @Column(name = "fotPlato")
    private String fotoPlato;
    
    @Column(name = "estado")
    private boolean estadoPlato;
    
    @ManyToOne
    @JoinColumn(name = "FK_idTipoPlato", referencedColumnName = "PK_idTipoPlato")
    private TipoPlato FK_idTipoPlato;
    
    @OneToMany(mappedBy = "FK_idPlato")
    private List<DetalleVenta> lstDetallesVentas;
    
    @OneToMany(mappedBy = "FK_idPlato")
    private List<InsumoPlato> lstInsumosPlato;

    public Plato() {
    }

    public Plato(int idPlato, String nombrePlato, String descripcionPlato, Date fechaCreacion, double precioPlato, String fotoPlato, boolean estadoPlato, TipoPlato FK_idTipoPlato, List<DetalleVenta> lstDetallesVentas, List<InsumoPlato> lstInsumosPlato) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.descripcionPlato = descripcionPlato;
        this.fechaCreacion = fechaCreacion;
        this.precioPlato = precioPlato;
        this.fotoPlato = fotoPlato;
        this.estadoPlato = estadoPlato;
        this.FK_idTipoPlato = FK_idTipoPlato;
        this.lstDetallesVentas = lstDetallesVentas;
        this.lstInsumosPlato = lstInsumosPlato;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public String getFotoPlato() {
        return fotoPlato;
    }

    public void setFotoPlato(String fotoPlato) {
        this.fotoPlato = fotoPlato;
    }

    public boolean isEstadoPlato() {
        return estadoPlato;
    }

    public void setEstadoPlato(boolean estadoPlato) {
        this.estadoPlato = estadoPlato;
    }

    public TipoPlato getFK_idTipoPlato() {
        return FK_idTipoPlato;
    }

    public void setFK_idTipoPlato(TipoPlato FK_idTipoPlato) {
        this.FK_idTipoPlato = FK_idTipoPlato;
    }

    public List<DetalleVenta> getLstDetallesVentas() {
        return lstDetallesVentas;
    }

    public void setLstDetallesVentas(List<DetalleVenta> lstDetallesVentas) {
        this.lstDetallesVentas = lstDetallesVentas;
    }

    public List<InsumoPlato> getLstInsumosPlato() {
        return lstInsumosPlato;
    }

    public void setLstInsumosPlato(List<InsumoPlato> lstInsumosPlato) {
        this.lstInsumosPlato = lstInsumosPlato;
    }

    
}
