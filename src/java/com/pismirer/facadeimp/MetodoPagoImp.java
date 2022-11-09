package com.pismirer.facadeimp;

import com.pismirer.entity.MetodoPago;
import com.pismirer.facade.IMetodoPago;
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
public class MetodoPagoImp implements IMetodoPago{

    private List<MetodoPago> lstMetodosPago = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<MetodoPago> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT mp FROM MetodoPago mp");
        this.lstMetodosPago = this.q.getResultList();
        return this.lstMetodosPago;
    }

    @Override
    public MetodoPago findById(int id) throws Exception {
        MetodoPago metodoPago = new MetodoPago();
        metodoPago = this.em.find(MetodoPago.class, id);
        return metodoPago;
    }

    @Transactional
    @Override
    public void add(MetodoPago metodoPago) throws Exception {
        this.em.persist(metodoPago);
    }

    @Transactional
    @Override
    public void update(MetodoPago metodoPago) throws Exception {
        this.em.merge(metodoPago);
    }

    @Transactional
    @Override
    public void delete(MetodoPago metodoPago) throws Exception {
        MetodoPago mp = new MetodoPago();
        mp = this.em.find(MetodoPago.class, metodoPago.getIdMetodoPago());
        if (mp != null) {
            this.em.remove(mp);
        }
    }
    
}
