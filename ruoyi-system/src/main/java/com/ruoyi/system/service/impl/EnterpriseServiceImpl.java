package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EnterpriseMapper;
import com.ruoyi.system.domain.Enterprise;
import com.ruoyi.system.service.IEnterpriseService;

/**
 * 企业Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-08
 */
@Service
public class EnterpriseServiceImpl implements IEnterpriseService 
{
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    /**
     * 查询企业
     * 
     * @param id 企业主键
     * @return 企业
     */
    @Override
    public Enterprise selectEnterpriseById(Long id)
    {
        return enterpriseMapper.selectEnterpriseById(id);
    }

    /**
     * 查询企业列表
     * 
     * @param enterprise 企业
     * @return 企业
     */
    @Override
    public List<Enterprise> selectEnterpriseList(Enterprise enterprise)
    {
        return enterpriseMapper.selectEnterpriseList(enterprise);
    }

    /**
     * 新增企业
     * 
     * @param enterprise 企业
     * @return 结果
     */
    @Override
    public int insertEnterprise(Enterprise enterprise)
    {
        enterprise.setCreateTime(DateUtils.getNowDate());
        return enterpriseMapper.insertEnterprise(enterprise);
    }

    /**
     * 修改企业
     * 
     * @param enterprise 企业
     * @return 结果
     */
    @Override
    public int updateEnterprise(Enterprise enterprise)
    {
        enterprise.setUpdateTime(DateUtils.getNowDate());
        return enterpriseMapper.updateEnterprise(enterprise);
    }

    /**
     * 批量删除企业
     * 
     * @param ids 需要删除的企业主键
     * @return 结果
     */
    @Override
    public int deleteEnterpriseByIds(Long[] ids)
    {
        return enterpriseMapper.deleteEnterpriseByIds(ids);
    }

    /**
     * 删除企业信息
     * 
     * @param id 企业主键
     * @return 结果
     */
    @Override
    public int deleteEnterpriseById(Long id)
    {
        return enterpriseMapper.deleteEnterpriseById(id);
    }
}
