package com.pismirer.facade;

import com.pismirer.entity.Insumo;
import java.util.List;

public interface IInsumo {
    public List<Insumo> findAll() throws Exception;
    public Insumo findById(int id) throws Exception;
    public void add(Insumo insumo) throws Exception;
    public void update(Insumo insumo) throws Exception;
    public void delete(Insumo insumo) throws Exception;
}
