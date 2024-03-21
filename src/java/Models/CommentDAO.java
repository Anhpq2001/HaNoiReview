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
public class CommentDAO extends DBContext {

    PostDAO postDAO = new PostDAO();
    UserDAO userDAO = new UserDAO();

    Connection con = connection;
    PreparedStatement stm;
    ResultSet rs;

    private final String GET_ALL = "SELECT [CommentID]\n"
            + "      ,[PostID]\n"
            + "      ,[UserID]\n"
            + "      ,[ParentCommentID]\n"
            + "      ,[Content]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[LikeCount]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Comments]";
    private final String GET_ONE = "SELECT [CommentID]\n"
            + "      ,[PostID]\n"
            + "      ,[UserID]\n"
            + "      ,[ParentCommentID]\n"
            + "      ,[Content]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[LikeCount]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Comments]\n"
            + "  WHERE [CommentID]=?";
    private final String GET_ALL_BY_POSTID = "SELECT [CommentID]\n"
            + "      ,[PostID]\n"
            + "      ,[UserID]\n"
            + "      ,[ParentCommentID]\n"
            + "      ,[Content]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[LikeCount]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Comments]\n"
            + "  WHERE [PostID]=? AND [IsDelete]=0";
    private final String GET_ALL_BY_POSTID_ADMIN = "SELECT [CommentID]\n"
            + "      ,[PostID]\n"
            + "      ,[UserID]\n"
            + "      ,[ParentCommentID]\n"
            + "      ,[Content]\n"
            + "      ,[CreatedAt]\n"
            + "      ,[UpdatedAt]\n"
            + "      ,[LikeCount]\n"
            + "      ,[IsDelete]\n"
            + "  FROM [dbo].[Comments]\n"
            + "  WHERE [PostID]=?";
    private final String INSERT = "INSERT INTO [dbo].[Comments]\n"
            + "           ([PostID]\n"
            + "           ,[UserID]\n"
            + "           ,[ParentCommentID]\n"
            + "           ,[Content]\n"
            + "           ,[CreatedAt])  \n"
            + "     VALUES\n"
            + "           (?,?,?,?,?)";
    private final String UPDATE = "";
    private final String UPDATE_BY_ID = "UPDATE [dbo].[Comments]\n"
            + "   SET [IsDelete] = ?\n"
            + " WHERE [CommentID] = ?";
    private final String DELETE = "";

    public List<Comment> getAll() {
        List<Comment> comments = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt(1));
                comment.setPost(postDAO.getOne(rs.getInt(2)));
                comment.setUser(userDAO.getOneById(rs.getInt(3)));
                comment.setParentCommentId(rs.getInt(4));
                comment.setContent(rs.getString(5));
                comment.setCreatedAt(rs.getDate(6));
                comment.setUpdatedAt(rs.getDate(7));
                comment.setLikeCount(rs.getInt(8));
                comment.setIsDelete(rs.getBoolean(9));
                comments.add(comment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

    public Comment getOne(int id) {
        Comment comment = new Comment();
        try {
            stm = con.prepareStatement(GET_ONE);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                comment.setId(rs.getInt(1));
                comment.setPost(postDAO.getOne(rs.getInt(2)));
                comment.setUser(userDAO.getOneById(rs.getInt(3)));
                comment.setParentCommentId(rs.getInt(4));
                comment.setContent(rs.getString(5));
                comment.setCreatedAt(rs.getDate(6));
                comment.setUpdatedAt(rs.getDate(7));
                comment.setLikeCount(rs.getInt(8));
                comment.setIsDelete(rs.getBoolean(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Comment> getAllCommentByPostId(int id) {
        List<Comment> comments = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL_BY_POSTID);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt(1));
                comment.setPost(postDAO.getOne(rs.getInt(2)));
                comment.setUser(userDAO.getOneById(rs.getInt(3)));
                comment.setParentCommentId(rs.getInt(4));
                comment.setContent(rs.getString(5));
                comment.setCreatedAt(rs.getDate(6));
                comment.setUpdatedAt(rs.getDate(7));
                comment.setLikeCount(rs.getInt(8));
                comment.setIsDelete(rs.getBoolean(9));
                comments.add(comment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

    public List<Comment> getAllCommentByPostIdForAdmin(int id) {
        List<Comment> comments = new ArrayList<>();
        try {
            stm = con.prepareStatement(GET_ALL_BY_POSTID_ADMIN);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt(1));
                comment.setPost(postDAO.getOne(rs.getInt(2)));
                comment.setUser(userDAO.getOneById(rs.getInt(3)));
                comment.setParentCommentId(rs.getInt(4));
                comment.setContent(rs.getString(5));
                comment.setCreatedAt(rs.getDate(6));
                comment.setUpdatedAt(rs.getDate(7));
                comment.setLikeCount(rs.getInt(8));
                comment.setIsDelete(rs.getBoolean(9));
                comments.add(comment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

    public void insert(Comment comment) {
        try {
            stm = con.prepareStatement(INSERT);
            stm.setInt(1, comment.getPost().getId());
            stm.setInt(2, comment.getUser().getId());
            stm.setInt(3, comment.getParentCommentId());
            stm.setString(4, comment.getContent());
            stm.setDate(5, (Date) comment.getCreatedAt());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Comment comment) {
    }

    public void delete(int id) {
    }

    public void updateById(int id, Comment comment) {
        try {
            stm = con.prepareStatement(UPDATE_BY_ID);
            stm.setBoolean(1, comment.isIsDelete());
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
