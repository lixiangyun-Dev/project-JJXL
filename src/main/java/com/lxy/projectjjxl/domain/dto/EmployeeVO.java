package com.lxy.projectjjxl.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/28 11:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {
    private String username;

    private String password;
}
