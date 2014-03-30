/**
 * 
 */
package Modulo_3.unicom.DAO;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.EntRepresentantelegal;

/**
 * @author Eduar
 *
 */
@Local
public interface EntRepresentanteLegalDAO {
	
	public EntRepresentantelegal buscarPorId(int id);

}
