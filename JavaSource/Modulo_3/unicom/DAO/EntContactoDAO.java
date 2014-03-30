/**
 * 
 */
package Modulo_3.unicom.DAO;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.EntContacto;
import Modulo_3.unicom.dm.Entitys.EntEntidad;

/**
 * @author Eduar
 *
 */
@Local
public interface EntContactoDAO {
	
	public EntContacto buscarPorEntidadYOrden(EntEntidad entidad, String orden);

}
