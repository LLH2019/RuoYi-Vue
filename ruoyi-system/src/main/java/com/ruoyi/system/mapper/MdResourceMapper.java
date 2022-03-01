package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.MdResource;

/**
 * 制造资源Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-27
 */
public interface MdResourceMapper 
{
    /**
     * 查询制造资源
     * 
     * @param id 制造资源主键
     * @return 制造资源
     */
    public MdResource selectMdResourceById(Long id);

    /**
     * 查询制造资源列表
     * 
     * @param mdResource 制造资源
     * @return 制造资源集合
     */
    public List<MdResource> selectMdResourceList(MdResource mdResource);

    /**
     * 新增制造资源
     * 
     * @param mdResource 制造资源
     * @return 结果
     */
    public int insertMdResource(MdResource mdResource);

    /**
     * 修改制造资源
     * 
     * @param mdResource 制造资源
     * @return 结果
     */
    public int updateMdResource(MdResource mdResource);

    /**
     * 删除制造资源
     * 
     * @param id 制造资源主键
     * @return 结果
     */
    public int deleteMdResourceById(Long id);

    /**
     * 批量删除制造资源
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMdResourceByIds(Long[] ids);
}
