package com.pismirer.facadeimp;

import com.pismirer.entity.DetalleVenta;
import com.pismirer.facade.IDetalleVenta;
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
public class DetalleVentaImp implements IDetalleVenta{

    private List<DetalleVenta> lstDetallesVenta = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<DetalleVenta> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT dv FROM DetalleVenta dv");
        this.lstDetallesVenta = this.q.getResultList();
        return this.lstDetallesVenta;
    }

    @Override
    public DetalleVenta findById(int id) throws Exception {
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta = this.em.find(DetalleVenta.class, id);
        return detalleVenta;
    }

    @Transactional
    @Override
    public void add(DetalleVenta detalleVenta) throws Exception {
        this.em.persist(detalleVenta);
    }

    @Transactional
    @Override
    public void update(DetalleVenta detalleVenta) throws Exception {
        this.em.merge(detalleVenta);
    }

    @Transactional
    @Override
    public void delete(DetalleVenta detalleVenta) throws Exception {
        DetalleVenta dv = new DetalleVenta();
        dv = this.em.find(DetalleVenta.class, detalleVenta.getIdDetalle());
        if (dv != null) {
            this.em.remove(dv);
        }
    }
    
}
