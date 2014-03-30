/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.EntidadProyecto;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 * 
 */
@Local
public interface EntidadProyectoDAO {

	public List<EntidadProyecto> buscarPorProyecto(Proyecto proyecto);
}
