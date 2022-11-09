package com.pismirer.controller;

import com.pismirer.entity.Persona;
import com.pismirer.facadeimp.PersonaImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("personaBean")
@ViewScoped
public class PersonaBean implements Serializable{
    
    private List<Persona> personas;
    private Persona persona;
    
    @Inject
    private PersonaImp personaImp;
    
    @PostConstruct
    public void init(){
        try {
            this.persona = new Persona();
            this.personas = this.personaImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void addPersona(){
        try {
            this.personaImp.add(persona);
            PrimeFaces.current().ajax().update("datosPersonas:personas");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deletePersona(Persona persona){
        try {
            this.personaImp.delete(persona);
            this.personas.remove(persona);
            PrimeFaces.current().ajax().update("datosPersonas:personas");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updatePersona(Persona persona){
        try {            
            this.personaImp.update(this.persona);
            PrimeFaces.current().ajax().update("datosPersonas:personas");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    
    
}
