/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import dal.DBContext;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhph
 */
public class UserDAO extends DBContext {

    Connection con = connection;
    PreparedStatement stm;
    ResultSet rs;

    private final String GET_ALL = "";
    private final String GET_ONE = "SELECT [UserID]\n"
            + "      ,[Account]\n"
            + "      ,[Password]\n"
            + "      ,[Email]\n"
            + "      ,[AvatarURL]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[IsAdmin]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Users]\n"
            + "  WHERE [Account]=? AND [Password]=?";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<User> getAll() {
        return null;
    }

    public User getOne(String account, String password) {
        User user = new User();
        try {
            stm = con.prepareStatement(GET_ONE);
            stm.setString(1, account);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                user.setAccount(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setAvatarUrl(rs.getString(5));
                user.setCreatedAt(rs.getDate(6));
                user.setUpdatedAt(rs.getDate(7));
                user.setIsAdmin(rs.getBoolean(8));
                user.setIsDelete(rs.getBoolean(9));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(User user) {
    }

    public void update(User user) {
    }

    public void delete(int id) {
    }
}
