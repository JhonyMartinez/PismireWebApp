package com.pismirer.controller;

import com.pismirer.entity.DetalleVenta;
import com.pismirer.entity.Domicilio;
import com.pismirer.entity.EstadoPedido;
import com.pismirer.entity.MetodoPago;
import com.pismirer.entity.Persona;
import com.pismirer.entity.Plato;
import com.pismirer.entity.Venta;
import com.pismirer.facadeimp.DetalleVentaImp;
import com.pismirer.facadeimp.DomicilioImp;
import com.pismirer.facadeimp.PlatoImp;
import com.pismirer.facadeimp.VentaImp;
import com.pismirer.utilities.Carrito;
import com.pismirer.utilities.ReportsController;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.PrimeFaces;

@Named("ventaBean")
@ViewScoped
public class VentaBean implements Serializable{
    
    private List<Venta> ventas;
    
    private List<Carrito> detalleCarrito;
    
    private Venta venta;
    private Persona personaAdd;
    private MetodoPago metodoPagoAdd;
    
    private Venta pedido;
    private DetalleVenta detalleVenta;
    
    Persona persona = new Persona();
    MetodoPago metodoPago = new MetodoPago();
    
    private Domicilio domicilio;
    private EstadoPedido estadoPedido;
    
    @Inject
    private VentaImp ventaImp;
    
    @Inject
    private DetalleVentaImp detalleVentaImp;
    
    @Inject
    private PlatoBean platoBean;
    
    @Inject
    private PlatoImp platoImp;
    
    @Inject
    private LoginBean loginBean;
    
    @Inject
    private DomicilioImp domicilioImp;
    

    
    @PostConstruct
    public void init(){
        try {
            this.venta = new Venta();
            this.metodoPagoAdd = new MetodoPago();
            this.detalleVenta = new DetalleVenta();
            this.ventas = this.ventaImp.findAll();
            this.detalleCarrito = this.platoBean.getPlatosCarrito();
            this.personaAdd = new Persona();
            this.persona = this.loginBean.getPersona();
            this.pedido = new Venta();
            this.domicilio = new Domicilio();
            this.estadoPedido = new EstadoPedido();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void addVenta(){
        try {
            Date fecha = new Date();
            Date hora = new Date();
            SimpleDateFormat formatear = new SimpleDateFormat("hh:mm:ss");
            formatear.format(hora);
            this.venta.setFechaVenta(fecha);
            this.venta.setHoraVenta(hora);
            this.venta.setTipoVenta("Presencial");
            this.venta.setFK_idMPago(metodoPagoAdd);
            this.venta.setFK_idPersona(personaAdd);
            this.ventaImp.add(venta);
            PrimeFaces.current().ajax().update("datosVentas:ventas");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void generateOrder(){
        try {
            Date fecha = new Date();
            Date hora = new Date();
            SimpleDateFormat formatear = new SimpleDateFormat("hh:mm:ss");
            formatear.format(hora);
            this.pedido.setFK_idMPago(metodoPago);
            this.pedido.setFK_idPersona(persona);
            this.pedido.setHoraVenta(hora);
            this.pedido.setFechaVenta(fecha);
            this.pedido.setTipoVenta("Domicilio");
            this.pedido.setValorVenta(this.platoBean.getTotal());
            this.ventaImp.add(pedido);
            
            for (int i = 0; i < this.detalleCarrito.size(); i++) {
                Plato plato = new Plato();
                plato = this.platoImp.findById(detalleCarrito.get(i).getIdPlato());
                this.detalleVenta.setFK_idVenta(pedido);
                this.detalleVenta.setFK_idPlato(plato);
                this.detalleVenta.setCantidadPlato(detalleCarrito.get(i).getCantidad());
                this.detalleVenta.setTotalPlato(detalleCarrito.get(i).getSubTotal());
                
                this.detalleVentaImp.add(detalleVenta);
            }
            this.estadoPedido.setIdEstadoPedido(1);
            this.domicilio.setFK_idEstadoPedido(estadoPedido);
            this.domicilio.setDireccionPedido(persona.getDireccionPersona());
            this.domicilio.setFK_idVenta(pedido);
            this.domicilio.setHoraSalidaPedido("00:00:00");
            this.domicilio.setHoraLlegadaPedido("00:00:00");
            
            this.domicilioImp.add(domicilio);
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("gracias.xhtml?faces-redirect=true");
            this.detalleCarrito.clear();
            this.domicilio = new Domicilio();
            this.platoBean.getPlatosCarrito().clear();
            this.platoBean.setProducto(0);
            this.platoBean.setContador(this.detalleCarrito.size());
            this.estadoPedido = new EstadoPedido();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Ha ocurrido un problema, intenta de nuevo mas tarde"));
        }
    }
    
    /*
    public void PDF2(ActionEvent actionEvent){
        try {
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ventas);
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Reportes/DetallePedido.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
            
            HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    */
    
    public void PDF(){
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            
            String logoPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Reportes/img/LogoPNG.png");
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("LogoSistema", logoPath);
            
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Reportes/DetallePedidoIMG.jasper");
            //JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, map, ReportsController.conectar());
            
            //JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            
            JasperPrint print = new JasperPrint();
            print = JasperFillManager.fillReport(reportPath, map, ReportsController.conectar());
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(print);
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-Disposition", "inline;filename=Detalle-Pedido.pdf");
            httpServletResponse.getOutputStream().write(pdfBytes);
            httpServletResponse.flushBuffer();
            
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Carrito> getDetalleCarrito() {
        return detalleCarrito;
    }

    public void setDetalleCarrito(List<Carrito> detalleCarrito) {
        this.detalleCarrito = detalleCarrito;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public PlatoBean getPlatoBean() {
        return platoBean;
    }

    public void setPlatoBean(PlatoBean platoBean) {
        this.platoBean = platoBean;
    }

    public Venta getPedido() {
        return pedido;
    }

    public void setPedido(Venta pedido) {
        this.pedido = pedido;
    }

    public Persona getPersonaAdd() {
        return personaAdd;
    }

    public void setPersonaAdd(Persona personaAdd) {
        this.personaAdd = personaAdd;
    }

    public MetodoPago getMetodoPagoAdd() {
        return metodoPagoAdd;
    }

    public void setMetodoPagoAdd(MetodoPago metodoPagoAdd) {
        this.metodoPagoAdd = metodoPagoAdd;
    }
    
    
    
    
}
