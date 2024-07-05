package generator.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName checkitem
 */
@TableName(value ="checkitem")
public class Checkitem implements Serializable {
    /**
     * æ£€æŸ¥é¡¹ç¼–å·
     */
    @TableId(type = IdType.AUTO)
    private Integer ciid;

    /**
     * æ£€æŸ¥é¡¹åç§°
     */
    private String ciname;

    /**
     * æ£€æŸ¥é¡¹å†…å®¹
     */
    private String cicontent;

    /**
     * æ£€æŸ¥é¡¹æ„ä¹‰
     */
    private String meaning;

    /**
     * å¤‡æ³¨
     */
    private String remarks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
     * æ£€æŸ¥é¡¹å†…å®¹
     */
    public String getCicontent() {
        return cicontent;
    }

    /**
     * æ£€æŸ¥é¡¹å†…å®¹
     */
    public void setCicontent(String cicontent) {
        this.cicontent = cicontent;
    }

    /**
     * æ£€æŸ¥é¡¹æ„ä¹‰
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * æ£€æŸ¥é¡¹æ„ä¹‰
     */
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    /**
     * å¤‡æ³¨
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * å¤‡æ³¨
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        Checkitem other = (Checkitem) that;
        return (this.getCiid() == null ? other.getCiid() == null : this.getCiid().equals(other.getCiid()))
            && (this.getCiname() == null ? other.getCiname() == null : this.getCiname().equals(other.getCiname()))
            && (this.getCicontent() == null ? other.getCicontent() == null : this.getCicontent().equals(other.getCicontent()))
            && (this.getMeaning() == null ? other.getMeaning() == null : this.getMeaning().equals(other.getMeaning()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCiid() == null) ? 0 : getCiid().hashCode());
        result = prime * result + ((getCiname() == null) ? 0 : getCiname().hashCode());
        result = prime * result + ((getCicontent() == null) ? 0 : getCicontent().hashCode());
        result = prime * result + ((getMeaning() == null) ? 0 : getMeaning().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ciid=").append(ciid);
        sb.append(", ciname=").append(ciname);
        sb.append(", cicontent=").append(cicontent);
        sb.append(", meaning=").append(meaning);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}