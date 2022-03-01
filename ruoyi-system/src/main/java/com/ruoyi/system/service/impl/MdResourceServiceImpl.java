package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MdResourceMapper;
import com.ruoyi.system.domain.MdResource;
import com.ruoyi.system.service.IMdResourceService;

/**
 * 制造资源Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-27
 */
@Service
public class MdResourceServiceImpl implements IMdResourceService 
{
    @Autowired
    private MdResourceMapper mdResourceMapper;

    /**
     * 查询制造资源
     * 
     * @param id 制造资源主键
     * @return 制造资源
     */
    @Override
    public MdResource selectMdResourceById(Long id)
    {
        return mdResourceMapper.selectMdResourceById(id);
    }

    /**
     * 查询制造资源列表
     * 
     * @param mdResource 制造资源
     * @return 制造资源
     */
    @Override
    public List<MdResource> selectMdResourceList(MdResource mdResource)
    {
        return mdResourceMapper.selectMdResourceList(mdResource);
    }

    /**
     * 新增制造资源
     * 
     * @param mdResource 制造资源
     * @return 结果
     */
    @Override
    public int insertMdResource(MdResource mdResource)
    {
        mdResource.setCreateTime(DateUtils.getNowDate());
        return mdResourceMapper.insertMdResource(mdResource);
    }

    /**
     * 修改制造资源
     * 
     * @param mdResource 制造资源
     * @return 结果
     */
    @Override
    public int updateMdResource(MdResource mdResource)
    {
        mdResource.setUpdateTime(DateUtils.getNowDate());
        return mdResourceMapper.updateMdResource(mdResource);
    }

    /**
     * 批量删除制造资源
     * 
     * @param ids 需要删除的制造资源主键
     * @return 结果
     */
    @Override
    public int deleteMdResourceByIds(Long[] ids)
    {
        return mdResourceMapper.deleteMdResourceByIds(ids);
    }

    /**
     * 删除制造资源信息
     * 
     * @param id 制造资源主键
     * @return 结果
     */
    @Override
    public int deleteMdResourceById(Long id)
    {
        return mdResourceMapper.deleteMdResourceById(id);
    }
}
