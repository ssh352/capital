package com.bazinga.capital.response;

/**
 * @author yunshan
 * @date 18/11/6
 */

import java.io.Serializable;

/**
 * 〈一句话介绍功能〉<br>
 * 处理结果
 *
 * @author yunshan
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PlatformResult implements Serializable {

    public static final Integer  FAILURE= -1;

    public static final Integer SUCCESS = 0;
    private static final long serialVersionUID = -3584612613984584380L;

    private Integer code;

    private String msg;

    private Object data;

    private Page page;

    public PlatformResult() {}

    public PlatformResult(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean success () {
        return code != null && SUCCESS.equals(code);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static PlatformResult buildSuccessResult() {
        return new PlatformResult(SUCCESS);
    }

    public static PlatformResult buildFailureResult() {
        return new PlatformResult(FAILURE);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
