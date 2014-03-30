package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ejecucion_cronograma database table.
 * 
 */
@Entity
@Table(name="ejecucion_cronograma")
public class EjecucionCronograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EJECUCION_CRONOGRAMA_IDEJECUCIONCRONOGRAMA_GENERATOR", sequenceName="EJECUCION_CRONOGRAMA_ID_EJECUCION_CRONOGRAMA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EJECUCION_CRONOGRAMA_IDEJECUCIONCRONOGRAMA_GENERATOR")
	@Column(name="id_ejecucion_cronograma")
	private Integer idEjecucionCronograma;

	@Column(name="descripci_ejecucion")
	private String descripciEjecucion;

	@Column(name="estado_cronograma")
	private Integer estadoCronograma;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="ejecucionCronograma")
	private List<Proyecto> proyecto;

	public EjecucionCronograma() {
	}

	public Integer getIdEjecucionCronograma() {
		return this.idEjecucionCronograma;
	}

	public void setIdEjecucionCronograma(Integer idEjecucionCronograma) {
		this.idEjecucionCronograma = idEjecucionCronograma;
	}

	public String getDescripciEjecucion() {
		return this.descripciEjecucion;
	}

	public void setDescripciEjecucion(String descripciEjecucion) {
		this.descripciEjecucion = descripciEjecucion;
	}

	public Integer getEstadoCronograma() {
		return this.estadoCronograma;
	}

	public void setEstadoCronograma(Integer estadoCronograma) {
		this.estadoCronograma = estadoCronograma;
	}

	public List<Proyecto> getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyecto().add(proyecto);
		proyecto.setEjecucionCronograma(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyecto().remove(proyecto);
		proyecto.setEjecucionCronograma(null);

		return proyecto;
	}

}