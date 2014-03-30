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

import Modulo_3.unicom.DAO.EntRolEntidadDAO;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntRolentidad;
import Modulo_3.unicom.dm.Entitys.EntTipoEntidad;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("entRolEntidadDAO")
public class EntRolEntidadJpaDAO implements EntRolEntidadDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(EntTipoEntidad.class.getSimpleName());

	// @Table(name = "ent_rolentidad", catalog = "sigpi", schema = "public")
	// @NamedQueries({
	// @NamedQuery(name = "rol.findAll", query =
	// "SELECT ROL FROM EntRolentidad rol"),
	// @NamedQuery(name = "rol.findById", query =
	// "SELECT ROL FROM EntRolentidad rol WHERE rol.idRolEntidad = :idRolEntidad"),
	// @NamedQuery(name = "rol.findByProEntNO", query =
	// "SELECT ROL FROM EntRolentidad rol WHERE NOT EXISTS (SELECT EP FROM EntidadProyecto ep WHERE ep.proyecto=:proyecto AND ep.entEntidad=:entEntidad AND ep.entRolentidad=rol.idRolEntidad )")
	// })

	public List<EntRolentidad> buscarPorProEntRol(Proyecto proyecto,
			EntEntidad entidad) {

		try {
//			log.info("buscarPorProEntRol 1.0");
			Query q = em.createNamedQuery("rol.findByProEntNO");
			q.setParameter("proyecto", proyecto);
			q.setParameter("entEntidad", entidad);
			@SuppressWarnings("unchecked")
			List<EntRolentidad> res = q.getResultList();

			return res;

		} catch (Exception e) {
			log.info("buscarPorProEntRol 1.1");
			return null;
		}

	}
	
	public List<EntRolentidad> buscarPorProEntRol2(Proyecto proyecto,
			EntEntidad entidad) {

		try {
//			log.info("buscarPorProEntRol 1.0");
			Query q = em.createNamedQuery("rol.findByProEntNOn");
			q.setParameter("proyecto", proyecto);
			q.setParameter("entEntidad", entidad);
			@SuppressWarnings("unchecked")
			List<EntRolentidad> res = q.getResultList();

			return res;

		} catch (Exception e) {
			log.info("buscarPorProEntRol 1.1");
			return null;
		}

	}


}
