package com.example.retailstore.userbuilder;

import com.example.retailstore.user.Billing;
import com.example.retailstore.user.Item;
import com.example.retailstore.user.ItemCategory;
import com.example.retailstore.user.User;

import java.util.List;

public class RetailSiteBilling implements BillingOperations {

    private Billing userBill;

    private User user;

    /*
     * Init User Info and Bill
     */
    @Override
    public void collectUserInfo(User user) {

        userBill = new Billing();

        this.user = user;

    }


    /*
     *  This function used to prepare shopping list for bill calculation
     * @param ItemList list of item user buy
     *
     * @return total bill cost
     */
    @Override
    public Double collectPurchasedItems(List<Item> ItemList) {

        userBill.setItemList(ItemList);

        return getTotalBillingCost(ItemList);

    }

    /*
     * This function to calculate shopping cost for all items
     *
     * @param ItemList list of item user buy
     *
     * @return total bill cost
     */
    private Double getTotalBillingCost(List<Item> ItemList) {
        Double cost = 0.0;

        for (Item Item : ItemList) {
            cost += Item.getItemCost();
        }
        return cost;
    }

    /**
     * This function user to apply discount per user segment as the following
     * Employee of the store, he gets a 30% discount
     * Affiliate of the store, he gets a 10% discount
     * Customer for over 2 years, he gets a 5% discount
     *
     * @return total bill cost after user role discount
     */
    @Override
    public Double userRoleDiscountApply(Double cost) {
        userBill.setTotalBilling(cost);
        Double discountAmount = 0.0;
        int discountPercentage = user.getUserRole().getDiscountPercentage();
        Double groceriesAmount = getGroceriedItemCost(userBill.getItemList());
        System.out.println("Total Bill Amount is :" + userBill.getTotalBilling());
        System.out.println(
                "User Type is: " + user.getUserRole().getUserRoleId() + "Discount: " + discountPercentage + " %");

        System.out.println("Total GROCERIES items is :" + groceriesAmount);
        discountAmount = (cost - groceriesAmount);
        System.out.println("Total Bill Amount Without GROCERIES is :" + discountAmount);

        discountAmount = ((discountAmount * discountPercentage) / 100);
        System.out.println("Total user Type discount Amount: " + discountAmount);

        userBill.setTotalBillingAfterUserRoleDiscount(cost - discountAmount);

        System.out.println(
                "Total Bill Amount After User Type Discount is :" + userBill.getTotalBillingAfterUserRoleDiscount());

        return userBill.getTotalBillingAfterUserRoleDiscount();
    }

    /*
     * This function used to calculate final discount on bill using the following
     * For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount).
     *
     * @param billCost after apply first discount for user type
     * @return final bill amount after apply discount
     */
    @Override
    public Double totalBillingDiscountApply(Double billCost) {

        System.out.println("Bill Amount Before Final Discount is : " + billCost);

        // Decrease 5 for each 100
        userBill.setFinalbillingCost(billCost - (Math.floor(Math.floor(billCost) / 100) * 5));
        System.out.println("Bill Amount After Final Discount is : " + userBill.getFinalbillingCost());

        return userBill.getFinalbillingCost();

    }

    /*
     * This function used to return the total of grocieres items
     *
     * @param ItemList  list of item user buy
     * @return cost of groceries items
     */
    @Override
    public Double getGroceriedItemCost(List<Item> ItemList) {
        Double cost = 0.0;
        for (Item Item : userBill.getItemList()) {
            if (Item.getCategory().equals(ItemCategory.GROCERIES)) {
                cost += Item.getItemCost();
            }
        }

        return cost;
    }

    /*
     * This function used to print full trace of bill statment
     * @param Bill
     *
     */
    @Override
    public String printBillingDetails(Billing bill) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User Details:");
        stringBuilder.append(user.toString());
        stringBuilder.append("Shop the following:");
        stringBuilder.append(bill.getItemList().toString());
        stringBuilder.append(" Total Bill Amount : ");
        stringBuilder.append(bill.getTotalBilling());
        stringBuilder.append(" Bill Amount After User Discount:");
        stringBuilder.append(bill.getTotalBillingAfterUserRoleDiscount());
        stringBuilder.append(" Bill Amount After final Discount:");
        stringBuilder.append(bill.getFinalbillingCost());
        return stringBuilder.toString();

    }

}
