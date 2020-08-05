package com.springcloud.study.colaspringcloud.domain.metrics.techcontribution;

import com.springcloud.study.colaspringcloud.domain.metrics.MainMetric;
import com.springcloud.study.colaspringcloud.domain.metrics.SubMetric;
import com.springcloud.study.colaspringcloud.domain.metrics.SubMetricType;

/**
 * 重构指标
 * @author xueliang.sxl, alisa.hsh, xiangning.lxn
 */
public class RefactoringMetric extends SubMetric {

    public RefactoringMetric(){
        this.subMetricType = SubMetricType.Refactoring;
    }

    public RefactoringMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricType.Refactoring;
    }

    @Override
    public double getWeight() {
        return  metricOwner.getWeight().getUnanimousWeight();
    }
}
