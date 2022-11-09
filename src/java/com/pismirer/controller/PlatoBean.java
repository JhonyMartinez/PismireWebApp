package com.pismirer.controller;

import com.pismirer.entity.Plato;
import com.pismirer.entity.TipoPlato;
import com.pismirer.facadeimp.PlatoImp;
import com.pismirer.facadeimp.TipoPlatoImp;
import com.pismirer.utilities.Carrito;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;

@Named("platoBean")
@SessionScoped
public class PlatoBean implements Serializable{
    
    private List<Plato> platos; //Lista con Todos los Platos
    private List<Plato> platosCategoria = new ArrayList(); //Lista con los Platos dentro de una Categoria especifica
    
    private List<Carrito> platosCarrito = new ArrayList(); //Lista del Carrito, aqui se almacenan los platos agregados
    
    private Plato platoAdd; //Objeto de Plato para utilizar en el dashboard, al momento de añadir nuevo plato es necesario
    private TipoPlato tipoPlatoAdd; //Objeto de TipoPlato para utilizar en el dashboard, al momento de añadir nuevo plato es necesario
    
    TipoPlato tipoPlato = new TipoPlato(); //Objeto de TipoPlato para utilizar en la pagina inicial, todo el tema de listar por categoria, carrito, etc
    Plato plato = new Plato();
    
    private UploadedFile file;
    
    @Inject
    private PlatoImp platoImp;
    
    @Inject
    private TipoPlatoImp tipoPlatoImp;
    
    @PostConstruct
    public void init(){
        try {
            this.platoAdd = new Plato();
            this.tipoPlatoAdd = new TipoPlato();
            this.platos = this.platoImp.findAll();  
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    //MOSTRAR PLATOS POR CATEGORIA
    
    public void selectCategory(int id){
        try {
            tipoPlato = this.tipoPlatoImp.findById(id);
            findByCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void findByCategory(int id){
        try {
            if (id == 0) {
                this.platosCategoria = this.platos;
            }else{
                this.platosCategoria = this.platoImp.findByCategory(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    //CRUD - DASHBOARD
    
    public void addPlato(){
        try {
            this.platoAdd.setFechaCreacion(new Date());
            this.platoAdd.setFK_idTipoPlato(tipoPlatoAdd);
            this.platoImp.add(platoAdd);
            PrimeFaces.current().ajax().update("datosPlatos:platos");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void deletePlato(Plato platoAdd){
        try {
            this.platoImp.delete(platoAdd);
            this.platos.remove(platoAdd);
            PrimeFaces.current().ajax().update("datosPlatos:platos");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void updatePlato(Plato platoAdd){
        try {
            this.platoImp.update(platoAdd);
            PrimeFaces.current().ajax().update("datosPlatos:platos");
            init();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    //CARRITO DE COMPRAS
    
    private int producto;
    private double total = 0.0;
    private int cantidad = 1;
    private int contador;
    
    public void addToCart(int id){
        try {
            int posicion = 0;
            cantidad = 1;
            this.plato = this.platoImp.findById(id);
            
            if (platosCarrito.size() > 0) {
                for (int i = 0; i < platosCarrito.size(); i++) {
                    if (id == platosCarrito.get(i).getIdPlato()) {
                        posicion = i;
                    }
                }
                if (id == platosCarrito.get(posicion).getIdPlato()) {
                    cantidad = platosCarrito.get(posicion).getCantidad() + cantidad;
                    double subTotal = platosCarrito.get(posicion).getPrecio() * cantidad;
                    platosCarrito.get(posicion).setCantidad(cantidad);
                    platosCarrito.get(posicion).setSubTotal(subTotal);
                } else{
                    producto = producto + 1;
            
                    Carrito cart = new Carrito();
                    cart.setProducto(producto);
                    cart.setIdPlato(plato.getIdPlato());
                    cart.setPrecio(plato.getPrecioPlato());
                    cart.setNombrePlato(plato.getNombrePlato());
                    cart.setDescripcion(plato.getDescripcionPlato());
                    cart.setCantidad(cantidad);
                    cart.setSubTotal(cantidad * plato.getPrecioPlato());
                    this.platosCarrito.add(cart);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Carrito", "Se agrego el Plato al Carrito"));
                }
            }else{
                producto = producto + 1;
            
                Carrito cart = new Carrito();
                cart.setProducto(producto);
                cart.setIdPlato(plato.getIdPlato());
                cart.setPrecio(plato.getPrecioPlato());
                cart.setNombrePlato(plato.getNombrePlato());
                cart.setDescripcion(plato.getDescripcionPlato());
                cart.setCantidad(cantidad);
                cart.setSubTotal(cantidad * plato.getPrecioPlato());
                this.platosCarrito.add(cart);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Carrito", "Se agrego el Plato al Carrito"));
            }
            contador = platosCarrito.size();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void removeToCart(int id){
        try {
            for (int i = 0; i < platosCarrito.size(); i++) {
            if (id == platosCarrito.get(i).getIdPlato()) {
                platosCarrito.remove(i);
                producto = producto - 1;
                contador = platosCarrito.size();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Carrito", "Se Elimino el Plato del Carrito"));
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void showCart(){
        try {
            total = 0.0;
            for (int i = 0; i < platosCarrito.size(); i++) {
                total = total + platosCarrito.get(i).getSubTotal();
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public void addQuantity(int id){
        int posicion = 0;
        cantidad = 1;
        for (int i = 0; i < platosCarrito.size(); i++) {
            if (id == platosCarrito.get(i).getIdPlato()) {
                cantidad = platosCarrito.get(i).getCantidad();
                posicion = i;
            }
        }
        if (id == platosCarrito.get(posicion).getIdPlato()) {
            cantidad = platosCarrito.get(posicion).getCantidad() + 1;
            double subTotal = platosCarrito.get(posicion).getPrecio() * cantidad;
            platosCarrito.get(posicion).setCantidad(cantidad);
            platosCarrito.get(posicion).setSubTotal(subTotal);
        }
        
    }
    
    public void removeQuantity(int id){
        int posicion = 0;
        cantidad = 1;
        for (int i = 0; i < platosCarrito.size(); i++) {
            if (id == platosCarrito.get(i).getIdPlato()) {
                cantidad = platosCarrito.get(i).getCantidad();
                posicion = i;
            }
        }
        if (id == platosCarrito.get(posicion).getIdPlato()) {
            if (cantidad > 1) {
                cantidad = platosCarrito.get(posicion).getCantidad() - 1;
                double subTotal = platosCarrito.get(posicion).getPrecio() * cantidad;
                platosCarrito.get(posicion).setCantidad(cantidad);
                platosCarrito.get(posicion).setSubTotal(subTotal);
            }  
        }
        
    }
    
    public void validateCart(){
        try {
            if (!platosCarrito.isEmpty()) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("pedido.xhtml?faces-redirect=true");
            } else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Carrito", "No tienes ningun producto en el Carrito"));
            }
        } catch (Exception e) {
        }
    }
    
    public void validateOrder(){
        try {
            if (platosCarrito.isEmpty()) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("categorias.xhtml?faces-redirect=true");
            }
        } catch (Exception e) {
        }
    }
    
    /* Subida de Datos */
    
    public void cargaPlatos(){
        try {
            Date date = new Date();
            if (file.getSize() > 0) {
                InputStream inputStream = file.getInputStream(); //Permite leer datos
                XSSFWorkbook libro = new XSSFWorkbook(inputStream); //Libro de excel
                Sheet sheet = libro.getSheetAt(0); //Hoja de excel
                Iterator<Row> iterator = sheet.iterator(); //El iterator permite recorrer una coleccion sin revelar su estructura
                int i = 0;
                while(iterator.hasNext()){
                    Row currentRow = iterator.next(); //El row se podria considerar una collecion de la libreria POI
                    if (i > 0) {
                        if (currentRow.getCell(0) == null && currentRow.getCell(1)
                            != null && currentRow.getCell(2)
                            != null && currentRow.getCell(3)
                            != null && currentRow.getCell(4)
                            !=null) {
                            platoAdd.setNombrePlato(currentRow.getCell(1).getStringCellValue());
                            platoAdd.setFechaCreacion(date);
                            platoAdd.setDescripcionPlato(currentRow.getCell(2).getStringCellValue());
                            platoAdd.setPrecioPlato(currentRow.getCell(3).getNumericCellValue());
                            platoAdd.setFotoPlato("Foto");
                            tipoPlatoAdd.setIdTipoPlato((int)currentRow.getCell(4).getNumericCellValue());
                            platoAdd.setFK_idTipoPlato(tipoPlatoAdd);
                            this.platoImp.add(platoAdd);
                            this.tipoPlatoAdd = new TipoPlato();    
                    } else{
                        break;
                    }
                    }
                    i++;
                }
                libro.close();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Datos importados"));
                PrimeFaces.current().ajax().update("datosPlatos:platos");
                init();
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Error al importar datos"));
            }
        } catch (Exception e) {
        }  
    }
    
    //ENCAPSULAMIENTO
    
    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }
    
    public List<Plato> getPlatosCategoria() {
        return platosCategoria;
    }

    public void setPlatosCategoria(List<Plato> platosCategoria) {
        this.platosCategoria = platosCategoria;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Plato getPlatoAdd() {
        return platoAdd;
    }

    public void setPlatoAdd(Plato platoAdd) {
        this.platoAdd = platoAdd;
    }
    
    
    public TipoPlato getTipoPlato() {
        return tipoPlato;
    }

    public TipoPlato getTipoPlatoAdd() {
        return tipoPlatoAdd;
    }

    public void setTipoPlatoAdd(TipoPlato tipoPlatoAdd) {
        this.tipoPlatoAdd = tipoPlatoAdd;
    }
    
    public void setTipoPlato(TipoPlato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public List<Carrito> getPlatosCarrito() {
        return platosCarrito;
    }

    public void setPlatosCarrito(List<Carrito> platosCarrito) {
        this.platosCarrito = platosCarrito;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
}
