package com.pismirer.controller;

import com.pismirer.entity.Persona;
import com.pismirer.entity.Rol;
import com.pismirer.entity.Usuario;
import com.pismirer.facadeimp.PersonaImp;
import com.pismirer.facadeimp.UsuarioImp;
import com.pismirer.utilities.EmailSender;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{
    private List<Usuario> usuarios;
    private Usuario usuario;
    private Persona persona;
    private Rol rol;
    
    @Inject
    private UsuarioImp usuarioImp;
    
    @Inject
    private PersonaImp personaImp;
    
    @PostConstruct
    public void init(){
        try {
            this.usuarios = usuarioImp.findAll();
            this.usuario = new Usuario();
            this.persona = new Persona();
            this.rol = new Rol();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    
    public void recoverPassword(){
        Usuario usPass;
        try {
            usPass = this.usuarioImp.userByEmail(usuario);
            if (usPass != null) {
                this.usuario = usPass;
                this.persona = this.personaImp.findById(usuario.getIdUsuario());
            
                String destinatario = usPass.getEmailUsuario();
                String asunto = "Pismire - Recuperación de Contraseña";
                String cuerpo = "Hola " + persona.getNombrePersona() + ". La contraseña de tu cuenta es: " + usPass.getPasswordUsuario() + " !No olvides cambiarla tras ingresar a tu cuenta!";
                if (EmailSender.enviarEmail(destinatario, asunto, cuerpo)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se envio la información correspondiente a su Correo"));
                } else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Correo no se pudo enviar"));
                }
            } else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "El Correo ingresado no existe en el sistema"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    private String passwordConfirm;
    private boolean checkConfirm = false;
    private boolean sendMessage = false;
    
    public void receiveData(){
        try {
            if (passwordConfirm.equals(this.usuario.getPasswordUsuario())) {
                if (checkConfirm == true) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("registro2.xhtml?faces-redirect=true");
                } else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debe aceptar la Politica de Privacidad"));
                }
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Las Contraseñas no Coinciden"));
            }
        } catch (Exception e) {
        }
    }
    
    public void newUser(){
        try {
            this.rol.setIdRol(1);
            this.usuario.setFK_idRol(rol);
            this.usuarioImp.add(usuario);
            this.persona.setFK_idUsuario(usuario);
            this.persona.setFotoPersona("foto");
            this.personaImp.add(persona);
            this.usuario = new Usuario();
            this.persona = new Persona();
            this.checkConfirm = false;
            this.sendMessage = true;
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?faces-redirect=true");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void clean(){
        try {
            this.usuario = new Usuario();
            this.persona = new Persona();
            this.checkConfirm = false;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void validateUserBeforePersona(){
        try {
            if (this.usuario.getEmailUsuario() == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("registro1.xhtml?faces-redirect=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void receiveMessage(){
        try {
            if (this.sendMessage == true) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Te has Registrado Correctamente"));
                this.sendMessage = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public boolean isCheckConfirm() {
        return checkConfirm;
    }

    public void setCheckConfirm(boolean checkConfirm) {
        this.checkConfirm = checkConfirm;
    }
    
    
    
    
}
