package com.pismirer.controller;

import com.pismirer.entity.Rol;
import com.pismirer.facadeimp.RolImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("rolBean") // Como se llamara el controlador, para llamarlo desde la vista
@ViewScoped
public class RolBean implements Serializable{
    private List<Rol> roles;
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }    
    

    @Inject
    private RolImp rolImp;
    
    @PostConstruct 
    public void init(){
        this.rol = new Rol();
        try {
            this.roles = this.rolImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
    public void addRol(){
        try {
            this.rolImp.add(this.rol);
            PrimeFaces.current().ajax().update("datosRoles:roles");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteRol(Rol rol){
        try {
            this.rolImp.delete(rol);
            this.roles.remove(rol);
            PrimeFaces.current().ajax().update("datosRoles:roles");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updateRol(Rol rol){
        try {            
            this.rolImp.update(this.rol);
            PrimeFaces.current().ajax().update("datosRoles:roles");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
