package com.pismirer.facadeimp;

import com.pismirer.entity.Persona;
import com.pismirer.entity.Usuario;
import com.pismirer.facade.IUsuario;
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
public class UsuarioImp implements IUsuario{

    private List<Usuario> lstUsuarios = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    private EntityManager em;
    
    private Query q;
    
    @Override
    public List<Usuario> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT u FROM Usuario u");
        this.lstUsuarios = q.getResultList();
        return this.lstUsuarios;
    }

    @Override
    public Usuario findById(int id) throws Exception {
        Usuario usuario = new Usuario();
        usuario = this.em.find(Usuario.class, id);
        return usuario;
    }

    @Transactional
    @Override
    public void add(Usuario usuario) throws Exception {
        this.em.persist(usuario);
    }

    @Transactional
    @Override
    public void update(Usuario usuario) throws Exception {
        this.em.merge(usuario);
    }

    @Transactional
    @Override
    public void delete(Usuario usuario) throws Exception {
        Usuario u = new Usuario();
        u = this.em.find(Usuario.class, usuario.getIdUsuario());
        if(u != null){
            this.em.remove(u);
        }
    }

    @Override
    public Usuario validateUser(Usuario usuario) throws Exception {
        Usuario us = null;
        String condicion;
        Query q;
        
        condicion = "SELECT u FROM Usuario u WHERE u.emailUsuario = ?1 AND u.passwordUsuario =?2";
        
        q = this.em.createQuery(condicion);
        q.setParameter(1, usuario.getEmailUsuario());
        q.setParameter(2, usuario.getPasswordUsuario());
        
        List<Usuario> lstUsu = q.getResultList();
        
        if (!lstUsu.isEmpty()) {
            us = lstUsu.get(0);
        }
        return us;
    }

    @Override
    public Usuario userByEmail(Usuario usuario) throws Exception {
        Usuario usPass = null;
        String consulta = "SELECT u FROM Usuario u WHERE u.emailUsuario = ?1";
        Query q;
        
        q = this.em.createQuery(consulta);
        q.setParameter(1, usuario.getEmailUsuario()); 
        
        List<Usuario> lstUsuByPass = q.getResultList();
        
        if (!lstUsuByPass.isEmpty()){
            usPass = lstUsuByPass.get(0);
        }
        return usPass;
    }

}
