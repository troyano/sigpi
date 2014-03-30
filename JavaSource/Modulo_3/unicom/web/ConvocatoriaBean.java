/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
/*
 * BO´s
 */
import comun.unicom.bo.CrudBO;
/*
 * Entitys
 */
import Modulo_3.unicom.dm.Entitys.Convocatoria;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean(name="convocatoriaBean")
@SessionScoped
public class ConvocatoriaBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(ConvocatoriaBean.class.getSimpleName()); 
	
	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;;
	/*
	 * Entitys
	 */

	private Convocatoria convocatoria = new Convocatoria();

	/*
	 * Varios
	 */
	private List<Convocatoria> listaConvocatoria;

	@SuppressWarnings("unchecked")
	public List<Convocatoria> mostrarTodos() {

		try {

			listaConvocatoria = (List<Convocatoria>) crudBO
					.buscarTodos((Class<T>) Convocatoria.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaConvocatoria;
	}

	@SuppressWarnings("unchecked")
	public void editar() {

		try {
			crudBO.editar((T) selected);
		} catch (NullPointerException e) {
			System.out.println("Editar ** NullPointerException Bean" + e);
			// e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void crear() {

		crudBO.crear((T) convocatoria);
	}

	@SuppressWarnings("unchecked")
	public void eliminareditar() {

		try {
			crudBO.remover((T) selected);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String destino = "C:'\'UpLoads";

	public void handleFileUpload(FileUploadEvent event) {

		System.out.println("===== File 1.0");
		UploadedFile file = event.getFile();
		System.out.println("===== File 1.0" + file);

		FacesMessage msg = new FacesMessage("Succesful", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void copyFile(String fileName, InputStream in) throws FileNotFoundException {
		
			OutputStream out = new FileOutputStream(
					new File(destino + fileName));
		
		int read = 0;
		byte[] bytes = new byte[1024];
			
		try {
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			in.close();
			out.flush();
			out.close();
			
			log.info("New file cread!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			log.info("Errores: ", e);
		}
	}

	/*
	 * setes and gettes
	 */
	/**
	 * @return the convocatoria
	 */
	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	/**
	 * @param convocatoria
	 *            the convocatoria to set
	 */
	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	/**
	 * @return the listaConvocatoria
	 */
	public List<Convocatoria> getListaConvocatoria() {
		return listaConvocatoria;
	}

	/**
	 * @param listaConvocatoria
	 *            the listaConvocatoria to set
	 */
	public void setListaConvocatoria(List<Convocatoria> listaConvocatoria) {
		this.listaConvocatoria = listaConvocatoria;
	}

	/**
	 * @return the selected
	 */
	public Convocatoria getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(Convocatoria selected) {
		this.selected = selected;
	}

	private Convocatoria selected;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 * 
	 */

}
