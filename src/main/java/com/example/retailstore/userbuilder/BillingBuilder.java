package com.example.retailstore.userbuilder;

import com.example.retailstore.user.Billing;
import com.example.retailstore.user.Item;
import org.springframework.stereotype.Component;

import java.util.List;

public class BillingBuilder {
    @Component
    public class BillBuilder {

        private List<Item> ItemList;
        private Double totalBilling;
        private Double totalBillingAfterUserTypeDiscount;
        private Double finalbillingCost;

        public BillBuilder ItemList(List<Item> ItemList) {
            this.ItemList = ItemList;
            return this;
        }

        public BillBuilder totalBilling(Double totalBilling) {
            this.totalBilling = totalBilling;
            return this;

        }

        public BillBuilder totalBillAfterUserTypeDiscount(Double totalBillingAfterUserTypeDiscount) {
            this.totalBillingAfterUserTypeDiscount = totalBillingAfterUserTypeDiscount;
            return this;
        }

        public BillBuilder finalbillingCost(Double finalbillingCost) {
            this.finalbillingCost = finalbillingCost;
            return this;
        }

        public Billing Build() {
            return new Billing(ItemList, totalBilling, totalBillingAfterUserTypeDiscount, finalbillingCost);
        }

    }
}
