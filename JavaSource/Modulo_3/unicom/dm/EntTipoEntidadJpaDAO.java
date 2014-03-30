/**
 * 
 */
package Modulo_3.unicom.dm;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.EntTipoEntidadDAO;
import Modulo_3.unicom.dm.Entitys.EntSector;
import Modulo_3.unicom.dm.Entitys.EntTipoEntidad;

/**
 * @author Eduar
 *
 */
@Stateless
@Named("entTipoEntidadDAO")
public class EntTipoEntidadJpaDAO implements EntTipoEntidadDAO {
	
	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntTipoEntidad.class.getSimpleName()); 
   
//	@Table(name="ent_tipo_entidad",catalog="sigpi",schema="public")
//	@NamedQueries({
//		@NamedQuery(name = "te.findAll", query = "SELECT TE FROM EntTipoEntidad te"),
//		@NamedQuery(name = "te.findById", query = "SELECT TE FROM EntTipoEntidad te WHERE te.idTipoentidad = :idTipoentidad"),
//		@NamedQuery(name = "te.findBySector", query = "SELECT TE FROM EntTipoEntidad te WHERE  te.entSector = :entSector")})
    
	public List<EntTipoEntidad> buscarPorSector(EntSector sector) {
		
		
    	try {
    		
//    		log.info(" sector 1.0--");
    		Query q = em.createNamedQuery("te.findBySector");
    		q.setParameter("entSector",sector);
        	@SuppressWarnings("unchecked")
    		List<EntTipoEntidad> res = q.getResultList();
        	return res;
		} catch(EJBException ejb){
//			log.info(" sector 1.1--");
			return null;
		} catch (IllegalStateException il) {
//			log.info(" sector 1.2--");
			return null;
		}  catch (Exception e) {
//			log.info(" sector 1.3--");
			return null;
		}
		
	}

}
