/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;
import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntProductosservicio;

/**
 * @author Eduar
 *
 */
@Local
public interface EntProductosYServiciosDAO {
	
	public List<EntProductosservicio> buscarPorEntidad(EntEntidad entidad);

}
