package com.pismirer.facade;

import com.pismirer.entity.TipoNovedad;
import java.util.List;

public interface ITipoNovedad {
    public List<TipoNovedad> findAll() throws Exception;
    public TipoNovedad findById(int id) throws Exception;
    public void add(TipoNovedad tiponovedad) throws Exception;
    public void update(TipoNovedad tiponovedad) throws Exception;
    public void delete(TipoNovedad tiponovedad) throws Exception;
}
