package com.pismirer.controller;

import com.pismirer.entity.Categoria;
import com.pismirer.entity.Insumo;
import com.pismirer.facadeimp.CategoriaImp;
import com.pismirer.facadeimp.InsumoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("insumoBean")
@ViewScoped
public class InsumoBean implements Serializable{
    
    private List<Insumo> insumos;
    private Insumo insumo;
    private Categoria categoria;
    
    private int idcategoria;
    
    @Inject
    private InsumoImp insumoImp;
    
    @Inject
    private CategoriaImp categoriaImp;
    
    @PostConstruct
    public void init(){
        try {
            this.insumo = new Insumo();
            this.categoria = new Categoria();
            this.insumos = this.insumoImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    
    public void addInsumo(){
        try {
            this.insumo.setFK_idCategoria(categoria);
            this.insumoImp.add(insumo);
            PrimeFaces.current().ajax().update("datosInsumos:insumos");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteInsumo(Insumo insumo){
        try {
            this.insumoImp.delete(insumo);
            this.insumos.remove(insumo);
            PrimeFaces.current().ajax().update("datosInsumos:insumos");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updateInsumo(){
        try {
            if (categoria.getIdCategoria() > 0) {
                this.insumo.setFK_idCategoria(categoria);
            }
            this.insumoImp.update(this.insumo);
            PrimeFaces.current().ajax().update("datosInsumos:insumos");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void loadDataInsumo(Insumo insumo){
        try {
            this.insumo.setFK_idCategoria(categoria);
            this.insumo = this.insumoImp.findById(insumo.getIdInsumo());
            PrimeFaces.current().ajax().update("edit");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
