/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Modulo_3.unicom.dm.Entitys.Region;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class RegionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private Region region = new Region();
	/*
	 * Varios
	 */
	private List<Region> listaRegion;
	private Region selected;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<Region> mostrarTodos() {

		try {
			listaRegion = (List<Region>) crudBO
					.buscarTodos((Class<T>) Region.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaRegion;
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
			crudBO.crear((T) region );

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
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return the listaRegion
	 */
	public List<Region> getListaRegion() {
		return listaRegion;
	}

	/**
	 * @param listaRegion
	 *            the listaRegion to set
	 */
	public void setListaRegion(List<Region> listaRegion) {
		this.listaRegion = listaRegion;
	}

	/**
	 * @return the selected
	 */
	public Region getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(Region selected) {
		this.selected = selected;
	}

}
