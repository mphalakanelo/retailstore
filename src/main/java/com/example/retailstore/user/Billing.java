package com.example.retailstore.user;

import java.util.List;

public class Billing {
    private List<Item> ItemList;
    private Double totalBilling;
    private Double totalBillingAfterUserRoleDiscount;
    private Double finalbillingCost;

    /**
     *
     */
    public Billing() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param ItemList
     * @param totalBilling
     * @param totalBillingAfterUserRoleDiscount
     * @param finalbillingCost
     */
    public Billing(List<Item> ItemList, Double totalBilling, Double totalBillingAfterUserRoleDiscount,
                Double finalbillingCost) {
        super();

        this.ItemList = ItemList;
        this.totalBilling = totalBilling;
        this.totalBillingAfterUserRoleDiscount = totalBillingAfterUserRoleDiscount;
        this.finalbillingCost = finalbillingCost;
    }

    public List<Item> getItemList() {
        return ItemList;
    }

    public void setItemList(List<Item> ItemList) {
        this.ItemList = ItemList;
    }

    public Double getTotalBilling() {
        return totalBilling;
    }

    public void setTotalBilling(Double totalBilling) {
        this.totalBilling = totalBilling;
    }

    public Double getTotalBillingAfterUserRoleDiscount() {
        return totalBillingAfterUserRoleDiscount;
    }

    public void setTotalBillingAfterUserRoleDiscount(Double totalBillingAfterUserRoleDiscount) {
        this.totalBillingAfterUserRoleDiscount = totalBillingAfterUserRoleDiscount;
    }

    public Double getFinalbillingCost() {
        return finalbillingCost;
    }

    public void setFinalbillingCost(Double finalbillingCost) {
        this.finalbillingCost = finalbillingCost;
    }

}
