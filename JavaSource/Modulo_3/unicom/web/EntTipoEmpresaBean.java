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

import Modulo_3.unicom.dm.Entitys.EntTipoEmpresa;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class EntTipoEmpresaBean<T> implements Serializable{
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntTipoEmpresa empresa = new EntTipoEmpresa();
	/*
	 * Varios
	 */
	private List<EntTipoEmpresa> listaEntTipoEmpresa;
	private EntTipoEmpresa selected;
	
	
	
	@SuppressWarnings("unchecked")
	public List<EntTipoEmpresa> mostrarTodos() {

		try {
			listaEntTipoEmpresa = (List<EntTipoEmpresa>) crudBO
					.buscarTodos((Class<T>) EntTipoEmpresa.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntTipoEmpresa;
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

			crudBO.crear((T) empresa, true);

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

	
	/*------------------     get  --------   set   ------------------*/

	/**
	 * @return the empresa
	 */
	public EntTipoEmpresa getEmpresa() {
		return empresa;
	}


	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(EntTipoEmpresa empresa) {
		this.empresa = empresa;
	}


	/**
	 * @return the listaEntTipoEmpresa
	 */
	public List<EntTipoEmpresa> getListaEntTipoEmpresa() {
		return listaEntTipoEmpresa;
	}


	/**
	 * @param listaEntTipoEmpresa the listaEntTipoEmpresa to set
	 */
	public void setListaEntTipoEmpresa(List<EntTipoEmpresa> listaEntTipoEmpresa) {
		this.listaEntTipoEmpresa = listaEntTipoEmpresa;
	}


	/**
	 * @return the selected
	 */
	public EntTipoEmpresa getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(EntTipoEmpresa selected) {
		this.selected = selected;
	}
	
	
	
	

}
