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

import Modulo_3.unicom.dm.Entitys.EntVariable;

import comun.unicom.bo.CrudBO;

/**
 * @author Eduar
 *
 */
@ManagedBean
@SessionScoped
public class EntVariables_finacierasBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	
	/*
	 * Entitys
	 */

	private EntVariable variable = new EntVariable();
	/*
	 * Varios
	 */
	
	private EntVariable selected;
	private List<EntVariable> listaEntVariable;
		
	
	@SuppressWarnings("unchecked")
	public List<EntVariable> mostrarTodos() {

		try {
			listaEntVariable = (List<EntVariable>) crudBO
					.buscarTodos((Class<T>) EntVariable.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

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

			crudBO.crear((T) variable, true);

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


	/*  -----------------get ----  set  ---------------------*/
	

	public EntVariable getVariable() {
		return variable;
	}

	public void setVariable(EntVariable variable) {
		this.variable = variable;
	}

	public EntVariable getSelected() {
		return selected;
	}

	public void setSelected(EntVariable selected) {
		this.selected = selected;
	}

	public List<EntVariable> getListaEntVariable() {
		return listaEntVariable;
	}

	public void setListaEntVariable(List<EntVariable> listaEntVariable) {
		this.listaEntVariable = listaEntVariable;
	}

}
