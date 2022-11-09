package com.pismirer.facadeimp;

import com.pismirer.entity.Novedad;
import com.pismirer.facade.INovedad;
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
public class NovedadImp implements INovedad{

    private List<Novedad> lstNovedades = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Novedad> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT n FROM Novedad n");
        this.lstNovedades = this.q.getResultList();
        return this.lstNovedades;
    }

    @Override
    public Novedad findById(int id) throws Exception {
        Novedad novedad = new Novedad();
        novedad = this.em.find(Novedad.class, id);
        return novedad;
    }

    @Transactional
    @Override
    public void add(Novedad novedad) throws Exception {
        this.em.persist(novedad);
    }

    @Transactional
    @Override
    public void update(Novedad novedad) throws Exception {
        this.em.merge(novedad);
    }

    @Transactional
    @Override
    public void delete(Novedad novedad) throws Exception {
        Novedad n = new Novedad();
        n = this.em.find(Novedad.class, novedad.getIdNovedad());
        if (n != null) {
            this.em.remove(n);
        }
    }

}
