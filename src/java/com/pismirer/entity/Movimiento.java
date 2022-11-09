package com.pismirer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_movimientos")
public class Movimiento implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idMovimiento")
    private int idMovimiento;
    
    @Column(name = "movimiento")
    private String nombreMovimiento; //Entrada o Salida
    
    @Column(name = "fecMovimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    
    @Column(name = "horMovimiento")
    private String horaMovimiento;
    
    @Column(name = "estado")
    private boolean estadoMovimiento;
    
    @OneToMany(mappedBy = "FK_idMovimiento")
    private List<InsumoMovimiento> lstInsumosMovimiento;

    public Movimiento() {
    }

    public Movimiento(int idMovimiento, String nombreMovimiento, Date fechaMovimiento, String horaMovimiento, boolean estadoMovimiento, List<InsumoMovimiento> lstInsumosMovimiento) {
        this.idMovimiento = idMovimiento;
        this.nombreMovimiento = nombreMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.horaMovimiento = horaMovimiento;
        this.estadoMovimiento = estadoMovimiento;
        this.lstInsumosMovimiento = lstInsumosMovimiento;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getNombreMovimiento() {
        return nombreMovimiento;
    }

    public void setNombreMovimiento(String nombreMovimiento) {
        this.nombreMovimiento = nombreMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getHoraMovimiento() {
        return horaMovimiento;
    }

    public void setHoraMovimiento(String horaMovimiento) {
        this.horaMovimiento = horaMovimiento;
    }

    public boolean isEstadoMovimiento() {
        return estadoMovimiento;
    }

    public void setEstadoMovimiento(boolean estadoMovimiento) {
        this.estadoMovimiento = estadoMovimiento;
    }

    public List<InsumoMovimiento> getLstInsumosMovimiento() {
        return lstInsumosMovimiento;
    }

    public void setLstInsumosMovimiento(List<InsumoMovimiento> lstInsumosMovimiento) {
        this.lstInsumosMovimiento = lstInsumosMovimiento;
    }

    
}
