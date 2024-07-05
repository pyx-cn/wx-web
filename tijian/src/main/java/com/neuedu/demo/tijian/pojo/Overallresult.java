package com.neuedu.demo.tijian.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName overallresult
 */
@TableName(value ="overallresult")
public class Overallresult implements Serializable {
    /**
     * æ€»æ£€ç»“è®ºé¡¹ç¼–å·
     */
    @TableId(type = IdType.AUTO)
    private Integer orid;

    /**
     * æ€»æ£€ç»“è®ºé¡¹æ ‡é¢˜
     */
    private String title;

    /**
     * æ€»æ£€ç»“è®ºé¡¹å†…å®¹
     */
    private String content;

    /**
     * æ‰€å±žé¢„çº¦ç¼–å·
     */
    private Integer orderid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * æ€»æ£€ç»“è®ºé¡¹ç¼–å·
     */
    public Integer getOrid() {
        return orid;
    }

    /**
     * æ€»æ£€ç»“è®ºé¡¹ç¼–å·
     */
    public void setOrid(Integer orid) {
        this.orid = orid;
    }

    /**
     * æ€»æ£€ç»“è®ºé¡¹æ ‡é¢˜
     */
    public String getTitle() {
        return title;
    }

    /**
     * æ€»æ£€ç»“è®ºé¡¹æ ‡é¢˜
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * æ€»æ£€ç»“è®ºé¡¹å†…å®¹
     */
    public String getContent() {
        return content;
    }

    /**
     * æ€»æ£€ç»“è®ºé¡¹å†…å®¹
     */
    public void setContent(String content) {
        this.content = content;
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
        Overallresult other = (Overallresult) that;
        return (this.getOrid() == null ? other.getOrid() == null : this.getOrid().equals(other.getOrid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrid() == null) ? 0 : getOrid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orid=").append(orid);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", orderid=").append(orderid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}