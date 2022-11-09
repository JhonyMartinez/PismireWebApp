package com.pismirer.facade;

import com.pismirer.entity.InsumoMovimiento;
import java.util.List;

public interface IInsumoMovimiento {
    public List<InsumoMovimiento> findAll() throws Exception;
    public InsumoMovimiento findById(int id) throws Exception;
    public void add(InsumoMovimiento insumoMovimiento) throws Exception;
    public void update(InsumoMovimiento insumoMovimiento) throws Exception;
    public void delete(InsumoMovimiento insumoMovimiento) throws Exception;
}
