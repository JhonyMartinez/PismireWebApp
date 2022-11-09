package com.pismirer.controller;

import com.pismirer.entity.Empleado;
import com.pismirer.entity.Novedad;
import com.pismirer.entity.NovedadEmpleado;
import com.pismirer.entity.TipoNovedad;
import com.pismirer.facadeimp.EmpleadoImp;
import com.pismirer.facadeimp.NovedadEmpleadoImp;
import com.pismirer.facadeimp.NovedadImp;
import com.pismirer.utilities.EmailSender;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("novedadBean")
@ViewScoped
public class NovedadBean implements Serializable{
    
    private List<NovedadEmpleado> novedadesEmpleado;
    private List<NovedadEmpleado> novedadesEmpleadoLogueado;
    private List<NovedadEmpleado> novedadesExceptoEmpleadoLogueado;
    
    private List<Empleado> empleadosSeleccionados;
    
    private Novedad novedad;
    private Empleado empleadoLogueado;
    private TipoNovedad tipoNovedad;
    private Empleado empleado;
    private NovedadEmpleado novedadEmpleado;
    
    private int idEmpleado;
    
    @Inject
    private NovedadImp novedadImp;
    
    @Inject
    private NovedadEmpleadoImp novedadEmpleadoImp;
    
    @Inject
    private LoginBean loginBean;
    
    @Inject
    private EmpleadoImp empleadoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.novedadesEmpleado = this.novedadEmpleadoImp.findAll();
            this.novedad = new Novedad();
            this.tipoNovedad = new TipoNovedad();
            this.empleado = new Empleado();
            this.novedadEmpleado = new NovedadEmpleado();
            this.empleadosSeleccionados = new ArrayList();
            this.empleadoLogueado = this.empleadoImp.findByFK(this.loginBean.getPersona().getIdPersona());
            this.novedadesEmpleadoLogueado = this.novedadEmpleadoImp.novByEmpLogged(this.empleadoLogueado.getIdEmpleado());
            this.novedadesExceptoEmpleadoLogueado = this.novedadEmpleadoImp.novsExceptEmpLogged(this.empleadoLogueado.getIdEmpleado());
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void addSelectedEmployee(){
        try {
            this.empleado = this.empleadoImp.findById(idEmpleado);
            this.empleadosSeleccionados.add(this.empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se agrego el empleado a la lista"));
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void cleanNewNoveltyFormOnClose(){
        try {
            this.empleadosSeleccionados.clear();
            this.idEmpleado = 0;
            this.novedad = new Novedad();
            this.tipoNovedad = new TipoNovedad();
            this.novedadEmpleado = new NovedadEmpleado();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void noveltySelected(int id){
        try {
            this.novedadEmpleado = this.novedadEmpleadoImp.findById(id);
            PrimeFaces.current().ajax().update("more-dialog");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void addNovelty(){
        try {
            String destinatario = null;
            String asunto = "Pismire - Nueva Novedad";
            String cuerpo = null;
            
            Date fecha = new Date();
            this.novedad.setFK_idTNovedad(tipoNovedad);
            this.novedad.setFechaRegistro(fecha);
            this.novedadImp.add(novedad);
            
            for (int i = 0; i < this.empleadosSeleccionados.size(); i++) {
                this.novedadEmpleado.setFK_idNovedad(novedad);
                this.novedadEmpleado.setFK_idEmpleado(this.empleadosSeleccionados.get(i));
                this.novedadEmpleadoImp.add(novedadEmpleado);
                destinatario = this.empleadosSeleccionados.get(i).getFK_idPersona().getFK_idUsuario().getEmailUsuario();
                cuerpo = "Hola " + this.empleadosSeleccionados.get(i).getFK_idPersona().getNombrePersona() + ". Tienes una nueva novedad registrada. No olvides revisarla al ingresar al Sistema";
                EmailSender.enviarEmail(destinatario, asunto, cuerpo);
            }
            cleanNewNoveltyFormOnClose();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha registrado y enviado la novedad a los empleados seleccionados"));
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Ha ocurrido un problema, intenta de nuevo mas tarde"));
        }
    }

    public List<NovedadEmpleado> getNovedadesEmpleado() {
        return novedadesEmpleado;
    }

    public void setNovedadesEmpleado(List<NovedadEmpleado> novedadesEmpleado) {
        this.novedadesEmpleado = novedadesEmpleado;
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public Empleado getEmpleadoLogueado() {
        return empleadoLogueado;
    }

    public void setEmpleadoLogueado(Empleado empleadoLogueado) {
        this.empleadoLogueado = empleadoLogueado;
    }

    public TipoNovedad getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(TipoNovedad tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getEmpleadosSeleccionados() {
        return empleadosSeleccionados;
    }

    public void setEmpleadosSeleccionados(List<Empleado> empleadosSeleccionados) {
        this.empleadosSeleccionados = empleadosSeleccionados;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public List<NovedadEmpleado> getNovedadesEmpleadoLogueado() {
        return novedadesEmpleadoLogueado;
    }

    public void setNovedadesEmpleadoLogueado(List<NovedadEmpleado> novedadesEmpleadoLogueado) {
        this.novedadesEmpleadoLogueado = novedadesEmpleadoLogueado;
    }

    public List<NovedadEmpleado> getNovedadesExceptoEmpleadoLogueado() {
        return novedadesExceptoEmpleadoLogueado;
    }

    public void setNovedadesExceptoEmpleadoLogueado(List<NovedadEmpleado> novedadesExceptoEmpleadoLogueado) {
        this.novedadesExceptoEmpleadoLogueado = novedadesExceptoEmpleadoLogueado;
    }

    public NovedadEmpleado getNovedadEmpleado() {
        return novedadEmpleado;
    }

    public void setNovedadEmpleado(NovedadEmpleado novedadEmpleado) {
        this.novedadEmpleado = novedadEmpleado;
    }
    
    
    
    
}
