package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MdResourceAgentMapper;
import com.ruoyi.system.domain.MdResourceAgent;
import com.ruoyi.system.service.IMdResourceAgentService;

/**
 * 制造资源AgentService业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-20
 */
@Service
public class MdResourceAgentServiceImpl implements IMdResourceAgentService 
{
    @Autowired
    private MdResourceAgentMapper mdResourceAgentMapper;

    /**
     * 查询制造资源Agent
     * 
     * @param id 制造资源Agent主键
     * @return 制造资源Agent
     */
    @Override
    public MdResourceAgent selectMdResourceAgentById(Long id)
    {
        return mdResourceAgentMapper.selectMdResourceAgentById(id);
    }

    /**
     * 查询制造资源Agent列表
     * 
     * @param mdResourceAgent 制造资源Agent
     * @return 制造资源Agent
     */
    @Override
    public List<MdResourceAgent> selectMdResourceAgentList(MdResourceAgent mdResourceAgent)
    {
        return mdResourceAgentMapper.selectMdResourceAgentList(mdResourceAgent);
    }

    /**
     * 新增制造资源Agent
     * 
     * @param mdResourceAgent 制造资源Agent
     * @return 结果
     */
    @Override
    public int insertMdResourceAgent(MdResourceAgent mdResourceAgent)
    {
        mdResourceAgent.setCreateTime(DateUtils.getNowDate());
        return mdResourceAgentMapper.insertMdResourceAgent(mdResourceAgent);
    }

    /**
     * 修改制造资源Agent
     * 
     * @param mdResourceAgent 制造资源Agent
     * @return 结果
     */
    @Override
    public int updateMdResourceAgent(MdResourceAgent mdResourceAgent)
    {
        mdResourceAgent.setUpdateTime(DateUtils.getNowDate());
        return mdResourceAgentMapper.updateMdResourceAgent(mdResourceAgent);
    }

    /**
     * 批量删除制造资源Agent
     * 
     * @param ids 需要删除的制造资源Agent主键
     * @return 结果
     */
    @Override
    public int deleteMdResourceAgentByIds(Long[] ids)
    {
        return mdResourceAgentMapper.deleteMdResourceAgentByIds(ids);
    }

    /**
     * 删除制造资源Agent信息
     * 
     * @param id 制造资源Agent主键
     * @return 结果
     */
    @Override
    public int deleteMdResourceAgentById(Long id)
    {
        return mdResourceAgentMapper.deleteMdResourceAgentById(id);
    }
}
