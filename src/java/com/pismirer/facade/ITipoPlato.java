package com.pismirer.facade;

import com.pismirer.entity.TipoPlato;
import java.util.List;

public interface ITipoPlato {
    public List<TipoPlato> findAll() throws Exception;
    public TipoPlato findById(int id) throws Exception;
    public void add(TipoPlato tipoPlato) throws Exception;
    public void update(TipoPlato tipoPlato) throws Exception;
    public void delete(TipoPlato tipoPlato) throws Exception;
}
