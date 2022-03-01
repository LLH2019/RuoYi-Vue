package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MdResourceAgentConfigMapper;
import com.ruoyi.system.domain.MdResourceAgentConfig;
import com.ruoyi.system.service.IMdResourceAgentConfigService;

/**
 * 制造资源Agent配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
@Service
public class MdResourceAgentConfigServiceImpl implements IMdResourceAgentConfigService 
{
    @Autowired
    private MdResourceAgentConfigMapper mdResourceAgentConfigMapper;

    /**
     * 查询制造资源Agent配置
     * 
     * @param id 制造资源Agent配置主键
     * @return 制造资源Agent配置
     */
    @Override
    public MdResourceAgentConfig selectMdResourceAgentConfigById(Long id)
    {
        return mdResourceAgentConfigMapper.selectMdResourceAgentConfigById(id);
    }

    /**
     * 查询制造资源Agent配置列表
     * 
     * @param mdResourceAgentConfig 制造资源Agent配置
     * @return 制造资源Agent配置
     */
    @Override
    public List<MdResourceAgentConfig> selectMdResourceAgentConfigList(MdResourceAgentConfig mdResourceAgentConfig)
    {
        return mdResourceAgentConfigMapper.selectMdResourceAgentConfigList(mdResourceAgentConfig);
    }

    /**
     * 新增制造资源Agent配置
     * 
     * @param mdResourceAgentConfig 制造资源Agent配置
     * @return 结果
     */
    @Override
    public int insertMdResourceAgentConfig(MdResourceAgentConfig mdResourceAgentConfig)
    {
        mdResourceAgentConfig.setCreateTime(DateUtils.getNowDate());
        return mdResourceAgentConfigMapper.insertMdResourceAgentConfig(mdResourceAgentConfig);
    }

    /**
     * 修改制造资源Agent配置
     * 
     * @param mdResourceAgentConfig 制造资源Agent配置
     * @return 结果
     */
    @Override
    public int updateMdResourceAgentConfig(MdResourceAgentConfig mdResourceAgentConfig)
    {
        mdResourceAgentConfig.setUpdateTime(DateUtils.getNowDate());
        return mdResourceAgentConfigMapper.updateMdResourceAgentConfig(mdResourceAgentConfig);
    }

    /**
     * 批量删除制造资源Agent配置
     * 
     * @param ids 需要删除的制造资源Agent配置主键
     * @return 结果
     */
    @Override
    public int deleteMdResourceAgentConfigByIds(Long[] ids)
    {
        return mdResourceAgentConfigMapper.deleteMdResourceAgentConfigByIds(ids);
    }

    /**
     * 删除制造资源Agent配置信息
     * 
     * @param id 制造资源Agent配置主键
     * @return 结果
     */
    @Override
    public int deleteMdResourceAgentConfigById(Long id)
    {
        return mdResourceAgentConfigMapper.deleteMdResourceAgentConfigById(id);
    }
}
