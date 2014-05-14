package framework.spring.junit;

/**
 * Created with IntelliJ IDEA.
 * User: gaozhan
 * Date: 4/29/14
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {

    private static final long serialVersionUID = -7970848646314840509L;



    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String username;
    private String password;
    private Date createTime;
    private Integer accountId;


}