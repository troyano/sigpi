/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.Fase;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 * 
 */
@Local
public interface FaseDAO {

	public List<Fase> buscarPorProyecto(Proyecto proyecto);
}
