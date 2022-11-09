package com.pismirer.facadeimp;

import com.pismirer.entity.Empleado;
import com.pismirer.entity.Persona;
import com.pismirer.facade.IEmpleado;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
public class EmpleadoImp implements IEmpleado{
    
    private List<Empleado> lstEmpleados = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;

    @Override
    public List<Empleado> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT e FROM Empleado e");
        this.lstEmpleados = this.q.getResultList();
        return this.lstEmpleados;
    }

    @Override
    public Empleado findById(int id) throws Exception {
        Empleado empleado = new Empleado();
        empleado = this.em.find(Empleado.class, id);
        return empleado;
    }

    @Transactional
    @Override
    public void add(Empleado empleado) throws Exception {
        this.em.persist(empleado);
    }

    @Transactional
    @Override
    public void update(Empleado empleado) throws Exception {
        this.em.merge(empleado);
    }

    @Transactional
    @Override
    public void delete(Empleado empleado) throws Exception {
        Empleado e = new Empleado();
        e = this.em.find(Empleado.class, empleado.getIdEmpleado());
        if (e != null) {
            this.em.remove(e);
        }
    }

    @Override
    public List<Empleado> newEmployees() throws Exception {
        List<Empleado> newEmployees = new ArrayList();
        Query q;
        String consulta = "SELECT e FROM Empleado e ORDER BY e.ingresoEmpleado DESC";
        q = this.em.createQuery(consulta);
        q.setMaxResults(3);
        newEmployees = q.getResultList();
        
        return newEmployees;
    }

    @Override
    public Empleado findByFK(int id) throws Exception {
        Empleado emp = null;
        Query q;
        String consulta = "SELECT * FROM tbl_empleados WHERE FK_idPersona = ?1";
        
        q = this.em.createNativeQuery(consulta, Empleado.class);
        q.setParameter(1, id);
        
        
        List<Empleado> empLog = q.getResultList();
        
        if (!empLog.isEmpty()) {
            emp = empLog.get(0);
        }
        
        return emp;
    }
    
    
    
}
