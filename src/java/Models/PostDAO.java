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
public class PostDAO extends DBContext {

    CategoryDAO categoryDAO = new CategoryDAO();

    Connection con = connection;
    PreparedStatement stm;
    ResultSet rs;

    private final String GET_ALL = "SELECT [PostID]\n"
            + "      ,[CategoryID]\n"
            + "      ,[Title]\n"
            + "      ,[Content]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[LikeCount]\n"
            + "      ,[ViewCount]\n"
            + "      ,[IsDelete]\n"
            + "      ,[address]\n"
            + "  FROM [dbo].[Posts]";
    private final String GET_ONE = "SELECT [PostID]\n"
            + "      ,[CategoryID]\n"
            + "      ,[Title]\n"
            + "      ,[Content]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[LikeCount]\n"
            + "      ,[ViewCount]\n"
            + "      ,[IsDelete]\n"
            + "      ,[address]\n"
            + "  FROM [dbo].[Posts]\n"
            + "  WHERE [PostID]=?";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setCategory(categoryDAO.getOne(rs.getInt(2)));
                post.setTitle(rs.getString(3));
                post.setContent(rs.getString(4));
                post.setCreatedAt(rs.getDate(5));
                post.setUpdatedAt(rs.getDate(6));
                post.setLikeCount(rs.getInt(7));
                post.setViewCount(rs.getInt(8));
                post.setIsDelete(rs.getBoolean(9));
                post.setAddress(rs.getString(10));
                posts.add(post);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }

    public Post getOne(int id) {
        Post post = new Post();
        try {
            stm = con.prepareStatement(GET_ONE);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                post.setCategory(categoryDAO.getOne(rs.getInt(2)));
                post.setTitle(rs.getString(3));
                post.setContent(rs.getString(4));
                post.setCreatedAt(rs.getDate(5));
                post.setUpdatedAt(rs.getDate(6));
                post.setLikeCount(rs.getInt(7));
                post.setViewCount(rs.getInt(8));
                post.setIsDelete(rs.getBoolean(9));
                post.setAddress(rs.getString(10));
                return post;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Post post) {
    }

    public void update(Post post) {
    }

    public void delete(int id) {
    }
}
