package com.pismirer.controller;

import com.pismirer.entity.Turno;
import com.pismirer.facadeimp.TurnoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("turnoBean")
@ViewScoped
public class TurnoBean implements Serializable{
    
    private List<Turno> turnos;
    
    @Inject
    private TurnoImp turnoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.turnos = this.turnoImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    
}
