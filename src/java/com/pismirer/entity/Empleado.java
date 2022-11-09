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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_empleados")
public class Empleado implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idEmpleado")
    private int idEmpleado;
    
    @Column(name = "perEmpleado")
    private String perfilEmpleado;
    
    @Column(name = "ingEmpleado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingresoEmpleado;

    @Column(name = "hvEmpleado")
    private String hvEmpleado;
    
    @Column(name = "conEmpleado")
    private String contratoEmpleado;
    
    @Column(name = "salEmpleado")
    private double salarioEmpleado;
    
    @Column(name = "cargoEmpleado")
    private String cargoEmpleado;
    
    @Column(name = "estado")
    private boolean estadoEmpleado;
    
    @ManyToOne
    @JoinColumn(name = "FK_idPersona", referencedColumnName = "PK_idPersona")
    private Persona FK_idPersona;
    
    @OneToMany(mappedBy = "FK_idEmpleado")
    private List<Domicilio> lstDomicilios;
    
    @OneToMany(mappedBy = "FK_idEmpleado")
    private List<NovedadEmpleado> lstNovedadEmp;
    
    @OneToMany(mappedBy = "FK_idEmpleado")
    private List<Programacion> lstProgramacion;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String perfilEmpleado, Date ingresoEmpleado, String hvEmpleado, String contratoEmpleado, double salarioEmpleado, String cargoEmpleado, boolean estadoEmpleado, Persona FK_idPersona, List<Domicilio> lstDomicilios, List<NovedadEmpleado> lstNovedadEmp, List<Programacion> lstProgramacion) {
        this.idEmpleado = idEmpleado;
        this.perfilEmpleado = perfilEmpleado;
        this.ingresoEmpleado = ingresoEmpleado;
        this.hvEmpleado = hvEmpleado;
        this.contratoEmpleado = contratoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.cargoEmpleado = cargoEmpleado;
        this.estadoEmpleado = estadoEmpleado;
        this.FK_idPersona = FK_idPersona;
        this.lstDomicilios = lstDomicilios;
        this.lstNovedadEmp = lstNovedadEmp;
        this.lstProgramacion = lstProgramacion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPerfilEmpleado() {
        return perfilEmpleado;
    }

    public void setPerfilEmpleado(String perfilEmpleado) {
        this.perfilEmpleado = perfilEmpleado;
    }

    public Date getIngresoEmpleado() {
        return ingresoEmpleado;
    }

    public void setIngresoEmpleado(Date ingresoEmpleado) {
        this.ingresoEmpleado = ingresoEmpleado;
    }

    public String getHvEmpleado() {
        return hvEmpleado;
    }

    public void setHvEmpleado(String hvEmpleado) {
        this.hvEmpleado = hvEmpleado;
    }

    public String getContratoEmpleado() {
        return contratoEmpleado;
    }

    public void setContratoEmpleado(String contratoEmpleado) {
        this.contratoEmpleado = contratoEmpleado;
    }

    public double getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(double salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public boolean isEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(boolean estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public Persona getFK_idPersona() {
        return FK_idPersona;
    }

    public void setFK_idPersona(Persona FK_idPersona) {
        this.FK_idPersona = FK_idPersona;
    }

    public List<Domicilio> getLstDomicilios() {
        return lstDomicilios;
    }

    public void setLstDomicilios(List<Domicilio> lstDomicilios) {
        this.lstDomicilios = lstDomicilios;
    }

    public List<NovedadEmpleado> getLstNovedadEmp() {
        return lstNovedadEmp;
    }

    public void setLstNovedadEmp(List<NovedadEmpleado> lstNovedadEmp) {
        this.lstNovedadEmp = lstNovedadEmp;
    }

    public List<Programacion> getLstProgramacion() {
        return lstProgramacion;
    }

    public void setLstProgramacion(List<Programacion> lstProgramacion) {
        this.lstProgramacion = lstProgramacion;
    }

    
    
}
