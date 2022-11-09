package com.pismirer.controller;

import com.pismirer.entity.TipoPlato;
import com.pismirer.facadeimp.TipoPlatoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("tipoPlatoBean")
@ViewScoped
public class TipoPlatoBean implements Serializable{
    
    private List<TipoPlato> tiposPlato;
    private TipoPlato tipoPlato;
    
    @Inject
    private TipoPlatoImp tipoPlatoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.tipoPlato = new TipoPlato();
            this.tiposPlato = this.tipoPlatoImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<TipoPlato> getTiposPlato() {
        return tiposPlato;
    }

    public void setTiposPlato(List<TipoPlato> tiposPlato) {
        this.tiposPlato = tiposPlato;
    }

    public TipoPlato getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(TipoPlato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }
    
    public void addTPlato(){
        try {
            this.tipoPlatoImp.add(this.tipoPlato);
            PrimeFaces.current().ajax().update("datosTPlato:tiposPlato");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteRol(TipoPlato tipoPlato){
        try {
            this.tipoPlatoImp.delete(tipoPlato);
            this.tiposPlato.remove(tipoPlato);
            PrimeFaces.current().ajax().update("datosTPlato:tiposPlato");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updateRol(TipoPlato tipoPlato){
        try {            
            this.tipoPlatoImp.update(this.tipoPlato);
            PrimeFaces.current().ajax().update("datosTPlato:tiposPlato");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
