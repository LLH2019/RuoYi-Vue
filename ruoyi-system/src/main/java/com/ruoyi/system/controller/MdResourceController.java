package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.MdResource;
import com.ruoyi.system.service.IMdResourceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制造资源Controller
 * 
 * @author ruoyi
 * @date 2022-02-27
 */
@RestController
@RequestMapping("/system/resource")
public class MdResourceController extends BaseController
{
    @Autowired
    private IMdResourceService mdResourceService;

    /**
     * 查询制造资源列表
     */
    @PreAuthorize("@ss.hasPermi('system:resource:list')")
    @GetMapping("/list")
    public TableDataInfo list(MdResource mdResource)
    {
        startPage();
        List<MdResource> list = mdResourceService.selectMdResourceList(mdResource);
        return getDataTable(list);
    }

    /**
     * 导出制造资源列表
     */
    @PreAuthorize("@ss.hasPermi('system:resource:export')")
    @Log(title = "制造资源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdResource mdResource)
    {
        List<MdResource> list = mdResourceService.selectMdResourceList(mdResource);
        ExcelUtil<MdResource> util = new ExcelUtil<MdResource>(MdResource.class);
        util.exportExcel(response, list, "制造资源数据");
    }

    /**
     * 获取制造资源详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:resource:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdResourceService.selectMdResourceById(id));
    }

    /**
     * 新增制造资源
     */
    @PreAuthorize("@ss.hasPermi('system:resource:add')")
    @Log(title = "制造资源", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdResource mdResource)
    {
        return toAjax(mdResourceService.insertMdResource(mdResource));
    }

    /**
     * 修改制造资源
     */
    @PreAuthorize("@ss.hasPermi('system:resource:edit')")
    @Log(title = "制造资源", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdResource mdResource)
    {
        return toAjax(mdResourceService.updateMdResource(mdResource));
    }

    /**
     * 删除制造资源
     */
    @PreAuthorize("@ss.hasPermi('system:resource:remove')")
    @Log(title = "制造资源", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdResourceService.deleteMdResourceByIds(ids));
    }
}
