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
public class CommentDAO extends DBContext{
    Connection con = connection;
    PreparedStatement stm;
    ResultSet rs;
    
    private final String GET_ALL = "";
    private final String GET_ONE = "";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";
    
    public List<Comment> getAll(){
        return null;
    }
    public Comment getOne(int id){
        return null;
    }    
    public void insert(Comment comment){
    }
    public void update(Comment comment){ 
    }
    public void delete(int id){
    }
}
