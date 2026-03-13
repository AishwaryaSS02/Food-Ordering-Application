package com.tap.DAO;

import java.util.List;
import com.tap.model.orders;

public interface orderDAO {

	    void addOrder(orders o);

	    orders getOrder(int id);

	    void updateOrder(orders o);

	    void deleteOrder(int id);

	    List<orders> getAllOrders();
}
