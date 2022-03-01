package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MdOrder;

/**
 * 制造订单Service接口
 * 
 * @author ruoyi
 * @date 2022-02-20
 */
public interface IMdOrderService 
{
    /**
     * 查询制造订单
     * 
     * @param id 制造订单主键
     * @return 制造订单
     */
    public MdOrder selectMdOrderById(Long id);

    /**
     * 查询制造订单列表
     * 
     * @param mdOrder 制造订单
     * @return 制造订单集合
     */
    public List<MdOrder> selectMdOrderList(MdOrder mdOrder);

    /**
     * 新增制造订单
     * 
     * @param mdOrder 制造订单
     * @return 结果
     */
    public int insertMdOrder(MdOrder mdOrder);

    /**
     * 修改制造订单
     * 
     * @param mdOrder 制造订单
     * @return 结果
     */
    public int updateMdOrder(MdOrder mdOrder);

    /**
     * 批量删除制造订单
     * 
     * @param ids 需要删除的制造订单主键集合
     * @return 结果
     */
    public int deleteMdOrderByIds(Long[] ids);

    /**
     * 删除制造订单信息
     * 
     * @param id 制造订单主键
     * @return 结果
     */
    public int deleteMdOrderById(Long id);
}
