package framework.mybatis.data.entity;

/**
 * User: gaozhan
 * Date: 12/12/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class VmResource extends CloudResource {
    private int cpuNum;
    private int memSize;
    private int nicNum;
    private int diskSize;
    private String innerIp;
    private String osType;

    public String getInnerIp() {
        return innerIp;
    }

    public void setInnerIp(String innerIp) {
        this.innerIp = innerIp;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
    public VmResource() {}

    public VmResource(int id, int cpuNum, int memSize, int nicNum, int diskSize, String owner, String innerIp, String osType) {
        super(id, owner);
        this.cpuNum = cpuNum;
        this.memSize = memSize;
        this.nicNum = nicNum;
        this.diskSize = diskSize;
        this.innerIp = innerIp;
        this.osType = osType;
    }

    public int getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(int cpuNum) {
        this.cpuNum = cpuNum;
    }

    public int getMemSize() {
        return memSize;
    }

    public void setMemSize(int memSize) {
        this.memSize = memSize;
    }

    public int getNicNum() {
        return nicNum;
    }

    public void setNicNum(int nicNum) {
        this.nicNum = nicNum;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }
}
