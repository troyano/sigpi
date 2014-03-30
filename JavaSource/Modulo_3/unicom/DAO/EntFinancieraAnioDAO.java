/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.Anio;
import Modulo_3.unicom.dm.Entitys.EntFinancieraAnio;
import Modulo_3.unicom.dm.Entitys.EntSituacionFinanciera;

/**
 * @author Eduar
 * @param <E>
 *
 */
@Local
public interface EntFinancieraAnioDAO {
	
	public List<EntFinancieraAnio> buscarPorSituacionFinanciera(EntSituacionFinanciera entity);
	
	public boolean crearFinancieraAnioListas(List<Anio> anios, ArrayList<Double> valores );

}
