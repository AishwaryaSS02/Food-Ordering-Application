package com.tap.DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.model.User;

import Utility.DBconnection;

public class UserDAOImp implements UserDAO {
	
	

	 private String ADD_USER =
	            "INSERT INTO users (username, password, email, address, role, createdDate, lastLoginDate) " +
	            "VALUES (?, ?, ?, ?, ?, ?, ?)";

	 private String GET_USER = "SELECT * FROM users WHERE userid = ?";
	 
	    @Override
	    public boolean addUser(User u) {

	        try (Connection connection = DBconnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {

	            preparedStatement.setString(1, u.getUsername());
	            preparedStatement.setString(2, u.getPassword());
	            preparedStatement.setString(3, u.getEmail());
	            preparedStatement.setString(4, u.getAddress());
	            preparedStatement.setString(5, u.getRole());
	            preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
	            preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
	    }

	@Override
	public User getUser(int id) {
		 
		 User u=null;
		 try 
			(Connection connection=DBconnection.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(GET_USER)){
			preparedStatement.setInt(1, id);
			
			ResultSet res = preparedStatement.executeQuery();
			
			if(res.next())
			{
				int userid=res.getInt("userid");
				String username=res.getString("username");
				String password=res.getString("password");
				String email=res.getString("email");
				String address=res.getString("address");
				String role=res.getString("role");
				
				u=new User(userid,username, password, email, address, role);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void updateUser(User u) {
		
		String UPDATE_USER = "UPDATE `users` SET `password`= ?, `email` = ?, `address` = ?, `role` =?"
				+ "where `userid` = ?";
		Connection connection=DBconnection.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, u.getPassword());
            preparedStatement.setString(2, u.getEmail());
            preparedStatement.setString(3, u.getAddress());
            preparedStatement.setString(4, u.getRole());
            preparedStatement.setInt(5, u.getUserid());
			
            preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int id) {

		String DELETE_USER = "DELETE from `user` WHERE `userid` = ?";
		Connection connection = DBconnection.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUser() {
	    String GET_ALL = "SELECT * FROM users";
		List<User> list = new ArrayList<>();

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(GET_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                User u = new User(
                        rs.getInt("userid"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("role")
                );
                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

	public User loginUser(String email, String password) {

	    User user = null;

	    String LOGIN_QUERY = "SELECT * FROM users WHERE email=? AND password=?";

	    try (Connection con = DBconnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(LOGIN_QUERY)) {

	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            user = new User(
	                    rs.getInt("userid"),
	                    rs.getString("username"),
	                    rs.getString("password"),
	                    rs.getString("email"),
	                    rs.getString("address"),
	                    rs.getString("role")
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	
	}
}


