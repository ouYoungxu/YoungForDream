package com.ouyang.study.array;

import java.util.Date;

/**
 * @author: ganjiang-ouyangxu
 * @Date: 2018年08月14日 11:23
 **/
public class ContractUser {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 签约用户
     */
    private Long userId;
    /**
     * 签约合同'
     */
    private Long contractId;
    /**
     * 签约人姓名
     */
    private String signName;
    /**
     * 签约手机
     */
    private String signMobile;
    /**
     * 签约方式 1:代签 2:无感知签名 3:有感知签名
     */
    private Integer signType;

    /**
     * 签章模式：1:普通签约 2:CFCA签约 3:SZCA签约
     */
    private Integer signMode;
    /**
     * 印章id
     */
    private Long sealId;
    /**
     * 签章类型（不能为空），1=空白标签签章,2=坐标签章,3=关键字签章
     */
    private Integer caSignType;

    /** 签约检验方式 1:短信验证码签约 2：签约密码签约 */
    private Integer validateType;
    /**
     * 签约关键字
     */
    private String signKey;
    /**
     * 签约X坐标
     */
    private Integer signX;
    /**
     * 签约Y坐标
     */
    private Integer signY;
    /**
     * 签约页码
     */
    private String signPage;
    /**
     * 签约顺序
     */
    private Integer signOrder;
    /**
     * 是否发起人 0-否 1-是
     */
    private Integer isSponsor;
    /**
     * 签约状态1.未签约2.已签约3.签约失败
     */
    private Integer signStatus;
    /**
     * 签约时间
     */
    private Date signTime;
    /**
     * 拒签原因
     */
    private String denyReason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getSignMobile() {
        return signMobile;
    }

    public void setSignMobile(String signMobile) {
        this.signMobile = signMobile;
    }

    public Integer getSignType() {
        return signType;
    }

    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    public Integer getSignMode() {
        return signMode;
    }

    public void setSignMode(Integer signMode) {
        this.signMode = signMode;
    }

    public Long getSealId() {
        return sealId;
    }

    public void setSealId(Long sealId) {
        this.sealId = sealId;
    }

    public Integer getCaSignType() {
        return caSignType;
    }

    public void setCaSignType(Integer caSignType) {
        this.caSignType = caSignType;
    }

    public Integer getValidateType() {
        return validateType;
    }

    public void setValidateType(Integer validateType) {
        this.validateType = validateType;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public Integer getSignX() {
        return signX;
    }

    public void setSignX(Integer signX) {
        this.signX = signX;
    }

    public Integer getSignY() {
        return signY;
    }

    public void setSignY(Integer signY) {
        this.signY = signY;
    }

    public String getSignPage() {
        return signPage;
    }

    public void setSignPage(String signPage) {
        this.signPage = signPage;
    }

    public Integer getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
    }

    public Integer getIsSponsor() {
        return isSponsor;
    }

    public void setIsSponsor(Integer isSponsor) {
        this.isSponsor = isSponsor;
    }

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getDenyReason() {
        return denyReason;
    }

    public void setDenyReason(String denyReason) {
        this.denyReason = denyReason;
    }

    @Override
    public String toString() {
        return "ContractUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", contractId=" + contractId +
                ", signName='" + signName + '\'' +
                ", signMobile='" + signMobile + '\'' +
                ", signType=" + signType +
                ", signMode=" + signMode +
                ", sealId=" + sealId +
                ", caSignType=" + caSignType +
                ", validateType=" + validateType +
                ", signKey='" + signKey + '\'' +
                ", signX=" + signX +
                ", signY=" + signY +
                ", signPage='" + signPage + '\'' +
                ", signOrder=" + signOrder +
                ", isSponsor=" + isSponsor +
                ", signStatus=" + signStatus +
                ", signTime=" + signTime +
                ", denyReason='" + denyReason + '\'' +
                '}';
    }
}
