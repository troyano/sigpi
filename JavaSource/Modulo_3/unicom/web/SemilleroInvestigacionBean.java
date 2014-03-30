/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;

import java.util.List;
/*
 * BO´s
 */
import comun.unicom.bo.CrudBO;

/*
 * Entitys
 */
import Modulo_3.unicom.dm.Entitys.SemilleroInvestigacion;
import Modulo_3.unicom.dm.Entitys.GrupoInvestigacion;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.jboss.logging.Logger;

/**
 * @author EDUAR
 * 
 * 
 */
@ManagedBean
@SessionScoped
public class SemilleroInvestigacionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	static Logger log = Logger.getLogger(SemilleroInvestigacionBean.class.getSimpleName()); 
	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;


	/*
	 * Entitys
	 */

	private SemilleroInvestigacion semillero = new SemilleroInvestigacion();
	private SemilleroInvestigacion sem = new SemilleroInvestigacion();

	/*
	 * Varios
	 */
	private List<SemilleroInvestigacion> listaSemilleroInvestigacion;
	private List<GrupoInvestigacion> listaGrupoInvestigacion;
	private SemilleroInvestigacion selected;
	
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void listas(){
		
		try {
			listaGrupoInvestigacion = (List<GrupoInvestigacion>) crudBO
					.buscarTodos((Class<T>) GrupoInvestigacion.class);

			
//			 int i=0; for(GrupoInvestigacion  patronTmp:listaGrupoInvestigacion){
//			  System.out.println("=========campo: "
//			  +(i++)+"--- grupo: "+patronTmp.getNombreGrupo());
//			  }
			 

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<SemilleroInvestigacion> mostrarTodos() {

		try {
			
//		    log.info("Log util");

			listaSemilleroInvestigacion = (List<SemilleroInvestigacion>) crudBO
					.buscarTodos((Class<T>) SemilleroInvestigacion.class);	

		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return listaSemilleroInvestigacion;
	}

	public List<GrupoInvestigacion> mostrarTodosGrupos() {

			return listaGrupoInvestigacion;
		
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
			System.out.println("Crear 1 **");
			 crudBO.crear((T) semillero);
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

	/*
	 * Sets y Gets
	 */

	/**
	 * @return the semillero
	 */
	public SemilleroInvestigacion getSemillero() {
		return semillero;
	}

	/**
	 * @return the listaSemilleroInvestigacion
	 */
	public List<SemilleroInvestigacion> getListaSemilleroInvestigacion() {
		return listaSemilleroInvestigacion;
	}

	/**
	 * @param listaSemilleroInvestigacion
	 *            the listaSemilleroInvestigacion to set
	 */
	public void setListaSemilleroInvestigacion(
			List<SemilleroInvestigacion> listaSemilleroInvestigacion) {
		this.listaSemilleroInvestigacion = listaSemilleroInvestigacion;
	}

	/**
	 * @param semillero
	 *            the semillero to set
	 */
	public void setSemillero(SemilleroInvestigacion semillero) {
		this.semillero = semillero;
	}

	/**
	 * @return the selected
	 */
	public SemilleroInvestigacion getSelected() {
		
		log.debug("get Selected");
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(SemilleroInvestigacion selected) {
		log.debug(" set Selected");
		this.selected = selected;
	}

	/**
	 * @return the listaGrupoInvestigacion
	 */
	public List<GrupoInvestigacion> getListaGrupoInvestigacion() {
		return listaGrupoInvestigacion;
	}

	/**
	 * @param listaGrupoInvestigacion
	 *            the listaGrupoInvestigacion to set
	 */
	public void setListaGrupoInvestigacion(
			List<GrupoInvestigacion> listaGrupoInvestigacion) {
		this.listaGrupoInvestigacion = listaGrupoInvestigacion;
	}

	/**
	 * @return the sem
	 */
	public SemilleroInvestigacion getSem() {
		return sem;
	}

	/**
	 * @param sem
	 *            the sem to set
	 */
	public void setSem(SemilleroInvestigacion sem) {
		this.sem = sem;
	}

}
