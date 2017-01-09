package com.self.shopping;

import java.math.BigDecimal;

/**
 * Created by rangak on 06/01/2017.
 */
public class TotalCost {
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private BigDecimal subTotalAmount = BigDecimal.ZERO;


    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getSubTotalAmount() {
        return subTotalAmount;
    }

    public void setSubTotalAmount(BigDecimal subTotalAmount) {
        this.subTotalAmount = subTotalAmount;
    }
}
