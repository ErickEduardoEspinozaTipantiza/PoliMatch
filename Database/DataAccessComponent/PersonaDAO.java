package DataAccessComponent;

import DataAccessComponent.DTO.PersonaDTO;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO extends SQLiteDataHelper implements IDAO<PersonaDTO> {

    @Override
    public boolean create(PersonaDTO entity) throws Exception {
        String query = "INSERT INTO Persona (Nombre) VALUES (?)";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<PersonaDTO> readAll() throws Exception {
        List<PersonaDTO> lst = new ArrayList<>();
        String query = "SELECT IdPersona, IdPersonaRol, IdPersonaSexo, Nombre, Apellido, FechaNacimiento, Correo, Observacion, Estado, FechaCrea, FechaModifica FROM Persona";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PersonaDTO pdto = new PersonaDTO(
                        rs.getInt("IdPersona"),
                        rs.getInt("IdPersonaRol"),
                        rs.getInt("IdPersonaSexo"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("FechaNacimiento"),
                        rs.getString("Correo"),
                        rs.getString("Observacion"),
                        rs.getString("Estado"),
                        rs.getString("FechaCrea"),
                        rs.getString("FechaModifica")
                );
                lst.add(pdto);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public PersonaDTO readBy(Integer id) throws Exception {
        PersonaDTO pd = null;
        String query = "SELECT IdPersona, IdPersonaRol, IdPersonaSexo, Nombre, Apellido, FechaNacimiento, Correo, Observacion, Estado, FechaCrea, FechaModifica FROM Persona WHERE Estado = 'A' AND IdPersona = ?";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pd = new PersonaDTO(
                            rs.getInt("IdPersona"),
                            rs.getInt("IdPersonaRol"),
                            rs.getInt("IdPersonaSexo"),
                            rs.getString("Nombre"),
                            rs.getString("Apellido"),
                            rs.getString("FechaNacimiento"),
                            rs.getString("Correo"),
                            rs.getString("Observacion"),
                            rs.getString("Estado"),
                            rs.getString("FechaCrea"),
                            rs.getString("FechaModifica")
                    );
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return pd;
    }

    @Override
    public boolean update(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Persona SET Nombre = ?, FechaModifica = ? WHERE IdPersona = ?";

        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, entity.getNombre());
            ps.setString(2, dtf.format(now));
            ps.setInt(3, entity.getIdPersona());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Persona SET Estado = ? WHERE IdPersona = ?";
        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "X");
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = "SELECT COUNT(IdPersona) TotalReg FROM Persona WHERE Estado = 'A'";
        try (Connection conn = openConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }
}
