package com.pismirer.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "tbl_usuarios")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idUsuario")
    private int idUsuario;
    
    @Column(name = "emaUsuario")
    private String emailUsuario;
    
    @Column(name = "passUsuario")
    private String passwordUsuario;
    
    @Column(name = "estado")
    private boolean estadoUsuario;
    
    @ManyToOne
    @JoinColumn(name="FK_idRol", referencedColumnName = "PK_idRol")
    private Rol FK_idRol;
    
    @OneToMany(mappedBy = "FK_idUsuario")
    private List<Persona> lstPersonas;

    public Usuario() {
    }

    public Usuario(int idUsuario, String emailUsuario, String passwordUsuario, boolean estadoUsuario, Rol FK_idRol, List<Persona> lstPersonas) {
        this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.estadoUsuario = estadoUsuario;
        this.FK_idRol = FK_idRol;
        this.lstPersonas = lstPersonas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public boolean isEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Rol getFK_idRol() {
        return FK_idRol;
    }

    public void setFK_idRol(Rol FK_idRol) {
        this.FK_idRol = FK_idRol;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    
    
    
}
