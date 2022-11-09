package com.pismirer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_programacion")
public class Programacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idProgramacion")
    private int idProgramacion;
    
    @ManyToOne
    @JoinColumn(name = "FK_idEmpleado", referencedColumnName = "PK_idEmpleado")
    private Empleado FK_idEmpleado;
    
    @ManyToOne
    @JoinColumn(name = "FK_idTurno", referencedColumnName = "PK_idTurno")
    private Turno FK_idTurno;
    
    @Column(name = "asistencia")
    private String asistencia;

    @Column(name = "estado")
    private boolean estadoProgramacion;
    
    public Programacion() {
    }

    public Programacion(int idProgramacion, Empleado FK_idEmpleado, Turno FK_idTurno, String asistencia, boolean estadoProgramacion) {
        this.idProgramacion = idProgramacion;
        this.FK_idEmpleado = FK_idEmpleado;
        this.FK_idTurno = FK_idTurno;
        this.asistencia = asistencia;
        this.estadoProgramacion = estadoProgramacion;
    }

    public int getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(int idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Empleado getFK_idEmpleado() {
        return FK_idEmpleado;
    }

    public void setFK_idEmpleado(Empleado FK_idEmpleado) {
        this.FK_idEmpleado = FK_idEmpleado;
    }

    public Turno getFK_idTurno() {
        return FK_idTurno;
    }

    public void setFK_idTurno(Turno FK_idTurno) {
        this.FK_idTurno = FK_idTurno;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public boolean isEstadoProgramacion() {
        return estadoProgramacion;
    }

    public void setEstadoProgramacion(boolean estadoProgramacion) {
        this.estadoProgramacion = estadoProgramacion;
    }

    
    
}
