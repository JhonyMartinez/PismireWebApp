package com.pismirer.facadeimp;

import com.pismirer.entity.Jornada;
import com.pismirer.facade.IJornada;
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
public class JornadaImp implements IJornada{
    private List<Jornada> lstJornadas = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    private EntityManager em;
    
    private Query q;
    
    @Override
    public List<Jornada> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT j FROM Jornada j");
        this.lstJornadas = q.getResultList();
        return this.lstJornadas;
    }

    @Override
    public Jornada findById(int id) throws Exception {
        Jornada jornada = new Jornada();
        jornada = this.em.find(Jornada.class, id);
        return jornada;
    }

    @Transactional
    @Override
    public void add(Jornada jornada) throws Exception {
        this.em.persist(jornada);
    }

    @Transactional
    @Override
    public void update(Jornada jornada) throws Exception {
        this.em.merge(jornada);
    }

    @Transactional
    @Override
    public void delete(Jornada jornada) throws Exception {
        Jornada j = new Jornada();
        j = this.em.find(Jornada.class, jornada.getIdJornada());
        if(j != null){
            this.em.remove(j);
        }
    }
    
}
