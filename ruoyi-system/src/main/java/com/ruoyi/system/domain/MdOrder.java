package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 制造订单对象 md_order
 * 
 * @author ruoyi
 * @date 2022-02-20
 */
public class MdOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderid;

    /** 图号 */
    @Excel(name = "图号")
    private String graphnumber;

    /** 订单名称 */
    @Excel(name = "订单名称")
    private String ordername;

    /** 型号 */
    @Excel(name = "型号")
    private String modeltype;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 交货期 */
    @Excel(name = "交货期")
    private String deliverytime;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private String demandnumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderid(String orderid) 
    {
        this.orderid = orderid;
    }

    public String getOrderid() 
    {
        return orderid;
    }
    public void setGraphnumber(String graphnumber) 
    {
        this.graphnumber = graphnumber;
    }

    public String getGraphnumber() 
    {
        return graphnumber;
    }
    public void setOrdername(String ordername) 
    {
        this.ordername = ordername;
    }

    public String getOrdername() 
    {
        return ordername;
    }
    public void setModeltype(String modeltype) 
    {
        this.modeltype = modeltype;
    }

    public String getModeltype() 
    {
        return modeltype;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setDeliverytime(String deliverytime) 
    {
        this.deliverytime = deliverytime;
    }

    public String getDeliverytime() 
    {
        return deliverytime;
    }
    public void setDemandnumber(String demandnumber) 
    {
        this.demandnumber = demandnumber;
    }

    public String getDemandnumber() 
    {
        return demandnumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderid", getOrderid())
            .append("graphnumber", getGraphnumber())
            .append("ordername", getOrdername())
            .append("modeltype", getModeltype())
            .append("state", getState())
            .append("deliverytime", getDeliverytime())
            .append("demandnumber", getDemandnumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
