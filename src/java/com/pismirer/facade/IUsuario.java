package com.pismirer.facade;

import com.pismirer.entity.Persona;
import com.pismirer.entity.Usuario;
import java.util.List;

public interface IUsuario {
    public List<Usuario> findAll() throws Exception;
    public Usuario findById(int id) throws Exception;
    public void add(Usuario usuario) throws Exception;
    public void update(Usuario usuario) throws Exception;
    public void delete(Usuario usuario) throws Exception;
    public Usuario validateUser(Usuario usuario) throws Exception;
    public Usuario userByEmail(Usuario usuario) throws Exception;
}
