package com.springcloud.study.colaspringcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RefreshScoreCmd extends CommonCommand{
    private String userId;
}
