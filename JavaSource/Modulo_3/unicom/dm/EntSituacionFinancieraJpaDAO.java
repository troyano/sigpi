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

import Modulo_3.unicom.DAO.EntSituacionFinacieraDAO;
import Modulo_3.unicom.dm.Entitys.Anio;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntSituacionFinanciera;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("entSituacionFinancieraDAO")
public class EntSituacionFinancieraJpaDAO implements EntSituacionFinacieraDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntSituacionFinanciera.class
			.getSimpleName());

	public EntSituacionFinancieraJpaDAO() {

	}
//
//	@NamedQueries({
//		@NamedQuery(name = "sf.findAll", query = "SELECT SF FROM EntSituacionFinanciera sf"),
//		@NamedQuery(name = "sf.findById", query = "SELECT SF FROM EntSituacionFinanciera sf WHERE sf.idEntidadVariable = :idEntidadVariable "),
//		@NamedQuery(name = "sf.findByEntidad", query = "SELECT SF FROM EntSituacionFinanciera sf WHERE sf.entEntidad = :entEntidad "),
//		@NamedQuery(name = "sf.findByMaxId", query = "SELECT SF FROM EntSituacionFinanciera sf WHERE sf.idEntidadVariable = (SELECT MAX(sff.idEntidadVariable) FROM EntSituacionFinanciera sff) ")})

	
	@SuppressWarnings("unchecked")
	public List<EntSituacionFinanciera> buscarPorEntidad(EntEntidad entidad) {

		Query q = null;
		
		String sql = "SELECT fin FROM "
				+ EntSituacionFinanciera.class.getSimpleName() + " fin "
				+ " JOIN fin.entEntidad ent " 
				+ " JOIN fin.entIndicador ind "
				+ " JOIN ind.entVariable var "
				+ " WHERE ent.idEntEntidad = :entEntidad";
		q = em.createQuery(sql);
		q.setParameter("entEntidad", entidad.getIdEntEntidad());

		try {
			
			List<EntSituacionFinanciera> res = q.getResultList();
			return res;
		} catch (Exception e) {
			log.info("+++++++ buscarPorEntidad 1.3+++");
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Anio> buscarAniosByEstado(int estado) {
		
		Query q = em.createNamedQuery("an.findByAnio");
		q.setParameter("estadoAnio",estado);
		List<Anio> res = q.getResultList();
		return res;
	}



}
