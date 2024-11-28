
package edu.ud2.model.services;

import java.util.ArrayList;

import edu.ud2.model.Partido;
import edu.ud2.model.dao.partido.IPartidoDao;
import edu.ud2.model.dao.partido.PartidoMySQL;

/**
 *
 * @author maria
 */
public class PartidoServicio implements IPartidoServicio {

    private IPartidoDao partidoDao;

    public PartidoServicio() {
        this.partidoDao = new PartidoMySQL();
    }

    /**
    * 
    */
    public void crearPartidos(ArrayList<Partido> partidos) {
        
        for (Partido p : partidos) {

            //TODO
            System.out.println("Se ha creado un partido con id: " + p.getId());
        }
    }


}
