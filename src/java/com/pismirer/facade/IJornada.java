package com.pismirer.facade;

import com.pismirer.entity.Jornada;
import java.util.List;

public interface IJornada {
    public List<Jornada> findAll() throws Exception;
    public Jornada findById(int id) throws Exception;
    public void add(Jornada jornada) throws Exception;
    public void update(Jornada jornada) throws Exception;
    public void delete(Jornada jornada) throws Exception;
}
