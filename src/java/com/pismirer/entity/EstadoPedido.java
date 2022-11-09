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
@Table(name = "tbl_estadospedido")
public class EstadoPedido implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idEstadoPedido")
    private int idEstadoPedido;
    
    @Column(name = "estadoPedido")
    private String nombreEstadoPedido;
    
    @OneToMany(mappedBy = "FK_idEstadoPedido")
    private List<Domicilio> lstDomicilios;

    @Column(name = "estado")
    private boolean estadoEPedido;
    
    public EstadoPedido() {
    }

    public EstadoPedido(int idEstadoPedido, String nombreEstadoPedido, List<Domicilio> lstDomicilios, boolean estadoEPedido) {
        this.idEstadoPedido = idEstadoPedido;
        this.nombreEstadoPedido = nombreEstadoPedido;
        this.lstDomicilios = lstDomicilios;
        this.estadoEPedido = estadoEPedido;
    }

    public int getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(int idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getNombreEstadoPedido() {
        return nombreEstadoPedido;
    }

    public void setNombreEstadoPedido(String nombreEstadoPedido) {
        this.nombreEstadoPedido = nombreEstadoPedido;
    }

    public List<Domicilio> getLstDomicilios() {
        return lstDomicilios;
    }

    public void setLstDomicilios(List<Domicilio> lstDomicilios) {
        this.lstDomicilios = lstDomicilios;
    }

    public boolean isEstadoEPedido() {
        return estadoEPedido;
    }

    public void setEstadoEPedido(boolean estadoEPedido) {
        this.estadoEPedido = estadoEPedido;
    }

    
}
