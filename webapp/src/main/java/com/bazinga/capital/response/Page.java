package com.bazinga.capital.response;

import lombok.Data;

/**
 * @author yunshan
 * @date 18/11/8
 */
@Data
public class Page {

    private Integer curPage;

    private Integer pageSize;

    private Integer totalNum;

    private Integer totalPage;

}
