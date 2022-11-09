package com.pismirer.facade;

import com.pismirer.entity.Programacion;
import java.util.List;

public interface IProgramacion {
    public List<Programacion> findAll() throws Exception;
    public Programacion findById(int id) throws Exception;
    public void add(Programacion programacion) throws Exception;
    public void update(Programacion programacion) throws Exception;
    public void delete(Programacion programacion) throws Exception;
}
