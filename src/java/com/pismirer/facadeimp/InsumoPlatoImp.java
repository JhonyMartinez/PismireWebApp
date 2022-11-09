package com.pismirer.facadeimp;

import com.pismirer.entity.InsumoPlato;
import com.pismirer.facade.IInsumoPlato;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
@ApplicationScoped
public class InsumoPlatoImp implements IInsumoPlato{

    private List<InsumoPlato> lstInsumosPlato = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    
    @Override
    public List<InsumoPlato> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT ip FROM InsumoPlato ip");
        this.lstInsumosPlato = this.q.getResultList();
        return this.lstInsumosPlato;
    }

    @Override
    public InsumoPlato finById(int id) throws Exception {
        InsumoPlato insumoPlato = new InsumoPlato();
        insumoPlato = this.em.find(InsumoPlato.class, id);
        return insumoPlato;
    }

    @Override
    public void add(InsumoPlato insumoPlato) throws Exception {
        this.em.persist(insumoPlato);
    }

    @Override
    public void update(InsumoPlato insumoPlato) throws Exception {
        this.em.merge(insumoPlato);
    }

    @Override
    public void delete(InsumoPlato insumoPlato) throws Exception {
        InsumoPlato ip = new InsumoPlato();
        ip = this.em.find(InsumoPlato.class, insumoPlato.getIdInsumoPlato());
        if (ip != null) {
            this.em.remove(ip);
        }
    }
    
}
