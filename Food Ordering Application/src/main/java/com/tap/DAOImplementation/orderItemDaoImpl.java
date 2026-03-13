package com.tap.DAOImplementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.orderItem;
import com.tap.model.OrderItem;
import Utility.DBconnection;

public class orderItemDaoImpl implements orderItem {

    // ✅ INSERT (now includes quantity)
    private static final String INSERT =
        "INSERT INTO order_item(orderId, menuId, quantity, totalAmount) VALUES(?,?,?,?)";

    private static final String SELECT =
        "SELECT * FROM order_item WHERE orderItemId=?";

    // ✅ UPDATE (update quantity also)
    private static final String UPDATE =
        "UPDATE order_item SET quantity=?, totalAmount=? WHERE orderItemId=?";

    private static final String DELETE =
        "DELETE FROM order_item WHERE orderItemId=?";

    private static final String SELECT_ALL =
        "SELECT * FROM order_item";

    // ---------------- ADD ORDER ITEM ----------------
    @Override
    public void addOrderItem(OrderItem oi) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT)) {

            ps.setInt(1, oi.getOrderId());
            ps.setInt(2, oi.getMenuId());
            ps.setInt(3, oi.getQuantity());          // ✅ quantity added
            ps.setDouble(4, oi.getTotalAmount());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- GET SINGLE ITEM ----------------
    @Override
    public OrderItem getOrderItem(int id) {

        OrderItem oi = null;

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                oi = new OrderItem(
                        rs.getInt("orderItemId"),
                        rs.getInt("orderId"),
                        rs.getInt("menuId"),
                        rs.getInt("quantity"),
                        rs.getDouble("totalAmount")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return oi;
    }

    // ---------------- UPDATE ITEM ----------------
    @Override
    public void updateOrderItem(OrderItem oi) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setInt(1, oi.getQuantity());          // ✅ update quantity
            ps.setDouble(2, oi.getTotalAmount());
            ps.setInt(3, oi.getOrderItemId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- DELETE ITEM ----------------
    @Override
    public void deleteOrderItem(int id) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- GET ALL ITEMS ----------------
    @Override
    public List<OrderItem> getAllOrderItems() {

        List<OrderItem> list = new ArrayList<>();

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                OrderItem oi = new OrderItem(
                        rs.getInt("orderItemId"),
                        rs.getInt("orderId"),
                        rs.getInt("menuId"),
                        rs.getInt("quantity"),
                        rs.getDouble("totalAmount")
                );

                list.add(oi);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}