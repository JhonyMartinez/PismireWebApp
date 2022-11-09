package com.pismirer.facadeimp;

import com.pismirer.entity.InsumoMovimiento;
import com.pismirer.facade.IInsumoMovimiento;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
@ApplicationScoped
public class InsumoMovimientoImp implements IInsumoMovimiento{

    private List<InsumoMovimiento> lstInsumoMovimiento = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<InsumoMovimiento> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT im FROM InsumoMovimiento im");
        this.lstInsumoMovimiento = this.q.getResultList();
        return this.lstInsumoMovimiento;
    }

    @Override
    public InsumoMovimiento findById(int id) throws Exception {
        InsumoMovimiento insumoMovimiento = new InsumoMovimiento();
        insumoMovimiento = this.em.find(InsumoMovimiento.class, id);
        return insumoMovimiento;
    }

    @Override
    public void add(InsumoMovimiento insumoMovimiento) throws Exception {
        this.em.persist(insumoMovimiento);
    }

    @Override
    public void update(InsumoMovimiento insumoMovimiento) throws Exception {
        this.em.merge(insumoMovimiento);
    }

    @Override
    public void delete(InsumoMovimiento insumoMovimiento) throws Exception {
        InsumoMovimiento im = new InsumoMovimiento();
        im = this.em.find(InsumoMovimiento.class, insumoMovimiento.getIdInsumoMovimiento());
        if (im != null) {
            this.em.remove(im);
        }
    }
    
}
