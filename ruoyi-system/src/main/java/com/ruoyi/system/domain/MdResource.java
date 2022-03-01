package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 制造资源对象 md_resource
 * 
 * @author ruoyi
 * @date 2022-02-27
 */
public class MdResource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 制造资源id */
    @Excel(name = "制造资源id")
    private String resourceid;

    /** 制造资源名称 */
    @Excel(name = "制造资源名称")
    private String resourcename;

    /** agent */
    @Excel(name = "agent")
    private String agent;

    /** 公司 */
    @Excel(name = "公司")
    private String company;

    /** 车间 */
    @Excel(name = "车间")
    private String workshop;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 规模 */
    @Excel(name = "规模")
    private String scale;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 连接 */
    @Excel(name = "连接")
    private Integer connect;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setResourceid(String resourceid) 
    {
        this.resourceid = resourceid;
    }

    public String getResourceid() 
    {
        return resourceid;
    }
    public void setResourcename(String resourcename) 
    {
        this.resourcename = resourcename;
    }

    public String getResourcename() 
    {
        return resourcename;
    }
    public void setAgent(String agent) 
    {
        this.agent = agent;
    }

    public String getAgent() 
    {
        return agent;
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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setScale(String scale) 
    {
        this.scale = scale;
    }

    public String getScale() 
    {
        return scale;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setConnect(Integer connect) 
    {
        this.connect = connect;
    }

    public Integer getConnect() 
    {
        return connect;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("resourceid", getResourceid())
            .append("resourcename", getResourcename())
            .append("agent", getAgent())
            .append("company", getCompany())
            .append("workshop", getWorkshop())
            .append("type", getType())
            .append("scale", getScale())
            .append("state", getState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("connect", getConnect())
            .toString();
    }
}
