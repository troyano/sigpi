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

import Modulo_3.unicom.DAO.EntIndicadorDAO;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntIndicador;
import Modulo_3.unicom.dm.Entitys.EntTipoEntidad;
import Modulo_3.unicom.dm.Entitys.EntVariable;

/**
 * @author Eduar
 *
 */
@Stateless
@Named("entIndicadorDAO")
public class EntIndicadorJpaDAO implements EntIndicadorDAO {
	
	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntTipoEntidad.class.getSimpleName()); 
   
//	@Table(name="ent_indicador",catalog="sigpi",schema="public")
//	@NamedQueries({
//		@NamedQuery(name = "ind.findAll", query = "SELECT IND FROM EntIndicador ind"),
//		@NamedQuery(name = "ind.findById", query = "SELECT IND FROM EntIndicador ind WHERE ind.idIndicador = :idIndicador"),
//		@NamedQuery(name = "ind.findByVariable", query = "SELECT IND FROM EntIndicador ind  WHERE ind.entVariable = :entVariable"),
//		@NamedQuery(name = "ind.findByVariableNoR", query = "SELECT IND FROM EntIndicador ind  WHERE ind.entVariable = :entVariable AND NOT EXISTS (SELECT SF FROM EntSituacionFinanciera sf WHERE ind.idIndicador = sf.entIndicador AND sf.entEntidad = :entEntidad)")})
    
	public List<EntIndicador> buscarPorVariable(EntVariable entity) {
		
		Query q = em.createNamedQuery("ind.findByVariable");
		q.setParameter("entVariable",entity);
    	@SuppressWarnings("unchecked")
		List<EntIndicador> res = q.getResultList();
    	
		return res;
	}

	@Override
	public List<EntIndicador> buscarPorVariableNORegistrada(EntVariable variable, EntEntidad  entidad) {

		Query q = em.createNamedQuery("ind.findByVariableNoR");
		q.setParameter("entVariable",variable);
		q.setParameter("entEntidad",entidad);
    	@SuppressWarnings("unchecked")
		List<EntIndicador> res = q.getResultList();
    	
		return res;
	}


}
