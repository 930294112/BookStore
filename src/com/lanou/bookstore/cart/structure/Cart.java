package com.lanou.bookstore.cart.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/9/22.
 */
public class Cart {
    private Map<String,CartItem> cartItemMap = new HashMap<>();

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItemMap=" + cartItemMap +
                '}';
    }

    public Cart(Map<String, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Map<String, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<String, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }


    public void clear() {
        cartItemMap.clear();
    }

    public void delete(String bid) {
        cartItemMap.remove(bid);
        setCartItemMap(cartItemMap);
    }


    public void clear1() {
        cartItemMap.clear();
    }
}
