package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Enterprise;

/**
 * 企业Service接口
 * 
 * @author ruoyi
 * @date 2022-02-08
 */
public interface IEnterpriseService 
{
    /**
     * 查询企业
     * 
     * @param id 企业主键
     * @return 企业
     */
    public Enterprise selectEnterpriseById(Long id);

    /**
     * 查询企业列表
     * 
     * @param enterprise 企业
     * @return 企业集合
     */
    public List<Enterprise> selectEnterpriseList(Enterprise enterprise);

    /**
     * 新增企业
     * 
     * @param enterprise 企业
     * @return 结果
     */
    public int insertEnterprise(Enterprise enterprise);

    /**
     * 修改企业
     * 
     * @param enterprise 企业
     * @return 结果
     */
    public int updateEnterprise(Enterprise enterprise);

    /**
     * 批量删除企业
     * 
     * @param ids 需要删除的企业主键集合
     * @return 结果
     */
    public int deleteEnterpriseByIds(Long[] ids);

    /**
     * 删除企业信息
     * 
     * @param id 企业主键
     * @return 结果
     */
    public int deleteEnterpriseById(Long id);
}
