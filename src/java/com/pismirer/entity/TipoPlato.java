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
@Table(name = "tbl_tiposplato")
public class TipoPlato implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idTipoPlato")
    private int idTipoPlato;
    
    @Column(name = "nomTipoPlato")
    private String nombreTipoPlato;
    
    @Column(name = "estado")
    private boolean estadoTPlato;
    
    @OneToMany(mappedBy = "FK_idTipoPlato")
    private List<Plato> lstPlatos;

    public TipoPlato() {
    }

    public TipoPlato(int idTipoPlato, String nombreTipoPlato, boolean estadoTPlato, List<Plato> lstPlatos) {
        this.idTipoPlato = idTipoPlato;
        this.nombreTipoPlato = nombreTipoPlato;
        this.estadoTPlato = estadoTPlato;
        this.lstPlatos = lstPlatos;
    }

    public int getIdTipoPlato() {
        return idTipoPlato;
    }

    public void setIdTipoPlato(int idTipoPlato) {
        this.idTipoPlato = idTipoPlato;
    }

    public String getNombreTipoPlato() {
        return nombreTipoPlato;
    }

    public void setNombreTipoPlato(String nombreTipoPlato) {
        this.nombreTipoPlato = nombreTipoPlato;
    }

    public boolean isEstadoTPlato() {
        return estadoTPlato;
    }

    public void setEstadoTPlato(boolean estadoTPlato) {
        this.estadoTPlato = estadoTPlato;
    }

    public List<Plato> getLstPlatos() {
        return lstPlatos;
    }

    public void setLstPlatos(List<Plato> lstPlatos) {
        this.lstPlatos = lstPlatos;
    }

    
}
