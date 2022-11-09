package com.pismirer.controller;

import com.pismirer.entity.Movimiento;
import com.pismirer.facadeimp.MovimientoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("movimientoBean")
@ViewScoped
public class MovimientoBean implements Serializable{
    
    private List<Movimiento> movimientos;
    
    @Inject
    private MovimientoImp movimientoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.movimientos = this.movimientoImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
}
