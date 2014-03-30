package comun.unicom.bo;

import javax.ejb.Local;

import comun.unicom.DAO.ICrud;

/**
 * Permite realizar las operaciones CRUD(crear modificar eliminar consultar)
 * sobre la entidad <T> definida
 * 
 * @author Eduar Troyano
 * 
 * @param <T>
 */
@Local
public interface CrudBO<T> extends ICrud<T>  {
	


	
}
