package com.lee.happy.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.lee.happy.model.ReadModel;

/**
 * @author lee
 * @date 2019/2/26
 */

public class ExcelListener extends AnalysisEventListener<ReadModel> {

    @Override
    public void invoke(ReadModel readModel, AnalysisContext analysisContext) {
        System.out.println("第" + analysisContext.getCurrentRowNum() + "行:" + JSON.toJSONString(readModel));
        readModel.setAmount(readModel.getTotal_amount() + "-------");
        System.out.println(JSON.toJSONString(readModel));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
