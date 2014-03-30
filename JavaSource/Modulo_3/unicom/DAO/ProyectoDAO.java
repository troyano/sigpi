/**
 * 
 */
package Modulo_3.unicom.DAO;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import Modulo_3.unicom.dm.Entitys.Proyecto;

/**
 * @author Eduar
 *
 */
@Local
public interface ProyectoDAO {

	public Proyecto buscarPorId(int id);
	
	public List<Proyecto> buscarPorEstado(int estado);

	List<Proyecto> buscarPorCatalogo(Proyecto proyectoBuscar,int estado,
			Date fechaInicial, Date fechaFinal);
}
