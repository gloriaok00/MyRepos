package org.example.edge;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * 分页入参
 */

@Data
public class PageReq {

    //第几页(默认第1页)
    @Min(1)
    private int page = 1;

    //每页条数(默认每页10条)
    @Min(1)
    private int pageSize = 10;

}
