package com.pismirer.facade;

import com.pismirer.entity.MetodoPago;
import java.util.List;

public interface IMetodoPago {
    public List<MetodoPago> findAll() throws Exception;
    public MetodoPago findById(int id) throws Exception;
    public void add(MetodoPago metodoPago) throws Exception;
    public void update(MetodoPago metodoPago) throws Exception;
    public void delete(MetodoPago metodoPago) throws Exception;
}
