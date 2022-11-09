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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_novedades")
public class Novedad implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idNovedad")
    private int idNovedad;
    
    @Column(name = "fecInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Column(name = "fecFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    
    @Column(name = "novedad")
    private String textoNovedad;
    
    @Column(name = "fecRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @ManyToOne
    @JoinColumn(name = "FK_idTNovedad", referencedColumnName = "PK_idTNovedad")
    private TipoNovedad FK_idTNovedad;
    
    @Column(name = "estado")
    private boolean estadoNovedad;
    
    @OneToMany(mappedBy = "FK_idNovedad")
    private List<NovedadEmpleado> lstNovedadEmp;

    public Novedad() {
    }

    public Novedad(int idNovedad, Date fechaInicio, Date fechaFinalizacion, String textoNovedad, Date fechaRegistro, TipoNovedad FK_idTNovedad, boolean estadoNovedad, List<NovedadEmpleado> lstNovedadEmp) {
        this.idNovedad = idNovedad;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.textoNovedad = textoNovedad;
        this.fechaRegistro = fechaRegistro;
        this.FK_idTNovedad = FK_idTNovedad;
        this.estadoNovedad = estadoNovedad;
        this.lstNovedadEmp = lstNovedadEmp;
    }

    public int getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(int idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getTextoNovedad() {
        return textoNovedad;
    }

    public void setTextoNovedad(String textoNovedad) {
        this.textoNovedad = textoNovedad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public TipoNovedad getFK_idTNovedad() {
        return FK_idTNovedad;
    }

    public void setFK_idTNovedad(TipoNovedad FK_idTNovedad) {
        this.FK_idTNovedad = FK_idTNovedad;
    }

    public boolean isEstadoNovedad() {
        return estadoNovedad;
    }

    public void setEstadoNovedad(boolean estadoNovedad) {
        this.estadoNovedad = estadoNovedad;
    }

    public List<NovedadEmpleado> getLstNovedadEmp() {
        return lstNovedadEmp;
    }

    public void setLstNovedadEmp(List<NovedadEmpleado> lstNovedadEmp) {
        this.lstNovedadEmp = lstNovedadEmp;
    }

    
    
}
