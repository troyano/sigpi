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

import Modulo_3.unicom.dm.Entitys.EjecucionCronograma;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class EjecucionCronogramaBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EjecucionCronograma cronograma = new EjecucionCronograma();
	/*
	 * Varios
	 */
	private List<EjecucionCronograma> listaEjecucionCronograma;
	private EjecucionCronograma selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<EjecucionCronograma> mostrarTodos() {

		try {
			listaEjecucionCronograma = (List<EjecucionCronograma>) crudBO
					.buscarTodos((Class<T>) EjecucionCronograma.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEjecucionCronograma;
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

			crudBO.crear((T) cronograma,true);

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

	
	/*  --------------------get   - ---  set  -------------------------*/

	/**
	 * @return the cronograma
	 */
	public EjecucionCronograma getCronograma() {
		return cronograma;
	}


	/**
	 * @param cronograma the cronograma to set
	 */
	public void setCronograma(EjecucionCronograma cronograma) {
		this.cronograma = cronograma;
	}


	/**
	 * @return the listaEjecucionCronograma
	 */
	public List<EjecucionCronograma> getListaEjecucionCronograma() {
		return listaEjecucionCronograma;
	}


	/**
	 * @param listaEjecucionCronograma the listaEjecucionCronograma to set
	 */
	public void setListaEjecucionCronograma(
			List<EjecucionCronograma> listaEjecucionCronograma) {
		this.listaEjecucionCronograma = listaEjecucionCronograma;
	}


	/**
	 * @return the selected
	 */
	public EjecucionCronograma getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EjecucionCronograma selected) {
		this.selected = selected;
	}
	
	
	

}
