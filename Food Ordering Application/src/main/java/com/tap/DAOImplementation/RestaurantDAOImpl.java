package com.tap.DAOImplementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.restaurantDAO;
import com.tap.model.Restaurant;
import Utility.DBconnection;

public class RestaurantDAOImpl implements restaurantDAO {



	    private String INSERT =
	            "INSERT INTO restaurant(name,cuisineType,deliveryTime,address,adminUserId,rating,isActive,imagePath) VALUES(?,?,?,?,?,?,?,?)";

	    private String GET_ONE =
	            "SELECT * FROM restaurant WHERE restaurantId=?";

	    private String UPDATE =
	            "UPDATE restaurant SET name=?, cuisineType=?, deliveryTime=?, address=?, adminUserId=?, rating=?, isActive=?, imagePath=? WHERE restaurantId=?";

	    private String DELETE =
	            "DELETE FROM restaurant WHERE restaurantId=?";

	    private String GET_ALL =
	            "SELECT * FROM restaurant";

	    // ---------------- ADD ----------------
	    public void addRestaurant(Restaurant r) {

	        try (Connection con = DBconnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(INSERT)) {

	            ps.setString(1, r.getName());
	            ps.setString(2, r.getCuisineType());
	            ps.setInt(3, r.getDeliveryTime());
	            ps.setString(4, r.getAddress());
	            ps.setInt(5, r.getAdminUserId());
	            ps.setDouble(6, r.getRating());
	            ps.setBoolean(7, r.isActive());
	            ps.setString(8, r.getImagePath());

	            ps.executeUpdate();
	            System.out.println("Restaurant Inserted");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // ---------------- GET ONE ----------------
	    public Restaurant getRestaurant(int id) {

	        Restaurant r = null;

	        try (Connection con = DBconnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(GET_ONE)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {

	                r = new Restaurant(
	                        rs.getInt("restaurantId"),
	                        rs.getString("name"),
	                        rs.getString("cuisineType"),
	                        rs.getInt("deliveryTime"),
	                        rs.getString("address"),
	                        rs.getInt("adminUserId"),
	                        rs.getDouble("rating"),
	                        rs.getBoolean("isActive"),
	                        rs.getString("imagePath")
	                );
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return r;
	    }

	    // ---------------- UPDATE ----------------
	    public void updateRestaurant(Restaurant r) {

	        try (Connection con = DBconnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(UPDATE)) {

	            ps.setString(1, r.getName());
	            ps.setString(2, r.getCuisineType());
	            ps.setInt(3, r.getDeliveryTime());
	            ps.setString(4, r.getAddress());
	            ps.setInt(5, r.getAdminUserId());
	            ps.setDouble(6, r.getRating());
	            ps.setBoolean(7, r.isActive());
	            ps.setString(8, r.getImagePath());
	            ps.setInt(9, r.getRestaurantId());

	            ps.executeUpdate();
	            System.out.println("Restaurant Updated");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // ---------------- DELETE ----------------
	    public void deleteRestaurant(int id) {

	        try (Connection con = DBconnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(DELETE)) {

	            ps.setInt(1, id);
	            ps.executeUpdate();
	            System.out.println("Restaurant Deleted");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // ---------------- GET ALL ----------------
	    public List<Restaurant> getAllRestaurants() {

	        List<Restaurant> list = new ArrayList<>();

	        try (Connection con = DBconnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(GET_ALL);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {

	                Restaurant r = new Restaurant(
	                        rs.getInt("restaurantId"),
	                        rs.getString("name"),
	                        rs.getString("cuisineType"),
	                        rs.getInt("deliveryTime"),
	                        rs.getString("address"),
	                        rs.getInt("adminUserId"),
	                        rs.getDouble("rating"),
	                        rs.getBoolean("isActive"),
	                        rs.getString("imagePath")
	                );
	                list.add(r);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	
}
