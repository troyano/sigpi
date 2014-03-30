/**
 * 
 */
package Modulo_3.unicom.dm;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.PersonalDAO;
import Modulo_3.unicom.dm.Entitys.Personal;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("PersonalDAO")
public class PersonalJpaDAO implements PersonalDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(Personal.class.getSimpleName());

	public PersonalJpaDAO() {

	}

	// @Table(name = "personal",catalog="sigpi",schema="public")
	// @NamedQueries({
	// @NamedQuery(name = "per.findAll", query =
	// "SELECT PER FROM Personal per"),
	// @NamedQuery(name = "per.findById", query =
	// "SELECT PER FROM Personal per WHERE per.idPersonal = :idPersonal")})

//	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)


	public Personal buscarPorId(int id) {

		try {
			log.info(" buscarPorId 1.0--"+id);
			Query q = em.createNamedQuery("per.findById");
			q.setParameter("idPersonal", id);

			Personal res = (Personal) q.getSingleResult();
			return res;
		} catch (NoResultException nre) {
			log.info(" buscarPorId 1.1--");
			return null;
		} catch (EJBException ejb) {
			log.info(" buscarPorId 1.2--");
			return null;
		} catch (IllegalStateException il) {
			log.info(" buscarPorId 1.3--");
			return null;
		} catch (Exception e) {
			log.info(" buscarPorId 1.4--");
			return null;
		}

	}
}
