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

import Modulo_3.unicom.dm.Entitys.Programa;
import Modulo_3.unicom.dm.Entitys.Sede;
import Modulo_3.unicom.dm.Entitys.SedePrograma;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class SedeProgramaBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */

	private SedePrograma sedePrograma = new SedePrograma();
	/*
	 * Varios
	 */
	private List<SedePrograma> listaSedePrograma;
	private List<Sede> listaSede;
	private List<Programa> listaPrograma;
	private SedePrograma selected;

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<SedePrograma> mostrarTodos() {

		try {
			listaSedePrograma = (List<SedePrograma>) crudBO
					.buscarTodos((Class<T>) SedePrograma.class);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaSedePrograma;
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas() {

		try {
			listaSede = (List<Sede>) crudBO.buscarTodos((Class<T>) Sede.class);
			
			listaPrograma = (List<Programa>) crudBO
					.buscarTodos((Class<T>) Programa.class);


		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public List<Sede> listaSedes() {

		return listaSede;

	}

	public List<Programa> listaProgramas() {

		return listaPrograma;

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

			crudBO.crear((T) sedePrograma, true);

		} catch (NullPointerException e) {
			// e.printStackTrace();
		} catch (PropertyNotFoundException e) {
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
	 * @return the sedePrograma
	 */
	public SedePrograma getSedePrograma() {
		return sedePrograma;
	}

	/**
	 * @param sedePrograma
	 *            the sedePrograma to set
	 */
	public void setSedePrograma(SedePrograma sedePrograma) {
		this.sedePrograma = sedePrograma;
	}

	/**
	 * @return the listaSedePrograma
	 */
	public List<SedePrograma> getListaSedePrograma() {
		return listaSedePrograma;
	}

	/**
	 * @param listaSedePrograma
	 *            the listaSedePrograma to set
	 */
	public void setListaSedePrograma(List<SedePrograma> listaSedePrograma) {
		this.listaSedePrograma = listaSedePrograma;
	}

	/**
	 * @return the selected
	 */
	public SedePrograma getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(SedePrograma selected) {
		this.selected = selected;
	}

	/**
	 * @return the listaSede
	 */
	public List<Sede> getListaSede() {
		return listaSede;
	}

	/**
	 * @param listaSede
	 *            the listaSede to set
	 */
	public void setListaSede(List<Sede> listaSede) {
		this.listaSede = listaSede;
	}

	/**
	 * @return the listaPrograma
	 */
	public List<Programa> getListaPrograma() {
		return listaPrograma;
	}

	/**
	 * @param listaPrograma
	 *            the listaPrograma to set
	 */
	public void setListaPrograma(List<Programa> listaPrograma) {
		this.listaPrograma = listaPrograma;
	}

}
