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

import Modulo_3.unicom.dm.Entitys.EntContribuyente;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class EntContribuyenteBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private EntContribuyente contribuyente = new EntContribuyente();
	/*
	 * Varios
	 */
	private List<EntContribuyente> listaEntContribuyente;
	private EntContribuyente selected;

	@SuppressWarnings("unchecked")
	public List<EntContribuyente> mostrarTodos() {

		try {
			listaEntContribuyente = (List<EntContribuyente>) crudBO
					.buscarTodos((Class<T>) EntContribuyente.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntContribuyente;
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

			crudBO.crear((T) contribuyente, true);

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

	/*-------------------------------get ------- set -------------------*/
	/**
	 * @return the contribuyente
	 */
	public EntContribuyente getContribuyente() {
		return contribuyente;
	}

	/**
	 * @param contribuyente the contribuyente to set
	 */
	public void setContribuyente(EntContribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}

	/**
	 * @return the listaEntContribuyente
	 */
	public List<EntContribuyente> getListaEntContribuyente() {
		return listaEntContribuyente;
	}

	/**
	 * @param listaEntContribuyente the listaEntContribuyente to set
	 */
	public void setListaEntContribuyente(
			List<EntContribuyente> listaEntContribuyente) {
		this.listaEntContribuyente = listaEntContribuyente;
	}

	/**
	 * @return the selected
	 */
	public EntContribuyente getSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EntContribuyente selected) {
		this.selected = selected;
	}
	
	

}
