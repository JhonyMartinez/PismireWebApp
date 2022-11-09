package com.pismirer.facade;

import com.pismirer.entity.Turno;
import java.util.List;

public interface ITurno {
    public List<Turno> findAll() throws Exception;
    public Turno findById(int id) throws Exception;
    public void add(Turno turno) throws Exception;
    public void update(Turno turno) throws Exception;
    public void delete(Turno turno) throws Exception;
}
