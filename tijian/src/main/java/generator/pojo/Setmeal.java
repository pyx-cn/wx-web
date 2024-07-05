package generator.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName setmeal
 */
@TableName(value ="setmeal")
public class Setmeal implements Serializable {
    /**
     * å¥—é¤ç¼–å·
     */
    @TableId(type = IdType.AUTO)
    private Integer smid;

    /**
     * å¥—é¤åç§°
     */
    private String name;

    /**
     * å¥—é¤ç±»åž‹ï¼ˆ1ï¼šç”·å£«é¤å¥—ï¼›0ï¼šå¥³å£«å¥—é¤ï¼‰
     */
    private Integer type;

    /**
     * å¥—é¤ä»·æ ¼
     */
    private Integer price;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * å¥—é¤ç¼–å·
     */
    public Integer getSmid() {
        return smid;
    }

    /**
     * å¥—é¤ç¼–å·
     */
    public void setSmid(Integer smid) {
        this.smid = smid;
    }

    /**
     * å¥—é¤åç§°
     */
    public String getName() {
        return name;
    }

    /**
     * å¥—é¤åç§°
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * å¥—é¤ç±»åž‹ï¼ˆ1ï¼šç”·å£«é¤å¥—ï¼›0ï¼šå¥³å£«å¥—é¤ï¼‰
     */
    public Integer getType() {
        return type;
    }

    /**
     * å¥—é¤ç±»åž‹ï¼ˆ1ï¼šç”·å£«é¤å¥—ï¼›0ï¼šå¥³å£«å¥—é¤ï¼‰
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * å¥—é¤ä»·æ ¼
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * å¥—é¤ä»·æ ¼
     */
    public void setPrice(Integer price) {
        this.price = price;
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
        Setmeal other = (Setmeal) that;
        return (this.getSmid() == null ? other.getSmid() == null : this.getSmid().equals(other.getSmid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSmid() == null) ? 0 : getSmid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", smid=").append(smid);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}