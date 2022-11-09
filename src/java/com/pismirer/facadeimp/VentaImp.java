package com.pismirer.facadeimp;

import com.pismirer.entity.Venta;
import com.pismirer.facade.IVenta;
import com.pismirer.utilities.Carrito;
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
public class VentaImp implements IVenta{

    private List<Venta> lstVentas = new ArrayList();
    @PersistenceContext(unitName = "PismireR2PU")
    
    private EntityManager em;
    private Query q;
    
    /*private List<Carrito> detalleCarrito;*/
    
    @Override
    public List<Venta> findAll() throws Exception {
        this.q = this.em.createQuery("SELECT v FROM Venta v");
        this.lstVentas = this.q.getResultList();
        return this.lstVentas;
    }

    @Override
    public Venta findById(int id) throws Exception {
        Venta venta = new Venta();
        venta = this.em.find(Venta.class, id);
        return venta;
    }

    @Transactional
    @Override
    public void add(Venta venta) throws Exception {
        this.em.persist(venta);
    }

    @Transactional
    @Override
    public void update(Venta venta) throws Exception {
        this.em.merge(venta);
    }

    @Transactional
    @Override
    public void delete(Venta venta) throws Exception {
        Venta v = new Venta();
        v = this.em.find(Venta.class, venta.getIdVenta());
        if (v != null) {
            this.em.remove(v);
        }
    }

    /**
    @Transactional
    @Override
    public void generateOrder(Venta venta) throws Exception {
        int idVenta = 0;
        Query q;
        String consulta;
        consulta = "INSERT into Venta values (null, ?1, ?2, ?3, ?4, ?5, ?6, null)";
        q = this.em.createNativeQuery(consulta);
        q.setParameter(1, venta.getFechaVenta());
        q.setParameter(2, venta.getHoraVenta());
        q.setParameter(3, venta.getValorVenta());
        q.setParameter(4, venta.getTipoVenta());
        q.setParameter(5, venta.getFK_idMPago());
        q.setParameter(6, venta.getFK_idPersona());
        q.executeUpdate();
        
        consulta = "SELECT @@IDENTITY as PK_idVenta";
        q = this.em.createQuery(consulta);
        idVenta = (int) q.getSingleResult();
        
        for (Carrito detalle : this.detalleCarrito) {
            consulta = "INSERT into DetalleVenta values (null, ?1, ?2, ?3, ?4, ?5, null)";
            q = this.em.createNativeQuery(consulta);
            q.setParameter(1, idVenta);
            q.setParameter(2, detalle.getIdPlato());
            q.setParameter(3, detalle.getCantidad());
            q.setParameter(4, detalle.getSubTotal());
            q.executeUpdate();
        }
        
    }
    
    public List<Carrito> getDetalleCarrito() {
        return detalleCarrito;
    }

    public void setDetalleCarrito(List<Carrito> detalleCarrito) {
        this.detalleCarrito = detalleCarrito;
    }
    */
    @Override
    public void lastIdVenta() throws Exception {
        int idVenta = 0;
        Query q;
        String consulta;
        consulta = "SELECT @@IDENTITY as PK_idVenta";
        q = this.em.createQuery(consulta);
        idVenta = (int) q.getSingleResult();
    }
    
}
