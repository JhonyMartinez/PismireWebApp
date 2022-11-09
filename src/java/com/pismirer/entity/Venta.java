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
@Table(name = "tbl_ventas")
public class Venta implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idVenta")
    private int idVenta;
    
    @Column(name = "fecVenta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "horVenta")
    private Date horaVenta;
    
    @Column(name = "valVenta")
    private double valorVenta;
    
    @Column(name = "tipoVenta")
    private String tipoVenta;
    
    @ManyToOne
    @JoinColumn(name = "FK_idMPago", referencedColumnName = "PK_idMPago")
    private MetodoPago FK_idMPago;
    
    @ManyToOne
    @JoinColumn(name = "FK_idPersona", referencedColumnName = "PK_idPersona")
    private Persona FK_idPersona;
   
    @Column(name = "estado")
    private boolean estadoVenta;
    
    @OneToMany(mappedBy = "FK_idVenta")
    private List<Domicilio> lstDomicilios;
    
    @OneToMany(mappedBy = "FK_idVenta")
    private List<DetalleVenta> lstDetallesVentas;

    public Venta() {
    }

    public Venta(int idVenta, Date fechaVenta, Date horaVenta, double valorVenta, String tipoVenta, MetodoPago FK_idMPago, Persona FK_idPersona, boolean estadoVenta, List<Domicilio> lstDomicilios, List<DetalleVenta> lstDetallesVentas) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.valorVenta = valorVenta;
        this.tipoVenta = tipoVenta;
        this.FK_idMPago = FK_idMPago;
        this.FK_idPersona = FK_idPersona;
        this.estadoVenta = estadoVenta;
        this.lstDomicilios = lstDomicilios;
        this.lstDetallesVentas = lstDetallesVentas;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Date horaVenta) {
        this.horaVenta = horaVenta;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public MetodoPago getFK_idMPago() {
        return FK_idMPago;
    }

    public void setFK_idMPago(MetodoPago FK_idMPago) {
        this.FK_idMPago = FK_idMPago;
    }

    public Persona getFK_idPersona() {
        return FK_idPersona;
    }

    public void setFK_idPersona(Persona FK_idPersona) {
        this.FK_idPersona = FK_idPersona;
    }

    public boolean isEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(boolean estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public List<Domicilio> getLstDomicilios() {
        return lstDomicilios;
    }

    public void setLstDomicilios(List<Domicilio> lstDomicilios) {
        this.lstDomicilios = lstDomicilios;
    }

    public List<DetalleVenta> getLstDetallesVentas() {
        return lstDetallesVentas;
    }

    public void setLstDetallesVentas(List<DetalleVenta> lstDetallesVentas) {
        this.lstDetallesVentas = lstDetallesVentas;
    }

    
}
