/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ELException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;

import Modulo_3.unicom.DAO.EntContactoDAO;
import Modulo_3.unicom.DAO.EntEntidadDAO;
import Modulo_3.unicom.DAO.EntTipoEntidadDAO;
import Modulo_3.unicom.dm.Entitys.EntCiiu;
import Modulo_3.unicom.dm.Entitys.EntContacto;
import Modulo_3.unicom.dm.Entitys.EntContribuyente;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntRepresentantelegal;
import Modulo_3.unicom.dm.Entitys.EntSector;
import Modulo_3.unicom.dm.Entitys.EntTamanoEntidad;
import Modulo_3.unicom.dm.Entitys.EntTipoEmpresa;
import Modulo_3.unicom.dm.Entitys.EntTipoEntidad;
import Modulo_3.unicom.dm.Entitys.EntTipoIdentificacion;
import Modulo_3.unicom.dm.Entitys.Municipio;
import Modulo_3.unicom.dm.Entitys.Pais;

import comun.unicom.bo.CrudBO;

/**
 * @author EDUAR
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class EntGeneralidadesBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EntEntidad.class.getSimpleName());

	/*
	 * EJB
	 */

	@EJB
	private CrudBO<T> crudBO;

	@EJB
	private EntTipoEntidadDAO entTipoEntidadDAO;

	@EJB
	private EntContactoDAO entContactoDAO;

	@EJB
	private EntEntidadDAO entEntidadDAO;

	/*
	 * Entitys
	 */
	private EntEntidad entidad = new EntEntidad();
	private EntRepresentantelegal representante = new EntRepresentantelegal();
	private EntContacto contacto = new EntContacto();
	private EntContacto contacto2 = new EntContacto();

	private EntEntidad entidadBuscar = new EntEntidad();
	private EntEntidad entidadSelecionada;

	private EntSector sector = new EntSector();

	private EntEntidad Entidadselected = new EntEntidad();

	/*
	 * Varios
	 */
	private List<EntTipoIdentificacion> listaEntTipoIdentificacion;
	private List<Pais> listaPais;
	private List<Municipio> listaMunicipio;
	private List<EntCiiu> listaEntCiiu;
	private List<EntSector> listaEntSector;
	private List<EntTamanoEntidad> listaEntTamanoEntidad;
	private List<EntTipoEntidad> listaEntTipoEntidad;
	private List<EntContribuyente> listaEntContribuyente;
	private List<EntTipoEmpresa> listaEntTipoEmpresa;
	private List<EntTipoEntidad> listTipoEntidadSector;

	private List<EntContacto> contactoSelected;
	private List<EntContacto> contacto2Selected;
	private List<EntEntidad> listaEntidades;
	private EntEntidad selected;

	private int tipoAccion;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {

		try {

			inicializar();

			listaEntTipoIdentificacion = (List<EntTipoIdentificacion>) crudBO
					.buscarTodos((Class<T>) EntTipoIdentificacion.class);

			listaPais = (List<Pais>) crudBO.buscarTodos((Class<T>) Pais.class);

			listaMunicipio = (List<Municipio>) crudBO
					.buscarTodos((Class<T>) Municipio.class);

			listaEntCiiu = (List<EntCiiu>) crudBO
					.buscarTodos((Class<T>) EntCiiu.class);

			listaEntSector = (List<EntSector>) crudBO
					.buscarTodos((Class<T>) EntSector.class);

			listaEntTamanoEntidad = (List<EntTamanoEntidad>) crudBO
					.buscarTodos((Class<T>) EntTamanoEntidad.class);

			// listaEntTipoEntidad = (List<EntTipoEntidad>) crudBO
			// .buscarTodos((Class<T>) EntTipoEntidad.class);

			listaEntContribuyente = (List<EntContribuyente>) crudBO
					.buscarTodos((Class<T>) EntContribuyente.class);

			listaEntTipoEmpresa = (List<EntTipoEmpresa>) crudBO
					.buscarTodos((Class<T>) EntTipoEmpresa.class);

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

	public List<Pais> listaPais() {
		return listaPais;
	}

	public List<Municipio> listaMunicipio() {
		return listaMunicipio;
	}

	public List<EntCiiu> listaEntCiiu() {
		return listaEntCiiu;
	}

	public List<EntSector> listaEntSector() {
		return listaEntSector;
	}

	public List<EntTamanoEntidad> listaEntTamanoEntidad() {
		return listaEntTamanoEntidad;
	}

	public List<EntTipoEntidad> listaEntTipoEntidad() {
		return listaEntTipoEntidad;
	}

	public List<EntContribuyente> listaEntContribuyente() {
		return listaEntContribuyente;
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
	@SuppressWarnings("unchecked")
	public List<EntTipoEntidad> listaChange() {

		try {

			if (sector != null) {
				// log.info("sector 1.0 ");
				listaEntTipoEntidad = entTipoEntidadDAO.buscarPorSector(sector);
				return listaEntTipoEntidad;
			} else {
				// log.info("sector 1.1 ");
				listaEntTipoEntidad = (List<EntTipoEntidad>) crudBO
						.buscarTodos((Class<T>) EntTipoEntidad.class);
				return listaEntTipoEntidad;
			}
		} catch (ELException ex) {
			log.info("++ listTipoEntidadSectorChange() 1.3 ");
			return null;
		} catch (NullPointerException ne) {
			log.info("++ listTipoEntidadSectorChange() 1.4 ");
			return null;
		} catch (Exception e) {
			log.info("++ listTipoEntidadSectorChange() 1.5 ");
			return null;
		}

	}

	public void reset() {
		this.entidad.setNombreEntidad(null);
		this.entidad.setNumeroIdentificacion(null);
		this.entidad.setDireccion(null);
		this.entidad.setEmail(null);
		this.entidad.setTelefono(null);
		this.entidad.setEntSituacionFinanciera(null);
		this.entidad.setExporta(null);
		this.entidad.setWebsite(null);
		this.entidad.setFax(null);
		this.entidad.setFechaConstitucion(null);
		this.entidad.setMatriculaCamara(null);
		this.entidad.setVentaUntimoAnio(null);
		this.entidad.setPrivadoExtranjero(null);
		this.entidad.setPrivadoNacional(null);
		this.entidad.setPublicoExtranjero(null);
		this.entidad.setPublicoNacional(null);

		this.entidad.setEntCiiu(null);

		this.contacto.setPapellido_contacto(null);
		this.contacto.setPnombre_contacto(null);
		this.contacto.setSapellido_contacto(null);
		this.contacto.setSnombre_contacto(null);
		this.contacto.setCargoContacto(null);
		this.contacto.setEmailContacto(null);
		this.contacto.setTelefonoContacto(null);

		this.contacto2.setPapellido_contacto(null);
		this.contacto2.setPnombre_contacto(null);
		this.contacto2.setSapellido_contacto(null);
		this.contacto2.setSnombre_contacto(null);
		this.contacto2.setCargoContacto(null);
		this.contacto2.setEmailContacto(null);
		this.contacto2.setTelefonoContacto(null);

		this.representante.setNumeroRepresentante(null);
		this.representante.setPapellido_representante_legal(null);
		this.representante.setPnombre_representante_legal(null);
		this.representante.setSapellido_representante_legal(null);
		this.representante.setSnombre_representante_legal(null);
	}

	public void inicializar() {

		log.info("+++ Accion Inicialzar");
		tipoAccion = 0;

		// log.info("init  catalogo  +");
		entidadSelecionada = new EntEntidad();
		entidadBuscar.setNumeroIdentificacion(null);
		entidadBuscar.setNombreEntidad(null);
		listaEntidades = null;
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
	public boolean crearEntidad() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			if (representante != null) {
				crudBO.crear((T) representante, true);
			} else {
				// Rolback
				context.addMessage(
						null,
						new FacesMessage("Error",
								"Ocurrió un error en el registro del Representante Legal."));

				return false;
			}

			if (representante != null && entidad != null) {
				entidad.setEntRepresentantelegal(representante);
				crudBO.crear((T) entidad, true);
			} else {
				// Rolback
				context.addMessage(null, new FacesMessage("Error",
						"Ocurrió un error en el registro de la Entidad."));

				return false;
			}
			if (entidad != null) {
				contacto.setOrden("1");
				contacto.setEntEntidad(entidad);
				crudBO.crear((T) contacto, true);
			} else {
				context.addMessage(null, new FacesMessage("Error",
						"Ocurrió un error en el registro del Contacto número 1."));

				return false;
			}
			if (entidad != null) {
				contacto2.setOrden("2");
				contacto2.setEntEntidad(entidad);
				crudBO.crear((T) contacto2, true);
			} else {
				context.addMessage(
						null,
						new FacesMessage("Error",
								"Ocurrió un error en el registro del Contacto número 2."));

				return false;
			}

			context.addMessage(null, new FacesMessage("Registro Exitoso",
					"Agregó: Entidad,  Representante y contacto."));
			// FacesContext.getCurrentInstance().addMessage(null, new
			// FacesMessage(FacesMessage.SEVERITY_FATAL,"Sample fatal message",
			// "Fatal Error in System"));

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}


	/**
	 * 
	 * @ MEtodos del Buscador
	 */

	public List<EntEntidad> dataTable() {
		try {

			listaEntidades = (List<EntEntidad>) entEntidadDAO
					.buscarPorDosParametros(entidadBuscar
							.getNumeroIdentificacion().trim().toUpperCase(),
							entidadBuscar.getNombreEntidad().trim()
									.toUpperCase());

		} catch (NullPointerException e) {

		}

		return listaEntidades;
	}

	public void resetBuscador() {
		System.out.println("entré a reset 1");
		entidadBuscar.setNumeroIdentificacion(null);
		entidadBuscar.setNombreEntidad(null);
		listaEntidades = null;
		RequestContext.getCurrentInstance().reset("formSearch");

	}

	/* --------- set ----- get -------------BUSCADOR */

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

	public List<Municipio> getListaMunicipio() {
		return listaMunicipio;
	}

	public void setListaMunicipio(List<Municipio> listaMunicipio) {
		this.listaMunicipio = listaMunicipio;
	}

	public List<EntCiiu> getListaEntCiiu() {
		return listaEntCiiu;
	}

	public void setListaEntCiiu(List<EntCiiu> listaEntCiiu) {
		this.listaEntCiiu = listaEntCiiu;
	}

	public List<EntSector> getListaEntSector() {
		return listaEntSector;
	}

	public void setListaEntSector(List<EntSector> listaEntSector) {
		this.listaEntSector = listaEntSector;
	}

	public List<EntTamanoEntidad> getListaEntTamanoEntidad() {
		return listaEntTamanoEntidad;
	}

	public void setListaEntTamanoEntidad(
			List<EntTamanoEntidad> listaEntTamanoEntidad) {
		this.listaEntTamanoEntidad = listaEntTamanoEntidad;
	}

	public List<EntTipoEntidad> getListaEntTipoEntidad() {
		return listaEntTipoEntidad;
	}

	public void setListaEntTipoEntidad(List<EntTipoEntidad> listaEntTipoEntidad) {
		this.listaEntTipoEntidad = listaEntTipoEntidad;
	}

	public List<EntContribuyente> getListaEntContribuyente() {
		return listaEntContribuyente;
	}

	public void setListaEntContribuyente(
			List<EntContribuyente> listaEntContribuyente) {
		this.listaEntContribuyente = listaEntContribuyente;
	}

	public List<EntTipoEmpresa> getListaEntTipoEmpresa() {
		return listaEntTipoEmpresa;
	}

	public void setListaEntTipoEmpresa(List<EntTipoEmpresa> listaEntTipoEmpresa) {
		this.listaEntTipoEmpresa = listaEntTipoEmpresa;
	}

	public List<EntTipoEntidad> getListTipoEntidadSector() {
		return listTipoEntidadSector;
	}

	public void setListTipoEntidadSector(
			List<EntTipoEntidad> listTipoEntidadSector) {
		this.listTipoEntidadSector = listTipoEntidadSector;
	}

	public EntSector getSector() {
		return sector;
	}

	public void setSector(EntSector sector) {
		this.sector = sector;
	}

	public EntEntidad getEntidad() {
		return entidad;
	}

	public void setEntidad(EntEntidad entidad) {
		this.entidad = entidad;
	}

	public EntRepresentantelegal getRepresentante() {
		return representante;
	}

	public void setRepresentante(EntRepresentantelegal representante) {
		this.representante = representante;
	}

	public EntContacto getContacto() {
		return contacto;
	}

	public void setContacto(EntContacto contacto) {
		this.contacto = contacto;
	}

	public EntContacto getContacto2() {
		return contacto2;
	}

	public void setContacto2(EntContacto contacto2) {
		this.contacto2 = contacto2;
	}

	public int getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(int tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public List<EntContacto> getContactoSelected() {
		return contactoSelected;
	}

	public void setContactoSelected(List<EntContacto> contactoSelected) {
		this.contactoSelected = contactoSelected;
	}

	public List<EntContacto> getContacto2Selected() {
		return contacto2Selected;
	}

	public void setContacto2Selected(List<EntContacto> contacto2Selected) {
		this.contacto2Selected = contacto2Selected;
	}

	public EntEntidad getEntidadselected() {
		return Entidadselected;
	}

	public void setEntidadselected(EntEntidad entidadselected) {
		Entidadselected = entidadselected;
	}

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

}
