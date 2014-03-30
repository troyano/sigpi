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

import comun.unicom.bo.CrudBO;

import Modulo_3.unicom.DAO.EntContactoDAO;
import Modulo_3.unicom.DAO.EntEntidadDAO;
import Modulo_3.unicom.DAO.EntRepresentanteLegalDAO;
import Modulo_3.unicom.dm.Entitys.EntContacto;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntRepresentantelegal;

/**
 * @author Eduar
 * 
 */
@ManagedBean
@SessionScoped
public class CatalogoBuscarEntidadBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(CatalogoBuscarEntidadBean.class.getSimpleName());

	/*
	 * EJB
	 */

	@EJB
	private CrudBO<T> crudBO;

	@EJB
	private EntEntidadDAO entEntidadDAO;

	@EJB
	private EntRepresentanteLegalDAO entRepresentanteLegalDAO;

	@EJB
	private EntContactoDAO entContactoDAO;
	/*
	 * Entitys
	 */

	private EntEntidad entidadBuscar = new EntEntidad();
	private EntEntidad entidadSelecionada = new EntEntidad();

	/*
	 * Varios
	 */
	private List<EntEntidad> listaEntidades;
	private EntEntidad selected;
	private EntRepresentantelegal selectedRepresentante;
	private EntContacto selectedContactoN1;
	private EntContacto selectedContactoN2;
	final String contactoN1 = "1";
	final String contactoN2 = "2";

	private int tipoAccion;

	@PostConstruct
	public void init() {

		// log.info("init  catalogo");
		entidadSelecionada = new EntEntidad();
		selected = new EntEntidad();
		selectedRepresentante = new EntRepresentantelegal();
		selectedContactoN1 = new EntContacto();
		selectedContactoN2 = new EntContacto();
		entidadBuscar.setNumeroIdentificacion(null);
		entidadBuscar.setNombreEntidad(null);
		listaEntidades = null;
	}

	public List<EntEntidad> dataTable() {

		try {
			selected = null;
			listaEntidades = null;

			listaEntidades = (List<EntEntidad>) entEntidadDAO
					.buscarPorDosParametros(entidadBuscar
							.getNumeroIdentificacion().trim().toUpperCase(),
							entidadBuscar.getNombreEntidad().trim()
									.toUpperCase());

		} catch (NullPointerException e) {
			// System.out.println("mostrarTodos ** NullPointerException Bean" +
			// e);
			// e.printStackTrace();
		}

		return listaEntidades;
	}

	public void reset() {
		log.info("entré a reset 1");
		// RequestContext.getCurrentInstance().reset("formSearch:datatable");
		// setEntidadBuscar(null);
		setListaEntidades(null);
		this.entidadBuscar.setNumeroIdentificacion(null);
		this.entidadBuscar.setNombreEntidad(null);
	}

	public boolean agregar() {

		try {
			if (selected != null) {

				log.info("+++++    != null  "
						+ selected.getNombreEntidad().toString());

				setEntidadSelecionada(selected);

				cargarAdicionales();

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Seleciono la Entidad", selected
										.getNombreEntidad().toString() + "!"));
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
										"No seleccionó ninguna Entidad",
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
			log.info("+++++ limpiarCatalogo 1.0 -- "
					+ selected.getEntRepresentantelegal().getIdRepresentante());
			this.entidadBuscar.setNombreEntidad(null);
			this.entidadBuscar.setNumeroIdentificacion(null);
			listaEntidades.clear();
			this.setSelected(null);

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
					+ selected.getEntRepresentantelegal().getIdRepresentante());

			selectedRepresentante = (EntRepresentantelegal) entRepresentanteLegalDAO
					.buscarPorId(selected.getEntRepresentantelegal()
							.getIdRepresentante());

			selectedContactoN1 = entContactoDAO.buscarPorEntidadYOrden(
					selected, contactoN1);

			selectedContactoN2 = entContactoDAO.buscarPorEntidadYOrden(
					selected, contactoN2);

			if (selectedRepresentante == null) {
				log.info("diferente de null");
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_FATAL,
										"Error",
										"Ocurrió un error al cargar el intentar Cargar la información de la sección 'Representante Legal'. Contacte con el Administrador del Sistema."));
			}
			if (selectedContactoN1 == null) {
				log.info("diferente de null");
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_FATAL,
										"Error",
										"Ocurrió un error al cargar el intentar Cargar la información de la sección del 'Contacto'. Comuniquese con el Administrador del Sistema."));
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
			crudBO.editar((T) selectedRepresentante);
			crudBO.editar((T) selectedContactoN1);

			if (selectedContactoN2 != null) {
				crudBO.editar((T) selectedContactoN2);
			}

			context.addMessage(null, new FacesMessage("Edición Exitosa",
					"Ediató : Entidad, Representante y contacto."));

			inicializar();
			return true;

		} catch (NullPointerException e) {
			log.info("Editar ** NullPointerException Bean" + e);
			// e.printStackTrace();
			return false;
		} catch (PropertyNotFoundException pnf) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_WARN,
									"Advertencia",
									"NO ha seleccionado ninguna Entidad para editar."));

			return false;
		}

	}

	public void inicializar() {

		log.info("+++ Accion Inicialzar Catalogo To home");
		tipoAccion = 0;
		resetFormEdit();
		init();
	}

	public void resetFormEdit() {
	
		this.setSelected(null);
		this.setSelectedRepresentante(null);
		this.setSelectedContactoN1(null);
		this.setSelectedContactoN2(null);
	}

	/* --------- set ----- get ------------- */

	public List<EntEntidad> getListaEntidades() {
		return listaEntidades;
	}

	public void setListaEntidades(List<EntEntidad> listaEntidades) {
		this.listaEntidades = listaEntidades;
	}

	public EntEntidad getEntidadBuscar() {
		return entidadBuscar;
	}

	public void setEntidadBuscar(EntEntidad entidadBuscar) {
		this.entidadBuscar = entidadBuscar;
	}

	public EntEntidad getSelected() {
		return selected;
	}

	public void setSelected(EntEntidad selected) {
		this.selected = selected;
	}

	public EntEntidad getEntidadSelecionada() {
		return entidadSelecionada;
	}

	public void setEntidadSelecionada(EntEntidad entidadSelecionada) {
		this.entidadSelecionada = entidadSelecionada;
	}

	public EntRepresentantelegal getSelectedRepresentante() {
		return selectedRepresentante;
	}

	public void setSelectedRepresentante(
			EntRepresentantelegal selectedRepresentante) {
		this.selectedRepresentante = selectedRepresentante;
	}

	public EntContacto getSelectedContactoN1() {
		return selectedContactoN1;
	}

	public void setSelectedContactoN1(EntContacto selectedContactoN1) {
		this.selectedContactoN1 = selectedContactoN1;
	}

	public EntContacto getSelectedContactoN2() {
		return selectedContactoN2;
	}

	public void setSelectedContactoN2(EntContacto selectedContactoN2) {
		this.selectedContactoN2 = selectedContactoN2;
	}

	public int getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(int tipoAccion) {
		this.tipoAccion = tipoAccion;
	}
}
