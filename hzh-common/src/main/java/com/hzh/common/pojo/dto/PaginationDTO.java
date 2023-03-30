package com.hzh.common.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 分页请求对象
 * @Author: FXS) Hzh
 * @Date: 2023/3/28 10:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页显示数量",required = true)
    private Integer size;

    @ApiModelProperty(value = "当前页",required = true)
    private Integer current;

}
