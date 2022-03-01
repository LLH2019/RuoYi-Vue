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
import com.ruoyi.system.domain.MdResourceAgentConfig;
import com.ruoyi.system.service.IMdResourceAgentConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制造资源Agent配置Controller
 * 
 * @author ruoyi
 * @date 2022-02-28
 */
@RestController
@RequestMapping("/agent/config")
public class MdResourceAgentConfigController extends BaseController
{
    @Autowired
    private IMdResourceAgentConfigService mdResourceAgentConfigService;

    /**
     * 查询制造资源Agent配置列表
     */
    @PreAuthorize("@ss.hasPermi('agent:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(MdResourceAgentConfig mdResourceAgentConfig)
    {
        startPage();
        List<MdResourceAgentConfig> list = mdResourceAgentConfigService.selectMdResourceAgentConfigList(mdResourceAgentConfig);
        return getDataTable(list);
    }

    /**
     * 导出制造资源Agent配置列表
     */
    @PreAuthorize("@ss.hasPermi('agent:config:export')")
    @Log(title = "制造资源Agent配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdResourceAgentConfig mdResourceAgentConfig)
    {
        List<MdResourceAgentConfig> list = mdResourceAgentConfigService.selectMdResourceAgentConfigList(mdResourceAgentConfig);
        ExcelUtil<MdResourceAgentConfig> util = new ExcelUtil<MdResourceAgentConfig>(MdResourceAgentConfig.class);
        util.exportExcel(response, list, "制造资源Agent配置数据");
    }

    /**
     * 获取制造资源Agent配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('agent:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdResourceAgentConfigService.selectMdResourceAgentConfigById(id));
    }

    /**
     * 新增制造资源Agent配置
     */
    @PreAuthorize("@ss.hasPermi('agent:config:add')")
    @Log(title = "制造资源Agent配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdResourceAgentConfig mdResourceAgentConfig)
    {
        return toAjax(mdResourceAgentConfigService.insertMdResourceAgentConfig(mdResourceAgentConfig));
    }

    /**
     * 修改制造资源Agent配置
     */
    @PreAuthorize("@ss.hasPermi('agent:config:edit')")
    @Log(title = "制造资源Agent配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdResourceAgentConfig mdResourceAgentConfig)
    {
        return toAjax(mdResourceAgentConfigService.updateMdResourceAgentConfig(mdResourceAgentConfig));
    }

    /**
     * 删除制造资源Agent配置
     */
    @PreAuthorize("@ss.hasPermi('agent:config:remove')")
    @Log(title = "制造资源Agent配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdResourceAgentConfigService.deleteMdResourceAgentConfigByIds(ids));
    }
}
