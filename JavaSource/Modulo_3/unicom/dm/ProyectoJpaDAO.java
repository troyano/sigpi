/**
 * 
 */
package Modulo_3.unicom.dm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Modulo_3.unicom.DAO.ProyectoDAO;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("proyectoDAO")
public class ProyectoJpaDAO implements ProyectoDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger.getLogger(ProyectoJpaDAO.class.getSimpleName());

	public ProyectoJpaDAO() {

	}

	// @Table(name = "proyecto", catalog = "sigpi", schema = "public")
	// @NamedQueries({
	// @NamedQuery(name = "pry.findAll", query =
	// "SELECT PRY FROM Proyecto pry"),
	// @NamedQuery(name = "pry.findById", query =
	// "SELECT PRY FROM Proyecto pry WHERE pry.idProyecto = :idProyecto"),
	// @NamedQuery(name = "pry.findByEstado", query =
	// "SELECT PRY FROM Proyecto pry WHERE pry.estadoProyecto= :estadoProyecto")
	// })

	public Proyecto buscarPorId(int id) {

		try {
			log.info(" buscarPorId 1.0--" + id);
			Query q = em.createNamedQuery("pry.findById");
			q.setParameter("idProyecto", id);

			Proyecto res = (Proyecto) q.getSingleResult();
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

	@SuppressWarnings("unchecked")
	public List<Proyecto> buscarPorEstado(int estado) {

		try {
			log.debug("+++++++ buscarPorEstado1.1");
			Query q = null;
			q = em.createNamedQuery("pry.findByEstado");
			q.setParameter("estadoProyecto", estado);
			List<Proyecto> res = (List<Proyecto>) q.getResultList();
			return res;
		} catch (NoResultException nre) {
			log.debug("+++++++ buscarPorEstado1.2");
			return null;
		} catch (Exception e) {
			log.debug("+++++++ buscarPorEstado1.3");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarPorCatalogo(Proyecto proyectoBuscar,
			int estado, Date fechaInicial, Date fechaFinal) {
		Query q = null;
		StringBuilder sql = new StringBuilder();
		String where = " WHERE ";
		String and = " AND ";
		
		try {
//			log.info(" buscarPorCatalogo 1.0");
			sql.append("SELECT pro FROM ");
			sql.append(Proyecto.class.getSimpleName() + " pro ");
			sql.append(where);
			sql.append(" pro.estadoProyecto = ");
			sql.append(estado + " ");

			if (proyectoBuscar.getNombreProyecto() != null) {
				
				sql.append(and);
				sql.append(" pro.nombreProyecto like '%");
				sql.append(proyectoBuscar.getNombreProyecto() + "%' ");
			}

			if (fechaInicial != null || fechaFinal != null) {
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String inicial = format.format(fechaInicial);
				String fin = format.format(fechaFinal);
				
				sql.append(and);
				sql.append(" pro.fechaCreacion between to_date ('");
				sql.append(inicial);
				sql.append("', 'yyyy-MM-dd') and to_date ('");
				sql.append(fin + "', 'yyyy-MM-dd') ");
			}

//			log.info(" SQL = " + sql.toString());
			q = em.createQuery(sql.toString());

			List<Proyecto> res = q.getResultList();

			return res;
		}catch(NullPointerException npe){
			log.info(" buscarPorCatalogo 1.1");
			return null;
		}catch (Exception e) {
			log.info(" buscarPorCatalogo 1.2");
			//e.printStackTrace();
			return null;
		}

	}
}
