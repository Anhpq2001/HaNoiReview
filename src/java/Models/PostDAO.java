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
            + "  FROM [dbo].[Posts]\n"
            + "  WHERE [IsDelete]=0";
    private final String GET_ALL_ADMIN = "SELECT [PostID]\n"
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
    private final String GET_ONE_BY_TITLE = "SELECT [PostID]\n"
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
            + "  WHERE [Title]=?";
    private final String GET_ONE_BY_CATEGORYID = "SELECT [PostID]\n"
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
            + "  WHERE [CategoryID] = ? AND [IsDelete]=0";
    private final String INSERT = "INSERT INTO [dbo].[Posts]\n"
            + "           ([CategoryID]\n"
            + "           ,[Title]\n"
            + "           ,[Content]\n"
            + "           ,[CreatedAt]\n"
            + "           ,[address])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[Posts]\n"
            + "   SET [CategoryID] = ?\n"
            + "      ,[Title] = ?\n"
            + "      ,[Content] = ?\n"
            + "      ,[UpdatedAt] = ?\n"
            + "      ,[address] = ?\n"
            + " WHERE [PostID] =?";
    private final String UPDATE_ISDELETE = "UPDATE [dbo].[Posts]\n"
            + "   SET [IsDelete]=?      \n"
            + " WHERE [PostID]=?";
    private final String DELETE = "";

    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt(1));
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

    public List<Post> getAllAdmin() {
        List<Post> posts = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL_ADMIN);
            rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt(1));
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
                post.setId(rs.getInt(1));
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
        try {
            stm = con.prepareStatement(INSERT);
            stm.setInt(1, post.getCategory().getId());
            stm.setString(2, post.getTitle());
            stm.setString(3, post.getContent());
            stm.setDate(4, (Date) post.getCreatedAt());
            stm.setString(5, post.getAddress());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Post post) {
        try {
            stm = con.prepareStatement(UPDATE);
            stm.setInt(1, post.getCategory().getId());
            stm.setString(2, post.getTitle());
            stm.setString(3, post.getContent());
            stm.setDate(4, (Date) post.getUpdatedAt());
            stm.setString(5, post.getAddress());
            stm.setInt(6, post.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
    }

    public Post getOneByTitle(String title) {
        Post post = new Post();
        try {
            stm = con.prepareStatement(GET_ONE_BY_TITLE);
            stm.setString(1, title);
            rs = stm.executeQuery();
            if (rs.next()) {
                post.setId(rs.getInt(1));
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

    public List<Post> getAllByCategoryId(int id) {
        List<Post> posts = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ONE_BY_CATEGORYID);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt(1));
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

    public void updateByStatus(int id, Post post) {
        try {
            stm = con.prepareStatement(UPDATE_ISDELETE);
            stm.setBoolean(1, post.isIsDelete());
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
