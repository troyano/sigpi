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

import Modulo_3.unicom.DAO.FaseDAO;
import Modulo_3.unicom.dm.Entitys.Fase;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("faseDAO")
public class FaseJpaDAO implements FaseDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(FaseJpaDAO.class.getSimpleName());

	public FaseJpaDAO() {

	}
//@Table(name = "fase", catalog = "sigpi", schema = "public")
//@NamedQueries({
//			@NamedQuery(name = "fase.findAll", query = "SELECT F FROM Fase f "),
//			@NamedQuery(name = "fase.findById", query = "SELECT F FROM Fase f WHERE f.idFase=:idFase "),
//			@NamedQuery(name = "fase.findByProyecto", query = "SELECT F FROM Fase f WHERE f.proyecto=:proyecto ") })
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Fase> buscarPorProyecto(Proyecto proyecto) {

		try {
			log.debug("+++++++ buscarPorProyecto 1.1");
			Query q = null;
			q = em.createNamedQuery("fase.findByProyecto");
			q.setParameter("proyecto", proyecto);
			List<Fase> res =  q.getResultList();
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
