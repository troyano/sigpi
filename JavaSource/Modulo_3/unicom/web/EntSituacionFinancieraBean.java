/**
 * 
 */
package Modulo_3.unicom.web;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import Modulo_3.unicom.DAO.EntFinancieraAnioDAO;
import Modulo_3.unicom.DAO.EntIndicadorDAO;
import Modulo_3.unicom.DAO.EntSituacionFinacieraDAO;
import Modulo_3.unicom.dm.Entitys.Anio;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntFinancieraAnio;
import Modulo_3.unicom.dm.Entitys.EntIndicador;
import Modulo_3.unicom.dm.Entitys.EntSituacionFinanciera;
import Modulo_3.unicom.dm.Entitys.EntVariable;

import comun.unicom.bo.CrudBO;

/**
 * @author Eduar
 * @param <T>
 * 
 */
@ManagedBean
@SessionScoped
public class EntSituacionFinancieraBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(EntSituacionFinanciera.class
			.getSimpleName());

	/*
	 * EJB
	 */
	@EJB
	private CrudBO<T> crudBO;

	@EJB
	private EntSituacionFinacieraDAO entSituacionFinacieraDAO;

	@EJB
	private EntFinancieraAnioDAO entFinancieraAnioDAO;

	@EJB
	private EntIndicadorDAO entIndicadorDAO;

	/*
	 * Entitys
	 */
	private EntEntidad entidad = new EntEntidad();

	private EntSituacionFinanciera situacionFinanciera = new EntSituacionFinanciera();
	private EntSituacionFinanciera selected;
	private EntFinancieraAnio selectedFAedit;

	boolean estadoCrear;
	private int aniosProgramados;
	private EntVariable variable = new EntVariable();
	private EntVariable variableEdit = new EntVariable();
	private Double valorEditar;

	/*
	 * Varios
	 */

	private List<EntEntidad> listaEntEntidad;
	private List<EntSituacionFinanciera> listaEntSituacionFinaciera;
	private List<EntIndicador> listaEntIndicador;
	private List<EntVariable> listaEntVariable;

	private List<EntFinancieraAnio> listaEntFinancieraAnio;
	private List<EntFinancieraAnio> listaEntFinancieraAnioSelected;

	private List<Anio> listaAnio;
	private String valorU;
	private String valorD;
	private String valorT;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {

		try {
			log.info("entre a situcion financiera post");
			estadoCrear = false;

			// listaEntIndicador = (List<EntIndicador>) crudBO
			// .buscarTodos((Class<T>) EntIndicador.class);

			listaEntVariable = (List<EntVariable>) crudBO
					.buscarTodos((Class<T>) EntVariable.class);

			listaEntEntidad = (List<EntEntidad>) crudBO
					.buscarTodos((Class<T>) EntEntidad.class);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public List<EntIndicador> listaIndicadores() {
		return listaEntIndicador;
	}

	public List<EntVariable> listaVariables() {
		return listaEntVariable;
	}

	public List<EntEntidad> listaEntEntidad() {
		return listaEntEntidad;
	}

	/**
	 * Metodo para filtrar situacion financiera dependiendo de la entidad
	 * seleccionada.
	 * 
	 * @author EDUAR
	 * @return
	 * 
	 */

	public List<EntSituacionFinanciera> listaChange() {

		try {
			// log.info("listaChange()");
			if (entidad == null) {

				listaEntSituacionFinaciera = null;
				estadoCrear = false;
				return listaEntSituacionFinaciera;
			} else {
				estadoCrear = true;
				listaEntSituacionFinaciera = entSituacionFinacieraDAO
						.buscarPorEntidad(entidad);

				return listaEntSituacionFinaciera;
			}
		} catch (ELException ex) {
			log.info("++ Change() 1.2 ");
			return null;
		} catch (NullPointerException ne) {
			log.info("++ Change() 1.3 ");
			return null;
		} catch (Exception e) {
			log.info("++ Change() 1.4 ");
			e.printStackTrace();
			return null;
		}

	}

	public List<EntIndicador> listaVariableChange() {

		try {

			if (variable != null && !variable.equals("")) {

				// listaEntIndicador =
				// entIndicadorDAO.buscarPorVariable(variable);
				listaEntIndicador = entIndicadorDAO
						.buscarPorVariableNORegistrada(variable, entidad);

				if (listaEntIndicador == null) {
					FacesContext
							.getCurrentInstance()
							.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_INFO,
											"No hay Indicadores",
											"Es posible que no hayan asociados a la variable seleccionada o ya todos estén creados para esta entidad."));
				}
				return listaEntIndicador;
			} else {

				listaEntIndicador = null;
				return listaEntIndicador;
			}
		} catch (ELException ex) {
			log.info("++ listaVariableChange() 1.5 ");
			return null;
		} catch (NullPointerException ne) {
			log.info("++ listaVariableChange() 1.6 ");
			return null;
		} catch (Exception e) {
			log.info("++ listaVariableChange() 1.7 ");
			return null;
		}

	}

	public List<EntIndicador> listaVariableChangeEdit() {

		try {

			setVariableEdit(selected.getEntIndicador().getEntVariable());
			EntVariable var = getVariableEdit();
			listaEntIndicador = entIndicadorDAO.buscarPorVariableNORegistrada(
					var, entidad);

			return listaEntIndicador;

		} catch (ELException ex) {
			log.info("++ listaVariableChange() 1.5 ");
			return null;
		} catch (NullPointerException ne) {
			log.info("++ listaVariableChange() 1.6 ");
			return null;
		} catch (Exception e) {
			log.info("++ listaVariableChange() 1.7 ");
			e.printStackTrace();
			return null;
		}

	}

	public List<EntFinancieraAnio> listaFinancieraAnioPorRowSelected() {

		try {
			// log.info("++ listaFinancieraAnioPorRowSelected() 1.1 ");
			listaEntFinancieraAnioSelected = null;
			if (selected != null) {
				// log.info("++ listaFinancieraAnioPorRowSelected() 1.2 ");
				listaEntFinancieraAnioSelected = entFinancieraAnioDAO
						.buscarPorSituacionFinanciera(selected);
			}

			return listaEntFinancieraAnioSelected;

		} catch (ELException ex) {
			log.info("++ listaFinancieraAnioPorRowSelected() 1.3 ");
			return null;
		} catch (NullPointerException ne) {
			log.info("++ listaFinancieraAnioPorRowSelected() 1.4");
			return null;
		} catch (Exception e) {
			log.info("++ listaFinancieraAnioPorRowSelected() 1.5 ");
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * Metodo q retorna los años con estado activo [0], pra el encabezado de la
	 * grid de crear situación financiera valor de indicadores
	 */
	public List<Anio> anios() {

		try {

			List<Anio> tempAnios = entSituacionFinacieraDAO
					.buscarAniosByEstado(0);

			// log.info("TAMANIO -- " + tempAnios.size());
			setAniosProgramados(tempAnios.size());
			while (tempAnios.size() < 3) {

				tempAnios.add(null);
				log.info("TAMANIO add new ** " + tempAnios.size());
			}

			// log.info("TAMANIO new ++ "+tempAnios.size());
			return tempAnios;

		} catch (ELException el) {
			log.info(" el  -");
			return null;
		} catch (Exception e) {
			log.info(" e  -");
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public void crear() {
		try {

			situacionFinanciera.setEntEntidad(entidad);

			crudBO.crear((T) situacionFinanciera);

			if (craerFinancieraAnio()) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(
						null,
						new FacesMessage("Registro Exitoso",
								"Agregó exitosamente la Situación Financiera para la Entidad seleccionada."));
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_FATAL,
										"Error: Se presentó un error en el registro",
										"Por favor intente de nuevo o contacte al Administrador del sistema."));
			}

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

	public boolean craerFinancieraAnio() {

		try {
			log.info("craerFinancieraAnio++++++  1.0 ");

			ArrayList<Double> valores = new ArrayList<Double>();
			valores.add(Double.parseDouble(getValorU()));
			valores.add(Double.parseDouble(getValorD()));
			valores.add(Double.parseDouble(getValorT()));

			List<Anio> anios = anios();
			log.info("craerFinancieraAnio++++++  2.0  anios - valores "
					+ anios.size() + " - " + valores.size());
			entFinancieraAnioDAO.crearFinancieraAnioListas(anios, valores);

			return true;
		} catch (NullPointerException np) {
			log.info("craerFinancieraAnio++++++  1.2 ");
			// np.printStackTrace();
			return false;

		} catch (Exception e) {
			log.info("craerFinancieraAnio++++++  1.3 ");
			// e.printStackTrace();
			return false;
		}
	}

	private void limpiarCrear() {

		this.situacionFinanciera.setEntIndicador(null);
		this.setVariable(null);
		this.setValorU(null);
		this.setValorD(null);
		this.setValorT(null);
		RequestContext.getCurrentInstance().reset("newForm");

	}

	@SuppressWarnings("unchecked")
	public void editar() {

		try {
			crudBO.editar((T) selected);
		} catch (NullPointerException e) {
			log.info("Editar ** NullPointerException Bean" + e);
			// e.printStackTrace();
		}

	}

	public void onCellEdit(CellEditEvent event) {
		log.info(" entre a cel edit 1.0");
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		// EntFinancieraAnio fin = (EntFinancieraAnio) event.g

		log.info(" entre a cel edit OLD = " + oldValue + " -NEw = " + newValue);
		// crudBO.editar((T) selected);
		if (newValue != null && !newValue.equals(oldValue)) {
			log.info(" entre a cel edit 1.2");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", "Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			log.info(" entre a cel edit 1.3");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"XXXX Cell Changed", "Old: " + oldValue + ", New:"
							+ newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	@SuppressWarnings("unchecked")
	public void onEdit(RowEditEvent event) {

		// FacesMessage msg = new FacesMessage("xxxxxx", ((EntFinancieraAnio)
		// event.getObject()).getValor().toString());

		// FacesContext.getCurrentInstance().addMessage(null, msg);
		// log.info("msg  = "+msg.getSummary().toString());
		// EntFinancieraAnio st = (EntFinancieraAnio) event.getObject();

		selectedFAedit.setValor(getValorEditar());
		crudBO.editar((T) selectedFAedit);
		// log.info(" valor = "+st.getValor());
		if (selectedFAedit != null) {
			log.info("valor  selected FA edit" + selectedFAedit.getValor());
		}
		setValorEditar(null);
		listaFinancieraAnioPorRowSelected();
	}

	public void onCancel() {
		log.info("ONcancel");
	}

	@SuppressWarnings("unchecked")
	public void eliminareditar() {

		try {

			Long retorno = crudBO.removerEntidades(
					EntFinancieraAnio.class,
					"fa",
					"fa.entSituacionFinanciera ="
							+ selected.getIdEntidadVariable());
			if (retorno > 0) {
				crudBO.remover((T) selected);
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Imposible Eliminar",
								"NO se a eliminado el registro."));

			}
			listaChange();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Registro Eliminado",
							"Se realizo exitosamente la eliminación."));

		} catch (Exception e) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"Error: Se presentó un error en la eliminación",
									"Por favor intente de nuevo o contacte a el Administrador del sistema."));
		}
	}

	public List<EntEntidad> getListaEntEntidad() {
		return listaEntEntidad;
	}

	public void setListaEntEntidad(List<EntEntidad> listaEntEntidad) {
		this.listaEntEntidad = listaEntEntidad;
	}

	public EntEntidad getEntidad() {
		return entidad;
	}

	public void setEntidad(EntEntidad entidad) {
		this.entidad = entidad;
	}

	public boolean isEstadoCrear() {
		return estadoCrear;
	}

	public void setEstadoCrear(boolean estadoCrear) {
		this.estadoCrear = estadoCrear;
	}

	public EntSituacionFinanciera getSituacionFinanciera() {
		return situacionFinanciera;
	}

	public void setSituacionFinanciera(
			EntSituacionFinanciera situacionFinanciera) {
		this.situacionFinanciera = situacionFinanciera;
	}

	public List<EntSituacionFinanciera> getListaEntSituacionFinaciera() {
		return listaEntSituacionFinaciera;
	}

	public void setListaEntSituacionFinaciera(
			List<EntSituacionFinanciera> listaEntSituacionFinaciera) {
		this.listaEntSituacionFinaciera = listaEntSituacionFinaciera;
	}

	public List<EntIndicador> getListaEntIndicador() {
		return listaEntIndicador;
	}

	public void setListaEntIndicador(List<EntIndicador> listaEntIndicador) {
		this.listaEntIndicador = listaEntIndicador;
	}

	public List<EntVariable> getListaEntVariable() {
		return listaEntVariable;
	}

	public void setListaEntVariable(List<EntVariable> listaEntVariable) {
		this.listaEntVariable = listaEntVariable;
	}

	public List<EntFinancieraAnio> getListaEntFinancieraAnio() {
		return listaEntFinancieraAnio;
	}

	public void setListaEntFinancieraAnio(
			List<EntFinancieraAnio> listaEntFinancieraAnio) {
		this.listaEntFinancieraAnio = listaEntFinancieraAnio;
	}

	public List<Anio> getListaAnio() {
		return listaAnio;
	}

	public void setListaAnio(List<Anio> listaAnio) {
		this.listaAnio = listaAnio;
	}

	public EntSituacionFinanciera getSelected() {
		return selected;
	}

	public void setSelected(EntSituacionFinanciera selected) {
		this.selected = selected;
	}

	public List<EntFinancieraAnio> getListaEntFinancieraAnioSelected() {
		return listaEntFinancieraAnioSelected;
	}

	public void setListaEntFinancieraAnioSelected(
			List<EntFinancieraAnio> listaEntFinancieraAnioSelected) {
		this.listaEntFinancieraAnioSelected = listaEntFinancieraAnioSelected;
	}

	public EntVariable getVariable() {
		return variable;
	}

	public void setVariable(EntVariable variable) {
		this.variable = variable;
	}

	public String getValorU() {
		return valorU;
	}

	public void setValorU(String valorU) {
		this.valorU = valorU;
	}

	public String getValorD() {
		return valorD;
	}

	public void setValorD(String valorD) {
		this.valorD = valorD;
	}

	public String getValorT() {
		return valorT;
	}

	public void setValorT(String valorT) {
		this.valorT = valorT;
	}

	public int getAniosProgramados() {
		return aniosProgramados;
	}

	public void setAniosProgramados(int aniosProgramados) {
		this.aniosProgramados = aniosProgramados;
	}

	public EntFinancieraAnio getSelectedFAedit() {
		return selectedFAedit;
	}

	public void setSelectedFAedit(EntFinancieraAnio selectedFAedit) {
		this.selectedFAedit = selectedFAedit;
	}

	public Double getValorEditar() {
		return valorEditar;
	}

	public void setValorEditar(Double valorEditar) {
		this.valorEditar = valorEditar;
	}

	public EntVariable getVariableEdit() {
		return variableEdit;
	}

	public void setVariableEdit(EntVariable variableEdit) {
		this.variableEdit = variableEdit;
	}

}
