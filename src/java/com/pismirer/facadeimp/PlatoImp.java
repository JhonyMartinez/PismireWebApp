package com.pismirer.facadeimp;

import com.pismirer.entity.Plato;
import com.pismirer.facade.IPlato;
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
public class PlatoImp implements IPlato{

    private List<Plato> lstPlatos = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Plato> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT pl FROM Plato pl");
        this.lstPlatos = this.q.getResultList();
        return this.lstPlatos;
    }

    @Override
    public Plato findById(int id) throws Exception {
        Plato plato = new Plato();
        plato = this.em.find(Plato.class, id);
        return plato;
    }

    @Transactional
    @Override
    public void add(Plato plato) throws Exception {
        this.em.persist(plato);
    }
    
    @Transactional
    @Override
    public void update(Plato plato) throws Exception {
        this.em.merge(plato);
    }
    
    @Transactional
    @Override
    public void delete(Plato plato) throws Exception {
        Plato pl = new Plato();
        pl = this.em.find(Plato.class, plato.getIdPlato());
        if (pl != null) {
            this.em.remove(pl);
        }
    }

    @Override
    public List<Plato> findByCategory(int id) throws Exception {
        List<Plato> lstPlatosByCategory = new ArrayList();
        String consulta = "SELECT pl FROM Plato pl, TipoPlato tp WHERE tp = pl.FK_idTipoPlato AND tp.idTipoPlato = ?1";
        Query q;
        
        q = this.em.createQuery(consulta);
        q.setParameter(1, id);
        
        lstPlatosByCategory = q.getResultList();
        
        return lstPlatosByCategory;
    }
    
}
