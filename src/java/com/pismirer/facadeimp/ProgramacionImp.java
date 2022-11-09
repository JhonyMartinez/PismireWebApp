package com.pismirer.facadeimp;

import com.pismirer.entity.Programacion;
import com.pismirer.facade.IProgramacion;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
@ApplicationScoped
public class ProgramacionImp implements IProgramacion{

    private List<Programacion> lstProgramacion = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Programacion> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT pr FROM Programacion pr");
        this.lstProgramacion = this.q.getResultList();
        return this.lstProgramacion;
    }

    @Override
    public Programacion findById(int id) throws Exception {
        Programacion programacion = new Programacion();
        programacion = this.em.find(Programacion.class, id);
        return programacion;
    }

    @Override
    public void add(Programacion programacion) throws Exception {
        this.em.persist(programacion);
    }

    @Override
    public void update(Programacion programacion) throws Exception {
        this.em.merge(programacion);
    }

    @Override
    public void delete(Programacion programacion) throws Exception {
        Programacion pr = new Programacion();
        pr = this.em.find(Programacion.class, programacion.getIdProgramacion());
        if (pr != null) {
            this.em.remove(pr);
        }
    }
    
}
