package Modulo_3.unicom.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
 
@ManagedBean(name="fileUploadController")
public class FileUploadController {
   private String destination="D:\\tmp\\";

    public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    } 
    
    public void handleFileUpload(FileUploadEvent event){
    	System.out.println("Entre a hn");
    	
    	FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void copyFile(String fileName, InputStream in) {
           try {
             
             
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
             
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
}