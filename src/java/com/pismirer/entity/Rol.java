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
@Table(name = "tbl_roles")
public class Rol implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idRol")
    private int idRol;
    
    @Column(name = "rol")
    private String nombreRol;
    
    @Column(name = "estado")
    private boolean estadoRol;
    
    @OneToMany(mappedBy = "FK_idRol")
    private List<Usuario> lstUsuarios;

    public Rol() {
    }

    public Rol(int idRol, String nombreRol, boolean estadoRol, List<Usuario> lstUsuarios) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.estadoRol = estadoRol;
        this.lstUsuarios = lstUsuarios;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public boolean isEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(boolean estadoRol) {
        this.estadoRol = estadoRol;
    }

    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    
}
