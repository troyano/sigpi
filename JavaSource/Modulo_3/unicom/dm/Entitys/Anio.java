package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the anio database table.
 * 
 */
@Entity
@Table(name="anio",catalog="sigpi",schema="public")
@NamedQueries({
	@NamedQuery(name = "an.findAll", query = "SELECT AN FROM Anio an"),
	@NamedQuery(name = "an.findById", query = "SELECT AN FROM Anio an WHERE an.idAnio = :idAnio "),
	@NamedQuery(name = "an.findByAnio", query = "SELECT AN FROM Anio an  WHERE an.estadoAnio = :estadoAnio ORDER BY an.anio ASC ")})

public class Anio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANIO_IDANIO_GENERATOR", sequenceName="ANIO_ID_ANIO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANIO_IDANIO_GENERATOR")
	@Column(name="id_anio")
	private Integer idAnio;

	private Integer anio;

	@Column(name="estado_anio")
	private Integer estadoAnio;

	//bi-directional many-to-one association to EntFinancieraAnio
	@OneToMany(mappedBy="anio")
	private List<EntFinancieraAnio> entFinancieraAnios;

	public Anio() {
	}

	public Integer getIdAnio() {
		return this.idAnio;
	}

	public void setIdAnio(Integer idAnio) {
		this.idAnio = idAnio;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getEstadoAnio() {
		return this.estadoAnio;
	}

	public void setEstadoAnio(Integer estadoAnio) {
		this.estadoAnio = estadoAnio;
	}

	public List<EntFinancieraAnio> getEntFinancieraAnios() {
		return this.entFinancieraAnios;
	}

	public void setEntFinancieraAnios(List<EntFinancieraAnio> entFinancieraAnios) {
		this.entFinancieraAnios = entFinancieraAnios;
	}

	public EntFinancieraAnio addEntFinancieraAnio(EntFinancieraAnio entFinancieraAnio) {
		getEntFinancieraAnios().add(entFinancieraAnio);
		entFinancieraAnio.setAnio(this);

		return entFinancieraAnio;
	}

	public EntFinancieraAnio removeEntFinancieraAnio(EntFinancieraAnio entFinancieraAnio) {
		getEntFinancieraAnios().remove(entFinancieraAnio);
		entFinancieraAnio.setAnio(null);

		return entFinancieraAnio;
	}

}