package com.pismirer.facadeimp;

import com.pismirer.entity.EstadoPedido;
import com.pismirer.facade.IEstadoPedido;
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
public class EstadoPedidoImp implements IEstadoPedido{
    
    private List<EstadoPedido> lstEstadosPedido = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;

    @Override
    public List<EstadoPedido> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT ep FROM EstadoPedido ep");
        this.lstEstadosPedido = this.q.getResultList();
        return this.lstEstadosPedido;
    }

    @Override
    public EstadoPedido findById(int id) throws Exception {
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido = this.em.find(EstadoPedido.class, id);
        return estadoPedido;
    }

    @Transactional
    @Override
    public void add(EstadoPedido estadoPedido) throws Exception {
        this.em.persist(estadoPedido);
    }

    @Transactional
    @Override
    public void update(EstadoPedido estadoPedido) throws Exception {
        this.em.merge(estadoPedido);
    }

    @Transactional
    @Override
    public void delete(EstadoPedido estadoPedido) throws Exception {
        EstadoPedido ep = new EstadoPedido();
        ep = this.em.find(EstadoPedido.class, estadoPedido.getIdEstadoPedido());
        if (ep != null) {
            this.em.remove(ep);
        }
    }
    
}
