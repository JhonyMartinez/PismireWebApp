package com.pismirer.facadeimp;

import com.pismirer.entity.Movimiento;
import com.pismirer.facade.IMovimiento;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
@ApplicationScoped
public class MovimientoImp implements IMovimiento{

    private List<Movimiento> lstMovimiento = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Movimiento> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT mv FROM Movimiento mv");
        this.lstMovimiento = this.q.getResultList();
        return this.lstMovimiento;
    }

    @Override
    public Movimiento findById(int id) throws Exception {
        Movimiento movimiento = new Movimiento();
        movimiento = this.em.find(Movimiento.class, id);
        return movimiento;
    }

    @Override
    public void add(Movimiento movimiento) throws Exception {
        this.em.persist(movimiento);
    }

    @Override
    public void update(Movimiento movimiento) throws Exception {
        this.em.merge(movimiento);
    }

    @Override
    public void delete(Movimiento movimiento) throws Exception {
        Movimiento mv = new Movimiento();
        mv = this.em.find(Movimiento.class, movimiento.getIdMovimiento());
        if (mv != null) {
            this.em.remove(mv);
        }
    }
    
}
