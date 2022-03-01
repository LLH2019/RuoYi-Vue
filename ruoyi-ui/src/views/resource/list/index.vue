<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="制造资源id" prop="resourceid">
        <el-input
          v-model="queryParams.resourceid"
          placeholder="请输入制造资源id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="制造资源名称" prop="resourcename">
        <el-input
          v-model="queryParams.resourcename"
          placeholder="请输入制造资源名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="agent" prop="agent">
        <el-input
          v-model="queryParams.agent"
          placeholder="请输入agent"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司" prop="company">
        <el-input
          v-model="queryParams.company"
          placeholder="请输入公司"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车间" prop="workshop">
        <el-input
          v-model="queryParams.workshop"
          placeholder="请输入车间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="规模" prop="scale">
        <el-input
          v-model="queryParams.scale"
          placeholder="请输入规模"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入状态"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="连接" prop="connect">
        <el-input
          v-model="queryParams.connect"
          placeholder="请输入连接"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:resource:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:resource:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:resource:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:resource:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="resourceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="制造资源id" align="center" prop="resourceid" />
      <el-table-column label="制造资源名称" align="center" prop="resourcename" />
      <el-table-column label="agent" align="center" prop="agent" />
      <el-table-column label="公司" align="center" prop="company" />
      <el-table-column label="车间" align="center" prop="workshop" />
      <el-table-column label="类型" align="center" prop="type" />
      <el-table-column label="规模" align="center" prop="scale" />
      <el-table-column label="状态" align="center" prop="state" />
      <el-table-column label="连接" align="center"  >
          
          <template slot-scope="scope">
      <el-switch
      style="display: block"
      v-model="scope.row.connect"
      active-color="#13ce66"
        inactive-color="#ff4949"
        @change="changeSwitch(scope.row)">>
      </el-switch>
          </template>
          </el-table-column>>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
             <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleSendOrder(scope.row)"
          >操作</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:resource:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:resource:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />


<el-dialog :title="title" :visible.sync="openOperation" width="500px">
      <el-form  :rules="rules" label-width="50px">
     
        <el-button type="primary" @click="startOperation">开始</el-button>
        <el-button type="warning" @click="suspendOperation">挂起</el-button>
        <el-button type="success" @click="continueOperation">继续</el-button>
        <el-button type="danger" @click="endOperation">结束</el-button>
     
      </el-form>
           <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">返 回</el-button>
      </div>
</el-dialog>


    <!-- 添加或修改制造资源对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="制造资源id" prop="resourceid">
          <el-input v-model="form.resourceid" placeholder="请输入制造资源id" />
        </el-form-item>
        <el-form-item label="制造资源名称" prop="resourcename">
          <el-input v-model="form.resourcename" placeholder="请输入制造资源名称" />
        </el-form-item>
        <el-form-item label="agent" prop="agent">
          <el-input v-model="form.agent" placeholder="请输入agent" />
        </el-form-item>
        <el-form-item label="公司" prop="company">
          <el-input v-model="form.company" placeholder="请输入公司" />
        </el-form-item>
        <el-form-item label="车间" prop="workshop">
          <el-input v-model="form.workshop" placeholder="请输入车间" />
        </el-form-item>
        <el-form-item label="规模" prop="scale">
          <el-input v-model="form.scale" placeholder="请输入规模" />
        </el-form-item>
        <el-form-item label="状态" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态" />
        </el-form-item>
        <el-form-item label="连接" prop="connect">
          <el-input v-model="form.connect" placeholder="请输入连接" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listResource, getResource, delResource, addResource, updateResource } from "@/api/system/resource";
import { sendMsg } from "@/api/system/mq";

export default {
  name: "Resource",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 制造资源表格数据
      resourceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示操作弹出层
      openOperation: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        resourceid: null,
        resourcename: null,
        agent: null,
        company: null,
        workshop: null,
        type: null,
        scale: null,
        state: null,
        connect: null
      },
      // 表单参数
      form: {},
      
      operationForm: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {

    changeSwitch (data) {
    if(data.connect) {
        data.state = "已连接"
    } else {
        data.state = "已断开"
    }
      console.log(data.connect)
    sendMsg(data)
    },

    /** 查询制造资源列表 */
    getList() {
      this.loading = true;
      listResource(this.queryParams).then(response => {
        this.resourceList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.openOperation = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        resourceid: null,
        resourcename: null,
        agent: null,
        company: null,
        workshop: null,
        type: null,
        scale: null,
        state: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        connect: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    handleSendOrder(row) {
      this.reset();
      this.openOperation = true;
      this.title = "操作按钮";
      this.operationForm = row
    },
    startOperation() {
      this.operationForm.state = "start"
      sendMsg(this.operationForm)
    },
    suspendOperation() {
      this.operationForm.state = "suspend"
      sendMsg(this.operationForm)
    },
    continueOperation() {
      this.operationForm.state = "continue"
      sendMsg(this.operationForm)
    },
    endOperation() {
      this.operationForm.state = "end"
      sendMsg(this.operationForm)
    },

    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加制造资源";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getResource(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改制造资源";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateResource(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addResource(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除制造资源编号为"' + ids + '"的数据项？').then(function() {
        return delResource(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/resource/export', {
        ...this.queryParams
      }, `resource_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
