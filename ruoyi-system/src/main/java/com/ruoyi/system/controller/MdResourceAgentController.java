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
import com.ruoyi.system.domain.MdResourceAgent;
import com.ruoyi.system.service.IMdResourceAgentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制造资源AgentController
 * 
 * @author ruoyi
 * @date 2022-02-20
 */
@RestController
@RequestMapping("/system/agent")
public class MdResourceAgentController extends BaseController
{
    @Autowired
    private IMdResourceAgentService mdResourceAgentService;

    /**
     * 查询制造资源Agent列表
     */
    @PreAuthorize("@ss.hasPermi('system:agent:list')")
    @GetMapping("/list")
    public TableDataInfo list(MdResourceAgent mdResourceAgent)
    {
        startPage();
        List<MdResourceAgent> list = mdResourceAgentService.selectMdResourceAgentList(mdResourceAgent);
        return getDataTable(list);
    }

    /**
     * 导出制造资源Agent列表
     */
    @PreAuthorize("@ss.hasPermi('system:agent:export')")
    @Log(title = "制造资源Agent", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdResourceAgent mdResourceAgent)
    {
        List<MdResourceAgent> list = mdResourceAgentService.selectMdResourceAgentList(mdResourceAgent);
        ExcelUtil<MdResourceAgent> util = new ExcelUtil<MdResourceAgent>(MdResourceAgent.class);
        util.exportExcel(response, list, "制造资源Agent数据");
    }

    /**
     * 获取制造资源Agent详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:agent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdResourceAgentService.selectMdResourceAgentById(id));
    }

    /**
     * 新增制造资源Agent
     */
    @PreAuthorize("@ss.hasPermi('system:agent:add')")
    @Log(title = "制造资源Agent", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdResourceAgent mdResourceAgent)
    {
        return toAjax(mdResourceAgentService.insertMdResourceAgent(mdResourceAgent));
    }

    /**
     * 修改制造资源Agent
     */
    @PreAuthorize("@ss.hasPermi('system:agent:edit')")
    @Log(title = "制造资源Agent", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdResourceAgent mdResourceAgent)
    {
        return toAjax(mdResourceAgentService.updateMdResourceAgent(mdResourceAgent));
    }

    /**
     * 删除制造资源Agent
     */
    @PreAuthorize("@ss.hasPermi('system:agent:remove')")
    @Log(title = "制造资源Agent", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdResourceAgentService.deleteMdResourceAgentByIds(ids));
    }
}
