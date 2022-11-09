package com.pismirer.facade;

import com.pismirer.entity.Empleado;
import com.pismirer.entity.Persona;
import java.util.List;

public interface IEmpleado {
    public List<Empleado> findAll() throws Exception;
    public Empleado findById(int id) throws Exception;
    public void add(Empleado empleado) throws Exception;
    public void update(Empleado empleado) throws Exception;
    public void delete(Empleado empleado) throws Exception;
    public List<Empleado> newEmployees() throws Exception;
    public Empleado findByFK(int id) throws Exception;
}
