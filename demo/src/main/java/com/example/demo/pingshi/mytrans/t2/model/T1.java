package com.example.demo.pingshi.mytrans.t2.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2022-07-13
 */
@Data
@EqualsAndHashCode
@ApiModel(value="T1对象", description="")
public class T1 {

    private static final long serialVersionUID=1L;

    private String name;

    private String createDate;

}
