package com.pismirer.facade;

import com.pismirer.entity.Rol;
import java.util.List;

public interface IRol {
    public List<Rol> findAll() throws Exception;
    public Rol findById(int id) throws Exception;
    public void add(Rol rol) throws Exception;
    public void update(Rol rol) throws Exception;
    public void delete(Rol rol) throws Exception;
    
}
