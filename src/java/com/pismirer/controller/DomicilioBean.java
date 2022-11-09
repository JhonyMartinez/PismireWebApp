package com.pismirer.controller;

import com.pismirer.entity.Domicilio;
import com.pismirer.facadeimp.DomicilioImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("domicilioBean")
@ViewScoped
public class DomicilioBean implements Serializable{
    
    private List<Domicilio> domicilios;
    
    @Inject
    private DomicilioImp domicilioImp;
    
    @PostConstruct
    public void init(){
        try {
            this.domicilios = this.domicilioImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    
}
