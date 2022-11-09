package com.pismirer.controller;

import com.pismirer.entity.Jornada;
import com.pismirer.facadeimp.JornadaImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("jornadaBean")
@ViewScoped
public class JornadaBean implements Serializable{
    
    private List<Jornada> jornadas;
    private Jornada jornada;
    
    @Inject
    private JornadaImp jornadaImp;
    
    @PostConstruct
    public void init(){
        try {
            this.jornada = new Jornada();
            this.jornadas = this.jornadaImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Jornada> getJornadas() {
        return jornadas;
    }

    public void setJornadas(List<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }
    
    public void addRol(){
        try {
            this.jornadaImp.add(this.jornada);
            PrimeFaces.current().ajax().update("datosJornadas:jornadas");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteRol(Jornada jornada){
        try {
            this.jornadaImp.delete(jornada);
            this.jornadas.remove(jornada);
            PrimeFaces.current().ajax().update("datosJornadas:jornadas");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updateRol(Jornada jornada){
        try {            
            this.jornadaImp.update(this.jornada);
            PrimeFaces.current().ajax().update("datosJornadas:jornadas");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
