package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the region database table.
 * 
 */
@Entity
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGION_IDREGION_GENERATOR", sequenceName="REGION_ID_REGION_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGION_IDREGION_GENERATOR")
	@Column(name="id_region")
	private Integer idRegion;

	@Column(name="estado_region")
	private Integer estadoRegion;

	@Column(name="nombre_region")
	private String nombreRegion;

	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="region")
	private List<Departamento> departamento;

	public Region() {
	}

	public Integer getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	public Integer getEstadoRegion() {
		return this.estadoRegion;
	}

	public void setEstadoRegion(Integer estadoRegion) {
		this.estadoRegion = estadoRegion;
	}

	public String getNombreRegion() {
		return this.nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public List<Departamento> getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(List<Departamento> departamento) {
		this.departamento = departamento;
	}

	public Departamento addDepartamento(Departamento departamento) {
		getDepartamento().add(departamento);
		departamento.setRegion(this);

		return departamento;
	}

	public Departamento removeDepartamento(Departamento departamento) {
		getDepartamento().remove(departamento);
		departamento.setRegion(null);

		return departamento;
	}

}