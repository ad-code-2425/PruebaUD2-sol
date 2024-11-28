package edu.ud2.model.dao.partido;

import edu.ud2.model.Partido;
import edu.ud2.model.util.IGenericDao;

/**
 *
 * @author mfernandez
 */
public interface IPartidoDao extends IGenericDao<Partido> {

    boolean existe(String nombre);

    
}
