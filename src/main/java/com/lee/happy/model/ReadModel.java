package com.lee.happy.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lee
 * @date 2019/2/26
 */
@Data
@NoArgsConstructor
public class ReadModel extends BaseRowModel {

    @ExcelProperty(value = {"授信时间"}, index = 0)
    private String creditTime;
    @ExcelProperty(value = {"total_amount"}, index = 1)
    private String total_amount;
    @ExcelProperty(value = {"cust_id"}, index = 2)
    private String custId;
    @ExcelProperty(value = {"提额后的额度"}, index = 3)
    private String amount;

}
