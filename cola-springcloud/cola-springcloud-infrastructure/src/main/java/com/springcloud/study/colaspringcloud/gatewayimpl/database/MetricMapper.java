package com.springcloud.study.colaspringcloud.gatewayimpl.database;

import com.springcloud.study.colaspringcloud.gatewayimpl.database.dataobject.MetricDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MetricMapper {

    int create(MetricDO dataObject);

    List<MetricDO> listByUserId(@Param("userId") String userId);

    List<MetricDO> listByMainMetric(@Param("userId") String userId, @Param("mainMetric") String mainMetric);

    List<MetricDO> listBySubMetric(@Param("userId") String userId, @Param("subMetric") String subMetric);

    int delete(@Param("id") String id, @Param("modifier") String modifier);

    MetricDO getById(@Param("id") String id);
}
