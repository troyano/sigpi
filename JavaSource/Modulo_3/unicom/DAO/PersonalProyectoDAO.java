/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.Personal;
import Modulo_3.unicom.dm.Entitys.PersonalProyecto;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 *
 */
@Local
public interface PersonalProyectoDAO {
	
	public List<PersonalProyecto> buscarPorCatalogo(
			PersonalProyecto personalProyectoBuscar, Personal personalBuscar,
			Proyecto proyectoBuscar);

}
