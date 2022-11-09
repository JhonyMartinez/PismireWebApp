package com.pismirer.facade;

import com.pismirer.entity.Novedad;
import java.util.List;

public interface INovedad {
    public List<Novedad> findAll() throws Exception;
    public Novedad findById(int id) throws Exception;
    public void add(Novedad novedad) throws Exception;
    public void update(Novedad novedad) throws Exception;
    public void delete(Novedad novedad) throws Exception;
}
