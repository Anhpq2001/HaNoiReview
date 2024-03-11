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
public class PostDAO extends DBContext {

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
            + "  FROM [dbo].[Posts]";
    private final String GET_ONE = "";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";

    public List<Post> getAll() {
        return null;
    }

    public Post getOne(int id) {
        return null;
    }

    public void insert(Post post) {
    }

    public void update(Post post) {
    }

    public void delete(int id) {
    }
}
