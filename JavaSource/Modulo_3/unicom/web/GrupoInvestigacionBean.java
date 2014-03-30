/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Modulo_3.unicom.dm.Entitys.GrupoInvestigacion;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * 
 */

@ManagedBean
@SessionScoped
public class GrupoInvestigacionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;
	/*
	 * Entitys
	 */

	private GrupoInvestigacion grupo = new GrupoInvestigacion();

	/*
	 * Varios
	 */
	private List<GrupoInvestigacion> listaGrupoInvestigacion;
	private List<GrupoInvestigacion> filtro;

	private GrupoInvestigacion selected;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<GrupoInvestigacion> mostrarTodos() {

		try {
			listaGrupoInvestigacion = (List<GrupoInvestigacion>) crudBO
					.buscarTodos((Class<T>) GrupoInvestigacion.class, true);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaGrupoInvestigacion;
	}

	/** ------- Metodo para editar-------- */

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
			System.out.println("Crear 1 **");
			 crudBO.crear((T) grupo);
			System.out.println("Crear 2 **");
		
			
		} catch (Exception e) {
			e.printStackTrace();
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

	/***************************************************************************************************************/
	/*
	 * private boolean value1;
	 * 
	 * private boolean value2;
	 * 
	 * public boolean isValue1() { return value1; }
	 * 
	 * public void setValue1(boolean value1) { this.value1 = value1; }
	 * 
	 * public boolean isValue2() { return value2; }
	 * 
	 * public void setValue2(boolean value2) { this.value2 = value2; } public
	 * void addMessage() { String summary = value2 ? "Activo" : "Inactivo";
	 * 
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(summary)); }
	 * 
	 * 
	 * /** -------- get ----set---------
	 */

	public List<GrupoInvestigacion> getListaGrupoInvestigacion() {
		return listaGrupoInvestigacion;
	}

	public void setListaGrupoInvestigacion(
			List<GrupoInvestigacion> listaGrupoInvestigacion) {
		this.listaGrupoInvestigacion = listaGrupoInvestigacion;
	}

	public GrupoInvestigacion getSelected() {
		return selected;
	}

	public void setSelected(GrupoInvestigacion selected) {
		this.selected = selected;
	}

	public GrupoInvestigacion getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoInvestigacion grupo) {
		this.grupo = grupo;
	}

	public List<GrupoInvestigacion> getFiltro() {
		return filtro;
	}

	public void setFiltro(List<GrupoInvestigacion> filtro) {
		this.filtro = filtro;
	}

}