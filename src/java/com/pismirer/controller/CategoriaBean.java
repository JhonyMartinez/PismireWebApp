package com.pismirer.controller;

import com.pismirer.entity.Categoria;
import com.pismirer.facadeimp.CategoriaImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("categoriaBean")
@ViewScoped
public class CategoriaBean implements Serializable{
    
    private List<Categoria> categorias;
    private Categoria categoria;
    
    @Inject
    private CategoriaImp categoriaImp;
    
    @PostConstruct
    public void init(){
        try {
            this.categoria = new Categoria();
            this.categorias = this.categoriaImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void addCategoria(){
        try {
            this.categoriaImp.add(categoria);
            PrimeFaces.current().ajax().update("datosCategorias:categorias");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCategoria(Categoria categoria){
        try {
            this.categoriaImp.delete(categoria);
            this.categorias.remove(categoria);
            PrimeFaces.current().ajax().update("datosCategorias:categorias");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updateCategoria(Categoria categoria){
        try {            
            this.categoriaImp.update(this.categoria);
            PrimeFaces.current().ajax().update("datosCategorias:categorias");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
}
