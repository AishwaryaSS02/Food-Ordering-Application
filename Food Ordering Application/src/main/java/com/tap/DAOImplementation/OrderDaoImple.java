package com.tap.DAOImplementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.orderDAO;
import com.tap.model.orders;
import Utility.DBconnection;


public class OrderDaoImple implements orderDAO {




    private String INSERT =
        "INSERT INTO orders(userId,restaurantId,totalAmount,status,paymentMode) VALUES(?,?,?,?,?)";

    private String SELECT =
        "SELECT * FROM orders WHERE orderId=?";

    private String UPDATE =
        "UPDATE orders SET status=?, paymentMode=? WHERE orderId=?";

    private String DELETE =
        "DELETE FROM orders WHERE orderId=?";

    private String SELECT_ALL =
        "SELECT * FROM orders";

    // -------- ADD --------
    public void addOrder1(orders o) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT)) {

            ps.setInt(1, o.getUserId());
            ps.setInt(2, o.getRestaurantId());
            ps.setDouble(3, o.getTotalAmount());
            ps.setString(4, o.getStatus());
            ps.setString(5, o.getPaymentMode());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------- GET --------
    public orders getOrder(int id) {

        orders o = null;

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

            	orders o1 = new orders(
            	        rs.getInt("orderId"),
            	        rs.getInt("userId"),
            	        rs.getInt("restaurantId"),
            	        rs.getTimestamp("orderDate"),
            	        rs.getDouble("totalAmount"),
            	        rs.getString("status"),
            	        rs.getString("paymentMode"),
            	        rs.getString("address")   // ⭐ add this
            	);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    // -------- UPDATE --------
    public void updateOrder(orders o) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setString(1, o.getStatus());
            ps.setString(2, o.getPaymentMode());
            ps.setInt(3, o.getOrderId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------- DELETE --------
    public void deleteOrder(int id) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------- GET ALL --------
    public List<orders> getAllOrders() {

        List<orders> list = new ArrayList<>();

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

            	orders o1 = new orders(
            	        rs.getInt("orderId"),
            	        rs.getInt("userId"),
            	        rs.getInt("restaurantId"),
            	        rs.getTimestamp("orderDate"),
            	        rs.getDouble("totalAmount"),
            	        rs.getString("status"),
            	        rs.getString("paymentMode"),
            	        rs.getString("address")   // ⭐ add this
            	);
                list.add(o1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

	@Override
	public int addOrder(orders o) {
		// TODO Auto-generated method stub
		
	}
}
