package com.RestaurantBook.RestaurantList.Repository;

import com.RestaurantBook.RestaurantList.Model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RestaurantRepository {
    private final Map<Long, Restaurant> restaurantMap = new HashMap<>();
    private Long currentId = 1L;

    public Restaurant findById(Long id) {
        return restaurantMap.get(id);
    }

    public List<Restaurant> findAll() {
        return restaurantMap.values().stream().collect(Collectors.toList());
    }

    public void save(Restaurant restaurant) {
        if (restaurant.getId() == null) {
            restaurant.setId(currentId++);
        }
        restaurantMap.put(restaurant.getId(), restaurant);
    }

    public void delete(Long id) {
        restaurantMap.remove(id);
    }
}
