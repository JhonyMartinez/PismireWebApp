package com.pismirer.facadeimp;

import com.pismirer.entity.Categoria;
import com.pismirer.facade.ICategoria;
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
public class CategoriaImp implements ICategoria{

    private List<Categoria> lstCategoria = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    @Override
    public List<Categoria> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT c FROM Categoria c");
        this.lstCategoria = this.q.getResultList();
        return this.lstCategoria;
    }

    @Override
    public Categoria findById(int id) throws Exception {
        Categoria categoria = new Categoria();
        categoria = this.em.find(Categoria.class, id);
        return categoria;
    }

    @Transactional
    @Override
    public void add(Categoria categoria) throws Exception {
        this.em.persist(categoria);
    }

    @Transactional
    @Override
    public void update(Categoria categoria) throws Exception {
        this.em.merge(categoria);
    }

    @Transactional
    @Override
    public void delete(Categoria categoria) throws Exception {
        Categoria c = new Categoria();
        c = this.em.find(Categoria.class, categoria.getIdCategoria());
        if (c != null) {
            this.em.remove(c);
        }
    }
    
}
