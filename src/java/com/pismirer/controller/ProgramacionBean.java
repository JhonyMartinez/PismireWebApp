package com.pismirer.controller;

import com.pismirer.entity.Programacion;
import com.pismirer.facadeimp.ProgramacionImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("programacionBean")
@ViewScoped
public class ProgramacionBean implements Serializable{
    
    private List<Programacion> programacion;
    
    @Inject
    private ProgramacionImp programacionImp;
    
    @PostConstruct
    public void init(){
        try {
            this.programacion = this.programacionImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Programacion> getProgramacion() {
        return programacion;
    }

    public void setProgramacion(List<Programacion> programacion) {
        this.programacion = programacion;
    }
    
    
    
}
