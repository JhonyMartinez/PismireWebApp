package com.pismirer.facade;

import com.pismirer.entity.DetalleVenta;
import java.util.List;

public interface IDetalleVenta {
    public List<DetalleVenta> findAll() throws Exception;
    public DetalleVenta findById(int id) throws Exception;
    public void add(DetalleVenta detalleVenta) throws Exception;
    public void update(DetalleVenta detalleVenta) throws Exception;
    public void delete(DetalleVenta detalleVenta) throws Exception;
}
