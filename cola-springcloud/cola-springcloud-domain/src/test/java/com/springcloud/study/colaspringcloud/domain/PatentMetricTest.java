package com.springcloud.study.colaspringcloud.domain;

import com.springcloud.study.colaspringcloud.domain.metrics.techinfluence.AuthorType;
import com.springcloud.study.colaspringcloud.domain.metrics.techinfluence.InfluenceMetric;
import com.springcloud.study.colaspringcloud.domain.metrics.techinfluence.PatentMetric;
import com.springcloud.study.colaspringcloud.domain.metrics.techinfluence.PatentMetricItem;
import com.springcloud.study.colaspringcloud.domain.user.UserProfile;
import org.junit.Assert;
import org.junit.Test;

/**
 * PatentMetricTest
 *
 * @author Frank Zhang
 * @date 2019-02-26 4:20 PM
 */
public class PatentMetricTest {

    @Test
    public void testPatentMetric(){
        PatentMetric patentMetric = new PatentMetric(new InfluenceMetric(new UserProfile()));
        patentMetric.addMetricItem(new PatentMetricItem("patentName","patentDesc","patentNo","sharingLink", AuthorType.FIRST_AUTHOR));
        patentMetric.addMetricItem(new PatentMetricItem("patentName","patentDesc","patentNo","sharingLink", AuthorType.OTHER_AUTHOR));

        Assert.assertEquals(25, patentMetric.calculateScore(), 0.01);

    }
}
