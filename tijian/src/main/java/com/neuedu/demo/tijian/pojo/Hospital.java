package com.neuedu.demo.tijian.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName hospital
 */
@TableName(value ="hospital")
public class Hospital implements Serializable {
    /**
     * åŒ»é™¢ç¼–å·
     */
    @TableId(type = IdType.AUTO)
    private Integer hpid;

    /**
     * åŒ»é™¢åç§°
     */
    private String name;

    /**
     * åŒ»é™¢å›¾ç‰‡
     */
    private String picture;

    /**
     * åŒ»é™¢ç”µè¯
     */
    private String telephone;

    /**
     * åŒ»é™¢åœ°å€
     */
    private String address;

    /**
     * è¥ä¸šæ—¶é—´
     */
    private String businesshours;

    /**
     * é‡‡è¡€æˆªæ­¢æ—¶é—´
     */
    private String deadline;

    /**
     * é¢„çº¦äººæ•°è§„åˆ™
     */
    private String rule;

    /**
     * åŒ»é™¢çŠ¶æ€ï¼ˆ1ï¼šæ­£å¸¸ï¼›2ï¼šå…¶ä»–ï¼‰
     */
    private Integer state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * åŒ»é™¢ç¼–å·
     */
    public Integer getHpid() {
        return hpid;
    }

    /**
     * åŒ»é™¢ç¼–å·
     */
    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }

    /**
     * åŒ»é™¢åç§°
     */
    public String getName() {
        return name;
    }

    /**
     * åŒ»é™¢åç§°
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * åŒ»é™¢å›¾ç‰‡
     */
    public String getPicture() {
        return picture;
    }

    /**
     * åŒ»é™¢å›¾ç‰‡
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * åŒ»é™¢ç”µè¯
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * åŒ»é™¢ç”µè¯
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * åŒ»é™¢åœ°å€
     */
    public String getAddress() {
        return address;
    }

    /**
     * åŒ»é™¢åœ°å€
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * è¥ä¸šæ—¶é—´
     */
    public String getBusinesshours() {
        return businesshours;
    }

    /**
     * è¥ä¸šæ—¶é—´
     */
    public void setBusinesshours(String businesshours) {
        this.businesshours = businesshours;
    }

    /**
     * é‡‡è¡€æˆªæ­¢æ—¶é—´
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * é‡‡è¡€æˆªæ­¢æ—¶é—´
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * é¢„çº¦äººæ•°è§„åˆ™
     */
    public String getRule() {
        return rule;
    }

    /**
     * é¢„çº¦äººæ•°è§„åˆ™
     */
    public void setRule(String rule) {
        this.rule = rule;
    }

    /**
     * åŒ»é™¢çŠ¶æ€ï¼ˆ1ï¼šæ­£å¸¸ï¼›2ï¼šå…¶ä»–ï¼‰
     */
    public Integer getState() {
        return state;
    }

    /**
     * åŒ»é™¢çŠ¶æ€ï¼ˆ1ï¼šæ­£å¸¸ï¼›2ï¼šå…¶ä»–ï¼‰
     */
    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Hospital other = (Hospital) that;
        return (this.getHpid() == null ? other.getHpid() == null : this.getHpid().equals(other.getHpid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getBusinesshours() == null ? other.getBusinesshours() == null : this.getBusinesshours().equals(other.getBusinesshours()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
            && (this.getRule() == null ? other.getRule() == null : this.getRule().equals(other.getRule()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHpid() == null) ? 0 : getHpid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getBusinesshours() == null) ? 0 : getBusinesshours().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        result = prime * result + ((getRule() == null) ? 0 : getRule().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hpid=").append(hpid);
        sb.append(", name=").append(name);
        sb.append(", picture=").append(picture);
        sb.append(", telephone=").append(telephone);
        sb.append(", address=").append(address);
        sb.append(", businesshours=").append(businesshours);
        sb.append(", deadline=").append(deadline);
        sb.append(", rule=").append(rule);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}