package com.pismirer.facade;

import com.pismirer.entity.Domicilio;
import java.util.List;

public interface IDomicilio {
    public List<Domicilio> findAll() throws Exception;
    public Domicilio findById(int id) throws Exception;
    public void add(Domicilio domicilio) throws Exception;
    public void update(Domicilio domicilio) throws Exception;
    public void delete(Domicilio domicilio) throws Exception;
}
