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

import Modulo_3.unicom.dm.Entitys.EntIndicador;
import Modulo_3.unicom.dm.Entitys.EntVariable;

import comun.unicom.bo.CrudBO;

/**
 * @author Eduar
 * @param <T>
 *
 */
@ManagedBean
@SessionScoped
public class EntIndicadoresVariablesBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntIndicador indicador = new EntIndicador();
	/*
	 * Varios
	 */
	private List<EntIndicador> listaEntIndicador;
	private EntIndicador selected;
	private List<EntVariable> listaEntVariable;
	
	
	@SuppressWarnings("unchecked")
	public List<EntIndicador> mostrarTodos() {

		try {
			listaEntIndicador = (List<EntIndicador>) crudBO
					.buscarTodos((Class<T>) EntIndicador.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntIndicador;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {
			listaEntVariable = (List<EntVariable>) crudBO
					.buscarTodos((Class<T>) EntVariable.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	public List<EntVariable> listaEntVariables() {
		return listaEntVariable;
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

			crudBO.crear((T) indicador, true);

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


	   /* -------------------   get   -------      set -------------------*/
		
	public EntIndicador getIndicador() {
		return indicador;
	}

	public void setIndicador(EntIndicador indicador) {
		this.indicador = indicador;
	}

	public List<EntIndicador> getListaEntIndicador() {
		return listaEntIndicador;
	}

	public void setListaEntIndicador(List<EntIndicador> listaEntIndicador) {
		this.listaEntIndicador = listaEntIndicador;
	}

	public EntIndicador getSelected() {
		return selected;
	}

	public void setSelected(EntIndicador selected) {
		this.selected = selected;
	}

	public List<EntVariable> getListaEntVariable() {
		return listaEntVariable;
	}

	public void setListaEntVariable(List<EntVariable> listaEntVariable) {
		this.listaEntVariable = listaEntVariable;
	}


}
