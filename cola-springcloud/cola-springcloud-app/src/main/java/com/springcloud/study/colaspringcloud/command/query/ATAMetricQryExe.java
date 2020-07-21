package com.springcloud.study.colaspringcloud.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.fastjson.JSON;
import com.springcloud.study.colaspringcloud.domain.metrics.SubMetricType;
import com.springcloud.study.colaspringcloud.dto.ATAMetricQry;
import com.springcloud.study.colaspringcloud.dto.clientobject.ATAMetricCO;
import com.springcloud.study.colaspringcloud.gatewayimpl.database.MetricMapper;
import com.springcloud.study.colaspringcloud.gatewayimpl.database.dataobject.MetricDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ATAMetricQryExe{

    @Resource
    private MetricMapper metricMapper;

    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {
        List<MetricDO> metricDOList = metricMapper.listBySubMetric(cmd.getOwnerId(), SubMetricType.ATA.getMetricSubTypeCode());
        List<ATAMetricCO> ataMetricCOList = new ArrayList<>();
        metricDOList.forEach(metricDO -> {
            ATAMetricCO ataMetricCO = JSON.parseObject(metricDO.getMetricItem(), ATAMetricCO.class);
            ataMetricCO.setOwnerId(metricDO.getUserId());
            ataMetricCOList.add(ataMetricCO);
        });
        return MultiResponse.ofWithoutTotal(ataMetricCOList);
    }

}
