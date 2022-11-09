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
@Table(name = "tbl_novempleado")
public class NovedadEmpleado implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idNovEmp")
    private int idNovedadEmpleado;
    
    @ManyToOne
    @JoinColumn(name = "FK_idEmpleado", referencedColumnName = "PK_idEmpleado")
    private Empleado FK_idEmpleado;
    
    @ManyToOne
    @JoinColumn(name = "FK_idNovedad", referencedColumnName = "PK_idNovedad")
    private Novedad FK_idNovedad;
    
    @Column(name = "estado")
    private boolean estadoNovEmp;

    public NovedadEmpleado() {
    }

    public NovedadEmpleado(int idNovedadEmpleado, Empleado FK_idEmpleado, Novedad FK_idNovedad, boolean estadoNovEmp) {
        this.idNovedadEmpleado = idNovedadEmpleado;
        this.FK_idEmpleado = FK_idEmpleado;
        this.FK_idNovedad = FK_idNovedad;
        this.estadoNovEmp = estadoNovEmp;
    }

    public int getIdNovedadEmpleado() {
        return idNovedadEmpleado;
    }

    public void setIdNovedadEmpleado(int idNovedadEmpleado) {
        this.idNovedadEmpleado = idNovedadEmpleado;
    }

    public Empleado getFK_idEmpleado() {
        return FK_idEmpleado;
    }

    public void setFK_idEmpleado(Empleado FK_idEmpleado) {
        this.FK_idEmpleado = FK_idEmpleado;
    }

    public Novedad getFK_idNovedad() {
        return FK_idNovedad;
    }

    public void setFK_idNovedad(Novedad FK_idNovedad) {
        this.FK_idNovedad = FK_idNovedad;
    }

    public boolean isEstadoNovEmp() {
        return estadoNovEmp;
    }

    public void setEstadoNovEmp(boolean estadoNovEmp) {
        this.estadoNovEmp = estadoNovEmp;
    }
    
    
}
