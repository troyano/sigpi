/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.PropertyNotFoundException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Modulo_3.unicom.dm.Entitys.EntSector;
import Modulo_3.unicom.dm.Entitys.EntTipoEntidad;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class EntTipoEntidadBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntTipoEntidad entidad = new EntTipoEntidad();
	/*
	 * Varios
	 */
	private List<EntTipoEntidad> listaEntTipoEntidad;
	private EntTipoEntidad selected;
	private List<EntSector> listaEntSector;
	
	
	@SuppressWarnings("unchecked")
	public List<EntTipoEntidad> mostrarTodos() {

		try {
			listaEntTipoEntidad = (List<EntTipoEntidad>) crudBO
					.buscarTodos((Class<T>) EntTipoEntidad.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntTipoEntidad;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {
			listaEntSector = (List<EntSector>) crudBO
					.buscarTodos((Class<T>) EntSector.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	public List<EntSector> listaEntSectores() {
		return listaEntSector;
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

			crudBO.crear((T) entidad, true);

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

   /* -------------------   get   -------      set -------------------*/
	/**
	 * @return the entidad
	 */
	public EntTipoEntidad getEntidad() {
		return entidad;
	}


	/**
	 * @param entidad the entidad to set
	 */
	public void setEntidad(EntTipoEntidad entidad) {
		this.entidad = entidad;
	}


	/**
	 * @return the listaEntTipoEntidad
	 */
	public List<EntTipoEntidad> getListaEntTipoEntidad() {
		return listaEntTipoEntidad;
	}


	/**
	 * @param listaEntTipoEntidad the listaEntTipoEntidad to set
	 */
	public void setListaEntTipoEntidad(List<EntTipoEntidad> listaEntTipoEntidad) {
		this.listaEntTipoEntidad = listaEntTipoEntidad;
	}


	/**
	 * @return the selected
	 */
	public EntTipoEntidad getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EntTipoEntidad selected) {
		this.selected = selected;
	}

	/**
	 * @return the listaEntSector
	 */
	public List<EntSector> getListaEntSector() {
		return listaEntSector;
	}

	/**
	 * @param listaEntSector the listaEntSector to set
	 */
	public void setListaEntSector(List<EntSector> listaEntSector) {
		this.listaEntSector = listaEntSector;
	}



}
