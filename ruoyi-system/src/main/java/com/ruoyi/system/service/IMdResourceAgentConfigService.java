package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MdResourceAgentConfig;

/**
 * 制造资源Agent配置Service接口
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
public interface IMdResourceAgentConfigService 
{
    /**
     * 查询制造资源Agent配置
     * 
     * @param id 制造资源Agent配置主键
     * @return 制造资源Agent配置
     */
    public MdResourceAgentConfig selectMdResourceAgentConfigById(Long id);

    /**
     * 查询制造资源Agent配置列表
     * 
     * @param mdResourceAgentConfig 制造资源Agent配置
     * @return 制造资源Agent配置集合
     */
    public List<MdResourceAgentConfig> selectMdResourceAgentConfigList(MdResourceAgentConfig mdResourceAgentConfig);

    /**
     * 新增制造资源Agent配置
     * 
     * @param mdResourceAgentConfig 制造资源Agent配置
     * @return 结果
     */
    public int insertMdResourceAgentConfig(MdResourceAgentConfig mdResourceAgentConfig);

    /**
     * 修改制造资源Agent配置
     * 
     * @param mdResourceAgentConfig 制造资源Agent配置
     * @return 结果
     */
    public int updateMdResourceAgentConfig(MdResourceAgentConfig mdResourceAgentConfig);

    /**
     * 批量删除制造资源Agent配置
     * 
     * @param ids 需要删除的制造资源Agent配置主键集合
     * @return 结果
     */
    public int deleteMdResourceAgentConfigByIds(Long[] ids);

    /**
     * 删除制造资源Agent配置信息
     * 
     * @param id 制造资源Agent配置主键
     * @return 结果
     */
    public int deleteMdResourceAgentConfigById(Long id);
}
