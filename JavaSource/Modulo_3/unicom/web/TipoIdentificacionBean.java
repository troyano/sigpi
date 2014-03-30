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

import Modulo_3.unicom.dm.Entitys.EntTipoIdentificacion;



import comun.unicom.bo.CrudBO;

/**
 * @author Eduar
 *
 */
@ManagedBean
@SessionScoped
public class TipoIdentificacionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntTipoIdentificacion tIdentificacion = new EntTipoIdentificacion();
	/*
	 * Varios
	 */
	private List<EntTipoIdentificacion> listaEntTipoIdentificacion;
	private EntTipoIdentificacion selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<EntTipoIdentificacion> mostrarTodos() {

		try {
			listaEntTipoIdentificacion = (List<EntTipoIdentificacion>) crudBO
					.buscarTodos((Class<T>) EntTipoIdentificacion.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntTipoIdentificacion;
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

			crudBO.crear((T) tIdentificacion);

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

	
	/*  ---------   set  -----   get   -------------*/
	



	/**
	 * @return the tIdentificacion
	 */
	public EntTipoIdentificacion gettIdentificacion() {
		return tIdentificacion;
	}


	/**
	 * @param tIdentificacion the tIdentificacion to set
	 */
	public void settIdentificacion(EntTipoIdentificacion tIdentificacion) {
		this.tIdentificacion = tIdentificacion;
	}


	/**
	 * @return the listaEntTipoIdentificacion
	 */
	public List<EntTipoIdentificacion> getListaEntTipoIdentificacion() {
		return listaEntTipoIdentificacion;
	}


	/**
	 * @param listaEntTipoIdentificacion the listaEntTipoIdentificacion to set
	 */
	public void setListaEntTipoIdentificacion(
			List<EntTipoIdentificacion> listaEntTipoIdentificacion) {
		this.listaEntTipoIdentificacion = listaEntTipoIdentificacion;
	}


	/**
	 * @return the selected
	 */
	public EntTipoIdentificacion getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EntTipoIdentificacion selected) {
		this.selected = selected;
	}



}
