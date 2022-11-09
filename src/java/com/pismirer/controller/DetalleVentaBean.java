package com.pismirer.controller;

import com.pismirer.entity.DetalleVenta;
import com.pismirer.facadeimp.DetalleVentaImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("detalleVentaBean")
@ViewScoped
public class DetalleVentaBean implements Serializable{
    
    private List<DetalleVenta> detallesVenta;
    
    @Inject
    private DetalleVentaImp detalleVentaImp;
    
    @PostConstruct
    public void init(){
        try {
            this.detallesVenta = this.detalleVentaImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }
    
}
