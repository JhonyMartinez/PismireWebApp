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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_turnos")
public class Turno implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_idTurno")
    private int idTurno;
    
    @Column(name = "fecTurno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTurno;
    
    @Column(name = "horInicio")
    private String horaInicio;
    
    @Column(name = "horSalida")
    private String horaSalida;
    
    @Column(name = "estado")
    private boolean estadoTurno;
    
    @ManyToOne
    @JoinColumn(name = "FK_idJornada", referencedColumnName = "PK_idJornada")
    private Jornada FK_idJornada;
    
    @OneToMany(mappedBy = "FK_idTurno")
    public List<Programacion> lstProgramacion;

    public Turno() {
    }

    public Turno(int idTurno, Date fechaTurno, String horaInicio, String horaSalida, boolean estadoTurno, Jornada FK_idJornada, List<Programacion> lstProgramacion) {
        this.idTurno = idTurno;
        this.fechaTurno = fechaTurno;
        this.horaInicio = horaInicio;
        this.horaSalida = horaSalida;
        this.estadoTurno = estadoTurno;
        this.FK_idJornada = FK_idJornada;
        this.lstProgramacion = lstProgramacion;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public boolean isEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(boolean estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

    public Jornada getFK_idJornada() {
        return FK_idJornada;
    }

    public void setFK_idJornada(Jornada FK_idJornada) {
        this.FK_idJornada = FK_idJornada;
    }

    public List<Programacion> getLstProgramacion() {
        return lstProgramacion;
    }

    public void setLstProgramacion(List<Programacion> lstProgramacion) {
        this.lstProgramacion = lstProgramacion;
    }

    
}
