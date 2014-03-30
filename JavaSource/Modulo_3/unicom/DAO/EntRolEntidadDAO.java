/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.EntEntidad;
import Modulo_3.unicom.dm.Entitys.EntRolentidad;
import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 *
 */
@Local
public interface EntRolEntidadDAO {
	
	public List<EntRolentidad> buscarPorProEntRol(Proyecto proyecto,
			EntEntidad entidad);
	
	public List<EntRolentidad> buscarPorProEntRol2(Proyecto proyecto,
			EntEntidad entidad);

}
