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

    private final String GET_ALL = "SELECT [UserID]\n"
            + "      ,[Account]\n"
            + "      ,[Password]\n"
            + "      ,[Email]\n"
            + "      ,[AvatarURL]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[IsAdmin]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Users]";
    private final String GET_ONE_BY_ID = "SELECT [UserID]\n"
            + "      ,[Account]\n"
            + "      ,[Password]\n"
            + "      ,[Email]\n"
            + "      ,[AvatarURL]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[IsAdmin]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Users]\n"
            + "  WHERE [UserID]=?";
    private final String GET_ONE_BY_ACCOUNT_AND_PASSWORD = "SELECT [UserID]\n"
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
    private final String GET_ONE_BY_ACCOUNT = "SELECT [UserID]\n"
            + "      ,[Account]\n"
            + "      ,[Password]\n"
            + "      ,[Email]\n"
            + "      ,[AvatarURL]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[IsAdmin]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Users]\n"
            + "  WHERE [Account]=?";
    private final String INSERT = "INSERT INTO [dbo].[Users]\n"
            + "           ([Account]\n"
            + "           ,[Password]\n"
            + "           ,[Email]\n"
            + "           ,[CreatedAt])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?)";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<User> getAll() {
        return null;
    }

    public User getOneById(int id) {
        User user = new User();
        try {
            stm = con.prepareStatement(GET_ONE_BY_ID);
            stm.setInt(1, id);
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

    public User getOneByAccountAndPassword(String account, String password) {
        try {
            stm = con.prepareStatement(GET_ONE_BY_ACCOUNT_AND_PASSWORD);
            stm.setString(1, account);
            stm.setString(2, password);
            
            rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
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

    public User getOneByAccount(String account) {
        try {
            stm = con.prepareStatement(GET_ONE_BY_ACCOUNT);
            stm.setString(1, account);
            rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
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
        try {
            stm = con.prepareStatement(INSERT);
            stm.setString(1, user.getAccount());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getEmail());
            stm.setDate(4, (Date) user.getCreatedAt());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(User user) {
    }

    public void delete(int id) {
    }
}
