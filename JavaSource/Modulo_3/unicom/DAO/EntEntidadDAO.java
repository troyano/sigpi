/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;
import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.EntEntidad;

/**
 * @author Eduar
 *
 */
@Local
public interface EntEntidadDAO {
	
	public List<EntEntidad> buscarPorDosParametros(String parametro1, String parametro2);

}
