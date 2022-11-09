package com.pismirer.facade;

import com.pismirer.entity.Plato;
import java.util.List;

public interface IPlato {
    public List<Plato> findAll() throws Exception;
    public Plato findById(int id) throws Exception;
    public void add(Plato plato) throws Exception;
    public void update(Plato plato) throws Exception;
    public void delete(Plato plato) throws Exception;
    public List<Plato> findByCategory(int id) throws Exception;
}
