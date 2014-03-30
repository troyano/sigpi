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


import Modulo_3.unicom.dm.Entitys.EntRolentidad;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class EntRolentidadBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntRolentidad rol = new EntRolentidad();
	/*
	 * Varios
	 */
	private List<EntRolentidad> listaRolEntidad;
	private EntRolentidad selected;
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<EntRolentidad> mostrarTodos() {

		try {
			listaRolEntidad = (List<EntRolentidad>) crudBO
					.buscarTodos((Class<T>) EntRolentidad.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaRolEntidad;
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

			crudBO.crear((T) rol, true);

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

	/**
	 * @return the rol
	 */
	public EntRolentidad getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(EntRolentidad rol) {
		this.rol = rol;
	}

	/**
	 * @return the listaRolEntidad
	 */
	public List<EntRolentidad> getListaRolEntidad() {
		return listaRolEntidad;
	}

	/**
	 * @param listaRolEntidad the listaRolEntidad to set
	 */
	public void setListaRolEntidad(List<EntRolentidad> listaRolEntidad) {
		this.listaRolEntidad = listaRolEntidad;
	}



	/**
	 * @return the selected
	 */
	public EntRolentidad getSelected() {
		return selected;
	}



	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EntRolentidad selected) {
		this.selected = selected;
	}



	
	

}
