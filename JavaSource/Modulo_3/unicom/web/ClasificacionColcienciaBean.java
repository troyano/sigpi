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

import Modulo_3.unicom.dm.Entitys.ClasificacionColciencia;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class ClasificacionColcienciaBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private ClasificacionColciencia clasificacion = new ClasificacionColciencia();
	/*
	 * Varios
	 */
	private List<ClasificacionColciencia> listaClasificacionColciencia;
	private ClasificacionColciencia selected;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<ClasificacionColciencia> mostrarTodos() {

		try {
			listaClasificacionColciencia = (List<ClasificacionColciencia>) crudBO
					.buscarTodos((Class<T>) ClasificacionColciencia.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaClasificacionColciencia;
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

			crudBO.crear((T) clasificacion, true);

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
	 * @return the listaClasificacionColciencia
	 */
	public List<ClasificacionColciencia> getListaClasificacionColciencia() {
		return listaClasificacionColciencia;
	}

	/**
	 * @param listaClasificacionColciencia
	 *            the listaClasificacionColciencia to set
	 */
	public void setListaClasificacionColciencia(
			List<ClasificacionColciencia> listaClasificacionColciencia) {
		this.listaClasificacionColciencia = listaClasificacionColciencia;
	}

	/**
	 * @return the selected
	 */
	public ClasificacionColciencia getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(ClasificacionColciencia selected) {
		this.selected = selected;
	}

	/**
	 * @return the clasificacion
	 */
	public ClasificacionColciencia getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion
	 *            the clasificacion to set
	 */
	public void setClasificacion(ClasificacionColciencia clasificacion) {
		this.clasificacion = clasificacion;
	}

}
