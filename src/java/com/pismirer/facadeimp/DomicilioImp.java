package com.pismirer.facadeimp;

import com.pismirer.entity.Domicilio;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.pismirer.facade.IDomicilio;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
public class DomicilioImp implements IDomicilio{

    private List<Domicilio> lstDomicilios = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Domicilio> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT d FROM Domicilio d");
        this.lstDomicilios = this.q.getResultList();
        return this.lstDomicilios;
    }

    @Override
    public Domicilio findById(int id) throws Exception {
        Domicilio domicilio = new Domicilio();
        domicilio = this.em.find(Domicilio.class, id);
        return domicilio;
    }

    @Transactional
    @Override
    public void add(Domicilio domicilio) throws Exception {
        this.em.persist(domicilio);
    }

    @Transactional
    @Override
    public void update(Domicilio domicilio) throws Exception {
        this.em.merge(domicilio);
    }

    @Transactional
    @Override
    public void delete(Domicilio domicilio) throws Exception {
        Domicilio d = new Domicilio();
        d = this.em.find(Domicilio.class, domicilio.getIdPedido());
        if (d != null) {
            this.em.remove(d);
        }
    }
    
    
}
