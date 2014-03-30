/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.el.PropertyNotFoundException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Modulo_3.unicom.dm.Entitys.AptEspesificacion;
import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class AptEspesificacionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private AptEspesificacion espesificacion = new AptEspesificacion();
	/*
	 * Varios
	 */
	private List<AptEspesificacion> listaAptEspesificacion;
	private AptEspesificacion selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<AptEspesificacion> mostrarTodos() {

		try {
			listaAptEspesificacion = (List<AptEspesificacion>) crudBO
					.buscarTodos((Class<T>) AptEspesificacion.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaAptEspesificacion;
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
		try {

			crudBO.crear((T) espesificacion, true);

		} catch (NullPointerException e) {
			System.out.println("Crear ** NullPointerException Bean" + e);
			// e.printStackTrace();
		} catch (PropertyNotFoundException e) {
			System.out
					.println("Crear **PropertyNotFoundException Bean ====================== "
							+ e);
			// e.printStackTrace();
		}

	}

	
	@SuppressWarnings("unchecked")
	public void eliminareditar() {

		try {
			crudBO.remover((T) selected);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	/*    --------   get   ------   set  ---------*/

	/**
	 * @return the espesificacion
	 */
	public AptEspesificacion getEspesificacion() {
		return espesificacion;
	}


	/**
	 * @param espesificacion the espesificacion to set
	 */
	public void setEspesificacion(AptEspesificacion espesificacion) {
		this.espesificacion = espesificacion;
	}


	/**
	 * @return the listaAptEspesificacion
	 */
	public List<AptEspesificacion> getListaAptEspesificacion() {
		return listaAptEspesificacion;
	}


	/**
	 * @param listaAptEspesificacion the listaAptEspesificacion to set
	 */
	public void setListaAptEspesificacion(
			List<AptEspesificacion> listaAptEspesificacion) {
		this.listaAptEspesificacion = listaAptEspesificacion;
	}


	/**
	 * @return the selected
	 */
	public AptEspesificacion getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(AptEspesificacion selected) {
		this.selected = selected;
	}
	
	
	
	
	
	
}
