/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.EntSector;
import Modulo_3.unicom.dm.Entitys.EntTipoEntidad;

/**
 * @author Eduar
 *
 */
@Local
public interface EntTipoEntidadDAO {
	
	public List<EntTipoEntidad> buscarPorSector(EntSector sector);

}
