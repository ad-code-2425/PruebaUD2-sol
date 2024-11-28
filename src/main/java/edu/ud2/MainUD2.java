package edu.ud2;

import java.util.ArrayList;

import edu.ud2.model.Partido;
import edu.ud2.model.dao.partido.IPartidoDao;
import edu.ud2.model.dao.partido.PartidoMySQL;
import edu.ud2.model.services.IPartidoServicio;
import edu.ud2.model.services.PartidoServicio;

public class MainUD2 {

    public static void main(String[] args) {

        // Creamos partidos en memoria
        ArrayList<Partido> partidos = crearPartidosMemoria();

        // Crear partidos en BD a través de DAO
      
        IPartidoServicio partidoServicio = new PartidoServicio();

        partidoServicio.crearPartidos(partidos);

    }

    private static ArrayList<Partido> crearPartidosMemoria() {
        ArrayList<Partido> partidos = new ArrayList<Partido>();

        Partido p1 = new Partido("PP", 44064, 32.51f);
        Partido p2 = new Partido("PSdeG", 43332, 31.97f);
        Partido p3 = new Partido("BNG", 31628, 23.34f);
        Partido p4 = new Partido("PODEMOS-EU-ANOVA", 8245, 6.08f);
        Partido p5 = new Partido("VOX", 2913, 2.15f);
        Partido p6 = new Partido("Cs", 1671, 1.23f);

        partidos.add(p1);
        partidos.add(p2);
        partidos.add(p3);
        partidos.add(p4);
        partidos.add(p5);
        partidos.add(p6);

        
        return partidos;

    }

}