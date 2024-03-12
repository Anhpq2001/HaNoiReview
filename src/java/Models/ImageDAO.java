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
public class ImageDAO extends DBContext {

    PostDAO postDAO = new PostDAO();

    Connection con = connection;
    PreparedStatement stm;
    ResultSet rs;

    private final String GET_ALL = "SELECT [ImageID]\n"
            + "      ,[PostID]\n"
            + "      ,[ImageURL]\n"
            + "  FROM [dbo].[Images]";
    private final String GET_ONE = "SELECT [ImageID]\n"
            + "      ,[PostID]\n"
            + "      ,[ImageURL]\n"
            + "  FROM [dbo].[Images]\n"
            + "  WHERE [ImageID]=?";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<Image> getAll() {
        List<Image> images = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setPost(postDAO.getOne(rs.getInt(1)));
                image.setImageUrl(rs.getString(2));
                images.add(image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }

    public Image getOne(int id) {
        Image image = new Image();
        try {
            stm = con.prepareStatement(GET_ONE);
            image.setPost(postDAO.getOne(rs.getInt(1)));
            image.setImageUrl(rs.getString(2));
            return image;
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Image image) {
    }

    public void update(Image image) {
    }

    public void delete(int id) {
    }
}
