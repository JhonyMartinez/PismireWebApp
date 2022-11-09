package com.pismirer.controller;

import com.pismirer.entity.TipoNovedad;
import com.pismirer.facadeimp.TipoNovedadImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("tipoNovedadBean")
@ViewScoped
public class TipoNovedadBean implements Serializable{
    
    private List<TipoNovedad> tiposnovedad;
    private TipoNovedad tiponov;
    
    @Inject
    private TipoNovedadImp tipoNovedadImp;
    
    @PostConstruct
    public void init(){
        this.tiponov = new TipoNovedad();
        try {
            this.tiposnovedad = this.tipoNovedadImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<TipoNovedad> getTiposnovedad() {
        return tiposnovedad;
    }

    public void setTiposnovedad(List<TipoNovedad> tiposnovedad) {
        this.tiposnovedad = tiposnovedad;
    }

    public TipoNovedad getTiponov() {
        return tiponov;
    }

    public void setTiponov(TipoNovedad tiponov) {
        this.tiponov = tiponov;
    }
    
    public void addTNovedad(){
        try {
            this.tipoNovedadImp.add(tiponov);
            PrimeFaces.current().ajax().update("datosTNov:tiposnovedad");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTNovedad(TipoNovedad tiponov){
        try {
            this.tipoNovedadImp.delete(tiponov);
            this.tiposnovedad.remove(tiponov);
            PrimeFaces.current().ajax().update("datosTNov:tiposnovedad");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateTNovedad(TipoNovedad tiponov){
        try {
            this.tipoNovedadImp.update(this.tiponov);
            PrimeFaces.current().ajax().update("datosTNov:tiposnovedad");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
