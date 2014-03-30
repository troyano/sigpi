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
import Modulo_3.unicom.dm.Entitys.TipoProyecto;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * 
 */
@ManagedBean
@SessionScoped
public class TipoProyectoBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private TipoProyecto tproyecto = new TipoProyecto();
	/*
	 * Varios
	 */
	private List<TipoProyecto> listaTipoProyecto;
	private TipoProyecto selected;

	@SuppressWarnings("unchecked")
	public List<TipoProyecto> mostrarTodos() {

		try {
			listaTipoProyecto = (List<TipoProyecto>) crudBO
					.buscarTodos((Class<T>) TipoProyecto.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaTipoProyecto;
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

			crudBO.crear((T) tproyecto);

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

	
	
	/*   -------  get   -----   set   -----------*/
	
	
	/**
	 * @return the tproyecto
	 */
	public TipoProyecto getTproyecto() {
		return tproyecto;
	}

	/**
	 * @param tproyecto the tproyecto to set
	 */
	public void setTproyecto(TipoProyecto tproyecto) {
		this.tproyecto = tproyecto;
	}

	/**
	 * @return the listaTipoProyecto
	 */
	public List<TipoProyecto> getListaTipoProyecto() {
		return listaTipoProyecto;
	}

	/**
	 * @param listaTipoProyecto the listaTipoProyecto to set
	 */
	public void setListaTipoProyecto(List<TipoProyecto> listaTipoProyecto) {
		this.listaTipoProyecto = listaTipoProyecto;
	}

	/**
	 * @return the selected
	 */
	public TipoProyecto getSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(TipoProyecto selected) {
		this.selected = selected;
	}
	

}
