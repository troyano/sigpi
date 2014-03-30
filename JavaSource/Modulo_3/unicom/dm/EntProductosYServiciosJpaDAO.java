/**
 * 
 */
package Modulo_3.unicom.dm;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.EntProductosYServiciosDAO;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntProductosservicio;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("entProductosYServiciosDAO")
public class EntProductosYServiciosJpaDAO implements EntProductosYServiciosDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntProductosservicio.class
			.getSimpleName());

	public EntProductosYServiciosJpaDAO() {

	}

//	@Table(name = "ent_productosservicios", catalog = "sigpi", schema = "public")
//	@NamedQueries({
//			@NamedQuery(name = "ps.findAll", query = "SELECT PS FROM EntProductosservicio ps"),
//			@NamedQuery(name = "ps.findById", query = "SELECT PS FROM EntProductosservicio ps WHERE ps.idProductosServicios = :idProductosServicios "),
//			@NamedQuery(name = "ps.findByEntidad", query = "SELECT PS FROM EntProductosservicio ps WHERE ps.entEntidad = :entEntidad ") })

	@SuppressWarnings("unchecked")
	@Override
	public List<EntProductosservicio> buscarPorEntidad(EntEntidad entidad) {

		Query q = null;

		log.info("+++++++ buscarPorEntidad 1.1");
		q = em.createNamedQuery("ps.findByEntidad");
		q.setParameter("entEntidad", entidad);

		try {
			log.info("+++++++ buscarPorEntidad 1.3");
			List<EntProductosservicio> res = q.getResultList();
			return res;
		} catch (Exception e) {
			log.info("+++++++ buscarPorEntidad 1.3");
			e.printStackTrace();
			return null;
		}
	}

}
