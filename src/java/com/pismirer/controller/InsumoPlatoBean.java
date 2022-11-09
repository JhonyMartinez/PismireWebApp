package com.pismirer.controller;

import com.pismirer.entity.InsumoPlato;
import com.pismirer.facadeimp.InsumoPlatoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("insumoPlatoBean")
@ViewScoped
public class InsumoPlatoBean implements Serializable{
    
    private List<InsumoPlato> insumoPlato;
    
    @Inject
    private InsumoPlatoImp insumoPlatoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.insumoPlato = this.insumoPlatoImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<InsumoPlato> getInsumoPlato() {
        return insumoPlato;
    }

    public void setInsumoPlato(List<InsumoPlato> insumoPlato) {
        this.insumoPlato = insumoPlato;
    }
    
    
}
