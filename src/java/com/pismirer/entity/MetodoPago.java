package com.pismirer.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_metodospago")
public class MetodoPago implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idMPago")
    private int idMetodoPago;
    
    @Column(name = "metodoPago")
    private String nombreMetodoPago;
    
    @Column(name = "estado")
    private boolean estadoMPago;
    
    @OneToMany(mappedBy = "FK_idMPago")
    private List<Venta> lstVentas;

    public MetodoPago() {
    }

    public MetodoPago(int idMetodoPago, String nombreMetodoPago, boolean estadoMPago, List<Venta> lstVentas) {
        this.idMetodoPago = idMetodoPago;
        this.nombreMetodoPago = nombreMetodoPago;
        this.estadoMPago = estadoMPago;
        this.lstVentas = lstVentas;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }

    public void setNombreMetodoPago(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }

    public boolean isEstadoMPago() {
        return estadoMPago;
    }

    public void setEstadoMPago(boolean estadoMPago) {
        this.estadoMPago = estadoMPago;
    }

    public List<Venta> getLstVentas() {
        return lstVentas;
    }

    public void setLstVentas(List<Venta> lstVentas) {
        this.lstVentas = lstVentas;
    }

    
}
