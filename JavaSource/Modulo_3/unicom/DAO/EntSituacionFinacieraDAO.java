/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.Anio;
import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntSituacionFinanciera;

/**
 * @author Eduar
 *
 */
@Local
public interface EntSituacionFinacieraDAO {
	
	
	public List<EntSituacionFinanciera> buscarPorEntidad(EntEntidad entidad);
	
	public List<Anio> buscarAniosByEstado(int estado);

}
