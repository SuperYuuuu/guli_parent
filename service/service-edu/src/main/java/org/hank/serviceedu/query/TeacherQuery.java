package org.hank.serviceedu.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Hank
 * @date 2021/3/9
 */
@ApiModel(value = "Teacher查询对象", description = "讲师查询对象封装")
@Data
public class TeacherQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer level;

    private String begin;

    private String end;
}
