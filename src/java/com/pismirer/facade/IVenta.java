package com.pismirer.facade;

import com.pismirer.entity.Venta;
import java.util.List;

public interface IVenta {
    public List<Venta> findAll() throws Exception;
    public Venta findById(int id) throws Exception;
    public void add(Venta venta) throws Exception;
    public void update(Venta venta) throws Exception;
    public void delete(Venta venta) throws Exception;
    /*public void generateOrder(Venta venta) throws Exception;*/
    public void lastIdVenta() throws Exception;
}
