package framework.mybatis.data.entity;

import java.util.Date;

/**
 * User: gaozhan
 * Date: 12/12/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class CloudResource {
    private int id;
    private String owner;
    private Date startTime;
    private Date endTime;

    public CloudResource() {
    }

    public CloudResource(int id, String owner) {
        this.id = id;
        this.owner = owner;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
