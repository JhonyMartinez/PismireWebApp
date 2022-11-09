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
@Table(name = "tbl_jornadas")
public class Jornada implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idJornada")
    private int idJornada;
    
    @Column(name = "jornada")
    private String nombreJornada;
    
    @OneToMany(mappedBy = "FK_idJornada")
    private List<Turno> lstTurnos;

    @Column(name = "estado")
    private boolean estadoJornada;
    
    public Jornada() {
    }

    public Jornada(int idJornada, String nombreJornada, List<Turno> lstTurnos, boolean estadoJornada) {
        this.idJornada = idJornada;
        this.nombreJornada = nombreJornada;
        this.lstTurnos = lstTurnos;
        this.estadoJornada = estadoJornada;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public String getNombreJornada() {
        return nombreJornada;
    }

    public void setNombreJornada(String nombreJornada) {
        this.nombreJornada = nombreJornada;
    }

    public List<Turno> getLstTurnos() {
        return lstTurnos;
    }

    public void setLstTurnos(List<Turno> lstTurnos) {
        this.lstTurnos = lstTurnos;
    }

    public boolean isEstadoJornada() {
        return estadoJornada;
    }

    public void setEstadoJornada(boolean estadoJornada) {
        this.estadoJornada = estadoJornada;
    }

    
    
}
