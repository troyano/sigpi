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

import Modulo_3.unicom.dm.Entitys.TipoVariableEvaluacion;
import Modulo_3.unicom.dm.Entitys.Variable;

import comun.unicom.bo.CrudBO;
/*
 * BO´s
 */
/*
 * Entitys
 */

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class VariablesBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
//
//	private final static Logger LOGGER = Logger.getLogger(VariablesBean.class
//			.getName());
	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;;
	/*
	 * Entitys
	 */

	private Variable variables = new Variable();
	private Variable var = new Variable();

	/*
	 * Varios
	 */
	private List<Variable> listaVariable;
	private List<Variable> listaVariablelist;
	private List<TipoVariableEvaluacion> listaTipoVariableEvaluacion;
	private Variable selected;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {

			listaTipoVariableEvaluacion = (List<TipoVariableEvaluacion>) crudBO
					.buscarTodos((Class<T>) TipoVariableEvaluacion.class);
			
			listaVariablelist = (List<Variable>) crudBO
					.buscarTodos((Class<T>) Variable.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public List<TipoVariableEvaluacion> mostrarTodosTiposV() {

		return listaTipoVariableEvaluacion;

	}
	
	public List<Variable> mostrarTodosvariables() {

		return listaVariablelist;

	}

	
	
	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<Variable> mostrarTodos() {

		try {

			listaVariable = (List<Variable>) crudBO
					.buscarTodos((Class<T>) Variable.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaVariable;
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

		crudBO.crear((T) variables);
	}

	@SuppressWarnings("unchecked")
	public void eliminareditar() {

		try {
			
			System.out.println("++++eli"+selected.getDescripcionVariable());
			crudBO.remover((T) selected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Sets y Gets
	 */

	public Variable getVariables() {
		return variables;
	}

	public void setVariables(Variable variables) {
		this.variables = variables;
	}


	public Variable getVar() {
		return var;
	}

	public void setVar(Variable var) {
		this.var = var;
	}

	public List<Variable> getListaVariable() {
		return listaVariable;
	}

	public void setListaVariable(List<Variable> listaVariable) {
		this.listaVariable = listaVariable;
	}

	public List<TipoVariableEvaluacion> getListaTipoVariableEvaluacion() {
		return listaTipoVariableEvaluacion;
	}

	public void setListaTipoVariableEvaluacion(
			List<TipoVariableEvaluacion> listaTipoVariableEvaluacion) {
		this.listaTipoVariableEvaluacion = listaTipoVariableEvaluacion;
	}


	public Variable getSelected() {
		return selected;
	}

	public void setSelected(Variable selected) {
		this.selected = selected;
	}



}
