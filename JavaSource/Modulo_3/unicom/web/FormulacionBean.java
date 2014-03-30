/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ELException;
import javax.el.PropertyNotFoundException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.ActividadDAO;
import Modulo_3.unicom.DAO.EntRolEntidadDAO;
import Modulo_3.unicom.DAO.EntidadProyectoDAO;
import Modulo_3.unicom.DAO.FaseDAO;
import Modulo_3.unicom.DAO.ProyectoDAO;
import Modulo_3.unicom.dm.Entitys.Actividad;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntRolentidad;
import Modulo_3.unicom.dm.Entitys.EntidadProyecto;
import Modulo_3.unicom.dm.Entitys.Fase;
import Modulo_3.unicom.dm.Entitys.Proyecto;
import Modulo_3.unicom.dm.Entitys.Sede;

import comun.unicom.bo.CrudBO;

/**
 * @author Eduar
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class FormulacionBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(FormulacionBean.class.getSimpleName());

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	@EJB
	private ProyectoDAO proyectoDAO;

	@EJB
	private EntidadProyectoDAO entidadProyectoDAO;

	@EJB
	private EntRolEntidadDAO entRolEntidadDAO;

	@EJB
	private FaseDAO faseDAO;

	@EJB
	private ActividadDAO actividadDAO;
	/*
	 * Entitys
	 */
	private Proyecto selected;

	/*
	 * Entitys
	 */

	private Proyecto proyectoSelecionado = new Proyecto();
	private EntidadProyecto entidadProyecto = new EntidadProyecto();
	private Proyecto proyecto = new Proyecto();
	private Proyecto proyectoFase = new Proyecto();
	private Actividad actividadFase = new Actividad();
	private EntEntidad entidad = new EntEntidad();
	private EntEntidad entidadEdit = new EntEntidad();
	private EntRolentidad rolEntidad = new EntRolentidad();
	private Fase fase = new Fase();

	/*
	 * Varios
	 */

	private List<Proyecto> listaProyectosFormulacion;
	private List<EntEntidad> listaEntEntidad;
	private List<Proyecto> listaProyectos;
	private List<EntidadProyecto> listaEntidadProyecto;
	private List<EntRolentidad> listaEntRolentidad;
	private List<Sede> listaSede;

	private Proyecto proyectoBuscar;

	private Proyecto selectedProyecto;
	private EntidadProyecto selectedEntidadProyecto;
	private Fase selectedFase;
	private Actividad selectedActividad;

	private Date fechaInicial;
	private Date fechaFinal;
	public static int estadoFormulacion = 0;
	private int tipoAccion;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {

		try {
			log.info("Log init");
			listaSede = (List<Sede>) crudBO.buscarTodos((Class<T>) Sede.class);

			lista();
			reset();
			inicializarCatalogo();
			opcionesEntidadProyecto();

		} catch (NullPointerException e) {
			log.info("Log init 0");
			// e.printStackTrace();
		} catch (Exception e) {
			log.info("Log init 1");
			// e.printStackTrace();
		}
	}

	public List<Sede> listaSedes() {

		return listaSede;

	}

	public void inicializarCatalogo() {

		try {
			// log.info("inicializar  catalogo");

			proyectoBuscar = new Proyecto();
			proyectoSelecionado = new Proyecto();

		} catch (NullPointerException e) {

			log.info("init  catalogo 1.1");
			e.printStackTrace();
		} catch (Exception e) {
			log.info("init  catalogo 1.2");
			e.printStackTrace();
		}

	}

	private void lista() {
		listaProyectos = proyectoDAO.buscarPorEstado(estadoFormulacion);
	}

	public List<Proyecto> listaFiltrar() {

		try {

			// log.info("listaFiltrar() 1.1");

			listaProyectos = (List<Proyecto>) proyectoDAO
					.buscarPorCatalogo(proyectoBuscar, estadoFormulacion,
							fechaInicial, fechaFinal);

			// log.info("listaFiltrar() 1.2");
		} catch (ELException ex) {
			log.info("++ listaFiltrar() 1.4 ");
			ex.printStackTrace();
			return null;
		} catch (NullPointerException ne) {
			log.info("++ listaFiltrar() 1.5 ");
			return null;
		} catch (Exception e) {

			log.info("++ listaFiltrar() 1.6 ");
			e.printStackTrace();
			return null;
		}

		return listaProyectos;
	}

	public void reset() {

		try {
			// log.info("reset 1");

			proyectoBuscar.setNombreProyecto(null);
			setFechaInicial(null);
			setFechaFinal(null);

		} catch (NullPointerException npe) {
			log.info("reset 2");
			// npe.printStackTrace();
		} catch (Exception e) {
			log.info("reset 3");
			// e.printStackTrace();
		}
	}

	/***
	 * INICIO -------------------------- MÉTODOS DE LA OPCION ENTIDAD - Rol de
	 * las Entidades del Proyecto *********
	 */

	@SuppressWarnings("unchecked")
	public void opcionesEntidadProyecto() {

		try {
			// log.info("opcionesEntidadProyecto 1.0");
			listaEntEntidad = (List<EntEntidad>) crudBO
					.buscarTodos((Class<T>) EntEntidad.class);

		} catch (Exception e) {
			log.info("opcionesEntidadProyecto 11");
			// e.printStackTrace();
		}
	}

	public List<EntEntidad> listaEntidades() {
		return listaEntEntidad;
	}

	public List<EntRolentidad> listaRolesChange() {

		try {
			listaEntRolentidad = null;
			if (entidad != null && !entidad.equals("")) {

				listaEntRolentidad = entRolEntidadDAO.buscarPorProEntRol(
						proyecto, entidad);

				if (listaEntRolentidad == null) {
					FacesContext
							.getCurrentInstance()
							.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_INFO,
											"Información",
											"La entidad ya tiene un rol en el proyecto."));
				}
			}

			return listaEntRolentidad;

		} catch (ELException ex) {
			log.info("++ listaRolesChange() 1.5 ");
			return null;
		} catch (NullPointerException ne) {
			log.info("++ listaRolesChange() 1.6 ");
			return null;
		} catch (Exception e) {
			log.info("++ listaRolesChange() 1.7 ");
			return null;
		}

	}

	public List<EntRolentidad> listaRolesChangeEdit() {

		try {

			setEntidadEdit(selectedEntidadProyecto.getEntEntidad());
			EntEntidad ent = getEntidadEdit();

			return listaEntRolentidad = entRolEntidadDAO.buscarPorProEntRol2(
					proyecto, ent);

		} catch (ELException ex) {
			log.info("++ listaRolesChange() 1.5 ");
			return null;
		} catch (NullPointerException ne) {
			log.info("++ listaRolesChange() 1.6 ");
			return null;
		} catch (Exception e) {
			log.info("++ listaRolesChange() 1.7 ");
			return null;
		}

	}

	public List<EntidadProyecto> mostrarEntidadesProyecto() {

		try {
			// log.info("init mostrarEntidadesProyecto 1.0 ++++ "
			// + getSelected().getNombreProyecto());

			setProyecto(getSelected());
			listaEntidadProyecto = (List<EntidadProyecto>) entidadProyectoDAO
					.buscarPorProyecto(proyecto);
			return listaEntidadProyecto;

		} catch (NullPointerException e) {
			log.info("init mostrarEntidadesProyecto 1.1");
			// e.printStackTrace();
			return null;
		} catch (Exception e) {
			log.info("init mostrarEntidadesProyecto 1.2");
			// e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public void crearEntidadProyecto() {
		try {

			entidadProyecto.setProyecto(proyecto);
			entidadProyecto.setEntEntidad(entidad);

			crudBO.crear((T) entidadProyecto);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(
					null,
					new FacesMessage("Registro Exitoso",
							"Agregó exitosamente un rol a una entidad para el Proyecto."));

			listaRolesChange();

		} catch (NullPointerException e) {
			log.info("crearEntidadProyecto  1");

			// e.printStackTrace();
		} catch (PropertyNotFoundException e) {
			log.info("crearEntidadProyecto++++crear  2");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"Error: Se presentó un error en el registro",
									"Por favor intente de nuevo o contacte al Administrador del sistema."));
			// e.printStackTrace();
		} catch (Exception e) {
			log.info("++++crear  3");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"Error: Se presentó un error en el registro",
									"Por favor intente de nuevo o contacte al Administrador del sistema."));
		}

	}

	@SuppressWarnings("unchecked")
	public void editarEntidadProyecto() {

		try {
			crudBO.editar((T) selectedEntidadProyecto);
		} catch (Exception e) {
			log.info("Editar ** selectedEntidadProyecto");
			// e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void eliminarEntidadProyecto() {

		try {
			crudBO.remover((T) selectedEntidadProyecto);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/***** * FIN -ROL ENTIDAD PROYECTO-------------------- **************************************************************************************************/
	/** * INICIO -------------------------- MÉTODOS DEl CRONOGRAMA********* */

	public List<Fase> fasesProyecto() {

		setProyectoFase(getSelected());
		List<Fase> listaFasesProyecto = (List<Fase>) faseDAO
				.buscarPorProyecto(proyectoFase);

		// List<Fase> listaFasesProyecto = (List<Fase>) crudBO
		// .buscarTodos((Class<T>) Fase.class);

		return listaFasesProyecto;
	}

	@SuppressWarnings("unchecked")
	public void crearFase() {
		try {
			//log.info("crearFase 1 **");

			entidadProyecto.setProyecto(proyecto);
			fase.setProyecto(proyectoFase);

			crudBO.crear((T) fase);
			resetCrearFase();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void resetCrearFase() {

		try {
			fase.setNombreFase(null);
			fase.setDescripcionFase(null);
			fase.setConsecutivoFase(null);
			fase.setFasFechainicio(null);
			fase.setFasFechafin(null);

			fase = new Fase();

		} catch (NullPointerException n) {
			log.info("reset crar fase 1");
		} catch (Exception e) {
			log.info("reset crar fase 2");
		}
	}

	@SuppressWarnings("unchecked")
	public void crearActividadFase() {
		try {
			//log.info("crearActividadFase 1 **");

			actividadFase.setFase(selectedFase);
			crudBO.crear((T) actividadFase);
			resetCrearActividadFase();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void resetCrearActividadFase() {

		try {
			actividadFase.setNombreActividad(null);
			actividadFase.setDescripcionActividad(null);
			actividadFase.setObservaciones(null);
			actividadFase.setInicio(null);
			actividadFase.setFin(null);
			actividadFase.setFase(null);

			actividadFase = new Actividad();

		} catch (NullPointerException n) {
			log.info("reset crar Actividadfase 1");
		} catch (Exception e) {
			log.info("reset crar Actividadfase 2");
		}
	}

	@SuppressWarnings("unchecked")
	public void editarFase() {

		try {
			crudBO.editar((T) selectedFase);
		} catch (Exception e) {
			log.info("Editar ** editarActividadFase");
			// e.printStackTrace();
		}

	}

	public List<Actividad> actividadesFase() {
		try {
			//log.info("++++++++ actividadesFase 1.0");
			List<Actividad> listaactividadFase = (List<Actividad>) actividadDAO
					.buscarPorFase(selectedFase);
			//log.info("++++++++ actividadesFase 1.1");
			return listaactividadFase;

		} catch (Exception e) {
			log.info("++++++++ actividadesFase 1.1");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public void editarActividad() {

		try {
			crudBO.editar((T) selectedActividad);
		} catch (Exception e) {
			log.info("Editar ** editarActividadFase");
			// e.printStackTrace();
		}

	}

	public void eliminarActividadFase() {

		try {

			if (selectedActividad != null) {

				// log.info("eliminarActividadFase 1.0 ***** ");

				actividadDAO.eliminar(selectedActividad);
			} else {
				// log.info("eliminarActividadFase 1.0 ----- ");
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Informacón",
										"Debe seleccionar la Actividad que desea eliminar."));
			}

		} catch (NullPointerException e) {
			log.info("eliminarActividadFase 1.1+++++++ ");
			e.printStackTrace();
		} catch (Exception e) {
			log.info("eliminarActividadFase 1.2+++++++ ");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void eliminarConograma() {

		try {

			if (selectedFase != null) {

				 //log.info("eliminarConograma 1.0 ***** ");

				crudBO.remover((T) selectedFase);
			} else {
				// log.info("eliminarActividadFase 1.0 ----- ");
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Informacón",
										"Debe seleccionar la Fase que desea eliminar."));
			}

		} catch (NullPointerException e) {
			log.info("eliminarConograma 1.1+++++++ ");
			e.printStackTrace();
		} catch (Exception e) {
			log.info("eliminarConograma 1.2+++++++ ");
			e.printStackTrace();
		}
	}

	/***** * FIN CRONOGRAMA-------------------- **************************************************************************************************/
	/* --------- set ----- get ------------- */

	public int getTipoAccion() {
		return tipoAccion;
	}

	public Proyecto getProyectoBuscar() {
		return proyectoBuscar;
	}

	public void setProyectoBuscar(Proyecto proyectoBuscar) {
		this.proyectoBuscar = proyectoBuscar;
	}

	public Proyecto getSelectedProyecto() {
		return selectedProyecto;
	}

	public void setSelectedProyecto(Proyecto selectedProyecto) {
		this.selectedProyecto = selectedProyecto;
	}

	public void setTipoAccion(int tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public List<Proyecto> getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(List<Proyecto> listaProyectos) {
		this.listaProyectos = listaProyectos;
	}

	public void setProyectoSelecionado(Proyecto proyectoSelecionado) {
		this.proyectoSelecionado = proyectoSelecionado;
	}

	public Proyecto getProyectoSelecionado() {
		return proyectoSelecionado;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Proyecto getSelected() {
		return selected;
	}

	public void setSelected(Proyecto selected) {
		this.selected = selected;
	}

	public List<Proyecto> getListaProyectosFormulacion() {
		return listaProyectosFormulacion;
	}

	public void setListaProyectosFormulacion(
			List<Proyecto> listaProyectosFormulacion) {
		this.listaProyectosFormulacion = listaProyectosFormulacion;
	}

	public List<Sede> getListaSede() {
		return listaSede;
	}

	public void setListaSede(List<Sede> listaSede) {
		this.listaSede = listaSede;
	}

	public List<EntEntidad> getListaEntEntidad() {
		return listaEntEntidad;
	}

	public void setListaEntEntidad(List<EntEntidad> listaEntEntidad) {
		this.listaEntEntidad = listaEntEntidad;
	}

	public List<EntRolentidad> getListaEntRolentidad() {
		return listaEntRolentidad;
	}

	public void setListaEntRolentidad(List<EntRolentidad> listaEntRolentidad) {
		this.listaEntRolentidad = listaEntRolentidad;
	}

	public EntEntidad getEntidad() {
		return entidad;
	}

	public void setEntidad(EntEntidad entidad) {
		this.entidad = entidad;
	}

	public EntRolentidad getRolEntidad() {
		return rolEntidad;
	}

	public void setRolEntidad(EntRolentidad rolEntidad) {
		this.rolEntidad = rolEntidad;
	}

	public EntidadProyecto getEntidadProyecto() {
		return entidadProyecto;
	}

	public void setEntidadProyecto(EntidadProyecto entidadProyecto) {
		this.entidadProyecto = entidadProyecto;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public EntidadProyecto getSelectedEntidadProyecto() {
		return selectedEntidadProyecto;
	}

	public void setSelectedEntidadProyecto(
			EntidadProyecto selectedEntidadProyecto) {
		this.selectedEntidadProyecto = selectedEntidadProyecto;
	}

	public EntEntidad getEntidadEdit() {
		return entidadEdit;
	}

	public void setEntidadEdit(EntEntidad entidadEdit) {
		this.entidadEdit = entidadEdit;
	}

	public Fase getSelectedFase() {
		return selectedFase;
	}

	public void setSelectedFase(Fase selectedFase) {
		this.selectedFase = selectedFase;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Proyecto getProyectoFase() {
		return proyectoFase;
	}

	public void setProyectoFase(Proyecto proyectoFase) {
		this.proyectoFase = proyectoFase;
	}

	public Actividad getSelectedActividad() {
		return selectedActividad;
	}

	public void setSelectedActividad(Actividad selectedActividad) {
		this.selectedActividad = selectedActividad;
	}

	public Actividad getActividadFase() {
		return actividadFase;
	}

	public void setActividadFase(Actividad actividadFase) {
		this.actividadFase = actividadFase;
	}

}
