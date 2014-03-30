package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_rol database table.
 * 
 */
@Entity
@Table(name="seg_rol")
public class SegRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_ROL_IDROL_GENERATOR", sequenceName="SEG_ROL_IDROL_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_ROL_IDROL_GENERATOR")
	@Column(name="id_rol")
	private Integer idRol;

	@Column(name="estado_rol")
	private Integer estadoRol;

	private String rol;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="segRol")
	private List<Personal> personal;

	public SegRol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Integer getEstadoRol() {
		return this.estadoRol;
	}

	public void setEstadoRol(Integer estadoRol) {
		this.estadoRol = estadoRol;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Personal> getPersonal() {
		return this.personal;
	}

	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}

	public Personal addPersonal(Personal personal) {
		getPersonal().add(personal);
		personal.setSegRol(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonal().remove(personal);
		personal.setSegRol(null);

		return personal;
	}

}