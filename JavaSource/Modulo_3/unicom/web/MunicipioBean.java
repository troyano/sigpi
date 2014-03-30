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
import Modulo_3.unicom.dm.Entitys.Municipio;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class MunicipioBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private Municipio munici = new Municipio();
	/*
	 * Varios
	 */
	private List<Municipio> listaMunicipio;
	private Municipio selected;
	private List<Departamento> listaDepartamento;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<Municipio> mostrarTodos() {

		try {
			listaMunicipio = (List<Municipio>) crudBO
					.buscarTodos((Class<T>) Municipio.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaMunicipio;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {
			
			listaDepartamento = (List<Departamento>) crudBO.buscarTodos((Class<T>) Departamento.class);


		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public List<Departamento> listaDepartamentos() {

		return listaDepartamento;

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

			crudBO.crear((T) munici, true);

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
	 * @return the munici
	 */
	public Municipio getMunici() {
		return munici;
	}

	/**
	 * @param munici the munici to set
	 */
	public void setMunici(Municipio munici) {
		this.munici = munici;
	}

	/**
	 * @return the listaMunicipio
	 */
	public List<Municipio> getListaMunicipio() {
		return listaMunicipio;
	}

	/**
	 * @param listaMunicipio the listaMunicipio to set
	 */
	public void setListaMunicipio(List<Municipio> listaMunicipio) {
		this.listaMunicipio = listaMunicipio;
	}

	/**
	 * @return the selected
	 */
	public Municipio getSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(Municipio selected) {
		this.selected = selected;
	}

	/**
	 * @return the listaDepartamento
	 */
	public List<Departamento> getListaDepartamento() {
		return listaDepartamento;
	}

	/**
	 * @param listaDepartamento the listaDepartamento to set
	 */
	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}

	
}
