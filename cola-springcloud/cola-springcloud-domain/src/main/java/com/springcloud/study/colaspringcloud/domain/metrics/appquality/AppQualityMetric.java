package com.springcloud.study.colaspringcloud.domain.metrics.appquality;

import com.springcloud.study.colaspringcloud.domain.metrics.MainMetric;
import com.springcloud.study.colaspringcloud.domain.metrics.MainMetricType;
import com.springcloud.study.colaspringcloud.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
