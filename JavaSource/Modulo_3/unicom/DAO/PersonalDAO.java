/**
 * 
 */
package Modulo_3.unicom.DAO;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.Personal;

/**
 * @author Eduar
 *
 */
@Local
public interface PersonalDAO {
	
	public Personal buscarPorId(int id);

}
