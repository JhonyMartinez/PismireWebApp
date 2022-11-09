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
@Table(name = "tbl_domicilios")
public class Domicilio implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idPedido")
    private int idPedido;
    
    @Column(name = "dirPedido")
    private String direccionPedido;
    
    @Column(name = "horSalidaPedido")
    private String horaSalidaPedido;
    
    @Column(name = "horLlegadaPedido")
    private String horaLlegadaPedido;
    
    @ManyToOne
    @JoinColumn(name = "FK_idVenta", referencedColumnName = "PK_idVenta")
    private Venta FK_idVenta;
    
    @ManyToOne
    @JoinColumn(name = "FK_idEstadoPedido", referencedColumnName = "PK_idEstadoPedido")
    private EstadoPedido FK_idEstadoPedido;
    
    @ManyToOne
    @JoinColumn(name = "FK_idEmpleado", referencedColumnName = "PK_idEmpleado")
    private Empleado FK_idEmpleado;

    @Column(name = "estado")
    private boolean estadoDomicilio;
    
    public Domicilio() {
    }

    public Domicilio(int idPedido, String direccionPedido, String horaSalidaPedido, String horaLlegadaPedido, Venta FK_idVenta, EstadoPedido FK_idEstadoPedido, Empleado FK_idEmpleado, boolean estadoDomicilio) {
        this.idPedido = idPedido;
        this.direccionPedido = direccionPedido;
        this.horaSalidaPedido = horaSalidaPedido;
        this.horaLlegadaPedido = horaLlegadaPedido;
        this.FK_idVenta = FK_idVenta;
        this.FK_idEstadoPedido = FK_idEstadoPedido;
        this.FK_idEmpleado = FK_idEmpleado;
        this.estadoDomicilio = estadoDomicilio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionPedido() {
        return direccionPedido;
    }

    public void setDireccionPedido(String direccionPedido) {
        this.direccionPedido = direccionPedido;
    }

    public String getHoraSalidaPedido() {
        return horaSalidaPedido;
    }

    public void setHoraSalidaPedido(String horaSalidaPedido) {
        this.horaSalidaPedido = horaSalidaPedido;
    }

    public String getHoraLlegadaPedido() {
        return horaLlegadaPedido;
    }

    public void setHoraLlegadaPedido(String horaLlegadaPedido) {
        this.horaLlegadaPedido = horaLlegadaPedido;
    }

    public Venta getFK_idVenta() {
        return FK_idVenta;
    }

    public void setFK_idVenta(Venta FK_idVenta) {
        this.FK_idVenta = FK_idVenta;
    }

    public EstadoPedido getFK_idEstadoPedido() {
        return FK_idEstadoPedido;
    }

    public void setFK_idEstadoPedido(EstadoPedido FK_idEstadoPedido) {
        this.FK_idEstadoPedido = FK_idEstadoPedido;
    }

    public Empleado getFK_idEmpleado() {
        return FK_idEmpleado;
    }

    public void setFK_idEmpleado(Empleado FK_idEmpleado) {
        this.FK_idEmpleado = FK_idEmpleado;
    }

    public boolean isEstadoDomicilio() {
        return estadoDomicilio;
    }

    public void setEstadoDomicilio(boolean estadoDomicilio) {
        this.estadoDomicilio = estadoDomicilio;
    }

    
}
