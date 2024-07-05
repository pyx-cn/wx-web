package com.neuedu.demo.tijian.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName doctor
 */
@TableName(value ="doctor")
public class Doctor implements Serializable {
    /**
     * åŒ»ç”Ÿç¼–å·
     */
    @TableId(type = IdType.AUTO)
    private Integer docid;

    /**
     * åŒ»ç”Ÿç¼–ç 
     */
    private String doccode;

    /**
     * çœŸå®žå§“å
     */
    private String realname;

    /**
     * å¯†ç 
     */
    private String password;

    /**
     * æ€§åˆ«
     */
    private Integer sex;

    /**
     * æ‰€å±žç§‘å®¤ï¼ˆ1ï¼šæ£€éªŒç§‘ï¼›2ï¼šå†…ç§‘ï¼›3ï¼šå¤–ç§‘ï¼‰
     */
    private Integer deptno;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * åŒ»ç”Ÿç¼–å·
     */
    public Integer getDocid() {
        return docid;
    }

    /**
     * åŒ»ç”Ÿç¼–å·
     */
    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    /**
     * åŒ»ç”Ÿç¼–ç 
     */
    public String getDoccode() {
        return doccode;
    }

    /**
     * åŒ»ç”Ÿç¼–ç 
     */
    public void setDoccode(String doccode) {
        this.doccode = doccode;
    }

    /**
     * çœŸå®žå§“å
     */
    public String getRealname() {
        return realname;
    }

    /**
     * çœŸå®žå§“å
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * å¯†ç 
     */
    public String getPassword() {
        return password;
    }

    /**
     * å¯†ç 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * æ€§åˆ«
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * æ€§åˆ«
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * æ‰€å±žç§‘å®¤ï¼ˆ1ï¼šæ£€éªŒç§‘ï¼›2ï¼šå†…ç§‘ï¼›3ï¼šå¤–ç§‘ï¼‰
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * æ‰€å±žç§‘å®¤ï¼ˆ1ï¼šæ£€éªŒç§‘ï¼›2ï¼šå†…ç§‘ï¼›3ï¼šå¤–ç§‘ï¼‰
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
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
        Doctor other = (Doctor) that;
        return (this.getDocid() == null ? other.getDocid() == null : this.getDocid().equals(other.getDocid()))
            && (this.getDoccode() == null ? other.getDoccode() == null : this.getDoccode().equals(other.getDoccode()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getDeptno() == null ? other.getDeptno() == null : this.getDeptno().equals(other.getDeptno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDocid() == null) ? 0 : getDocid().hashCode());
        result = prime * result + ((getDoccode() == null) ? 0 : getDoccode().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getDeptno() == null) ? 0 : getDeptno().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", docid=").append(docid);
        sb.append(", doccode=").append(doccode);
        sb.append(", realname=").append(realname);
        sb.append(", password=").append(password);
        sb.append(", sex=").append(sex);
        sb.append(", deptno=").append(deptno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}