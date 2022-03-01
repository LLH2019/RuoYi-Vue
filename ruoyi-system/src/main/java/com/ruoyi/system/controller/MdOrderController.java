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
import com.ruoyi.system.domain.MdOrder;
import com.ruoyi.system.service.IMdOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制造订单Controller
 * 
 * @author ruoyi
 * @date 2022-02-20
 */
@RestController
@RequestMapping("/system/order")
public class MdOrderController extends BaseController
{
    @Autowired
    private IMdOrderService mdOrderService;

    /**
     * 查询制造订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(MdOrder mdOrder)
    {
        startPage();
        List<MdOrder> list = mdOrderService.selectMdOrderList(mdOrder);
        return getDataTable(list);
    }

    /**
     * 导出制造订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "制造订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdOrder mdOrder)
    {
        List<MdOrder> list = mdOrderService.selectMdOrderList(mdOrder);
        ExcelUtil<MdOrder> util = new ExcelUtil<MdOrder>(MdOrder.class);
        util.exportExcel(response, list, "制造订单数据");
    }

    /**
     * 获取制造订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdOrderService.selectMdOrderById(id));
    }

    /**
     * 新增制造订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "制造订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdOrder mdOrder)
    {
        return toAjax(mdOrderService.insertMdOrder(mdOrder));
    }

    /**
     * 修改制造订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "制造订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdOrder mdOrder)
    {
        return toAjax(mdOrderService.updateMdOrder(mdOrder));
    }

    /**
     * 删除制造订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "制造订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdOrderService.deleteMdOrderByIds(ids));
    }
}
