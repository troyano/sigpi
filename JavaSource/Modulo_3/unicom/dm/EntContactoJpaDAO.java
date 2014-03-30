/**
 * 
 */
package Modulo_3.unicom.dm;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.EntContactoDAO;
import Modulo_3.unicom.dm.Entitys.EntContacto;
import Modulo_3.unicom.dm.Entitys.EntEntidad;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("entContactoDAO")
public class EntContactoJpaDAO implements EntContactoDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntContacto.class.getSimpleName());

	public EntContactoJpaDAO() {

	}

//	@Table(name="ent_contacto",catalog="sigpi",schema="public")
//	@NamedQueries({
//			@NamedQuery(name = "c.findAll", query = "SELECT C FROM EntContacto c"),
//			@NamedQuery(name = "c.findById", query = "SELECT C FROM EntContacto c WHERE c.idContacto = :idContacto"),
//			@NamedQuery(name = "c.buscarPorEntidadYOrden", query = "SELECT C FROM EntContacto c WHERE c.entEntidad = :entEntidad AND c.orden = :orden ")})

	@Override
	public EntContacto buscarPorEntidadYOrden(EntEntidad entidad,
			String orden) {

		try {
			log.debug("+++++++ buscarPorEntidadYOrden 1.1");
			Query q = null;
			q = em.createNamedQuery("c.buscarPorEntidadYOrden");
			q.setParameter("entEntidad", entidad);
			q.setParameter("orden", orden);
			EntContacto res = (EntContacto) q.getSingleResult();
			return res;
		} catch(NoResultException nre){
			return null;
		} catch (Exception e) {
			return null;
		}

	}
	
}
