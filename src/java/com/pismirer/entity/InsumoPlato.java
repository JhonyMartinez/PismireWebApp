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
@Table(name = "tbl_insumosplato")
public class InsumoPlato implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idInsuPlato")
    private int idInsumoPlato;
    
    @ManyToOne
    @JoinColumn(name = "FK_idPlato", referencedColumnName = "PK_idPlato")
    private Plato FK_idPlato;
    
    @ManyToOne
    @JoinColumn(name = "FK_idInsumo", referencedColumnName = "PK_idInsumo")
    private Insumo FK_idInsumo;
    
    @Column(name = "canNecesaria")
    private int cantidadNecesaria;

    @Column(name = "estado")
    private boolean estadoInsuPlat;

    public InsumoPlato() {
    }

    public InsumoPlato(int idInsumoPlato, Plato FK_idPlato, Insumo FK_idInsumo, int cantidadNecesaria, boolean estadoInsuPlat) {
        this.idInsumoPlato = idInsumoPlato;
        this.FK_idPlato = FK_idPlato;
        this.FK_idInsumo = FK_idInsumo;
        this.cantidadNecesaria = cantidadNecesaria;
        this.estadoInsuPlat = estadoInsuPlat;
    }

    public int getIdInsumoPlato() {
        return idInsumoPlato;
    }

    public void setIdInsumoPlato(int idInsumoPlato) {
        this.idInsumoPlato = idInsumoPlato;
    }

    public Plato getFK_idPlato() {
        return FK_idPlato;
    }

    public void setFK_idPlato(Plato FK_idPlato) {
        this.FK_idPlato = FK_idPlato;
    }

    public Insumo getFK_idInsumo() {
        return FK_idInsumo;
    }

    public void setFK_idInsumo(Insumo FK_idInsumo) {
        this.FK_idInsumo = FK_idInsumo;
    }

    public int getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(int cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public boolean isEstadoInsuPlat() {
        return estadoInsuPlat;
    }

    public void setEstadoInsuPlat(boolean estadoInsuPlat) {
        this.estadoInsuPlat = estadoInsuPlat;
    }
    
    
    
}
