/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ELException;
import javax.el.PropertyNotFoundException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.EntProductosYServiciosDAO;
import Modulo_3.unicom.dm.Entitys.EntCiiu;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntProductosservicio;
import Modulo_3.unicom.dm.Entitys.Pais;

import comun.unicom.bo.CrudBO;

/**
 * @author Alex
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class EntProductosservicioBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(EntProductosservicio.class
			.getSimpleName());

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	@EJB
	private EntProductosYServiciosDAO entProductosYServiciosDAO;

	/*
	 * Entitys
	 */
	private EntEntidad entidad = new EntEntidad();
	private Pais pais = new Pais();
	private EntCiiu ciiu = new EntCiiu();
	private EntProductosservicio productosServicio = new EntProductosservicio();
	private EntProductosservicio selected;

	/*
	 * Varios
	 */

	private List<Pais> listaPais;
	private List<EntCiiu> listaEntCiiu;
	private List<EntEntidad> listaEntEntidad;
	private List<EntProductosservicio> listaEntProductosservicio;
	private boolean estadoCrear;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {

		try {

			estadoCrear = false;
			listaPais = (List<Pais>) crudBO.buscarTodos((Class<T>) Pais.class);

			listaEntCiiu = (List<EntCiiu>) crudBO
					.buscarTodos((Class<T>) EntCiiu.class);

			listaEntEntidad = (List<EntEntidad>) crudBO
					.buscarTodos((Class<T>) EntEntidad.class);

			// listaEntProductosservicio = (List<EntProductosservicio>) crudBO
			// .buscarTodos((Class<T>) EntProductosservicio.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public List<Pais> listaPais() {
		return listaPais;
	}

	public List<EntCiiu> listaEntCiiu() {
		return listaEntCiiu;
	}

	public List<EntEntidad> listaEntEntidad() {
		return listaEntEntidad;
	}

	/**
	 * Metodo para filtrar Productos y servicios dependiendo de la entidad
	 * seleccionada.
	 * 
	 * @author EDUAR
	 * @return
	 * 
	 */

	public List<EntProductosservicio> listaChange() {

		try {

			if (entidad == null) {
				log.info("++ listProductosYserviciosSectorChange() 1.1 ");
				listaEntProductosservicio = null;
				estadoCrear = false;
				return listaEntProductosservicio;
			} else {
				log.info("++ listProductosYserviciosSectorChange() 1.1.0 buscarPorEntidad ");
				estadoCrear = true;
				listaEntProductosservicio = entProductosYServiciosDAO
						.buscarPorEntidad(entidad);

				return listaEntProductosservicio;
			}
		} catch (ELException ex) {
			log.info("++ listProductosYserviciosSectorChange() 1.2 ");
			return null;
		} catch (NullPointerException ne) {
			log.info("++ listProductosYserviciosSectorChange() 1.3 ");
			return null;
		} catch (Exception e) {
			log.info("++ listProductosYserviciosSectorChange() 1.4 ");
			return null;
		}

	}

	public void cargar() {

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
	public void crear() {
		try {

			productosServicio.setEntEntidad(entidad);
			log.info("++++crear");
			crudBO.crear((T) productosServicio);
			limpiarCrear();
			listaChange();

		} catch (NullPointerException e) {
			log.info("++++crear  1");
			// e.printStackTrace();
		} catch (PropertyNotFoundException e) {
			log.info("++++crear  2");
			// e.printStackTrace();
		}

	}

	private void limpiarCrear() {

		log.info("++++limpiarCrear");
		productosServicio.setEntCiiu(null);
		productosServicio.setNombreProductoServicio(null);
		productosServicio.setPais(null);

	}

	public void eliminareditar() {

		try {
			// crudBO.remover((T) selected);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public EntProductosservicio getProductosServicio() {
		return productosServicio;
	}

	public void setProductosServicio(EntProductosservicio productosServicio) {
		this.productosServicio = productosServicio;
	}

	public List<EntEntidad> getListaEntEntidad() {
		return listaEntEntidad;
	}

	public void setListaEntEntidad(List<EntEntidad> listaEntEntidad) {
		this.listaEntEntidad = listaEntEntidad;
	}

	public List<Pais> getListaPais() {
		return listaPais;
	}

	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}

	public List<EntCiiu> getListaEntCiiu() {
		return listaEntCiiu;
	}

	public void setListaEntCiiu(List<EntCiiu> listaEntCiiu) {
		this.listaEntCiiu = listaEntCiiu;
	}

	public List<EntProductosservicio> getListaEntProductosservicio() {
		return listaEntProductosservicio;
	}

	public void setListaEntProductosservicio(
			List<EntProductosservicio> listaEntProductosservicio) {
		this.listaEntProductosservicio = listaEntProductosservicio;
	}

	public EntProductosservicio getSelected() {
		return selected;
	}

	public void setSelected(EntProductosservicio selected) {
		this.selected = selected;
	}

	public EntCiiu getCiiu() {
		return ciiu;
	}

	public void setCiiu(EntCiiu ciiu) {
		this.ciiu = ciiu;
	}

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

	public boolean isEstadoCrear() {
		return estadoCrear;
	}

	public void setEstadoCrear(boolean estadoCrear) {
		this.estadoCrear = estadoCrear;
	}

}
