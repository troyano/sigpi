/**
 * 
 */
package Modulo_3.unicom.web.catalogos;

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
import org.primefaces.context.RequestContext;

import Modulo_3.unicom.DAO.PersonalDAO;
import Modulo_3.unicom.DAO.PersonalProyectoDAO;
import Modulo_3.unicom.DAO.ProyectoDAO;
import Modulo_3.unicom.dm.Entitys.Personal;
import Modulo_3.unicom.dm.Entitys.PersonalProyecto;
import Modulo_3.unicom.dm.Entitys.Proyecto;

import comun.unicom.bo.CrudBO;

/**
 * @author Eduar
 * 
 */
@ManagedBean
@SessionScoped
public class CatalogoBuscarProyectoBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(CatalogoBuscarProyectoBean.class.getSimpleName());

	/*
	 * EJB
	 */

	@EJB
	private CrudBO<T> crudBO;

	@EJB
	private PersonalProyectoDAO personalProyectoDAO;
	
	@EJB
	private PersonalDAO personalDAO;
	
	@EJB
	private ProyectoDAO proyectoDAO;

	/*
	 * Entitys
	 */

	private PersonalProyecto personalProyectoBuscar;
	private Proyecto proyectoBuscar;
	private Personal personalBuscar;

	private PersonalProyecto proyectoSelecionado = new PersonalProyecto();

	/*
	 * Varios
	 */
	private List<PersonalProyecto> listaPersonalProyecto;
	private PersonalProyecto selected;
	private Proyecto selectedProyecto;
	private Personal selectedPersonal;

	private int tipoAccion;

	@PostConstruct
	public void init() {

		 log.info("init  catalogo");
		proyectoSelecionado = new PersonalProyecto();
		selected = new PersonalProyecto();
		selectedProyecto = new Proyecto();
		selectedPersonal = new Personal();

		personalProyectoBuscar = new PersonalProyecto();
		proyectoBuscar = new Proyecto();
		personalBuscar = new Personal();
		reset();
	}

	public List<PersonalProyecto> dataTable() {
			log.info("dataTable() 1.0");
		try {
			log.info("dataTable() 1.1");
			selected = null;
			listaPersonalProyecto = null;

			listaPersonalProyecto = (List<PersonalProyecto>) personalProyectoDAO
						.buscarPorCatalogo(personalProyectoBuscar, personalBuscar, proyectoBuscar);
			log.info("dataTable() 1.2");	
		} catch (NullPointerException e) {
			
			log.info("dataTable() 1.3");	
			 e.printStackTrace();
		}

		return listaPersonalProyecto;
	}

	public void reset() {
		log.info("entré a reset 1");

		personalProyectoBuscar.setSedePrograma(null);
		proyectoBuscar.setNombreProyecto(null);
		personalBuscar.setIdentificacion(null);
		personalBuscar.setPrimerNombre(null);
		personalBuscar.setPrimerApellido(null);

		listaPersonalProyecto = null;
	}

	public boolean agregar() {

		try {
			if (selected != null) {

				log.info("+++++    != null  "
						+ selected.getProyecto().getNombreProyecto().toString());

				setProyectoSelecionado(selected);

				cargarAdicionales();

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Seleciono el Proyecto", selected
										.getProyecto().getNombreProyecto().toString() + "!"));
				RequestContext.getCurrentInstance().execute(
						"searchDialog.hide()");
				// reset();
				return true;
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN,
										"No seleccionó ninguna Proyecto",
										"Para editar o ver, debe seleccionar una opción del buscador.!"));
				log.info("+++++    == null 2");
				return false;
			}

		} catch (NullPointerException nl) {
			// log.info("null pointer agregar 1");
			return false;
		} catch (Exception e) {
			log.info("null pointer agregar 2");
			return false;
		}
	}

	public void limpiarCatalogo() {

		try {
			log.info("+++++ limpiarCatalogo 1.0 -- ");

			init();
			listaPersonalProyecto.clear();
			this.setPersonalBuscar(null);
			this.setPersonalProyectoBuscar(null);
			this.setProyectoBuscar(null);
			this.setProyectoSelecionado(null);
			

		} catch (PropertyNotFoundException pnfe) {
			log.info(" PropertyNotFoundException  1.0++");

		} catch (Exception e) {
			log.info(" Exception  2.0++");
			// e.printStackTrace();
		}

	}

	public void cargarAdicionales() {

		try {
			log.info("cargarAdicionales +++++"
					+ selected.getProyecto().getNombreProyecto()+" -- "+selected.getPersonal().getIdentificacion());

			selectedProyecto = proyectoDAO
					.buscarPorId(selected.getProyecto().getIdProyecto());

			selectedPersonal = personalDAO
					.buscarPorId(selected.getPersonal().getIdPersonal());

			if (selectedPersonal == null || selectedProyecto == null
					|| selected == null) {

				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_FATAL,
										"Error",
										"Ocurrió un error al cargar el intentar Cargar la información. Comuniquese con el Administrador del Sistema."));
			}

		} catch (NullPointerException nl) {
			log.info("cargarAdicionales 1");
			nl.printStackTrace();

		} catch (Exception e) {
			log.info("cargarAdicionales 2");
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public boolean editar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			crudBO.editar((T) selected);
			crudBO.editar((T) selectedPersonal);
			crudBO.editar((T) selectedProyecto);

			context.addMessage(null, new FacesMessage("Edición Exitosa",
					"Ediató : Entidad, Representante y contacto."));

			inicializar();
			return true;

		} catch (NullPointerException e) {
			log.info("Editar ** NullPointerException Bean" + e);
			// e.printStackTrace();
			return false;
		} catch (PropertyNotFoundException pnf) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia",
							"NO ha seleccionado ninguna Entidad para editar."));

			return false;
		}

	}

	public void inicializar() {

		log.info("+++ Accion Inicialzar Catalogo To home");
		tipoAccion = 0;
		init();
	}


	/* --------- set ----- get ------------- */

	public int getTipoAccion() {
		return tipoAccion;
	}

	public PersonalProyecto getPersonalProyectoBuscar() {
		return personalProyectoBuscar;
	}

	public void setPersonalProyectoBuscar(
			PersonalProyecto personalProyectoBuscar) {
		this.personalProyectoBuscar = personalProyectoBuscar;
	}

	public Proyecto getProyectoBuscar() {
		return proyectoBuscar;
	}

	public void setProyectoBuscar(Proyecto proyectoBuscar) {
		this.proyectoBuscar = proyectoBuscar;
	}

	public Personal getPersonalBuscar() {
		return personalBuscar;
	}

	public void setPersonalBuscar(Personal personalBuscar) {
		this.personalBuscar = personalBuscar;
	}

	public PersonalProyecto getProyectoSelecionado() {
		return proyectoSelecionado;
	}

	public void setProyectoSelecionado(PersonalProyecto proyectoSelecionado) {
		this.proyectoSelecionado = proyectoSelecionado;
	}

	public List<PersonalProyecto> getListaPersonalProyecto() {
		return listaPersonalProyecto;
	}

	public void setListaPersonalProyecto(
			List<PersonalProyecto> listaPersonalProyecto) {
		this.listaPersonalProyecto = listaPersonalProyecto;
	}

	public PersonalProyecto getSelected() {
		return selected;
	}

	public void setSelected(PersonalProyecto selected) {
		this.selected = selected;
	}

	public Proyecto getSelectedProyecto() {
		return selectedProyecto;
	}

	public void setSelectedProyecto(Proyecto selectedProyecto) {
		this.selectedProyecto = selectedProyecto;
	}

	public Personal getSelectedPersonal() {
		return selectedPersonal;
	}

	public void setSelectedPersonal(Personal selectedPersonal) {
		this.selectedPersonal = selectedPersonal;
	}

	public void setTipoAccion(int tipoAccion) {
		this.tipoAccion = tipoAccion;
	}
}
