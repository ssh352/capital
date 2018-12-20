package com.bazinga.capital.model;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.util.Date;
import java.util.Date;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈用户测试〉<p>
 *
 * @author
 * @date 2018-12-20
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   PRIMARY
     */
    private Integer id;

    /**
     * 姓名
     *
     * @最大长度   30
     * @允许为空   NO
     * @是否索引   YES
     */
    private String name;

    /**
     * 身份证
     *
     * @最大长度   20
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   uk_id_card
     */
    private String idCard;

    /**
     * 性别
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer sex;

    /**
     * 生日
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Date birthday;

    /**
     * 状态
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer status;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @最大长度   20
     * @允许为空   NO
     * @是否索引   NO
     */
    private String creator;

    /**
     * 修改时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date modifyTime;

    /**
     * 修改人
     *
     * @最大长度   20
     * @允许为空   YES
     * @是否索引   NO
     */
    private String modifier;

    /**
     * 是否删除
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", status=" + status +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", modifyTime=" + modifyTime +
                ", modifier='" + modifier + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}