/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.PropertyNotFoundException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Modulo_3.unicom.dm.Entitys.AreaInvestigacion;
import Modulo_3.unicom.dm.Entitys.LineaInvestigacion;

import comun.unicom.bo.CrudBO;

/**
 * @author ALEX
 * @param <T>
 * 
 * 
 */
@ManagedBean
@SessionScoped
public class LineaInvestigacionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	/*
	 * Entitys
	 */

	private LineaInvestigacion linea = new LineaInvestigacion();
	/*
	 * Varios
	 */
	private List<LineaInvestigacion> listaLineaInvestigacion;
	private LineaInvestigacion selected;
	private List<AreaInvestigacion> listaAreaInvestigacion;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {

			listaAreaInvestigacion = (List<AreaInvestigacion>) crudBO
					.buscarTodos((Class<T>) AreaInvestigacion.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<LineaInvestigacion> mostrarTodos() {

		try {
			listaLineaInvestigacion = (List<LineaInvestigacion>) crudBO
					.buscarTodos((Class<T>) LineaInvestigacion.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaLineaInvestigacion;
	}
	
	public List<AreaInvestigacion> mostrarTodosAreas() {

		return listaAreaInvestigacion;
	
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

			crudBO.crear((T) linea, true);

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

	/* get -- set */

	/**
	 * @return the listaLineaInvestigacion
	 */
	public List<LineaInvestigacion> getListaLineaInvestigacion() {
		return listaLineaInvestigacion;
	}

	/**
	 * @param listaLineaInvestigacion
	 *            the listaLineaInvestigacion to set
	 */
	public void setListaLineaInvestigacion(
			List<LineaInvestigacion> listaLineaInvestigacion) {
		this.listaLineaInvestigacion = listaLineaInvestigacion;
	}

	/**
	 * @return the linea
	 */
	public LineaInvestigacion getLinea() {
		return linea;
	}

	/**
	 * @param linea
	 *            the linea to set
	 */
	public void setLinea(LineaInvestigacion linea) {
		this.linea = linea;
	}

	/**
	 * @return the selected
	 */
	public LineaInvestigacion getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(LineaInvestigacion selected) {
		this.selected = selected;
	}

	/**
	 * @return the listaAreaInvestigacion
	 */
	public List<AreaInvestigacion> getListaAreaInvestigacion() {
		return listaAreaInvestigacion;
	}

	/**
	 * @param listaAreaInvestigacion
	 *            the listaAreaInvestigacion to set
	 */
	public void setListaAreaInvestigacion(
			List<AreaInvestigacion> listaAreaInvestigacion) {
		this.listaAreaInvestigacion = listaAreaInvestigacion;
	}

}
