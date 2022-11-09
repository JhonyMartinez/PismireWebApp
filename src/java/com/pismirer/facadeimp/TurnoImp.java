package com.pismirer.facadeimp;

import com.pismirer.entity.Turno;
import com.pismirer.facade.ITurno;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
@ApplicationScoped
public class TurnoImp implements ITurno{

    private List<Turno> lstTurnos = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Turno> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT t FROM Turno t");
        this.lstTurnos = this.q.getResultList();
        return this.lstTurnos;
    }

    @Override
    public Turno findById(int id) throws Exception {
        Turno turno = new Turno();
        turno = this.em.find(Turno.class, id);
        return turno;
    }

    @Override
    public void add(Turno turno) throws Exception {
        this.em.persist(turno);
    }

    @Override
    public void update(Turno turno) throws Exception {
        this.em.merge(turno);
    }

    @Override
    public void delete(Turno turno) throws Exception {
        Turno t = new Turno();
        t = this.em.find(Turno.class, turno.getIdTurno());
        if(t != null){
            this.em.remove(t);
        }
    }
    
}
