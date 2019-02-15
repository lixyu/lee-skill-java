/*
package com.lee.happy.service;

*/
/**
 * @author lee
 * @date 2019/2/15
 *//*


public class ChannelImportService {
    private final ChannelImportDao channelImportDao;

    public ChannelImportService(ChannelImportDao channelImportDao) {
        this.channelImportDao = channelImportDao;
    }

    @Log
    public void manaulImport() {
        //String url = "http://10.138.61.57:30000/boltloan-api/channel/register";
        String url = "http://10.1.13.21:10000/api/channel/register";
        List<ChannelImport> importList = channelImportDao.findByStatus();
        List<ChannelInputPO> inputPOList = importList.stream().map(channelImport -> {
            ChannelInputPO input = new ChannelInputPO(channelImport.getName(), channelImport.getIdno(), channelImport.getMobile(),
                    0, channelImport.getChannel(), channelImport.getChannelUserId());
            String param = JacksonUtils.obj2Json(input);
            log.info("入参:" + param);
            String result = HttpUtils.doJson(url, param, BoltLoanConstants.TIME_OUT);
            log.info("出参:" + result);
            Map<String, String> map = JacksonUtils.json2Map(result);
            if ("10000".equals(map.get("code"))) {
                channelImport.setStatus(1);
                channelImportDao.updateById(channelImport);
            }

            return input;
        }).collect(Collectors.toList());
        log.info("导入记录数" + inputPOList.size());
        log.info("导入完成");
    }

}
*/
