
package Modulo_3.unicom.DAO;

import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.Actividad;
import Modulo_3.unicom.dm.Entitys.Fase;

/**
 * @author Eduar
 * 
 */
@Local
public interface ActividadDAO {

	public List<Actividad> buscarPorFase(Fase fase);

	public void eliminar(Actividad selectedActividad);
}
