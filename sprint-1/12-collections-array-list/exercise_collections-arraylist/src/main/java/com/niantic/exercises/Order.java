package com.niantic.exercises;

import com.niantic.models.OrderLineItem;

import java.util.ArrayList;
import java.util.List;


/*
The exercises in this class are optional - this is the challenge exercise
 */
public class Order
{
    // this ArrayList is the container (shopping cart) for all items that are being ordered
    private ArrayList<OrderLineItem> shoppingCart = new ArrayList<>();

    public ArrayList<OrderLineItem> getShoppingCart()
    {
        return shoppingCart;
    }

    /*
    1. Add logic to allow a user to add an Item to a shopping cart
        - if the item already exists in the cart, update the quantity
        - search for a line item by name, and add the new quantity to the original quantity
     */
    public void addItem(OrderLineItem item)
    {
        // check if the item is already in the cart
//        OrderLineItem currentItem = null;
//
//        for(var lineItem : shoppingCart)
//        {
//            if(lineItem.getProduct().equalsIgnoreCase(item.getProduct()))
//            {
//                currentItem = lineItem;
//                break;
//            }
//        }
//
//        if(currentItem != null)
//        {
//            int newQuantity = currentItem.getQuantity() + item.getQuantity();
//            currentItem.setQuantity(newQuantity);
//        }
//        else
//        {
//            // or add a new item
//            shoppingCart.add(item);
//        }

        var existingItem = shoppingCart.stream()
                                       .filter(lineItem -> {
                                           return lineItem.getProduct().equalsIgnoreCase(item.getProduct());
                                       })
                                       .findFirst();

        // either update the quantity
        if(existingItem.isPresent()) {
            var currentItem = existingItem.get();
            int newQuantity = currentItem.getQuantity() + item.getQuantity();
            currentItem.setQuantity(newQuantity);
        }
        else
        {
            // or add a new item
            shoppingCart.add(item);
        }
    }

    /*
    2. Add logic to allow a user to add an Item to a shopping cart
        - search for a line item by name, and remove it from the list
     */
    public void removeItem(OrderLineItem item)
    {
    }

    /*
    3. Search for the highest priced item in the shopping cart and return the
        line item that contains that item.

        If the shopping cart is empty return null
     */
    public OrderLineItem findHighestPriceProduct()
    {
        return null;
    }

    /*
    4. Search for the most expensive line item in the shopping cart
        and return it

        If the shopping cart is empty return null
     */
    public OrderLineItem findMostExpensiveLineItem()
    {
        return null;
    }

    /*
    5. Calculate and return the order total
     */
    public double getOrderTotal()
    {
        return 0;
    }

    /*
    6. Return the total number of items in the cart
     */
    public int getTotalItemCount()
    {
        return 0;
    }

    /*
    7. Calculate the average price for all items in the shopping cart
     */
    public double getAveragePricePerItem()
    {
        return 0;
    }
}
