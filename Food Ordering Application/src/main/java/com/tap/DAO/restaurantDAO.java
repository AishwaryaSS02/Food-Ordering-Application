package com.tap.DAO;

import java.util.List;
import com.tap.model.Restaurant;

public interface restaurantDAO {

	void addRestaurant(Restaurant r);

    Restaurant getRestaurant(int id);

    void updateRestaurant(Restaurant r);

    void deleteRestaurant(int id);

    List<Restaurant> getAllRestaurants();
}
