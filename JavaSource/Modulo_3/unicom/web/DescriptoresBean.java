/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Modulo_3.unicom.dm.Entitys.Descriptores;
import Modulo_3.unicom.dm.Entitys.Variable;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class DescriptoresBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;;
	/*
	 * Entitys
	 */

	private Descriptores descriptores = new Descriptores();
	private Descriptores descr = new Descriptores();

	/*
	 * Varios
	 */
	private List<Descriptores> listaDescriptores;
	private List<Variable> listaVariables;
	private Descriptores selected;
	private Variable idVar;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {

			listaVariables = (List<Variable>) crudBO
					.buscarTodos((Class<T>) Variable.class);

		} catch (NullPointerException e) {
			
		}

	
	}

	public List<Variable> mostrarVariables() {

		return listaVariables;

	}
	
	
	
	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<Descriptores> mostrarTodos() {

		try {

			listaDescriptores = (List<Descriptores>) crudBO
					.buscarTodos((Class<T>) Descriptores.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaDescriptores;
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

		crudBO.crear((T) descriptores);
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

	public Descriptores getDescriptores() {
		return descriptores;
	}

	public void setVariables(Descriptores descriptores) {
		this.descriptores = descriptores;
	}

	public Descriptores getDescr() {
		return descr;
	}

	public void setVar(Descriptores descr) {
		this.descr = descr;
	}

	public List<Descriptores> getListaDescriptore() {
		return listaDescriptores;
	}

	public void setListaDescriptore(List<Descriptores> listaDescriptores) {
		this.listaDescriptores = listaDescriptores;
	}


	public Descriptores getSelected() {
		return selected;
	}

	public void setSelected(Descriptores selected) {
		this.selected = selected;
	}

	public Variable getIdVar() {
		return idVar;
	}


	public void setIdVar(Variable idVar) {
		this.idVar = idVar;
	}

	public List<Variable> getListaVariables() {
		return listaVariables;
	}

	public void setListaVariables(List<Variable> listaVariables) {
		this.listaVariables = listaVariables;
	}	
	
	
}
