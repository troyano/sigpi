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

import Modulo_3.unicom.DAO.ActividadDAO;
import Modulo_3.unicom.dm.Entitys.Actividad;
import Modulo_3.unicom.dm.Entitys.Fase;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("actividadDAO")
public class ActividadJpaDAO implements ActividadDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(ActividadJpaDAO.class.getSimpleName());

	public ActividadJpaDAO() {

	}

//@Table(name = "actividad", catalog = "sigpi", schema = "public")
//@NamedQueries({
//			@NamedQuery(name = "act.findAll", query = "SELECT A FROM Actividad a "),
//			@NamedQuery(name = "act.findById", query = "SELECT A FROM Actividad a WHERE a.idActividad=:idActividad "),
//			@NamedQuery(name = "act.findByFase", query = "SELECT A FROM Actividad a WHERE a.fase=:fase ") })

	@SuppressWarnings("unchecked")
	@Override
	public List<Actividad> buscarPorFase(Fase fase) {
		try {
			log.debug("+++++++ buscarPorFase 1.1");
			Query q = null;
			q = em.createNamedQuery("fase.findByProyecto");
			q.setParameter("fase", fase);
			List<Actividad> res = q.getResultList();
			return res;
		} catch (NoResultException nre) {
			log.debug("+++++++ buscarPorFase 1.2");
			return null;
		} catch (Exception e) {
			log.debug("+++++++ buscarPorFase 1.3");
			return null;
		}
	}

	@Override
	public void eliminar(Actividad selectedActividad) {

		try {
//			em.remove(em.merge(selectedActividad));
			Query query = em.createQuery("DELETE FROM Actividad  WHERE idActividad=:id ");
			@SuppressWarnings("unused")
			int deletedCount = query.setParameter("id", selectedActividad.getIdActividad()).executeUpdate();
			//log.info("+++++ -- "+deletedCount);
		} catch (Exception e) {
			log.info("delete 1.0");
			//e.printStackTrace();
		}
	}
}
