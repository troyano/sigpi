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

import Modulo_3.unicom.dm.Entitys.TipoVariableEvaluacion;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class TipoVariableEvaluacionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private TipoVariableEvaluacion tVEvaluacion = new TipoVariableEvaluacion();
	/*
	 * Varios
	 */
	private List<TipoVariableEvaluacion> listaTipoVariableEvaluacion;
	private TipoVariableEvaluacion selected;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<TipoVariableEvaluacion> mostrarTodos() {

		try {
			listaTipoVariableEvaluacion = (List<TipoVariableEvaluacion>) crudBO
					.buscarTodos((Class<T>) TipoVariableEvaluacion.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaTipoVariableEvaluacion;
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

			crudBO.crear((T) tVEvaluacion, true);

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

	/*
	 * Sets y Gets
	 */

	/**
	 * @return the tVEvaluacion
	 */
	public TipoVariableEvaluacion gettVEvaluacion() {
		return tVEvaluacion;
	}

	/**
	 * @param tVEvaluacion
	 *            the tVEvaluacion to set
	 */
	public void settVEvaluacion(TipoVariableEvaluacion tVEvaluacion) {
		this.tVEvaluacion = tVEvaluacion;
	}

	/**
	 * @return the listaTipoVariableEvaluacion
	 */
	public List<TipoVariableEvaluacion> getListaTipoVariableEvaluacion() {
		return listaTipoVariableEvaluacion;
	}

	/**
	 * @param listaTipoVariableEvaluacion
	 *            the listaTipoVariableEvaluacion to set
	 */
	public void setListaTipoVariableEvaluacion(
			List<TipoVariableEvaluacion> listaTipoVariableEvaluacion) {
		this.listaTipoVariableEvaluacion = listaTipoVariableEvaluacion;
	}

	/**
	 * @return the selected
	 */
	public TipoVariableEvaluacion getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(TipoVariableEvaluacion selected) {
		this.selected = selected;
	}
}
