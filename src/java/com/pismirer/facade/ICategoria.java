package com.pismirer.facade;

import com.pismirer.entity.Categoria;
import java.util.List;

public interface ICategoria {
    public List<Categoria> findAll() throws Exception;
    public Categoria findById(int id) throws Exception;
    public void add(Categoria categoria) throws Exception;
    public void update(Categoria categoria) throws Exception;
    public void delete(Categoria categoria) throws Exception;
}
