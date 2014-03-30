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

import Modulo_3.unicom.dm.Entitys.EntCiiu;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class EntCiiuBean<T> implements Serializable{
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntCiiu ciiu = new EntCiiu();
	/*
	 * Varios
	 */
	private List<EntCiiu> listaEntCiiu;
	private EntCiiu selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<EntCiiu> mostrarTodos() {

		try {
			listaEntCiiu = (List<EntCiiu>) crudBO
					.buscarTodos((Class<T>) EntCiiu.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntCiiu;
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

			crudBO.crear((T) ciiu, true);

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
	
	/*---------------- get  ------------  set ---------------*/

	/**
	 * @return the ciiu
	 */
	public EntCiiu getCiiu() {
		return ciiu;
	}


	/**
	 * @param ciiu the ciiu to set
	 */
	public void setCiiu(EntCiiu ciiu) {
		this.ciiu = ciiu;
	}


	/**
	 * @return the listaEntCiiu
	 */
	public List<EntCiiu> getListaEntCiiu() {
		return listaEntCiiu;
	}


	/**
	 * @param listaEntCiiu the listaEntCiiu to set
	 */
	public void setListaEntCiiu(List<EntCiiu> listaEntCiiu) {
		this.listaEntCiiu = listaEntCiiu;
	}


	/**
	 * @return the selected
	 */
	public EntCiiu getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EntCiiu selected) {
		this.selected = selected;
	}
	
	
	


}
