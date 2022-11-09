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
@Table(name = "tbl_personas")
public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idPersona")
    private int idPersona;
    
    @Column(name = "cedPersona")
    private Long cedulaPersona;
    
    @Column(name = "nomPersona")
    private String nombrePersona;
    
    @Column(name = "apePersona")
    private String apellidoPersona;
    
    @Column(name = "telPersona")
    private Long telefonoPersona;
    
    @Column(name = "dirPersona")
    private String direccionPersona;
    
    @Column(name = "fotPersona")
    private String fotoPersona;
    
    @Column(name = "fecNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    
    @Column(name = "estado")
    private boolean estadoPersona;
    
    @ManyToOne
    @JoinColumn(name = "FK_idUsuario", referencedColumnName = "PK_idUsuario")
    private Usuario FK_idUsuario;
    
    @OneToMany(mappedBy = "FK_idPersona")
    private List<Empleado> lstEmpleados;
    
    @OneToMany(mappedBy = "FK_idPersona")
    private List<Venta> lstVentas;

    public Persona() {
    }

    public Persona(int idPersona, Long cedulaPersona, String nombrePersona, String apellidoPersona, Long telefonoPersona, String direccionPersona, String fotoPersona, Date fechaNacimiento, boolean estadoPersona, Usuario FK_idUsuario, List<Empleado> lstEmpleados, List<Venta> lstVentas) {
        this.idPersona = idPersona;
        this.cedulaPersona = cedulaPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.telefonoPersona = telefonoPersona;
        this.direccionPersona = direccionPersona;
        this.fotoPersona = fotoPersona;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoPersona = estadoPersona;
        this.FK_idUsuario = FK_idUsuario;
        this.lstEmpleados = lstEmpleados;
        this.lstVentas = lstVentas;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Long getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(Long cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public Long getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(Long telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getFotoPersona() {
        return fotoPersona;
    }

    public void setFotoPersona(String fotoPersona) {
        this.fotoPersona = fotoPersona;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstadoPersona() {
        return estadoPersona;
    }

    public void setEstadoPersona(boolean estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

    public Usuario getFK_idUsuario() {
        return FK_idUsuario;
    }

    public void setFK_idUsuario(Usuario FK_idUsuario) {
        this.FK_idUsuario = FK_idUsuario;
    }

    public List<Empleado> getLstEmpleados() {
        return lstEmpleados;
    }

    public void setLstEmpleados(List<Empleado> lstEmpleados) {
        this.lstEmpleados = lstEmpleados;
    }

    public List<Venta> getLstVentas() {
        return lstVentas;
    }

    public void setLstVentas(List<Venta> lstVentas) {
        this.lstVentas = lstVentas;
    }

    
}
