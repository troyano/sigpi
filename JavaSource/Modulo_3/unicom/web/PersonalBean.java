/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.PropertyNotFoundException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntTipoIdentificacion;
import Modulo_3.unicom.dm.Entitys.Pais;
import Modulo_3.unicom.dm.Entitys.Personal;
import Modulo_3.unicom.dm.Entitys.SedePrograma;
import Modulo_3.unicom.dm.Entitys.SegRol;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 * 
 */

@ManagedBean
@SessionScoped
public class PersonalBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(Personal.class.getSimpleName());

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	/*
	 * Entitys
	 */
	private EntEntidad entidad = new EntEntidad();
	private Pais pais = new Pais();
	private SedePrograma sedePrograma = new SedePrograma();
	private Personal personal = new Personal();
	private Personal selected;

	private SegRol segRol = new SegRol();

	/*
	 * Varios
	 */
	private List<EntTipoIdentificacion> listaEntTipoIdentificacion;
	private List<Pais> listaPais;
	private List<SedePrograma> listaSedePrograma;
	private List<Personal> listaPersonal;
	private List<SegRol> listaSegRol;

	// private boolean estadoCrear;

	/**
	 * Metodos para cargar las diferentes listas de selección (Combos) de la
	 * interfaz de Usuario
	 * 
	 * @author Alex
	 * @return
	 * 
	 */
	public List<EntTipoIdentificacion> listaEntTipoIdentificacion() {
		return listaEntTipoIdentificacion;
	}

	public List<Pais> listaPais() {
		return listaPais;
	}

	public List<SedePrograma> listaSedePrograma() {
		return listaSedePrograma;
	}

	public List<Personal> listaPersonal() {
		return listaPersonal;
	}

	public List<SegRol> listaSegRol() {
		return listaSegRol;
	}

	/**
	 * FIN listas
	 */

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {

		try {

			listaPais = (List<Pais>) crudBO.buscarTodos((Class<T>) Pais.class);

			listaSedePrograma = (List<SedePrograma>) crudBO
					.buscarTodos((Class<T>) SedePrograma.class);

			listaSegRol = (List<SegRol>) crudBO
					.buscarTodos((Class<T>) SegRol.class);
			listaEntTipoIdentificacion = (List<EntTipoIdentificacion>) crudBO
					.buscarTodos((Class<T>) EntTipoIdentificacion.class);

			// listaEntProductosservicio = (List<EntProductosservicio>) crudBO
			// .buscarTodos((Class<T>) EntProductosservicio.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para buscar la lista de todos los datos de una entidad
	 */
	@SuppressWarnings("unchecked")
	public List<Personal> mostrarTodos() {

		try {

			listaPersonal = (List<Personal>) crudBO.buscarTodos(
					(Class<T>) Personal.class, true);

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaPersonal;
	}

	@SuppressWarnings("unchecked")
	public void crear() {

		log.info("entre +++ personal");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			log.info("entre +++ personal");
			// personal.setPais(pais);
			// personal.setSedePrograma(sedePrograma);
			log.info("++++crear");
			personal.setEstadoPersonal(0);
			crudBO.crear((T) personal);
			limpiarCrear();
			context.addMessage(null, new FacesMessage("Registro Exitoso",
					"Agregó : Agrego un nuevo usuario a la plataforma."));

		} catch (NullPointerException e) {
			log.info("++++crear  1");
			// e.printStackTrace();
		} catch (PropertyNotFoundException e) {
			log.info("++++crear  2");
			// e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void editar() {

		try {
			crudBO.editar((T) selected);
		} catch (NullPointerException e) {
			System.out.println("Editar ** NullPointerException Bean" + e);
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void cambiarEstado() {
		
		log.info("+++++++ CAMBIAR ESTADO ");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			log.info("+++++++ CAMBIAR ESTADO = " + selected.getEstadoPersonal());
			if (selected.getEstadoPersonal() == 1) {
				selected.setEstadoPersonal(0);
			} else {
				selected.setEstadoPersonal(1);
			}

			crudBO.editar((T) selected);

			context.addMessage(null, new FacesMessage("Actualización Exitosa"));

		} catch (Exception e) {
			log.info("Editar ESTADO ** NullPointerException Bean" + e);
			e.printStackTrace();
		}
	}

	private void limpiarCrear() {

		log.info("++++limpiarCrear");
		personal.setSedePrograma(null);
		personal.setEntTipoIdentificacion(null);
		personal.setPais(null);

	}

	/***
	 * --------------------------------------------get ---set-------------------
	 */
	/**
	 * @return the entidad
	 */
	public EntEntidad getEntidad() {
		return entidad;
	}

	public void setEntidad(EntEntidad entidad) {
		this.entidad = entidad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public SedePrograma getSedePrograma() {
		return sedePrograma;
	}

	public void setSedePrograma(SedePrograma sedePrograma) {
		this.sedePrograma = sedePrograma;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Personal getSelected() {
		return selected;
	}

	public void setSelected(Personal selected) {
		this.selected = selected;
	}

	public SegRol getSegRol() {
		return segRol;
	}

	public void setSegRol(SegRol segRol) {
		this.segRol = segRol;
	}

	public List<EntTipoIdentificacion> getListaEntTipoIdentificacion() {
		return listaEntTipoIdentificacion;
	}

	public void setListaEntTipoIdentificacion(
			List<EntTipoIdentificacion> listaEntTipoIdentificacion) {
		this.listaEntTipoIdentificacion = listaEntTipoIdentificacion;
	}

	public List<Pais> getListaPais() {
		return listaPais;
	}

	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}

	public List<SedePrograma> getListaSedePrograma() {
		return listaSedePrograma;
	}

	public void setListaSedePrograma(List<SedePrograma> listaSedePrograma) {
		this.listaSedePrograma = listaSedePrograma;
	}

	public List<Personal> getListaPersonal() {
		return listaPersonal;
	}

	public void setListaPersonal(List<Personal> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}

	public List<SegRol> getListaSegRol() {
		return listaSegRol;
	}

	public void setListaSegRol(List<SegRol> listaSegRol) {
		this.listaSegRol = listaSegRol;
	}

}
