package com.pismirer.facadeimp;

import com.pismirer.entity.TipoPlato;
import com.pismirer.facade.ITipoPlato;
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
public class TipoPlatoImp implements ITipoPlato{

    private List<TipoPlato> lstTipoPlato = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<TipoPlato> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT tp FROM TipoPlato tp");
        this.lstTipoPlato = this.q.getResultList();
        return this.lstTipoPlato;
    }

    @Override
    public TipoPlato findById(int id) throws Exception {
        TipoPlato tipoPlato = new TipoPlato();
        tipoPlato = this.em.find(TipoPlato.class, id);
        return tipoPlato;
    }

    @Transactional
    @Override
    public void add(TipoPlato tipoPlato) throws Exception {
        this.em.persist(tipoPlato);
    }

    @Transactional
    @Override
    public void update(TipoPlato tipoPlato) throws Exception {
        this.em.merge(tipoPlato);
    }

    @Transactional
    @Override
    public void delete(TipoPlato tipoPlato) throws Exception {
        TipoPlato tp = new TipoPlato();
        tp = this.em.find(TipoPlato.class, tipoPlato.getIdTipoPlato());
        if (tp != null) {
            this.em.remove(tp);
        }
    }
    
    
    
}
