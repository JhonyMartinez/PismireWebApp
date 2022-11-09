package com.pismirer.controller;

import com.pismirer.entity.InsumoMovimiento;
import com.pismirer.facadeimp.InsumoMovimientoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("insumoMovimientoBean")
@ViewScoped
public class InsumoMovimientoBean implements Serializable{
    
    private List<InsumoMovimiento> insumoMovimiento;
    
    @Inject
    private InsumoMovimientoImp insumoMovimientoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.insumoMovimiento = this.insumoMovimientoImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<InsumoMovimiento> getInsumoMovimiento() {
        return insumoMovimiento;
    }

    public void setInsumoMovimiento(List<InsumoMovimiento> insumoMovimiento) {
        this.insumoMovimiento = insumoMovimiento;
    }
    
}
