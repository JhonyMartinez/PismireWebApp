package com.pismirer.facade;

import com.pismirer.entity.NovedadEmpleado;
import java.util.List;

public interface INovedadEmpleado {
    public List<NovedadEmpleado> findAll() throws Exception;
    public NovedadEmpleado findById(int id) throws Exception;
    public void add(NovedadEmpleado novedadEmpleado) throws Exception;
    public void update(NovedadEmpleado novedadEmpleado) throws Exception;
    public void delete(NovedadEmpleado novedadEmpleado) throws Exception;
    public List<NovedadEmpleado> novByEmpLogged(int id) throws Exception;
    public List<NovedadEmpleado> novsExceptEmpLogged(int id) throws Exception;
}
