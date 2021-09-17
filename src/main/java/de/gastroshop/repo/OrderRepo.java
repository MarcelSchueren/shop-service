package de.gastroshop.repo;

import de.gastroshop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    private List<Order> orderList = new ArrayList<>();

    public void add(Order order){
        orderList.add(order);
    }

    public List<Order> list(){
        return this.orderList;
    }

    public Order get(int id){
        for (Order order : orderList) {
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orderList) {
            sb.append(order.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
