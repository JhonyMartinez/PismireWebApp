package com.pismirer.facadeimp;

import com.pismirer.entity.TipoNovedad;
import com.pismirer.facade.ITipoNovedad;
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
public class TipoNovedadImp implements ITipoNovedad{

    private List<TipoNovedad> lstTiposNovedad = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<TipoNovedad> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT tn FROM TipoNovedad tn");
        this.lstTiposNovedad = this.q.getResultList();
        return this.lstTiposNovedad;
    }

    @Override
    public TipoNovedad findById(int id) throws Exception {
        TipoNovedad tipoNovedad = new TipoNovedad();
        tipoNovedad = this.em.find(TipoNovedad.class, id);
        return tipoNovedad;
    }

    @Transactional
    @Override
    public void add(TipoNovedad tiponovedad) throws Exception {
        this.em.persist(tiponovedad);
    }

    @Transactional
    @Override
    public void update(TipoNovedad tiponovedad) throws Exception {
        this.em.merge(tiponovedad);
    }
    
    @Transactional
    @Override
    public void delete(TipoNovedad tiponovedad) throws Exception {
        TipoNovedad tn = new TipoNovedad();
        tn = this.em.find(TipoNovedad.class, tiponovedad.getIdTipoNovedad());
        if (tn != null) {
            this.em.remove(tn);
        }
    }
    
}
