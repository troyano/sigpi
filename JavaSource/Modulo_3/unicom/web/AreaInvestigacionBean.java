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

import org.primefaces.component.behavior.ajax.AjaxBehaviorHandler;
import org.primefaces.event.data.FilterEvent;

import Modulo_3.unicom.dm.Entitys.AreaInvestigacion;




import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class AreaInvestigacionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private AreaInvestigacion area = new AreaInvestigacion();
	/*
	 * Varios
	 */
	private List<AreaInvestigacion> listaAreaInvestigacion;
	private AreaInvestigacion selected;
	private List<AreaInvestigacion> filtered;
	
	
	
	@SuppressWarnings("unchecked")
	public List<AreaInvestigacion> mostrarTodos() {

		try {
			listaAreaInvestigacion = (List<AreaInvestigacion>) crudBO
					.buscarTodos((Class<T>) AreaInvestigacion.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaAreaInvestigacion;
	}
	
	public void onFiltr(AjaxBehaviorHandler event){
		
	}
	public void filtro(FilterEvent filtro){
		
		filtro.getData();
		filtro.getFilters();
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

			crudBO.crear((T) area, true);

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
	
	
	
	
	
	/*  set ---  get   */

	/**
	 * @return the area
	 */
	public AreaInvestigacion getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(AreaInvestigacion area) {
		this.area = area;
	}
	/**
	 * @return the listaAreaInvestigacion
	 */
	public List<AreaInvestigacion> getListaAreaInvestigacion() {
		return listaAreaInvestigacion;
	}
	/**
	 * @param listaAreaInvestigacion the listaAreaInvestigacion to set
	 */
	public void setListaAreaInvestigacion(
			List<AreaInvestigacion> listaAreaInvestigacion) {
		this.listaAreaInvestigacion = listaAreaInvestigacion;
	}
	/**
	 * @return the selected
	 */
	public AreaInvestigacion getSelected() {
		return selected;
	}
	/**
	 * @param selected the selected to set
	 */
	public void setSelected(AreaInvestigacion selected) {
		this.selected = selected;
	}


	/**
	 * @return the filtered
	 */
	public List<AreaInvestigacion> getFiltered() {
		return filtered;
	}


	/**
	 * @param filtered the filtered to set
	 */
	public void setFiltered(List<AreaInvestigacion> filtered) {
		this.filtered = filtered;
	}
	
	
	
}
