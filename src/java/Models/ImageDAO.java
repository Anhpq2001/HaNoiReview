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
public class ImageDAO extends DBContext {

    Connection con = connection;
    PreparedStatement stm;
    ResultSet rs;

    private final String GET_ALL = "SELECT [ImageID]\n"
            + "      ,[PostID]\n"
            + "      ,[ImageURL]\n"
            + "  FROM [dbo].[Images]";
    private final String GET_ONE = "";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<Image> getAll() {
        return null;
    }

    public Image getOne(int id) {
        return null;
    }

    public void insert(Image image) {
    }

    public void update(Image image) {
    }

    public void delete(int id) {
    }
}
