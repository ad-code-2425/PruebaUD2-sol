package edu.ud2.model.dao.partido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.ud2.model.Partido;
import edu.ud2.model.util.AbstractGenericDao;
import edu.ud2.model.util.db.DBCPDataSourceUtil;
import edu.ud2.model.util.exceptions.InstanceNotFoundException;

/**
 *
 * @author maria
 */
public class PartidoMySQL
        extends AbstractGenericDao<Partido> implements IPartidoDao {

    private DataSource dataSource;

    public PartidoMySQL() {
        this.dataSource = DBCPDataSourceUtil.getDataSource();
    }

    @Override
    public Partido create(Partido entity) {

        try (
                Connection conexion = this.dataSource.getConnection();
                PreparedStatement pstmt = conexion.prepareStatement(
                        "INSERT INTO PARTIDO\n"
                                + "           ( nombre \n"
                                + "           , porcentaje \n"
                                + "           , numero_votos )\n"
                                + "     VALUES\n"
                                + "           (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);) {

            pstmt.setString(1, entity.getNombre());
            pstmt.setFloat(2, entity.getPorcentaje());
            pstmt.setInt(3, entity.getVotos());

            // Devolverá 0 para las sentencias SQL que no devuelven nada o el número de
            // filas afectadas
            pstmt.executeUpdate();

            try (ResultSet clavesResultado = pstmt.getGeneratedKeys();) {

                if (clavesResultado.next()) {
                    int partidoId = clavesResultado.getInt(1);
                    entity.setId(partidoId);
                } else {
                    entity = null;
                }
            }
        } catch (

        SQLException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
            entity = null;
        }
        return entity;
    }

    @Override
    public Partido read(int id) throws InstanceNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Partido entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(String nombre) {
        boolean existe = false;

        try (
                Connection conexion = this.dataSource.getConnection();
                PreparedStatement pstmt = conexion.prepareStatement(
                        "SELECT COUNT(*)\n"
                                + "  FROM   PARTIDO \n"
                                + " WHERE nombre = ?");) {

            pstmt.setString(1, nombre);

            // Devolverá 0 para las sentencias SQL que no devuelven nada o el número de
            // filas afectadas
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                int partidosCount = result.getInt(1);
                if (partidosCount > 0) {
                    existe = true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());

        }
        return existe;
    }

}