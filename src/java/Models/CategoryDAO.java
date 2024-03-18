/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import dal.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhph
 */
public class CategoryDAO extends DBContext {

    Connection con = connection;
    PreparedStatement stm;
    ResultSet rs;

    private final String GET_ALL = "SELECT [CategoryID]\n"
            + "      ,[Name]\n"
            + "      ,[Description]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Categories]";
    private final String GET_ONE = "SELECT [CategoryID]\n"
            + "      ,[Name]\n"
            + "      ,[Description]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Categories]\n"
            + "  WHERE [CategoryID]=?";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setName(rs.getString(2));
                category.setDescription(rs.getString(3));
                category.setCreatedAt(rs.getDate(4));
                category.setUpdatedAt(rs.getDate(5));
                category.setIsDelete(rs.getBoolean(6));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categories;
    }

    public Category getOne(int id) {
        Category category = new Category();
        try {
            stm = con.prepareStatement(GET_ONE);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                category.setName(rs.getString(2));
                category.setDescription(rs.getString(3));
                category.setCreatedAt(rs.getDate(4));
                category.setUpdatedAt(rs.getDate(5));
                category.setIsDelete(rs.getBoolean(6));
                return category;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Category category) {
    }

    public void update(Category category) {
    }

    public void delete(int id) {
    }
}
