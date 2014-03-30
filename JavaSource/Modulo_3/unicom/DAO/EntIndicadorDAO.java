/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntIndicador;
import Modulo_3.unicom.dm.Entitys.EntVariable;

/**
 * @author Eduar
 *
 */
@Local
public interface EntIndicadorDAO {
	
	public List<EntIndicador> buscarPorVariable(EntVariable entity);
	
	public List<EntIndicador> buscarPorVariableNORegistrada(EntVariable variable, EntEntidad  entidad);

}
