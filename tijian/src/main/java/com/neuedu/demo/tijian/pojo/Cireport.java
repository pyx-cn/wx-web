package com.neuedu.demo.tijian.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * @TableName cireport
 */
@TableName(value ="cireport")
public class Cireport implements Serializable {
    /**
     * æ£€æŸ¥é¡¹æŠ¥å‘Šä¸»é”®
     */
    @TableId(type = IdType.AUTO)
    private Integer cirid;

    /**
     * æ£€æŸ¥é¡¹ç¼–å·
     */
    private Integer ciid;

    /**
     * æ£€æŸ¥é¡¹åç§°
     */
    private String ciname;

    /**
     * æ‰€å±žé¢„çº¦ç¼–å·
     */
    private Integer orderid;

    @TableField(exist = false)
    private List<Cidetailedreport> detailedreports;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * æ£€æŸ¥é¡¹æŠ¥å‘Šä¸»é”®
     */
    public Integer getCirid() {
        return cirid;
    }

    /**
     * æ£€æŸ¥é¡¹æŠ¥å‘Šä¸»é”®
     */
    public void setCirid(Integer cirid) {
        this.cirid = cirid;
    }

    /**
     * æ£€æŸ¥é¡¹ç¼–å·
     */
    public Integer getCiid() {
        return ciid;
    }

    /**
     * æ£€æŸ¥é¡¹ç¼–å·
     */
    public void setCiid(Integer ciid) {
        this.ciid = ciid;
    }

    /**
     * æ£€æŸ¥é¡¹åç§°
     */
    public String getCiname() {
        return ciname;
    }

    /**
     * æ£€æŸ¥é¡¹åç§°
     */
    public void setCiname(String ciname) {
        this.ciname = ciname;
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
        Cireport other = (Cireport) that;
        return (this.getCirid() == null ? other.getCirid() == null : this.getCirid().equals(other.getCirid()))
            && (this.getCiid() == null ? other.getCiid() == null : this.getCiid().equals(other.getCiid()))
            && (this.getCiname() == null ? other.getCiname() == null : this.getCiname().equals(other.getCiname()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()));
    }

    public List<Cidetailedreport> getDetailedreports() {
        return detailedreports;
    }

    public void setDetailedreports(List<Cidetailedreport> detailedreports) {
        this.detailedreports = detailedreports;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCirid() == null) ? 0 : getCirid().hashCode());
        result = prime * result + ((getCiid() == null) ? 0 : getCiid().hashCode());
        result = prime * result + ((getCiname() == null) ? 0 : getCiname().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cirid=").append(cirid);
        sb.append(", ciid=").append(ciid);
        sb.append(", ciname=").append(ciname);
        sb.append(", orderid=").append(orderid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}