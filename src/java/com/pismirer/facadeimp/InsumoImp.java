package com.pismirer.facadeimp;

import com.pismirer.entity.Insumo;
import com.pismirer.facade.IInsumo;
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
public class InsumoImp implements IInsumo{

    private List<Insumo> lstInsumos = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Insumo> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT i FROM Insumo i");
        this.lstInsumos = this.q.getResultList();
        return this.lstInsumos;
    }

    @Override
    public Insumo findById(int id) throws Exception {
        Insumo insumo = new Insumo();
        insumo = this.em.find(Insumo.class, id);
        return insumo;
    }

    @Transactional
    @Override
    public void add(Insumo insumo) throws Exception {
        this.em.persist(insumo);
    }

    @Transactional
    @Override
    public void update(Insumo insumo) throws Exception {
        this.em.merge(insumo);
    }

    @Transactional
    @Override
    public void delete(Insumo insumo) throws Exception {
        Insumo i = new Insumo();
        i = this.em.find(Insumo.class, insumo.getIdInsumo());
        if (i != null) {
            this.em.remove(i);
        }
    }
    
}
