package com.hzh.common.pojo.centre;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Hzh
 * @since 2023-03-20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("china_city")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="chinaCity对象", description="中国城市信息表")
public class ChinaCity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pid;

    private String cityname;

    private Integer type;

    @ApiModelProperty(value = "逻辑删除")
    private String state;


}
