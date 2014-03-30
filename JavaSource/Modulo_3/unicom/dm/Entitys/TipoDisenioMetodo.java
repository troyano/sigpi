package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_disenio_metodo database table.
 * 
 */
@Entity
@Table(name="tipo_disenio_metodo")
public class TipoDisenioMetodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_DISENIO_METODO_IDTIPODISENIO_GENERATOR", sequenceName="TIPO_DISENIO_METODO_ID_TIPO_DISENIO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_DISENIO_METODO_IDTIPODISENIO_GENERATOR")
	@Column(name="id_tipo_disenio")
	private Integer idTipoDisenio;

	@Column(name="estado_disenio_metodo")
	private Integer estadoDisenioMetodo;

	@Column(name="nombre_disenio_metodo")
	private String nombreDisenioMetodo;

	//bi-directional many-to-one association to DisenioMetodo
	@OneToMany(mappedBy="tipoDisenioMetodo")
	private List<DisenioMetodo> disenioMetodo;

	public TipoDisenioMetodo() {
	}

	public Integer getIdTipoDisenio() {
		return this.idTipoDisenio;
	}

	public void setIdTipoDisenio(Integer idTipoDisenio) {
		this.idTipoDisenio = idTipoDisenio;
	}

	public Integer getEstadoDisenioMetodo() {
		return this.estadoDisenioMetodo;
	}

	public void setEstadoDisenioMetodo(Integer estadoDisenioMetodo) {
		this.estadoDisenioMetodo = estadoDisenioMetodo;
	}

	public String getNombreDisenioMetodo() {
		return this.nombreDisenioMetodo;
	}

	public void setNombreDisenioMetodo(String nombreDisenioMetodo) {
		this.nombreDisenioMetodo = nombreDisenioMetodo;
	}

	public List<DisenioMetodo> getDisenioMetodo() {
		return this.disenioMetodo;
	}

	public void setDisenioMetodo(List<DisenioMetodo> disenioMetodo) {
		this.disenioMetodo = disenioMetodo;
	}

	public DisenioMetodo addDisenioMetodo(DisenioMetodo disenioMetodo) {
		getDisenioMetodo().add(disenioMetodo);
		disenioMetodo.setTipoDisenioMetodo(this);

		return disenioMetodo;
	}

	public DisenioMetodo removeDisenioMetodo(DisenioMetodo disenioMetodo) {
		getDisenioMetodo().remove(disenioMetodo);
		disenioMetodo.setTipoDisenioMetodo(null);

		return disenioMetodo;
	}

}