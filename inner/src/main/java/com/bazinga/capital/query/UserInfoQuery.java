package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈用户测试 查询参数〉<p>
 *
 * @author
 * @date 2018-12-20
 */

public class UserInfoQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 生日 开始
     */
    private Date birthdayFrom;

    /**
     * 生日 结束
     */
    private Date birthdayTo;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改时间 开始
     */
    private Date modifyTimeFrom;

    /**
     * 修改时间 结束
     */
    private Date modifyTimeTo;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthdayFrom() {
        return birthdayFrom;
    }

    public void setBirthdayFrom(Date birthdayFrom) {
        this.birthdayFrom = birthdayFrom;
    }

    public Date getBirthdayTo() {
        return birthdayTo;
    }

    public void setBirthdayTo(Date birthdayTo) {
        this.birthdayTo = birthdayTo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTimeFrom() {
        return createTimeFrom;
    }

    public void setCreateTimeFrom(Date createTimeFrom) {
        this.createTimeFrom = createTimeFrom;
    }

    public Date getCreateTimeTo() {
        return createTimeTo;
    }

    public void setCreateTimeTo(Date createTimeTo) {
        this.createTimeTo = createTimeTo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifyTimeFrom() {
        return modifyTimeFrom;
    }

    public void setModifyTimeFrom(Date modifyTimeFrom) {
        this.modifyTimeFrom = modifyTimeFrom;
    }

    public Date getModifyTimeTo() {
        return modifyTimeTo;
    }

    public void setModifyTimeTo(Date modifyTimeTo) {
        this.modifyTimeTo = modifyTimeTo;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}