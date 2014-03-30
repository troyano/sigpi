/**
 * 
 */
package Modulo_3.unicom.dm;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.EntidadProyectoDAO;
import Modulo_3.unicom.dm.Entitys.EntidadProyecto;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("entidadProyectoDAO")
public class EntidadProyectoJpaDAO implements EntidadProyectoDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntidadProyectoJpaDAO.class.getSimpleName());

	public EntidadProyectoJpaDAO() {

	}
//@Table(name = "entidad_proyecto", catalog = "sigpi", schema = "public")
//@NamedQueries({
//			@NamedQuery(name = "enp.findAll", query = "SELECT ENP FROM EntidadProyecto enp "),
//			@NamedQuery(name = "enp.findById", query = "SELECT ENP FROM EntidadProyecto enp WHERE enp.idEntidadProyecto=:idEntidadProyecto "),
//			@NamedQuery(name = "enp.findByProyecto", query = "SELECT ENP FROM EntidadProyecto enp WHERE enp.proyecto=:proyecto ") })

	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadProyecto> buscarPorProyecto(Proyecto proyecto) {

		try {
			log.debug("+++++++ buscarPorProyecto 1.1");
			Query q = null;
			q = em.createNamedQuery("enp.findByProyecto");
			q.setParameter("proyecto", proyecto);
			List<EntidadProyecto> res =  q.getResultList();
			return res;
		} catch (NoResultException nre) {
			log.debug("+++++++ buscarPorProyecto 1.2");
			return null;
		} catch (Exception e) {
			log.debug("+++++++ buscarPorProyecto 1.3");
			return null;
		}
	}

}
