package com.pismirer.facade;

import com.pismirer.entity.EstadoPedido;
import java.util.List;

public interface IEstadoPedido {
    public List<EstadoPedido> findAll() throws Exception;
    public EstadoPedido findById(int id) throws Exception;
    public void add(EstadoPedido estadoPedido) throws Exception;
    public void update(EstadoPedido estadoPedido) throws Exception;
    public void delete(EstadoPedido estadoPedido) throws Exception;
}
