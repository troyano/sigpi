/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Modulo_3.unicom.dm.Entitys.Pais;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class PaisBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private Pais pais = new Pais();
	/*
	 * Varios
	 */
	private List<Pais> listaPais;
	private Pais selected;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<Pais> mostrarTodos() {

		try {
			listaPais = (List<Pais>) crudBO.buscarTodos((Class<T>) Pais.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaPais;
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
			
		crudBO.crear((T) pais );


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
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the listaPais
	 */
	public List<Pais> getListaPais() {
		return listaPais;
	}

	/**
	 * @param listaPais
	 *            the listaPais to set
	 */
	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}

	/**
	 * @return the selected
	 */
	public Pais getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(Pais selected) {
		this.selected = selected;
	}

}
