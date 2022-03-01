package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 制造资源Agent对象 md_resource_agent
 * 
 * @author ruoyi
 * @date 2022-02-20
 */
public class MdResourceAgent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** agent编号 */
    @Excel(name = "agent编号")
    private String agentid;

    /** agent名称 */
    @Excel(name = "agent名称")
    private String agentname;

    /** agent类型 */
    @Excel(name = "agent类型")
    private String type;

    /** 连接设备 */
    @Excel(name = "连接设备")
    private String device;

    /** 所属公司 */
    @Excel(name = "所属公司")
    private String company;

    /** 所属车间 */
    @Excel(name = "所属车间")
    private String workshop;

    /** 通信方式 */
    @Excel(name = "通信方式")
    private String com;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAgentid(String agentid) 
    {
        this.agentid = agentid;
    }

    public String getAgentid() 
    {
        return agentid;
    }
    public void setAgentname(String agentname) 
    {
        this.agentname = agentname;
    }

    public String getAgentname() 
    {
        return agentname;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDevice(String device) 
    {
        this.device = device;
    }

    public String getDevice() 
    {
        return device;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setWorkshop(String workshop) 
    {
        this.workshop = workshop;
    }

    public String getWorkshop() 
    {
        return workshop;
    }
    public void setCom(String com) 
    {
        this.com = com;
    }

    public String getCom() 
    {
        return com;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("agentid", getAgentid())
            .append("agentname", getAgentname())
            .append("type", getType())
            .append("device", getDevice())
            .append("company", getCompany())
            .append("workshop", getWorkshop())
            .append("com", getCom())
            .append("state", getState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
