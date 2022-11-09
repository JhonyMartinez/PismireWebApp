package com.pismirer.facadeimp;

import com.pismirer.entity.Persona;
import com.pismirer.facade.IPersona;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
public class PersonaImp implements IPersona{

    private List<Persona> lstPersonas = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Persona> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT per FROM Persona per");
        this.lstPersonas = this.q.getResultList();
        return this.lstPersonas;
    }

    @Override
    public Persona findById(int id) throws Exception {
        Persona persona = new Persona();
        persona = this.em.find(Persona.class, id);
        return persona;
    }

    @Transactional
    @Override
    public void add(Persona persona) throws Exception {
        this.em.persist(persona);
    }

    @Transactional
    @Override
    public void update(Persona persona) throws Exception {
        this.em.merge(persona);
    }

    @Transactional
    @Override
    public void delete(Persona persona) throws Exception {
        Persona per = new Persona();
        per = this.em.find(Persona.class, persona.getIdPersona());
        if (per != null) {
            this.em.remove(per);
        }
    }
    
}
