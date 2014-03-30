/**
 * 
 */
package Modulo_3.unicom.dm;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.EntFinancieraAnioDAO;
import Modulo_3.unicom.dm.Entitys.Anio;
import Modulo_3.unicom.dm.Entitys.EntFinancieraAnio;
import Modulo_3.unicom.dm.Entitys.EntSituacionFinanciera;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("entFinancieraAnioDAO")
public class EntFinancieraAnioJpaDAO implements EntFinancieraAnioDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntFinancieraAnio.class
			.getSimpleName());

	public EntFinancieraAnioJpaDAO() {

	}

	// @Table(name = "ent_financiera_anio", catalog = "sigpi", schema =
	// "public")
	// @NamedQueries({
	// @NamedQuery(name = "fn.findAll", query =
	// "SELECT FN FROM EntFinancieraAnio fn"),
	// @NamedQuery(name = "fn.findById", query =
	// "SELECT FN FROM EntFinancieraAnio fn WHERE fn.idFinancieraAnio = :idFinancieraAnio "),
	// @NamedQuery(name = "fn.findBySituacionF", query =
	// "SELECT FN FROM EntFinancieraAnio fn WHERE fn.entSituacionFinanciera = :entSituacionFinanciera ")
	// })

	@SuppressWarnings("unchecked")
	@Override
	public List<EntFinancieraAnio> buscarPorSituacionFinanciera(
			EntSituacionFinanciera entity) {

		Query q = null;

		q = em.createNamedQuery("fn.findBySituacionF");
		q.setParameter("entSituacionFinanciera", entity);

		try {

			List<EntFinancieraAnio> res = q.getResultList();
			return res;
		} catch (Exception e) {
			log.info("+++++++ buscarPorSituacionFinanciera 1.3+++");
			e.printStackTrace();
			return null;
		}

	}

	public EntSituacionFinanciera lastID() {

		Query q = em.createNamedQuery("sf.findByMaxId");
		try {
			return (EntSituacionFinanciera) q.getSingleResult();
		} catch (NoResultException nre) {
			log.info(" no resul");
			return null;
		} catch (Exception e) {
			log.info(" exeption");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean crearFinancieraAnioListas(List<Anio> anios,
			ArrayList<Double> valores) {

		try {

			EntSituacionFinanciera situacion = lastID();
			int i = 0;
			for (Anio a : anios) {
				EntFinancieraAnio financieraAnio = new EntFinancieraAnio();

				financieraAnio.setEntSituacionFinanciera(situacion);
				financieraAnio.setAnio(a);
				financieraAnio.setValor(valores.get(i));

				em.merge(financieraAnio);
				i++;
			}

			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
