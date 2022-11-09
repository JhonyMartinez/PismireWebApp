package com.pismirer.facade;

import com.pismirer.entity.InsumoPlato;
import java.util.List;

public interface IInsumoPlato {
    public List<InsumoPlato> findAll() throws Exception;
    public InsumoPlato finById(int id) throws Exception;
    public void add(InsumoPlato insumoPlato) throws Exception;
    public void update(InsumoPlato insumoPlato) throws Exception;
    public void delete(InsumoPlato insumoPlato) throws Exception;
}
