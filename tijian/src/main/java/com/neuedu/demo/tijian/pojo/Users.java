package com.neuedu.demo.tijian.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
public class Users implements Serializable {
    /**
     * ç”¨æˆ·ç¼–å·ï¼ˆæ‰‹æœºå·ç ï¼‰
     */
    @TableId
    private String userid;

    /**
     * å¯†ç 
     */
    private String password;

    /**
     * çœŸå®žå§“å
     */
    private String realname;

    /**
     * ç”¨æˆ·æ€§åˆ«ï¼ˆ1ï¼šç”·ï¼›0å¥³ï¼‰
     */
    private Integer sex;

    /**
     * èº«ä»½è¯å·
     */
    private String identitycard;

    /**
     * å‡ºç”Ÿæ—¥æœŸ
     */
    private LocalDate birthday;

    /**
     * ç”¨æˆ·ç±»åž‹ï¼ˆ1ï¼šæ™®é€šç”¨æˆ·ï¼›2ï¼šä¸œè½¯å†…éƒ¨å‘˜å·¥ï¼›3ï¼šå…¶ä»–ï¼‰
     */
    private Integer usertype;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ç”¨æˆ·ç¼–å·ï¼ˆæ‰‹æœºå·ç ï¼‰
     */
    public String getUserid() {
        return userid;
    }

    /**
     * ç”¨æˆ·ç¼–å·ï¼ˆæ‰‹æœºå·ç ï¼‰
     */
    public void setUserid(String userid) {
        this.userid = userid;
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
     * ç”¨æˆ·æ€§åˆ«ï¼ˆ1ï¼šç”·ï¼›0å¥³ï¼‰
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * ç”¨æˆ·æ€§åˆ«ï¼ˆ1ï¼šç”·ï¼›0å¥³ï¼‰
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * èº«ä»½è¯å·
     */
    public String getIdentitycard() {
        return identitycard;
    }

    /**
     * èº«ä»½è¯å·
     */
    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard;
    }

    /**
     * å‡ºç”Ÿæ—¥æœŸ
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * å‡ºç”Ÿæ—¥æœŸ
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * ç”¨æˆ·ç±»åž‹ï¼ˆ1ï¼šæ™®é€šç”¨æˆ·ï¼›2ï¼šä¸œè½¯å†…éƒ¨å‘˜å·¥ï¼›3ï¼šå…¶ä»–ï¼‰
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * ç”¨æˆ·ç±»åž‹ï¼ˆ1ï¼šæ™®é€šç”¨æˆ·ï¼›2ï¼šä¸œè½¯å†…éƒ¨å‘˜å·¥ï¼›3ï¼šå…¶ä»–ï¼‰
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
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
        Users other = (Users) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getIdentitycard() == null ? other.getIdentitycard() == null : this.getIdentitycard().equals(other.getIdentitycard()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getUsertype() == null ? other.getUsertype() == null : this.getUsertype().equals(other.getUsertype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getIdentitycard() == null) ? 0 : getIdentitycard().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getUsertype() == null) ? 0 : getUsertype().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", password=").append(password);
        sb.append(", realname=").append(realname);
        sb.append(", sex=").append(sex);
        sb.append(", identitycard=").append(identitycard);
        sb.append(", birthday=").append(birthday);
        sb.append(", usertype=").append(usertype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}