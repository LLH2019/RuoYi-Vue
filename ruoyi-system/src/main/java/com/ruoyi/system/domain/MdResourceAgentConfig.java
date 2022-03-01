package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 制造资源Agent配置对象 md_resource_agent_config
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
public class MdResourceAgentConfig extends BaseEntity
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

    /** 开始 */
    @Excel(name = "开始")
    private String startt;

    /** 暂停 */
    @Excel(name = "暂停")
    private String suspendt;

    /** 继续 */
    @Excel(name = "继续")
    private String continuet;

    /** 结束 */
    @Excel(name = "结束")
    private String endt;

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
    public void setStartt(String startt) 
    {
        this.startt = startt;
    }

    public String getStartt() 
    {
        return startt;
    }
    public void setSuspendt(String suspendt) 
    {
        this.suspendt = suspendt;
    }

    public String getSuspendt() 
    {
        return suspendt;
    }
    public void setContinuet(String continuet) 
    {
        this.continuet = continuet;
    }

    public String getContinuet() 
    {
        return continuet;
    }
    public void setEndt(String endt) 
    {
        this.endt = endt;
    }

    public String getEndt() 
    {
        return endt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("agentid", getAgentid())
            .append("agentname", getAgentname())
            .append("startt", getStartt())
            .append("suspendt", getSuspendt())
            .append("continuet", getContinuet())
            .append("endt", getEndt())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
