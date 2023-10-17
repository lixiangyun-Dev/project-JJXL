package com.lxy.projectjjxl.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/27 10:25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonPageHelper {
    private long total;  //总记录条数
    private List rows;  //结果列表
}
