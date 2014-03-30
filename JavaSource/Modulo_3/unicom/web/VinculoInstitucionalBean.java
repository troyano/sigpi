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

import Modulo_3.unicom.dm.Entitys.VinculoInstitucional;



import comun.unicom.bo.CrudBO;

/**
 * @author Eduar
 *
 */
@ManagedBean
@SessionScoped
public class VinculoInstitucionalBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private VinculoInstitucional vInstitucional = new VinculoInstitucional();
	/*
	 * Varios
	 */
	private List<VinculoInstitucional> listaVinculoInstitucional;
	private VinculoInstitucional selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<VinculoInstitucional> mostrarTodos() {

		try {
			listaVinculoInstitucional = (List<VinculoInstitucional>) crudBO
					.buscarTodos((Class<T>) VinculoInstitucional.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaVinculoInstitucional;
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

			crudBO.crear((T) vInstitucional);

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
	 * @return the vInstitucional
	 */
	public VinculoInstitucional getvInstitucional() {
		return vInstitucional;
	}


	/**
	 * @param vInstitucional the vInstitucional to set
	 */
	public void setvInstitucional(VinculoInstitucional vInstitucional) {
		this.vInstitucional = vInstitucional;
	}


	/**
	 * @return the listaVinculoInstitucional
	 */
	public List<VinculoInstitucional> getListaVinculoInstitucional() {
		return listaVinculoInstitucional;
	}


	/**
	 * @param listaVinculoInstitucional the listaVinculoInstitucional to set
	 */
	public void setListaVinculoInstitucional(
			List<VinculoInstitucional> listaVinculoInstitucional) {
		this.listaVinculoInstitucional = listaVinculoInstitucional;
	}


	/**
	 * @return the selected
	 */
	public VinculoInstitucional getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(VinculoInstitucional selected) {
		this.selected = selected;
	}


}
