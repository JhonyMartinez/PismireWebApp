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
@Table(name = "tbl_categorias")
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idCategoria")
    private int idCategoria;
    
    @Column(name = "nomCategoria")
    private String nombreCategoria;
    
    @Column(name = "desCategoria")
    private String descripcionCategoria;
    
    @Column(name = "tipMedida")
    private String tipoMedida;
    
    @OneToMany(mappedBy = "FK_idCategoria")
    private List<Insumo> lstInsumos;
    
    @Column(name = "estado")
    private boolean estadoCategoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nombreCategoria, String descripcionCategoria, String tipoMedida, List<Insumo> lstInsumos, boolean estadoCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.tipoMedida = tipoMedida;
        this.lstInsumos = lstInsumos;
        this.estadoCategoria = estadoCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public String getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(String tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    public List<Insumo> getLstInsumos() {
        return lstInsumos;
    }

    public void setLstInsumos(List<Insumo> lstInsumos) {
        this.lstInsumos = lstInsumos;
    }

    public boolean isEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(boolean estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

    
}
