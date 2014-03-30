/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.EntEntidadDAO;
import Modulo_3.unicom.dm.Entitys.EntTipoIdentificacion;
import Modulo_3.unicom.dm.Entitys.Personal;
import Modulo_3.unicom.dm.Entitys.PersonalProyecto;
import Modulo_3.unicom.dm.Entitys.Proyecto;
import Modulo_3.unicom.dm.Entitys.SedePrograma;
import Modulo_3.unicom.dm.Entitys.TipoPersonal;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class proyectosBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(Proyecto.class.getSimpleName());

	/*
	 * EJB
	 */

	@EJB
	private CrudBO<T> crudBO;

	@EJB
	private EntEntidadDAO entEntidadDAO;

	/*
	 * Entitys
	 */
	private Proyecto proyecto = new Proyecto();
	private PersonalProyecto personalProyecto = new PersonalProyecto();
	private Personal personal = new Personal();


	/*
	 * Varios
	 */
	private List<EntTipoIdentificacion> listaEntTipoIdentificacion;
	private List<SedePrograma> listaSedePrograma;
	private List<TipoPersonal> listaTipoPersonal;

	private int tipoAccion;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {

		try {

			inicializar();

			listaEntTipoIdentificacion = (List<EntTipoIdentificacion>) crudBO
					.buscarTodos((Class<T>) EntTipoIdentificacion.class);

			listaSedePrograma = (List<SedePrograma>) crudBO
					.buscarTodos((Class<T>) SedePrograma.class);
			
			listaTipoPersonal = (List<TipoPersonal>) crudBO
					.buscarTodos((Class<T>) TipoPersonal.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodos para cargar las diferentes listas de selección (Combos) de la
	 * interfaz de generalidades Entidad.
	 * 
	 * @author EDUAR
	 * @return listas de entidades
	 * 
	 */
	public List<EntTipoIdentificacion> listaEntTipoIdentificacion() {
		return listaEntTipoIdentificacion;
	}

	public List<SedePrograma> listaSedesProgramas() {
		return listaSedePrograma;
	}

	public List<TipoPersonal> listaTipoPer() {
		return listaTipoPersonal;
	}
	/**
	 * FIN listas
	 */

	/**
	 * Metodo para filtrar tipo entidad dependiendo del Sector seleccionado
	 * 
	 * @author EDUAR
	 * @return
	 * 
	 */

	public void reset() {
		 this.setProyecto(null);
		 this.setPersonal(null);
		 this.setPersonalProyecto(null);
	}

	public void inicializar() {

		log.info("+++ Accion Inicialzar");
		tipoAccion = 0;

	}

	public String accionCrear() {

		log.info("+++ Accion Crear");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Va a registrar una entidad"));

		tipoAccion = 1;
		return "crear";
	}

	public void accionEditar() {

		log.info("+++ Accion Editar");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Va a Editar una entidad"));

		tipoAccion = 2;
	}

	/**
	 * Metodo para registrar la Entidad (generalidades), segun parametros y
	 * condiciones del formulario V2 de colciencias INGRESO DE LA ENTIDAD en
	 * orden de ingreso de info - contacto - entidad - representante legal
	 * 
	 * @author EDUAR
	 * @return true si cumple con todo el registro de las variables de entidad
	 *         generalidades
	 * 
	 */
	@SuppressWarnings("unchecked")
	public boolean crearProyecto() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			if (proyecto != null) {
				Date fechaCreacion = new Date();
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				proyecto.setFechaCreacion(fechaCreacion);
				// Estado formulación  = 0
				proyecto.setEstadoProyecto(0);
				crudBO.crear((T) proyecto, true);
			} else {
				// Rolback
				context.addMessage(null, new FacesMessage("Error",
						"Ocurrió un error en el registro del Proyecto"));

				return false;
			}

			if (personal != null && proyecto != null) {
				personal.setClave(personal.getIdentificacion());
				crudBO.crear((T) personal, true);
			} else {
				// Rolback
				context.addMessage(null, new FacesMessage("Error",
						"Ocurrió un error en el registro del Personal."));

				return false;
			}

			if (personal != null && proyecto != null) {
				personalProyecto.setPersonal(personal);
				personalProyecto.setProyecto(proyecto);
				crudBO.crear((T) personalProyecto, true);
			} else {
				// Rolback
				context.addMessage(null, new FacesMessage("Error",
						"Ocurrió un error en el registro del Personal."));

				return false;
			}

			context.addMessage(null, new FacesMessage("Registro Exitoso",
					"Agregó un nuevo proyecto y su Líder."));
			// FacesContext.getCurrentInstance().addMessage(null, new
			// FacesMessage(FacesMessage.SEVERITY_FATAL,"Sample fatal message",
			// "Fatal Error in System"));

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	/* --------- set ----- get -------------BUSCADOR */

	public List<EntTipoIdentificacion> getListaEntTipoIdentificacion() {
		return listaEntTipoIdentificacion;
	}

	public void setListaEntTipoIdentificacion(
			List<EntTipoIdentificacion> listaEntTipoIdentificacion) {
		this.listaEntTipoIdentificacion = listaEntTipoIdentificacion;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public PersonalProyecto getPersonalProyecto() {
		return personalProyecto;
	}

	public void setPersonalProyecto(PersonalProyecto personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public List<SedePrograma> getListaSedePrograma() {
		return listaSedePrograma;
	}

	public void setListaSedePrograma(List<SedePrograma> listaSedePrograma) {
		this.listaSedePrograma = listaSedePrograma;
	}

	public int getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(int tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public List<TipoPersonal> getListaTipoPersonal() {
		return listaTipoPersonal;
	}

	public void setListaTipoPersonal(List<TipoPersonal> listaTipoPersonal) {
		this.listaTipoPersonal = listaTipoPersonal;
	}

}
