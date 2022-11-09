package com.pismirer.facade;

import com.pismirer.entity.Persona;
import java.util.List;

public interface IPersona {
    public List<Persona> findAll() throws Exception;
    public Persona findById(int id) throws Exception;
    public void add(Persona persona) throws Exception;
    public void update(Persona persona) throws Exception;
    public void delete(Persona persona) throws Exception;
}
