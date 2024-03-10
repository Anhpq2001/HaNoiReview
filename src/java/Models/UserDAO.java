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
public class UserDAO extends DBContext{
    Connection con = connection;
    PreparedStatement stm;
    ResultSet rs;
    
    private final String GET_ALL = "";
    private final String GET_ONE = "";
    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";
    
    public List<User> getAll(){
        return null;
    }
    public User getOne(String account, String password){
        return null;
    }    
    public void insert(User user){
    }
    public void update(User user){ 
    }
    public void delete(int id){
    }
}
