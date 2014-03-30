package comun.unicom.DAO;

import comun.unicom.DAO.ICrud;
import javax.ejb.Local;

/**
 * @author Eduar Troyano
 * 
 */
@Local
public interface CrudDAO<T> extends ICrud<T> {


}
