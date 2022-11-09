package com.pismirer.facadeimp;

import com.pismirer.entity.Rol;
import com.pismirer.facade.IRol;
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
public class RolImp implements IRol {
    
    private List<Rol> lstRoles = new ArrayList<>();
    @PersistenceContext(unitName = "PismireR2PU") //Va a glashfish y crea el EntityManager
    private EntityManager em;
    
    private Query q; //Permite ejecutar alguans sentencias de hql (sql de clases)
    
    @Override
    public List<Rol> findAll() throws Exception{
        //this.em.getTransaction().begin();
        this.q = this.em.createQuery("SELECT r FROM Rol r"); //Consulta hql
        this.lstRoles = q.getResultList();
        //this.em.getTransaction().commit(); //Confirma la consulta anterior
        return this.lstRoles;
    }
    

    @Override
    public Rol findById(int id) throws Exception{
        Rol rol = new Rol();
        rol = this.em.find(Rol.class, id);
        //this.em.getTransaction().commit();
        return rol;
    }
    
    @Transactional
    @Override
    public void add(Rol rol) throws Exception{
        //this.em.getTransaction().begin();
        this.em.persist(rol);
        //this.em.getTransaction().commit();
    }

    @Transactional
    @Override
    public void update(Rol rol) throws Exception{
        //this.em.getTransaction().begin();
        this.em.merge(rol);
        //this.em.getTransaction().commit();
    }

    @Transactional
    @Override
    public void delete(Rol rol) throws Exception{
        Rol r = new Rol();
        r = this.em.find(Rol.class, rol.getIdRol());
        if (r != null) {
            //this.em.getTransaction().begin();
            this.em.remove(r); //Eliminar
            //this.em.getTransaction().commit();
        }
    }
    
}
