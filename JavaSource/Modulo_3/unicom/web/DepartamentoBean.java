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

import Modulo_3.unicom.dm.Entitys.Departamento;
import Modulo_3.unicom.dm.Entitys.Pais;
import Modulo_3.unicom.dm.Entitys.Region;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class DepartamentoBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private Departamento depart = new Departamento();
	/*
	 * Varios
	 */
	private List<Departamento> listaDepartamento;
	private List<Pais> listaPais;
	private List<Region> listaRegion;
	private Departamento selected;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<Departamento> mostrarTodos() {

		try {
			listaDepartamento = (List<Departamento>) crudBO
					.buscarTodos((Class<T>) Departamento.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaDepartamento;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {
			listaPais = (List<Pais>) crudBO.buscarTodos((Class<T>) Pais.class);
			
			listaRegion = (List<Region>) crudBO
					.buscarTodos((Class<T>) Region.class);


		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public List<Pais> listaPaises() {

		return listaPais;

	}

	public List<Region> listaRegiones() {

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
		try {

			crudBO.crear((T) depart, true);

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
	 * @return the dep
	 */
	public Departamento getDepart() {
		return depart;
	}

	/**
	 * @param dep
	 *            the dep to set
	 */
	public void setDepart(Departamento depart) {
		this.depart = depart;
	}

	/**
	 * @return the listaDepartamento
	 */
	public List<Departamento> getListaDepartamento() {
		return listaDepartamento;
	}

	/**
	 * @param listaDepartamento
	 *            the listaDepartamento to set
	 */
	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}

	/**
	 * @return the selected
	 */
	public Departamento getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(Departamento selected) {
		this.selected = selected;
	}

	/**
	 * @return the listaPais
	 */
	public List<Pais> getListaPais() {
		return listaPais;
	}

	/**
	 * @param listaPais the listaPais to set
	 */
	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}

	/**
	 * @return the listaRegion
	 */
	public List<Region> getListaRegion() {
		return listaRegion;
	}

	/**
	 * @param listaRegion the listaRegion to set
	 */
	public void setListaRegion(List<Region> listaRegion) {
		this.listaRegion = listaRegion;
	}

	
	
	
}
