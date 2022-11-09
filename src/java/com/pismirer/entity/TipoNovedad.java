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
@Table(name = "tbl_tiposnovedad")
public class TipoNovedad implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idTNovedad")
    private int idTipoNovedad;
    
    @Column(name = "tipoNovedad")
    private String nombreTipoNovedad;
    
    @Column(name = "estado")
    private boolean estadoTNovedad;
    
    @OneToMany(mappedBy = "FK_idTNovedad")
    private List<Novedad> lstNovedades;

    public TipoNovedad() {
    }

    public TipoNovedad(int idTipoNovedad, String nombreTipoNovedad, boolean estadoTNovedad, List<Novedad> lstNovedades) {
        this.idTipoNovedad = idTipoNovedad;
        this.nombreTipoNovedad = nombreTipoNovedad;
        this.estadoTNovedad = estadoTNovedad;
        this.lstNovedades = lstNovedades;
    }

    public int getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(int idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
    }

    public String getNombreTipoNovedad() {
        return nombreTipoNovedad;
    }

    public void setNombreTipoNovedad(String nombreTipoNovedad) {
        this.nombreTipoNovedad = nombreTipoNovedad;
    }

    public boolean isEstadoTNovedad() {
        return estadoTNovedad;
    }

    public void setEstadoTNovedad(boolean estadoTNovedad) {
        this.estadoTNovedad = estadoTNovedad;
    }

    public List<Novedad> getLstNovedades() {
        return lstNovedades;
    }

    public void setLstNovedades(List<Novedad> lstNovedades) {
        this.lstNovedades = lstNovedades;
    }

    
}
