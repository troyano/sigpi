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

import Modulo_3.unicom.DAO.EntRepresentanteLegalDAO;
import Modulo_3.unicom.dm.Entitys.EntRepresentantelegal;
import Modulo_3.unicom.dm.Entitys.EntTipoEntidad;

/**
 * @author Eduar
 *
 */
@Stateless
@Named("entRepresentanteLegalDAO")
public class EntRepresentanteLegalJpaDAO implements EntRepresentanteLegalDAO {
	
	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntTipoEntidad.class.getSimpleName()); 
   
//	@NamedQueries({
//		@NamedQuery(name = "re.findAll", query = "SELECT RE FROM EntRepresentantelegal re"),
//		@NamedQuery(name = "re.findById", query = "SELECT RE FROM EntRepresentantelegal re WHERE re.idRepresentante = :idRepresentante")})
    
	public EntRepresentantelegal buscarPorId(int id) {
		
		
    	try {

    		Query q = em.createNamedQuery("re.findById");
    		q.setParameter("idRepresentante",id);
        
    		EntRepresentantelegal res = (EntRepresentantelegal) q.getSingleResult();
        	return res;
		}catch(NoResultException nre){
			log.info(" buscarPorId 1.1--");
			return null;
		} catch(EJBException ejb){
			log.info(" buscarPorId 1.2--");
			return null;
		} catch (IllegalStateException il) {
			log.info(" buscarPorId 1.3--");
			return null;
		}  catch (Exception e) {
			log.info(" buscarPorId 1.4--");
			return null;
		}
		
	}

}
