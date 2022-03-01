package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MdResourceAgent;

/**
 * 制造资源AgentService接口
 * 
 * @author ruoyi
 * @date 2022-02-20
 */
public interface IMdResourceAgentService 
{
    /**
     * 查询制造资源Agent
     * 
     * @param id 制造资源Agent主键
     * @return 制造资源Agent
     */
    public MdResourceAgent selectMdResourceAgentById(Long id);

    /**
     * 查询制造资源Agent列表
     * 
     * @param mdResourceAgent 制造资源Agent
     * @return 制造资源Agent集合
     */
    public List<MdResourceAgent> selectMdResourceAgentList(MdResourceAgent mdResourceAgent);

    /**
     * 新增制造资源Agent
     * 
     * @param mdResourceAgent 制造资源Agent
     * @return 结果
     */
    public int insertMdResourceAgent(MdResourceAgent mdResourceAgent);

    /**
     * 修改制造资源Agent
     * 
     * @param mdResourceAgent 制造资源Agent
     * @return 结果
     */
    public int updateMdResourceAgent(MdResourceAgent mdResourceAgent);

    /**
     * 批量删除制造资源Agent
     * 
     * @param ids 需要删除的制造资源Agent主键集合
     * @return 结果
     */
    public int deleteMdResourceAgentByIds(Long[] ids);

    /**
     * 删除制造资源Agent信息
     * 
     * @param id 制造资源Agent主键
     * @return 结果
     */
    public int deleteMdResourceAgentById(Long id);
}
