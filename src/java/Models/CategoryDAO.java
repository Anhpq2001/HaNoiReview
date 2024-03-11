/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import dal.DBContext;
import java.sql.*;
import java.util.List;

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
    private final String GET_ONE = "";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<Category> getAll() {
        return null;
    }

    public Category getOne(int id) {
        return null;
    }

    public void insert(Category category) {
    }

    public void update(Category category) {
    }

    public void delete(int id) {
    }
}
