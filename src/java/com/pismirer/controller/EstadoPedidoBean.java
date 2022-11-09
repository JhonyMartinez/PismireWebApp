package com.pismirer.controller;

import com.pismirer.entity.EstadoPedido;
import com.pismirer.facadeimp.EstadoPedidoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("estadoPedidoBean")
@ViewScoped
public class EstadoPedidoBean implements Serializable{
    
    private List<EstadoPedido> estadosPedido;
    private EstadoPedido estped;
    
    @Inject
    private EstadoPedidoImp estadoPedidoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.estped = new EstadoPedido();
            this.estadosPedido = this.estadoPedidoImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<EstadoPedido> getEstadosPedido() {
        return estadosPedido;
    }

    public void setEstadosPedido(List<EstadoPedido> estadosPedido) {
        this.estadosPedido = estadosPedido;
    }

    public EstadoPedido getEstped() {
        return estped;
    }

    public void setEstped(EstadoPedido estped) {
        this.estped = estped;
    }
    
    public void addEPedido(){
        try {
            this.estadoPedidoImp.add(estped);
            PrimeFaces.current().ajax().update("datosEPedido:estadosPedido");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteEPedido(EstadoPedido estped){
        try {
            this.estadoPedidoImp.delete(estped);
            this.estadosPedido.remove(estped);
            PrimeFaces.current().ajax().update("datosEPedido:estadosPedido");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updateEPedido(EstadoPedido estped){
        try {            
            this.estadoPedidoImp.update(this.estped);
            PrimeFaces.current().ajax().update("datosEPedido:estadosPedido");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
}
