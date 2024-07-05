package generator.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName orders
 */
@TableName(value ="orders")
public class Orders implements Serializable {
    /**
     * è®¢å•ç¼–å·
     */
    @TableId(type = IdType.AUTO)
    private Integer orderid;

    /**
     * é¢„çº¦æ—¥æœŸ
     */
    private Date orderdate;

    /**
     * å®¢æˆ·ç¼–å·
     */
    private String userid;

    /**
     * æ‰€å±žåŒ»é™¢ç¼–å·
     */
    private Integer hpid;

    /**
     * æ‰€å±žå¥—é¤ç¼–å·
     */
    private Integer smid;

    /**
     * è®¢å•çŠ¶æ€ï¼ˆ1ï¼šæœªå½’æ¡£ï¼›2ï¼šå·²å½’æ¡£ï¼‰
     */
    private Integer state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * è®¢å•ç¼–å·
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * è®¢å•ç¼–å·
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * é¢„çº¦æ—¥æœŸ
     */
    public Date getOrderdate() {
        return orderdate;
    }

    /**
     * é¢„çº¦æ—¥æœŸ
     */
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    /**
     * å®¢æˆ·ç¼–å·
     */
    public String getUserid() {
        return userid;
    }

    /**
     * å®¢æˆ·ç¼–å·
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * æ‰€å±žåŒ»é™¢ç¼–å·
     */
    public Integer getHpid() {
        return hpid;
    }

    /**
     * æ‰€å±žåŒ»é™¢ç¼–å·
     */
    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }

    /**
     * æ‰€å±žå¥—é¤ç¼–å·
     */
    public Integer getSmid() {
        return smid;
    }

    /**
     * æ‰€å±žå¥—é¤ç¼–å·
     */
    public void setSmid(Integer smid) {
        this.smid = smid;
    }

    /**
     * è®¢å•çŠ¶æ€ï¼ˆ1ï¼šæœªå½’æ¡£ï¼›2ï¼šå·²å½’æ¡£ï¼‰
     */
    public Integer getState() {
        return state;
    }

    /**
     * è®¢å•çŠ¶æ€ï¼ˆ1ï¼šæœªå½’æ¡£ï¼›2ï¼šå·²å½’æ¡£ï¼‰
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
        Orders other = (Orders) that;
        return (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getOrderdate() == null ? other.getOrderdate() == null : this.getOrderdate().equals(other.getOrderdate()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getHpid() == null ? other.getHpid() == null : this.getHpid().equals(other.getHpid()))
            && (this.getSmid() == null ? other.getSmid() == null : this.getSmid().equals(other.getSmid()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getOrderdate() == null) ? 0 : getOrderdate().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getHpid() == null) ? 0 : getHpid().hashCode());
        result = prime * result + ((getSmid() == null) ? 0 : getSmid().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderid=").append(orderid);
        sb.append(", orderdate=").append(orderdate);
        sb.append(", userid=").append(userid);
        sb.append(", hpid=").append(hpid);
        sb.append(", smid=").append(smid);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}