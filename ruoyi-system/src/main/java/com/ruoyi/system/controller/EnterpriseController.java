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
import com.ruoyi.system.domain.Enterprise;
import com.ruoyi.system.service.IEnterpriseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业Controller
 * 
 * @author ruoyi
 * @date 2022-02-08
 */
@RestController
@RequestMapping("/enterprise/info")
public class EnterpriseController extends BaseController
{
    @Autowired
    private IEnterpriseService enterpriseService;

    /**
     * 查询企业列表
     */
    @PreAuthorize("@ss.hasPermi('enterprise:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(Enterprise enterprise)
    {
        startPage();
        List<Enterprise> list = enterpriseService.selectEnterpriseList(enterprise);
        return getDataTable(list);
    }

    /**
     * 导出企业列表
     */
    @PreAuthorize("@ss.hasPermi('enterprise:info:export')")
    @Log(title = "企业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Enterprise enterprise)
    {
        List<Enterprise> list = enterpriseService.selectEnterpriseList(enterprise);
        ExcelUtil<Enterprise> util = new ExcelUtil<Enterprise>(Enterprise.class);
        util.exportExcel(response, list, "企业数据");
    }

    /**
     * 获取企业详细信息
     */
    @PreAuthorize("@ss.hasPermi('enterprise:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(enterpriseService.selectEnterpriseById(id));
    }

    /**
     * 新增企业
     */
    @PreAuthorize("@ss.hasPermi('enterprise:info:add')")
    @Log(title = "企业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Enterprise enterprise)
    {
        return toAjax(enterpriseService.insertEnterprise(enterprise));
    }

    /**
     * 修改企业
     */
    @PreAuthorize("@ss.hasPermi('enterprise:info:edit')")
    @Log(title = "企业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Enterprise enterprise)
    {
        return toAjax(enterpriseService.updateEnterprise(enterprise));
    }

    /**
     * 删除企业
     */
    @PreAuthorize("@ss.hasPermi('enterprise:info:remove')")
    @Log(title = "企业", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(enterpriseService.deleteEnterpriseByIds(ids));
    }
}
