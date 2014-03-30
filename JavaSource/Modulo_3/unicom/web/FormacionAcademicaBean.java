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

import Modulo_3.unicom.dm.Entitys.FormacionAcademica;



import comun.unicom.bo.CrudBO;

/**
 * @author Eduar
 *
 */
@ManagedBean
@SessionScoped
public class FormacionAcademicaBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private FormacionAcademica fAcademica = new FormacionAcademica();
	/*
	 * Varios
	 */
	private List<FormacionAcademica> listaFormacionAcademica;
	private FormacionAcademica selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<FormacionAcademica> mostrarTodos() {

		try {
			listaFormacionAcademica = (List<FormacionAcademica>) crudBO
					.buscarTodos((Class<T>) FormacionAcademica.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaFormacionAcademica;
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

			crudBO.crear((T) fAcademica);

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
	 * @return the fAcademica
	 */
	public FormacionAcademica getfAcademica() {
		return fAcademica;
	}


	/**
	 * @param fAcademica the fAcademica to set
	 */
	public void setfAcademica(FormacionAcademica fAcademica) {
		this.fAcademica = fAcademica;
	}


	/**
	 * @return the listaFormacionAcademica
	 */
	public List<FormacionAcademica> getListaFormacionAcademica() {
		return listaFormacionAcademica;
	}


	/**
	 * @param listaFormacionAcademica the listaFormacionAcademica to set
	 */
	public void setListaFormacionAcademica(
			List<FormacionAcademica> listaFormacionAcademica) {
		this.listaFormacionAcademica = listaFormacionAcademica;
	}


	/**
	 * @return the selected
	 */
	public FormacionAcademica getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(FormacionAcademica selected) {
		this.selected = selected;
	}

}
