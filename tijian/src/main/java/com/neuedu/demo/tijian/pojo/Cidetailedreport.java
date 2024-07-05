package com.neuedu.demo.tijian.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName cidetailedreport
 */
@TableName(value ="cidetailedreport")
public class Cidetailedreport implements Serializable {
    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†æŠ¥å‘Šä¸»é”®
     */
    @TableId(type = IdType.AUTO)
    private Integer cidrid;

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†åç§°
     */
    private String name;

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†å•ä½
     */
    private String unit;

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼èŒƒå›´ä¸­çš„æœ€å°å€¼
     */
    private Double minrange;

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼èŒƒå›´ä¸­çš„æœ€å¤§å€¼
     */
    private Double maxrange;

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼ï¼ˆéžæ•°å­—åž‹ï¼‰
     */
    private String normalvalue;

    /**
     * æ£€æŸ¥é¡¹éªŒè¯èŒƒå›´è¯´æ˜Žæ–‡å­—
     */
    private String normalvaluestring;

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†ç±»åž‹ï¼ˆ1ï¼šæ•°å€¼èŒƒå›´éªŒè¯åž‹ï¼›2ï¼šæ•°å€¼ç›¸ç­‰éªŒè¯åž‹ï¼›3ï¼šæ— éœ€éªŒè¯åž‹ï¼›4ï¼šæè¿°åž‹ï¼›5ï¼šå…¶å®ƒï¼‰
     */
    private Integer type;

    /**
     * æ£€æŸ¥é¡¹ç›®æ˜Žç»†å€¼
     */
    private String value;

    /**
     * æ­¤é¡¹æ˜¯å¦å¼‚å¸¸ï¼ˆ0ï¼šæ— å¼‚å¸¸ï¼›1ï¼šå¼‚å¸¸ï¼‰
     */
    private Integer iserror;

    /**
     * æ‰€å±žæ£€æŸ¥é¡¹æŠ¥å‘Šç¼–å·
     */
    private Integer ciid;

    /**
     * æ‰€å±žé¢„çº¦ç¼–å·
     */
    private Integer orderid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†æŠ¥å‘Šä¸»é”®
     */
    public Integer getCidrid() {
        return cidrid;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†æŠ¥å‘Šä¸»é”®
     */
    public void setCidrid(Integer cidrid) {
        this.cidrid = cidrid;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†åç§°
     */
    public String getName() {
        return name;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†åç§°
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†å•ä½
     */
    public String getUnit() {
        return unit;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†å•ä½
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼èŒƒå›´ä¸­çš„æœ€å°å€¼
     */
    public Double getMinrange() {
        return minrange;
    }

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼èŒƒå›´ä¸­çš„æœ€å°å€¼
     */
    public void setMinrange(Double minrange) {
        this.minrange = minrange;
    }

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼èŒƒå›´ä¸­çš„æœ€å¤§å€¼
     */
    public Double getMaxrange() {
        return maxrange;
    }

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼èŒƒå›´ä¸­çš„æœ€å¤§å€¼
     */
    public void setMaxrange(Double maxrange) {
        this.maxrange = maxrange;
    }

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼ï¼ˆéžæ•°å­—åž‹ï¼‰
     */
    public String getNormalvalue() {
        return normalvalue;
    }

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žæ­£å¸¸å€¼ï¼ˆéžæ•°å­—åž‹ï¼‰
     */
    public void setNormalvalue(String normalvalue) {
        this.normalvalue = normalvalue;
    }

    /**
     * æ£€æŸ¥é¡¹éªŒè¯èŒƒå›´è¯´æ˜Žæ–‡å­—
     */
    public String getNormalvaluestring() {
        return normalvaluestring;
    }

    /**
     * æ£€æŸ¥é¡¹éªŒè¯èŒƒå›´è¯´æ˜Žæ–‡å­—
     */
    public void setNormalvaluestring(String normalvaluestring) {
        this.normalvaluestring = normalvaluestring;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†ç±»åž‹ï¼ˆ1ï¼šæ•°å€¼èŒƒå›´éªŒè¯åž‹ï¼›2ï¼šæ•°å€¼ç›¸ç­‰éªŒè¯åž‹ï¼›3ï¼šæ— éœ€éªŒè¯åž‹ï¼›4ï¼šæè¿°åž‹ï¼›5ï¼šå…¶å®ƒï¼‰
     */
    public Integer getType() {
        return type;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†ç±»åž‹ï¼ˆ1ï¼šæ•°å€¼èŒƒå›´éªŒè¯åž‹ï¼›2ï¼šæ•°å€¼ç›¸ç­‰éªŒè¯åž‹ï¼›3ï¼šæ— éœ€éªŒè¯åž‹ï¼›4ï¼šæè¿°åž‹ï¼›5ï¼šå…¶å®ƒï¼‰
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * æ£€æŸ¥é¡¹ç›®æ˜Žç»†å€¼
     */
    public String getValue() {
        return value;
    }

    /**
     * æ£€æŸ¥é¡¹ç›®æ˜Žç»†å€¼
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * æ­¤é¡¹æ˜¯å¦å¼‚å¸¸ï¼ˆ0ï¼šæ— å¼‚å¸¸ï¼›1ï¼šå¼‚å¸¸ï¼‰
     */
    public Integer getIserror() {
        return iserror;
    }

    /**
     * æ­¤é¡¹æ˜¯å¦å¼‚å¸¸ï¼ˆ0ï¼šæ— å¼‚å¸¸ï¼›1ï¼šå¼‚å¸¸ï¼‰
     */
    public void setIserror(Integer iserror) {
        this.iserror = iserror;
    }

    /**
     * æ‰€å±žæ£€æŸ¥é¡¹æŠ¥å‘Šç¼–å·
     */
    public Integer getCiid() {
        return ciid;
    }

    /**
     * æ‰€å±žæ£€æŸ¥é¡¹æŠ¥å‘Šç¼–å·
     */
    public void setCiid(Integer ciid) {
        this.ciid = ciid;
    }

    /**
     * æ‰€å±žé¢„çº¦ç¼–å·
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * æ‰€å±žé¢„çº¦ç¼–å·
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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
        Cidetailedreport other = (Cidetailedreport) that;
        return (this.getCidrid() == null ? other.getCidrid() == null : this.getCidrid().equals(other.getCidrid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getMinrange() == null ? other.getMinrange() == null : this.getMinrange().equals(other.getMinrange()))
            && (this.getMaxrange() == null ? other.getMaxrange() == null : this.getMaxrange().equals(other.getMaxrange()))
            && (this.getNormalvalue() == null ? other.getNormalvalue() == null : this.getNormalvalue().equals(other.getNormalvalue()))
            && (this.getNormalvaluestring() == null ? other.getNormalvaluestring() == null : this.getNormalvaluestring().equals(other.getNormalvaluestring()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getIserror() == null ? other.getIserror() == null : this.getIserror().equals(other.getIserror()))
            && (this.getCiid() == null ? other.getCiid() == null : this.getCiid().equals(other.getCiid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCidrid() == null) ? 0 : getCidrid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getMinrange() == null) ? 0 : getMinrange().hashCode());
        result = prime * result + ((getMaxrange() == null) ? 0 : getMaxrange().hashCode());
        result = prime * result + ((getNormalvalue() == null) ? 0 : getNormalvalue().hashCode());
        result = prime * result + ((getNormalvaluestring() == null) ? 0 : getNormalvaluestring().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getIserror() == null) ? 0 : getIserror().hashCode());
        result = prime * result + ((getCiid() == null) ? 0 : getCiid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cidrid=").append(cidrid);
        sb.append(", name=").append(name);
        sb.append(", unit=").append(unit);
        sb.append(", minrange=").append(minrange);
        sb.append(", maxrange=").append(maxrange);
        sb.append(", normalvalue=").append(normalvalue);
        sb.append(", normalvaluestring=").append(normalvaluestring);
        sb.append(", type=").append(type);
        sb.append(", value=").append(value);
        sb.append(", iserror=").append(iserror);
        sb.append(", ciid=").append(ciid);
        sb.append(", orderid=").append(orderid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}