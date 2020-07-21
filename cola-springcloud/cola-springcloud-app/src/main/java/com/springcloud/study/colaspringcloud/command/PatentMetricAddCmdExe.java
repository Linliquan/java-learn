package com.springcloud.study.colaspringcloud.command;

import com.alibaba.cola.dto.Response;
import com.springcloud.study.colaspringcloud.domain.gateway.MetricGateway;
import com.springcloud.study.colaspringcloud.domain.metrics.techinfluence.AuthorType;
import com.springcloud.study.colaspringcloud.domain.metrics.techinfluence.InfluenceMetric;
import com.springcloud.study.colaspringcloud.domain.metrics.techinfluence.PatentMetric;
import com.springcloud.study.colaspringcloud.domain.metrics.techinfluence.PatentMetricItem;
import com.springcloud.study.colaspringcloud.domain.user.UserProfile;
import com.springcloud.study.colaspringcloud.dto.PatentMetricAddCmd;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * PatentMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:41 AM
 */
@Component
public class PatentMetricAddCmdExe{

    @Resource
    private MetricGateway metricGateway;

    public Response execute(PatentMetricAddCmd cmd) {
        PatentMetricItem patentMetricItem = new PatentMetricItem();
        BeanUtils.copyProperties(cmd.getPatentMetricCO(), patentMetricItem);
        patentMetricItem.setSubMetric(new PatentMetric(new InfluenceMetric(new UserProfile(cmd.getPatentMetricCO().getOwnerId()))));
        patentMetricItem.setAuthorType(AuthorType.valueOf(cmd.getPatentMetricCO().getAuthorType()));
        metricGateway.save(patentMetricItem);
        return Response.buildSuccess();
    }
}