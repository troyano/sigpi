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

import Modulo_3.unicom.dm.Entitys.EntTamanoEntidad;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class EntTamanoEntidadBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntTamanoEntidad tamano = new EntTamanoEntidad();
	/*
	 * Varios
	 */
	private List<EntTamanoEntidad> listaEntTamanoEntidad;
	private EntTamanoEntidad selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<EntTamanoEntidad> mostrarTodos() {

		try {
			listaEntTamanoEntidad = (List<EntTamanoEntidad>) crudBO
					.buscarTodos((Class<T>) EntTamanoEntidad.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntTamanoEntidad;
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

			crudBO.crear((T) tamano, true);

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

/*   ----------------  get  -------  set   --------------------*/
	
	/**
	 * @return the tamano
	 */
	public EntTamanoEntidad getTamano() {
		return tamano;
	}


	/**
	 * @param tamano the tamano to set
	 */
	public void setTamano(EntTamanoEntidad tamano) {
		this.tamano = tamano;
	}


	/**
	 * @return the listaEntTamanoEntidad
	 */
	public List<EntTamanoEntidad> getListaEntTamanoEntidad() {
		return listaEntTamanoEntidad;
	}


	/**
	 * @param listaEntTamanoEntidad the listaEntTamanoEntidad to set
	 */
	public void setListaEntTamanoEntidad(
			List<EntTamanoEntidad> listaEntTamanoEntidad) {
		this.listaEntTamanoEntidad = listaEntTamanoEntidad;
	}


	/**
	 * @return the selected
	 */
	public EntTamanoEntidad getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EntTamanoEntidad selected) {
		this.selected = selected;
	}
	
	
	


}
