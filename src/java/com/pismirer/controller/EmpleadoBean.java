package com.pismirer.controller;

import com.pismirer.entity.Empleado;
import com.pismirer.entity.Persona;
import com.pismirer.entity.Rol;
import com.pismirer.entity.Usuario;
import com.pismirer.facadeimp.EmpleadoImp;
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
import org.primefaces.PrimeFaces;

@Named("empleadoBean")
@SessionScoped
public class EmpleadoBean implements Serializable{
    
    private List<Empleado> empleados;
    private List<Empleado> nuevosEmpleados;
    private Empleado empleado;
    private Persona persona;
    private Usuario usuario;
    private Rol rol;
    
    private Empleado empleadoLogueado;
    private Empleado empleadoSeleccionado;
    
    private Empleado empleadoEdit;
    private Persona personaEdit;
    private Usuario usuarioEdit;
    
    private int totalEmpleados;
    
    @Inject
    private EmpleadoImp empleadoImp;
    
    @Inject
    private PersonaImp personaImp;
    
    @Inject
    private UsuarioImp usuarioImp;
    
    @Inject
    private LoginBean loginBean;
    
    @PostConstruct
    public void init(){
        try {
            this.empleados = this.empleadoImp.findAll();
            this.nuevosEmpleados = this.empleadoImp.newEmployees();
            this.empleado = new Empleado();
            this.persona = new Persona();
            this.usuario = new Usuario();
            this.rol = new Rol();
            this.totalEmpleados = this.empleados.size();
            this.empleadoLogueado = new Empleado();
            this.empleadoLogueado = this.empleadoImp.findByFK(this.loginBean.getPersona().getIdPersona());
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void addEmpleado(){
        try {
            this.rol.setIdRol(2);
            this.usuario.setFK_idRol(rol);
            this.usuario.setPasswordUsuario(this.persona.getCedulaPersona() + "TempPass-");
            this.usuarioImp.add(usuario);
            this.persona.setFK_idUsuario(usuario);
            this.persona.setFotoPersona("foto");
            this.personaImp.add(persona);
            this.empleado.setFK_idPersona(persona);
            this.empleadoImp.add(empleado);
            
            String destinatario = usuario.getEmailUsuario();
            String asunto = "Pismire - Nuevo Empleado";
            String cuerpo = "Hola " + persona.getNombrePersona() + ". Has sido registrado como empleado para el Restaurante El Satélite. Inicia Sesion en nuestro sistema con tu correo y esta contraseña temporal: " + usuario.getPasswordUsuario() + " !No olvides cambiarla tras ingresar a tu cuenta!";
            if (EmailSender.enviarEmail(destinatario, asunto, cuerpo)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se envio la información correspondiente a su Correo"));
            } else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Correo no se pudo enviar"));
            }
            
            PrimeFaces.current().ajax().update("datosEmpleados:empleados");
            init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Empleado Registrado Correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void showProfileByEmployee(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cruds/seccion_perfil_empleados.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void backOfProfileEmployee(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../seccion_empleados.xhtml");
            this.empleadoSeleccionado = new Empleado();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void editEmpleado(){
        try {
            this.usuarioImp.update(this.usuarioEdit);
            this.personaImp.update(this.personaEdit);
            this.empleadoImp.update(this.empleadoEdit);
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void loadDataEmpleado(int id){
        try {
            if (id == 1) {
                this.usuarioEdit = this.empleadoLogueado.getFK_idPersona().getFK_idUsuario();
                this.personaEdit = this.empleadoLogueado.getFK_idPersona();
                this.empleadoEdit = this.empleadoLogueado;
                PrimeFaces.current().ajax().update("edit-form");
            }else{
                this.usuarioEdit = this.empleadoSeleccionado.getFK_idPersona().getFK_idUsuario();
                this.personaEdit = this.empleadoSeleccionado.getFK_idPersona();
                this.empleadoEdit = this.empleadoSeleccionado;
                PrimeFaces.current().ajax().update("edit-form");
            }  
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    /*Getters And Setters*/
    
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getTotalEmpleados() {
        return totalEmpleados;
    }

    public void setTotalEmpleados(int totalEmpleados) {
        this.totalEmpleados = totalEmpleados;
    }

    public List<Empleado> getNuevosEmpleados() {
        return nuevosEmpleados;
    }

    public void setNuevosEmpleados(List<Empleado> nuevosEmpleados) {
        this.nuevosEmpleados = nuevosEmpleados;
    }

    public Empleado getEmpleadoLogueado() {
        return empleadoLogueado;
    }

    public void setEmpleadoLogueado(Empleado empleadoLogueado) {
        this.empleadoLogueado = empleadoLogueado;
    }

    public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public Empleado getEmpleadoEdit() {
        return empleadoEdit;
    }

    public void setEmpleadoEdit(Empleado empleadoEdit) {
        this.empleadoEdit = empleadoEdit;
    }

    public Persona getPersonaEdit() {
        return personaEdit;
    }

    public void setPersonaEdit(Persona personaEdit) {
        this.personaEdit = personaEdit;
    }

    public Usuario getUsuarioEdit() {
        return usuarioEdit;
    }

    public void setUsuarioEdit(Usuario usuarioEdit) {
        this.usuarioEdit = usuarioEdit;
    }
    
    
    
}
