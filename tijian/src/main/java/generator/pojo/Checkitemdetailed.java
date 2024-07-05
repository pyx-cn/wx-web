package generator.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName checkitemdetailed
 */
@TableName(value ="checkitemdetailed")
public class Checkitemdetailed implements Serializable {
    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†ç¼–å·
     */
    @TableId(type = IdType.AUTO)
    private Integer cdid;

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žåç§°
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
     * æ£€æŸ¥é¡¹æ˜Žç»†ç±»åž‹ï¼ˆ1ï¼šæ•°å€¼å›´èŒƒéªŒè¯åž‹ï¼›2ï¼šæ•°å€¼ç›¸ç­‰éªŒè¯åž‹ï¼›3ï¼šæ— éœ€éªŒè¯åž‹ï¼›4ï¼šæè¿°åž‹ï¼›5ï¼šå…¶å®ƒï¼‰
     */
    private Integer type;

    /**
     * æ‰€å±žæ£€æŸ¥é¡¹ç¼–å·
     */
    private Integer ciid;

    /**
     * å¤‡æ³¨
     */
    private String remarks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†ç¼–å·
     */
    public Integer getCdid() {
        return cdid;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†ç¼–å·
     */
    public void setCdid(Integer cdid) {
        this.cdid = cdid;
    }

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žåç§°
     */
    public String getName() {
        return name;
    }

    /**
     * æ£€æŸ¥é¡¹ç»†æ˜Žåç§°
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
     * æ£€æŸ¥é¡¹æ˜Žç»†ç±»åž‹ï¼ˆ1ï¼šæ•°å€¼å›´èŒƒéªŒè¯åž‹ï¼›2ï¼šæ•°å€¼ç›¸ç­‰éªŒè¯åž‹ï¼›3ï¼šæ— éœ€éªŒè¯åž‹ï¼›4ï¼šæè¿°åž‹ï¼›5ï¼šå…¶å®ƒï¼‰
     */
    public Integer getType() {
        return type;
    }

    /**
     * æ£€æŸ¥é¡¹æ˜Žç»†ç±»åž‹ï¼ˆ1ï¼šæ•°å€¼å›´èŒƒéªŒè¯åž‹ï¼›2ï¼šæ•°å€¼ç›¸ç­‰éªŒè¯åž‹ï¼›3ï¼šæ— éœ€éªŒè¯åž‹ï¼›4ï¼šæè¿°åž‹ï¼›5ï¼šå…¶å®ƒï¼‰
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * æ‰€å±žæ£€æŸ¥é¡¹ç¼–å·
     */
    public Integer getCiid() {
        return ciid;
    }

    /**
     * æ‰€å±žæ£€æŸ¥é¡¹ç¼–å·
     */
    public void setCiid(Integer ciid) {
        this.ciid = ciid;
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
        Checkitemdetailed other = (Checkitemdetailed) that;
        return (this.getCdid() == null ? other.getCdid() == null : this.getCdid().equals(other.getCdid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getMinrange() == null ? other.getMinrange() == null : this.getMinrange().equals(other.getMinrange()))
            && (this.getMaxrange() == null ? other.getMaxrange() == null : this.getMaxrange().equals(other.getMaxrange()))
            && (this.getNormalvalue() == null ? other.getNormalvalue() == null : this.getNormalvalue().equals(other.getNormalvalue()))
            && (this.getNormalvaluestring() == null ? other.getNormalvaluestring() == null : this.getNormalvaluestring().equals(other.getNormalvaluestring()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCiid() == null ? other.getCiid() == null : this.getCiid().equals(other.getCiid()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCdid() == null) ? 0 : getCdid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getMinrange() == null) ? 0 : getMinrange().hashCode());
        result = prime * result + ((getMaxrange() == null) ? 0 : getMaxrange().hashCode());
        result = prime * result + ((getNormalvalue() == null) ? 0 : getNormalvalue().hashCode());
        result = prime * result + ((getNormalvaluestring() == null) ? 0 : getNormalvaluestring().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCiid() == null) ? 0 : getCiid().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cdid=").append(cdid);
        sb.append(", name=").append(name);
        sb.append(", unit=").append(unit);
        sb.append(", minrange=").append(minrange);
        sb.append(", maxrange=").append(maxrange);
        sb.append(", normalvalue=").append(normalvalue);
        sb.append(", normalvaluestring=").append(normalvaluestring);
        sb.append(", type=").append(type);
        sb.append(", ciid=").append(ciid);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}