package com.tap.DAO;

import java.util.List;
import com.tap.model.OrderItem;

public interface orderItem {


	    void addOrderItem(OrderItem oi);

	    OrderItem getOrderItem(int id);

	    void updateOrderItem(OrderItem oi);

	    void deleteOrderItem(int id);

	    List<OrderItem> getAllOrderItems();
	

}
