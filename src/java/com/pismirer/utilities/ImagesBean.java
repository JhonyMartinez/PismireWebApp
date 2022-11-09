package com.pismirer.utilities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@ViewScoped
public class ImagesBean {
    
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public void upload(){
        try {
            if (file != null) {
                ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String path = ctx.getRealPath("/");
                System.out.println("Hola este es el path" + path);
                
            }
        } catch (Exception e) {
        }
    }
    
}
