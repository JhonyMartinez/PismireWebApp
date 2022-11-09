package com.pismirer.facade;

import com.pismirer.entity.Movimiento;
import java.util.List;

public interface IMovimiento {
    public List<Movimiento> findAll() throws Exception;
    public Movimiento findById(int id) throws Exception;
    public void add(Movimiento movimiento) throws Exception;
    public void update(Movimiento movimiento) throws Exception;
    public void delete(Movimiento movimiento) throws Exception;
}
