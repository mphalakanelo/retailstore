package com.example.retailstore.userbuilder;

import com.example.retailstore.user.Billing;
import com.example.retailstore.user.Item;
import com.example.retailstore.user.User;

import java.util.List;

public interface BillingOperations {
    public void collectUserInfo(User user);

    public Double getGroceriedItemCost(List<Item> ItemList);

    public Double collectPurchasedItems(List<Item> ItemList);

    public Double userRoleDiscountApply(Double cost);

    public Double totalBillingDiscountApply(Double cost);

    public String printBillingDetails(Billing bill);

}
