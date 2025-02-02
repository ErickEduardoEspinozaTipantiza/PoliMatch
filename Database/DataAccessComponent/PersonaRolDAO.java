package DataAccessComponent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccessComponent.DTO.PersonaRolDTO;

public class PersonaRolDAO extends SQLServerDataHelper implements IDAO<PersonaRolDTO>{
    
    @Override
    public boolean create(PersonaRolDTO entity) throws Exception {
        String query="INSERT INTO PersonaRol(Nombre) VALUES(?)";
        try {
            Connection conn=openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<PersonaRolDTO> readAll() throws Exception {
        List<PersonaRolDTO> lst = new ArrayList<>();
        String query="SELECT IdPersonaRol "
                        +",IdPersonaRolPadre"
                        +",Nombre         "
                        +",Observacion    "
                        +",Estado         "
                        +",FechaCrea      "
                        +",FechaModifica  "
                        +"FROM PersonaRol ";
        try {
            Connection conn=openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(); 
            while(rs.next()) {
                PersonaRolDTO prdto = new PersonaRolDTO(rs.getInt(1)
                                        ,rs.getInt(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7));
            lst.add(prdto);

            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    @Override
    public PersonaRolDTO readBy(Integer id) throws Exception {
        PersonaRolDTO prd= new PersonaRolDTO();
        String  query="SELECT IdPersonaRol"
                        +",IdPersonaRolPadre" 
                        +",Nombre        " 
                        +",Observacion   " 
                        +",Estado        " 
                        +",FechaCrea     " 
                        +",FechaModifica "     
                        +"FROM PersonaRol "
                        +"WHERE Estado ='A' AND IdPersonaRol= "+id.toString();
        try {
            Connection conn=openConnection();
            Statement   stm=conn.createStatement();
            ResultSet   rs=stm.executeQuery(query);
            while (rs.next()) {
                prd = new PersonaRolDTO(rs.getInt(1)
                                     ,rs.getInt(2)
                                     ,rs.getString(3)
                                     ,rs.getString(4)
                                     ,rs.getString(5)
                                     ,rs.getString(6)
                                     ,rs.getString(7));
                                                }            
            } catch (Exception e) {
                throw e;
            }
            return prd;
    }

    @Override
    public boolean update(PersonaRolDTO entity) throws Exception {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query= "UPDATE PersonaRol SET Nombre = ?, FechaModifica = ? WHERE IdPersonaRol = ?";
        try {
            Connection conn=openConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,entity.getNombre());
            ps.setString(2,dtf.format(now));
            ps.setInt(3,entity.getIdPersonaRol());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE PersonaRol SET Estado=? WHERE IdPersonaRol=?";
        try {
            Connection conn=openConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,"X");
            ps.setInt(2,id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query= "SELECT COUNT(IdPersonaRol) TotalReg FROM PersonaRol"
        + "WHERE Estado='A'";
        try {
           Connection conn= openConnection();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(query);
           while (rs.next()) {
               return rs.getInt(1);

           }
        } catch (Exception e) {
           throw e;
       }
       return  0 ;
    }
}
