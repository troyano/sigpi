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
 *
 */
@ManagedBean
@SessionScoped
public class EntSectorBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntSector sector = new EntSector();
	/*
	 * Varios
	 */
	private List<EntSector> listaEntSector;
	private EntSector selected;
	private List<EntTipoEntidad> listaEntTipoEntidad;
		
	
	@SuppressWarnings("unchecked")
	public List<EntSector> mostrarTodos() {

		try {
			listaEntSector = (List<EntSector>) crudBO
					.buscarTodos((Class<T>) EntSector.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntSector;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {
			listaEntTipoEntidad = (List<EntTipoEntidad>) crudBO
					.buscarTodos((Class<T>) EntTipoEntidad.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public List<EntTipoEntidad> listaEntTipoEntidad() {
		return listaEntTipoEntidad;
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

			crudBO.crear((T) sector, true);

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

	/*  -----------------get ----  set  ---------------------*/
	
	/**
	 * @return the sector
	 */
	public EntSector getSector() {
		return sector;
	}


	/**
	 * @param sector the sector to set
	 */
	public void setSector(EntSector sector) {
		this.sector = sector;
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


	/**
	 * @return the selected
	 */
	public EntSector getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EntSector selected) {
		this.selected = selected;
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
}
