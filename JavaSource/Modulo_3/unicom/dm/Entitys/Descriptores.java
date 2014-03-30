package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the descriptores database table.
 * 
 */
@Entity
@Table(name="descriptores")
public class Descriptores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DESCRIPTORES_IDDESCRIPTORES_GENERATOR", sequenceName="DESCRIPTORES_ID_DESCRIPTORES_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DESCRIPTORES_IDDESCRIPTORES_GENERATOR")
	@Column(name="id_descriptores")
	private Integer idDescriptores;

	@Column(name="descripcion_descritores")
	private String descripcionDescritores;

	@Column(name="estado_descriptor")
	private Integer estadoDescriptor;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_estado")
	private Date fechaEstado;

	@Column(name="puntaje_descriptor")
	private Integer puntajeDescriptor;

	@Column(name="puntaje_descriptores")
	private Integer puntajeDescriptores;

	//bi-directional many-to-one association to Variable
	@ManyToOne
	@JoinColumn(name="id_variable")
	private Variable variable;

	//bi-directional many-to-one association to PuntajeRevisor
	@OneToMany(mappedBy="descriptores")
	private List<PuntajeRevisor> puntajeRevisor;

	public Descriptores() {
	}

	public Integer getIdDescriptores() {
		return this.idDescriptores;
	}

	public void setIdDescriptores(Integer idDescriptores) {
		this.idDescriptores = idDescriptores;
	}

	public String getDescripcionDescritores() {
		return this.descripcionDescritores;
	}

	public void setDescripcionDescritores(String descripcionDescritores) {
		this.descripcionDescritores = descripcionDescritores;
	}

	public Integer getEstadoDescriptor() {
		return this.estadoDescriptor;
	}

	public void setEstadoDescriptor(Integer estadoDescriptor) {
		this.estadoDescriptor = estadoDescriptor;
	}

	public Date getFechaEstado() {
		return this.fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Integer getPuntajeDescriptor() {
		return this.puntajeDescriptor;
	}

	public void setPuntajeDescriptor(Integer puntajeDescriptor) {
		this.puntajeDescriptor = puntajeDescriptor;
	}

	public Integer getPuntajeDescriptores() {
		return this.puntajeDescriptores;
	}

	public void setPuntajeDescriptores(Integer puntajeDescriptores) {
		this.puntajeDescriptores = puntajeDescriptores;
	}

	public Variable getVariable() {
		return this.variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public List<PuntajeRevisor> getPuntajeRevisor() {
		return this.puntajeRevisor;
	}

	public void setPuntajeRevisor(List<PuntajeRevisor> puntajeRevisor) {
		this.puntajeRevisor = puntajeRevisor;
	}

	public PuntajeRevisor addPuntajeRevisor(PuntajeRevisor puntajeRevisor) {
		getPuntajeRevisor().add(puntajeRevisor);
		puntajeRevisor.setDescriptores(this);

		return puntajeRevisor;
	}

	public PuntajeRevisor removePuntajeRevisor(PuntajeRevisor puntajeRevisor) {
		getPuntajeRevisor().remove(puntajeRevisor);
		puntajeRevisor.setDescriptores(null);

		return puntajeRevisor;
	}

}