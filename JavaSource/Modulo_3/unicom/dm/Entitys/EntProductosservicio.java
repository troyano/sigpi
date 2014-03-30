package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ent_productosservicios database table.
 * 
 */
@Entity
@Table(name = "ent_productosservicios", catalog = "sigpi", schema = "public")
@NamedQueries({
		@NamedQuery(name = "ps.findAll", query = "SELECT PS FROM EntProductosservicio ps"),
		@NamedQuery(name = "ps.findById", query = "SELECT PS FROM EntProductosservicio ps WHERE ps.idProductosServicios = :idProductosServicios "),
		@NamedQuery(name = "ps.findByEntidad", query = "SELECT PS FROM EntProductosservicio ps WHERE ps.entEntidad = :entEntidad ") })
public class EntProductosservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ENT_PRODUCTOSSERVICIOS_IDPRODUCTOSSERVICIOS_GENERATOR", sequenceName = "ENT_PRODUCTOSSERVICIOS_ID_PRODUCTOS_SERVICIOS_SEQ", allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENT_PRODUCTOSSERVICIOS_IDPRODUCTOSSERVICIOS_GENERATOR")
	@Column(name = "id_productos_servicios")
	private Integer idProductosServicios;

	@Column(name = "estado_produc_serv")
	private Integer estadoProducServ;

	private Integer exportacion;

	@Column(name = "nombre_producto_servicio")
	private String nombreProductoServicio;

	// bi-directional many-to-one association to EntCiiu
	@ManyToOne
	@JoinColumn(name = "id_ciiu")
	private EntCiiu entCiiu;

	// bi-directional many-to-one association to EntEntidad
	@ManyToOne
	@JoinColumn(name = "id_ent_entidad")
	private EntEntidad entEntidad;

	// bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;

	public EntProductosservicio() {
	}

	public Integer getIdProductosServicios() {
		return this.idProductosServicios;
	}

	public void setIdProductosServicios(Integer idProductosServicios) {
		this.idProductosServicios = idProductosServicios;
	}

	public Integer getEstadoProducServ() {
		return this.estadoProducServ;
	}

	public void setEstadoProducServ(Integer estadoProducServ) {
		this.estadoProducServ = estadoProducServ;
	}

	public Integer getExportacion() {
		return this.exportacion;
	}

	public void setExportacion(Integer exportacion) {
		this.exportacion = exportacion;
	}

	public String getNombreProductoServicio() {
		return this.nombreProductoServicio;
	}

	public void setNombreProductoServicio(String nombreProductoServicio) {
		this.nombreProductoServicio = nombreProductoServicio;
	}

	public EntCiiu getEntCiiu() {
		return this.entCiiu;
	}

	public void setEntCiiu(EntCiiu entCiiu) {
		this.entCiiu = entCiiu;
	}

	public EntEntidad getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(EntEntidad entEntidad) {
		this.entEntidad = entEntidad;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}