package com.lee.happy.po;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lee
 * @date 2019/2/14
 */
@Data
@NoArgsConstructor
public class CustQuotaPo {
    private Integer custId;
    private Integer impAmount;

    public CustQuotaPo(Integer custId, Integer impAmount) {
        this.custId = custId;
        this.impAmount = impAmount;
    }
}
