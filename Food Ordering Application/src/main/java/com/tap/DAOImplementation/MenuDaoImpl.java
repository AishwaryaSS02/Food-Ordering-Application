package com.tap.DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.model.menu;

import Utility.DBconnection;

public class MenuDaoImpl {

	private static final String SELECT_BY_RESTAURANT = "SELECT * FROM menu WHERE restaurantId = ?";

	private String INSERT =
            "INSERT INTO menu(restaurantId,itemName,description,price,isAvailable,imagePath) VALUES(?,?,?,?,?,?)";

    private String SELECT =
            "SELECT * FROM menu WHERE menuId=?";

    private String UPDATE =
            "UPDATE menu SET itemName=?,price=?,isAvailable=? WHERE menuId=?";

    private String DELETE =
            "DELETE FROM menu WHERE menuId=?";

    private String SELECT_ALL =
            "SELECT * FROM menu";

    // ---------------- ADD ----------------
    public void addMenu(menu m) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT)) {

        	ps.setInt(1, m.getRestaurantId());
            ps.setString(2, m.getItemName());
            ps.setString(3, m.getDescription());
            ps.setDouble(4, m.getPrice());
            ps.setBoolean(5, m.isAvailable());
            ps.setString(6, m.getImagePath());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- GET ----------------
    public menu getMenu(int id) {

        menu m = null;

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                m = new menu(
                        rs.getInt("menuId"),
                        rs.getInt("restaurantId"),
                        rs.getString("itemName"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getBoolean("isAvailable"),
                        rs.getString("imagePath")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    // ---------------- UPDATE ----------------
    public void updateMenu(menu m) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setString(1, m.getItemName());
            ps.setDouble(2, m.getPrice());
            ps.setBoolean(3, m.isAvailable());
            ps.setInt(4, m.getMenuId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- DELETE ----------------
    public void deleteMenu(int id) {

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- GET ALL ----------------
    public List<menu> getAllMenu() {

        List<menu> list = new ArrayList<>();

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                menu m = new menu(
                        rs.getInt("menuId"),
                        rs.getInt("restaurantId"),
                        rs.getString("itemName"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getBoolean("isAvailable"),
                        rs.getString("imagePath")
                );
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
 // ---------------- GET MENU BY RESTAURANT ----------------
    public List<menu> getAllMenuByRestaurantId(int restaurantId) {

        List<menu> list = new ArrayList<>();

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_RESTAURANT)) {

            // set restaurantId in query
            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                menu m = new menu(
                        rs.getInt("menuId"),
                        rs.getInt("restaurantId"),
                        rs.getString("itemName"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getBoolean("isAvailable"),
                        rs.getString("imagePath")
                );

                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
