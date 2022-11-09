package com.pismirer.controller;

import com.pismirer.entity.MetodoPago;
import com.pismirer.facadeimp.MetodoPagoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("metodoPagoBean")
@ViewScoped
public class MetodoPagoBean implements Serializable{
    
    private List<MetodoPago> metodosPago;
    private MetodoPago metodopago;
    
    @Inject
    private MetodoPagoImp metodoPagoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.metodopago = new MetodoPago();
            this.metodosPago = this.metodoPagoImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<MetodoPago> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(List<MetodoPago> metodosPago) {
        this.metodosPago = metodosPago;
    }

    public MetodoPago getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(MetodoPago metodopago) {
        this.metodopago = metodopago;
    }
    
    public void addMPago(){
        try {
            this.metodoPagoImp.add(this.metodopago);
            PrimeFaces.current().ajax().update("datosMPago:metodosPago");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteMPago(MetodoPago metodopago){
        try {
            this.metodoPagoImp.delete(metodopago);
            this.metodosPago.remove(metodopago);
            PrimeFaces.current().ajax().update("datosMPago:metodosPago");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updateMPago(MetodoPago metodopago){
        try {            
            this.metodoPagoImp.update(this.metodopago);
            PrimeFaces.current().ajax().update("datosMPago:metodosPago");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }        
}
