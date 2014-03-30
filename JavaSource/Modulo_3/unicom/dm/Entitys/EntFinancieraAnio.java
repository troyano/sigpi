package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the ent_financiera_anio database table.
 * 
 */
@Entity
@Table(name = "ent_financiera_anio", catalog = "sigpi", schema = "public")
 @NamedQueries({ 
 @NamedQuery(name = "fn.findAll", query = "SELECT FN FROM EntFinancieraAnio fn"),
 @NamedQuery(name = "fn.findById", query = "SELECT FN FROM EntFinancieraAnio fn WHERE fn.idFinancieraAnio = :idFinancieraAnio "),
 @NamedQuery(name = "fn.findBySituacionF", query = "SELECT FN FROM EntFinancieraAnio fn WHERE fn.entSituacionFinanciera = :entSituacionFinanciera ORDER BY fn.anio ASC ") })
public class EntFinancieraAnio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_FINANCIERA_ANIO_IDFINANCIERAANIO_GENERATOR", sequenceName="ENT_FINANCIERA_ANIO_ID_FINANCIERA_ANIO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_FINANCIERA_ANIO_IDFINANCIERAANIO_GENERATOR")
	@Column(name="id_financiera_anio")
	private Integer idFinancieraAnio;

	private Double valor;
	
	//bi-directional many-to-one association to Anio
	@ManyToOne
	@JoinColumn(name="id_anio")
	private Anio anio;

	//bi-directional many-to-one association to EntSituacionFinanciera
	@ManyToOne
	@JoinColumn(name="id_financiera")
	private EntSituacionFinanciera entSituacionFinanciera;

	public EntFinancieraAnio() {
	}

	public Integer getIdFinancieraAnio() {
		return this.idFinancieraAnio;
	}

	public void setIdFinancieraAnio(Integer idFinancieraAnio) {
		this.idFinancieraAnio = idFinancieraAnio;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public void setAnio(Anio anio) {
		this.anio = anio;
	}

	public EntSituacionFinanciera getEntSituacionFinanciera() {
		return this.entSituacionFinanciera;
	}

	public void setEntSituacionFinanciera(EntSituacionFinanciera entSituacionFinanciera) {
		this.entSituacionFinanciera = entSituacionFinanciera;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}