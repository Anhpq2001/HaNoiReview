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
    private final String INSERT = "INSERT INTO [dbo].[Images]\n"
            + "           ([PostID]\n"
            + "           ,[ImageURL])\n"
            + "     VALUES\n"
            + "           (?,?)";
    private final String GET_ONE_BY_POSTID = "SELECT [ImageID]\n"
            + "      ,[PostID]\n"
            + "      ,[ImageURL]\n"
            + "  FROM [dbo].[Images]\n"
            + "  WHERE [PostID]=?";
    private final String UPDATE_BY_POSTID = "UPDATE [dbo].[Images]\n"
            + "   SET [ImageURL] = ?\n"
            + " WHERE [PostID] =?";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<Image> getAll() {
        List<Image> images = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt(1));
                image.setPost(postDAO.getOne(rs.getInt(2)));
                image.setImageUrl(rs.getString(3));
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
            image.setId(rs.getInt(1));
            image.setPost(postDAO.getOne(rs.getInt(2)));
            image.setImageUrl(rs.getString(3));
            return image;
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Image image) {
        try {
            stm = con.prepareStatement(INSERT);
            stm.setInt(1, image.getPost().getId());
            stm.setString(2, image.getImageUrl());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Image image) {
    }

    public void delete(int id) {
    }

    public Image getOneByPostId(int id) {
        Image image = new Image();
        try {
            stm = con.prepareStatement(GET_ONE_BY_POSTID);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                image.setId(rs.getInt(1));
                image.setPost(postDAO.getOne(rs.getInt(2)));
                image.setImageUrl(rs.getString(3));
                return image;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateByPostId(int id, Image image) {
        try {
            stm = con.prepareStatement(UPDATE_BY_POSTID);
            stm.setString(1, image.getImageUrl());
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
