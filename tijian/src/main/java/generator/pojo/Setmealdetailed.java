package generator.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName setmealdetailed
 */
@TableName(value ="setmealdetailed")
public class Setmealdetailed implements Serializable {
    /**
     * å¥—é¤æ˜Žç»†ç¼–å·ï¼ˆæ— æ„ä¹‰ä¸»é”®ï¼‰
     */
    @TableId(type = IdType.AUTO)
    private Integer sdid;

    /**
     * å¥—é¤ç¼–å·
     */
    private Integer smid;

    /**
     * æ£€æŸ¥é¡¹ç¼–å·
     */
    private Integer ciid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * å¥—é¤æ˜Žç»†ç¼–å·ï¼ˆæ— æ„ä¹‰ä¸»é”®ï¼‰
     */
    public Integer getSdid() {
        return sdid;
    }

    /**
     * å¥—é¤æ˜Žç»†ç¼–å·ï¼ˆæ— æ„ä¹‰ä¸»é”®ï¼‰
     */
    public void setSdid(Integer sdid) {
        this.sdid = sdid;
    }

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
        Setmealdetailed other = (Setmealdetailed) that;
        return (this.getSdid() == null ? other.getSdid() == null : this.getSdid().equals(other.getSdid()))
            && (this.getSmid() == null ? other.getSmid() == null : this.getSmid().equals(other.getSmid()))
            && (this.getCiid() == null ? other.getCiid() == null : this.getCiid().equals(other.getCiid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSdid() == null) ? 0 : getSdid().hashCode());
        result = prime * result + ((getSmid() == null) ? 0 : getSmid().hashCode());
        result = prime * result + ((getCiid() == null) ? 0 : getCiid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sdid=").append(sdid);
        sb.append(", smid=").append(smid);
        sb.append(", ciid=").append(ciid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}