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

import Modulo_3.unicom.dm.Entitys.TipoPersonal;



import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 *
 */
@ManagedBean
@SessionScoped
public class TipoPersonalBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private TipoPersonal tpersonal = new TipoPersonal();
	/*
	 * Varios
	 */
	private List<TipoPersonal> listaTipoPersonal;
	private TipoPersonal selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<TipoPersonal> mostrarTodos() {

		try {
			listaTipoPersonal = (List<TipoPersonal>) crudBO
					.buscarTodos((Class<T>) TipoPersonal.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaTipoPersonal;
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

			crudBO.crear((T) tpersonal, true);

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
	 * @return the tpersonal
	 */
	public TipoPersonal getTpersonal() {
		return tpersonal;
	}


	/**
	 * @param tpersonal the tpersonal to set
	 */
	public void setTpersonal(TipoPersonal tpersonal) {
		this.tpersonal = tpersonal;
	}


	/**
	 * @return the listaTipoPersonal
	 */
	public List<TipoPersonal> getListaTipoPersonal() {
		return listaTipoPersonal;
	}


	/**
	 * @param listaTipoPersonal the listaTipoPersonal to set
	 */
	public void setListaTipoPersonal(List<TipoPersonal> listaTipoPersonal) {
		this.listaTipoPersonal = listaTipoPersonal;
	}


	/**
	 * @return the selected
	 */
	public TipoPersonal getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(TipoPersonal selected) {
		this.selected = selected;
	}
	
	


}
