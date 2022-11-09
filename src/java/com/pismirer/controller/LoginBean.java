package com.pismirer.controller;

import com.pismirer.entity.Persona;
import com.pismirer.entity.Usuario;
import com.pismirer.facadeimp.PersonaImp;
import com.pismirer.facadeimp.UsuarioImp;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    private Usuario usuario;
    private Persona persona = new Persona();
    
    @Inject
    private UsuarioImp usuarioImp;
    
    @Inject
    private PersonaImp personaImp;
    
    @PostConstruct
    public void init(){
        this.usuario = new Usuario();
    }

    public LoginBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    String url = "";
    public void iniciarSesion(){
        Usuario us;
        try {
            us = this.usuarioImp.validateUser(usuario);
            if (us != null) {
                this.usuario = us;
                this.persona = this.personaImp.findById(usuario.getIdUsuario());
            
                switch(us.getFK_idRol().getIdRol()){
                    case (3):
                        url = "../Dashboards/Administrador/index_admin.xhtml?faces-redirect=true";
                        FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                    break;
                    case (2):
                        url = "../Dashboards/Empleado/index_empleado.xhtml?faces-redirect=true";
                        FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                    break;
                    case (1):
                        url = "../Dashboards/Cliente/index_cliente.xhtml?faces-redirect=true";
                        FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                    break;
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fallo", e.getMessage()));
        }
    }
    
    public void ingresarDashboard(){
        try {
            if(url.contains("..")){
                url = url.substring(3);
            }
            System.out.println(url);
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (Exception e) {
        }
    }
    
    public void cerrarSesion(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml?faces-redirect=true");
        } catch (Exception e) {
        }
    }

    Boolean Validacion = false;
    
    public void validar(){
        try {
            Usuario usu = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if (usu == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../Login/login.xhtml?faces-redirect=true");
                Validacion = false;
            } else{
                Validacion = true;
            }
        } catch (Exception e) {
        }
    }
    
    public void validarLoginCart(){
        try {
            Usuario usu = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if (usu == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("Login/login.xhtml?faces-redirect=true");
            }
        } catch (Exception e) {
        }
    }

    public Boolean getValidacion() {
        return Validacion;
    }

    public void setValidacion(Boolean Validacion) {
        this.Validacion = Validacion;
    }
    
}
