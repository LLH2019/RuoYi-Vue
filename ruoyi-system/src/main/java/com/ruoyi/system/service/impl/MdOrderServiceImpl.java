package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MdOrderMapper;
import com.ruoyi.system.domain.MdOrder;
import com.ruoyi.system.service.IMdOrderService;

/**
 * 制造订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-20
 */
@Service
public class MdOrderServiceImpl implements IMdOrderService 
{
    @Autowired
    private MdOrderMapper mdOrderMapper;

    /**
     * 查询制造订单
     * 
     * @param id 制造订单主键
     * @return 制造订单
     */
    @Override
    public MdOrder selectMdOrderById(Long id)
    {
        return mdOrderMapper.selectMdOrderById(id);
    }

    /**
     * 查询制造订单列表
     * 
     * @param mdOrder 制造订单
     * @return 制造订单
     */
    @Override
    public List<MdOrder> selectMdOrderList(MdOrder mdOrder)
    {
        return mdOrderMapper.selectMdOrderList(mdOrder);
    }

    /**
     * 新增制造订单
     * 
     * @param mdOrder 制造订单
     * @return 结果
     */
    @Override
    public int insertMdOrder(MdOrder mdOrder)
    {
        mdOrder.setCreateTime(DateUtils.getNowDate());
        return mdOrderMapper.insertMdOrder(mdOrder);
    }

    /**
     * 修改制造订单
     * 
     * @param mdOrder 制造订单
     * @return 结果
     */
    @Override
    public int updateMdOrder(MdOrder mdOrder)
    {
        mdOrder.setUpdateTime(DateUtils.getNowDate());
        return mdOrderMapper.updateMdOrder(mdOrder);
    }

    /**
     * 批量删除制造订单
     * 
     * @param ids 需要删除的制造订单主键
     * @return 结果
     */
    @Override
    public int deleteMdOrderByIds(Long[] ids)
    {
        return mdOrderMapper.deleteMdOrderByIds(ids);
    }

    /**
     * 删除制造订单信息
     * 
     * @param id 制造订单主键
     * @return 结果
     */
    @Override
    public int deleteMdOrderById(Long id)
    {
        return mdOrderMapper.deleteMdOrderById(id);
    }
}
