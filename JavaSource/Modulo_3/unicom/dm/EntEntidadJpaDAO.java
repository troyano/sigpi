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

import Modulo_3.unicom.DAO.EntEntidadDAO;
import Modulo_3.unicom.dm.Entitys.EntEntidad;

/**
 * @author Eduar
 *
 */
@Stateless
@Named("entEntidadDAO")
public class EntEntidadJpaDAO implements EntEntidadDAO {
	
	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntEntidad.class.getSimpleName()); 
	
    public EntEntidadJpaDAO() {
        
    }
    
//    @Table(name = "ent_entidad",catalog="sigpi",schema="public")
//    @NamedQueries({
//    		@NamedQuery(name = "e.findAll", query = "SELECT E FROM EntEntidad e"),
//    		@NamedQuery(name = "e.findById", query = "SELECT E FROM EntEntidad e WHERE e.idEntEntidad = :idEntEntidad"),
//    		@NamedQuery(name = "e.findByNombreYNumeroId", query = "SELECT E FROM EntEntidad e WHERE e.numeroIdentificacion like :numeroIdentificacion AND  e.nombreEntidad like :nombreEntidad"),
//    		@NamedQuery(name = "e.findByNumeroId", query = "SELECT E FROM EntEntidad e WHERE e.numeroIdentificacion like :numeroIdentificacion"),
//    		@NamedQuery(name = "e.findByNombre", query = "SELECT E FROM EntEntidad e WHERE  e.nombreEntidad like :nombreEntidad")})
    
	@Override
	public List<EntEntidad> buscarPorDosParametros(String parametro1, String parametro2) {
		
		Query q = null;
//		log.info("+++++++ buscarPorDosParametros 1.0  par1 = "+parametro1+" par2 = "+parametro2);
		if(parametro1 == "" && parametro2 == ""){
			log.info("+++++++ buscarPorDosParametros 1.1");
			q = em.createNamedQuery("e.findAll");
		}else if(parametro1 != "" && parametro2 != ""){
			log.info("+++++++ buscarPorDosParametros 1.2");
			q = em.createNamedQuery("e.findByNombreYNumeroId");
			q.setParameter("numeroIdentificacion","%"+ parametro1 +"%");
			q.setParameter("nombreEntidad", "%"+ parametro2 +"%");
			
		}else if(parametro2 != ""  &&  parametro1 == ""){
			log.info("+++++++ buscarPorDosParametros 1.3");
			q = em.createNamedQuery("e.findByNombre");
			q.setParameter("nombreEntidad", "%"+ parametro2 +"%");
			
		}else if(parametro1 !=""  &&  parametro2 == ""){
	    	log.info("+++++++ buscarPorDosParametros 1.4");
			q = em.createNamedQuery("e.findByNumeroId");
			q.setParameter("numeroIdentificacion", "%"+ parametro1 +"%");
		}
//		else{
////			log.info("+++++++ buscarPorDosParametros 1.5");
//			q = em.createNamedQuery("e.findAll");
//		}
		log.debug("+++++++ buscarPorDosParametros 1.6** ");
		log.debug("+++++++ buscarPorDosParametros 1.6-- "+q);
    	@SuppressWarnings("unchecked")
		List<EntEntidad> res = q.getResultList();
    	
		return res;
	}

}
