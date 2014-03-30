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

import Modulo_3.unicom.DAO.PersonalProyectoDAO;
import Modulo_3.unicom.dm.Entitys.Personal;
import Modulo_3.unicom.dm.Entitys.PersonalProyecto;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 * 
 */
@Stateless
@Named("personalProyectoDAO")
public class PersonalProyectoJpaDAO implements PersonalProyectoDAO {

	@PersistenceContext(unitName = "Modulo_2")
	private EntityManager em;
	static Logger log = Logger
			.getLogger(PersonalProyecto.class.getSimpleName());

	public PersonalProyectoJpaDAO() {

	}

	// @Table(name = "personal_proyecto", catalog = "sigpi", schema = "public")
	// @NamedQueries({
	// @NamedQuery(name = "pp.findAll", query =
	// "SELECT PP FROM PersonalProyecto pp"),
	// @NamedQuery(name = "pp.findById", query =
	// "SELECT PP FROM PersonalProyecto pp WHERE pp.idPersonalProyecto = :idPersonalProyecto"),
	// //
	// // @NamedQuery(name = "pp.findBySedePrograma", query =
	// "SELECT PP FROM PersonalProyecto pp WHERE pp.sedePrograma = :sedePrograma"),
	// //
	// // @NamedQuery(name = "pp.findByNombreProyecto", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.proyecto pro WHERE pro.nombreProyecto like :nombreProyecto"),
	// //
	// // @NamedQuery(name = "pp.findByIdenPersonal", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per WHERE per.identificacion like :identificacion"),
	// // @NamedQuery(name = "pp.findByPnombrePersonal", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per WHERE per.primerNombre like :primerNombre"),
	// // @NamedQuery(name = "pp.findByPapellidoPersonal", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per WHERE per.primerApellido like :primerApellido"),
	// //
	// // @NamedQuery(name = "pp.findByIdenApellNomPersonal", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per "
	// // + "WHERE per.identificacion like :identificacion "
	// // + "AND per.primerNombre like :primerNombre "
	// // + "AND per.primerApellido like :primerApellido "),
	// // @NamedQuery(name = "pp.findByIdenApellNomPersonal", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per "
	// // + "WHERE per.identificacion like :identificacion "
	// // + "AND per.primerNombre like :primerNombre "),
	// // @NamedQuery(name = "pp.findByIdenApellNomPersonal", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per "
	// // + "WHERE per.identificacion like :identificacion "
	// // + "AND per.primerApellido like :primerApellido "),
	// // @NamedQuery(name = "pp.findByIdenApellNomPersonal", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per "
	// // + "WHERE per.primerNombre like :primerNombre "
	// // + "AND per.primerApellido like :primerApellido "),
	//
	// @NamedQuery(name = "pp.findByCatalogoAll", query =
	// "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per JOIN pp.proyecto pro "
	// + "WHERE per.identificacion like :identificacion "
	// + "AND per.primerNombre like :primerNombre "
	// + "AND per.primerApellido like :primerApellido "
	// + "AND pro.nombreProyecto like :nombreProyecto "
	// + "AND pp.sedePrograma = :sedePrograma") })

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalProyecto> buscarPorCatalogo(
			PersonalProyecto personalProyectoBuscar, Personal personalBuscar,
			Proyecto proyectoBuscar) {
		Query q = null;
		StringBuilder sql = new StringBuilder();
		String where = "WHERE";
		String and = "AND";
		boolean personalProyecto = false;
		boolean proyecto = false;
		log.info(" buscarPorCatalogo ");
		try {

			sql.append("SELECT pp FROM ");
			sql.append(PersonalProyecto.class.getSimpleName()+" pp ");
			sql.append(" JOIN pp.personal per JOIN pp.proyecto pro  ");
			
			if (personalProyectoBuscar != null || personalBuscar != null
					|| proyectoBuscar != null) {

				sql.append(where);

				if (personalProyectoBuscar.getSedePrograma() != null) {
					sql.append(" pp.sedePrograma = ");
					sql.append(personalProyectoBuscar.getSedePrograma().getIdSedePrograma()+" ");
					personalProyecto = true;
				}

				if (proyectoBuscar != null) {
					if (personalProyecto) {
						sql.append(and);
					}
					if (proyectoBuscar.getNombreProyecto() != null || proyectoBuscar.getNombreProyecto() != "") {
						sql.append(" pro.nombreProyecto like '%");
						sql.append(proyectoBuscar.getNombreProyecto()+"%' ");
						proyecto = true;
					}
				}

				if (personalBuscar != null) {
					if (proyecto) {
						sql.append(and);
					}
					if (personalBuscar.getIdentificacion() != null || personalBuscar.getIdentificacion() != "" ) {
						sql.append(" per.identificacion like '%");
						sql.append(personalBuscar.getIdentificacion()+"%' ");
					}
					if (personalBuscar.getPrimerNombre() != null ||  personalBuscar.getPrimerNombre() != "") {
						sql.append(and);
						sql.append(" per.primerNombre like '%");
						sql.append(personalBuscar.getPrimerNombre()+"%' ");
					}
					if (personalBuscar.getPrimerApellido() != null || personalBuscar.getPrimerApellido() != "") {
						sql.append(and);
						sql.append(" per.primerApellido like '%");
						sql.append(personalBuscar.getPrimerNombre()+"%' ");
					}
				}

			}
			log.info(" SQL = "+sql.toString());
			q = em.createQuery(sql.toString());
		
			List<PersonalProyecto> res = q.getResultList();

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
