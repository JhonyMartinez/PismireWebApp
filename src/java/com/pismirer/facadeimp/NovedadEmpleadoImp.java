package com.pismirer.facadeimp;

import com.pismirer.entity.NovedadEmpleado;
import com.pismirer.facade.INovedadEmpleado;
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
public class NovedadEmpleadoImp implements INovedadEmpleado{
    
    private List<NovedadEmpleado> lstNovedadEmpleado = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")

    private EntityManager em;
    private Query q;
    
    @Override
    public List<NovedadEmpleado> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT ne FROM NovedadEmpleado ne");
        this.lstNovedadEmpleado = this.q.getResultList();
        return this.lstNovedadEmpleado;
    }

    @Override
    public NovedadEmpleado findById(int id) throws Exception {
        NovedadEmpleado novedadEmpleado = new NovedadEmpleado();
        novedadEmpleado = this.em.find(NovedadEmpleado.class, id);
        return novedadEmpleado;
    }

    @Transactional
    @Override
    public void add(NovedadEmpleado novedadEmpleado) throws Exception {
        this.em.persist(novedadEmpleado);
    }

    @Transactional
    @Override
    public void update(NovedadEmpleado novedadEmpleado) throws Exception {
        this.em.merge(novedadEmpleado);
    }

    @Transactional
    @Override
    public void delete(NovedadEmpleado novedadEmpleado) throws Exception {
        NovedadEmpleado ne = new NovedadEmpleado();
        ne = this.em.find(NovedadEmpleado.class, novedadEmpleado.getIdNovedadEmpleado());
        if (ne != null) {
            this.em.remove(ne);
        }
    }

    @Override
    public List<NovedadEmpleado> novByEmpLogged(int id) throws Exception {
        List<NovedadEmpleado> novByEmpLogged = new ArrayList();
        Query q;
        String consulta = "SELECT * FROM tbl_novEmpleado WHERE FK_idEmpleado = ?1;";
        
        q = this.em.createNativeQuery(consulta, NovedadEmpleado.class);
        q.setParameter(1, id);
        
        novByEmpLogged = q.getResultList();
        
        return novByEmpLogged;
    }

    @Override
    public List<NovedadEmpleado> novsExceptEmpLogged(int id) throws Exception {
        List<NovedadEmpleado> novsExceptEmpLogged = new ArrayList();
        Query q;
        String consulta = "SELECT * FROM tbl_novEmpleado WHERE FK_idEmpleado NOT IN (?1);";
        
        q = this.em.createNativeQuery(consulta, NovedadEmpleado.class);
        q.setParameter(1, id);
        
        novsExceptEmpLogged = q.getResultList();
        
        return novsExceptEmpLogged;
    }
    
}
