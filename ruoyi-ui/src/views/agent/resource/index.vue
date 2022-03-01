<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="agent编号" prop="agentid">
        <el-input
          v-model="queryParams.agentid"
          placeholder="请输入agent编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="agent名称" prop="agentname">
        <el-input
          v-model="queryParams.agentname"
          placeholder="请输入agent名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="连接设备" prop="device">
        <el-input
          v-model="queryParams.device"
          placeholder="请输入连接设备"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属公司" prop="company">
        <el-input
          v-model="queryParams.company"
          placeholder="请输入所属公司"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属车间" prop="workshop">
        <el-input
          v-model="queryParams.workshop"
          placeholder="请输入所属车间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="通信方式" prop="com">
        <el-input
          v-model="queryParams.com"
          placeholder="请输入通信方式"
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
          v-hasPermi="['system:agent:add']"
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
          v-hasPermi="['system:agent:edit']"
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
          v-hasPermi="['system:agent:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:agent:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="agentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="agent编号" align="center" prop="agentid" />
      <el-table-column label="agent名称" align="center" prop="agentname" />
      <el-table-column label="agent类型" align="center" prop="type" />
      <el-table-column label="连接设备" align="center" prop="device" />
      <el-table-column label="所属公司" align="center" prop="company" />
      <el-table-column label="所属车间" align="center" prop="workshop" />
      <!-- <el-table-column label="通信方式" align="center" prop="com" /> -->
      <!-- <el-table-column label="状态" align="center" prop="state" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
           <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleConfig(scope.row)"
            v-hasPermi="['system:agent:edit']"
          >配置</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:agent:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:agent:remove']"
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


<el-dialog :title="title" :visible.sync="openConfig" width="500px">
      <el-form  :rules="rules" label-width="50px">
        <el-form-item label="开始" prop="agentname">
           <el-col :span="12">
          <el-select v-model="startType" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                    <el-option
               v-for="item in options"
             :key="item.value"
             :label="item.label"
             :value="item.value">
               </el-option>
          </el-select>
           </el-col>
            <el-col :span="12">
          <el-input v-model="startMsg" placeholder="请输入连接指令" clearable :style="{width: '100%'}"/>
            </el-col>
        </el-form-item>

<el-form-item label="挂起" prop="agentname">
           <el-col :span="12">
          <el-select v-model="suspendType" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                    <el-option
               v-for="item in options"
             :key="item.value"
             :label="item.label"
             :value="item.value">
               </el-option>
          </el-select>
           </el-col>
            <el-col :span="12">
          <el-input v-model="suspendMsg" placeholder="请输入连接指令" clearable :style="{width: '100%'}"/>
            </el-col>
        </el-form-item>

        <el-form-item label="继续" prop="agentname">
           <el-col :span="12">
          <el-select v-model="continueType" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                    <el-option
               v-for="item in options"
             :key="item.value"
             :label="item.label"
             :value="item.value">
               </el-option>
          </el-select>
           </el-col>
            <el-col :span="12">
          <el-input v-model="continueMsg" placeholder="请输入连接指令" clearable :style="{width: '100%'}"/>
            </el-col>
        </el-form-item>

        <el-form-item label="结束" prop="agentname">
           <el-col :span="12">
          <el-select v-model="endType" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                    <el-option
               v-for="item in options"
             :key="item.value"
             :label="item.label"
             :value="item.value">
               </el-option>
          </el-select>
           </el-col>
            <el-col :span="12">
          <el-input v-model="endMsg" placeholder="请输入连接指令" clearable :style="{width: '100%'}"/>
            </el-col>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitConfigForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 添加或修改制造资源Agent对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="agent编号" prop="agentid">
          <el-input v-model="form.agentid" placeholder="请输入agent编号" />
        </el-form-item>
        <el-form-item label="agent名称" prop="agentname">
          <el-input v-model="form.agentname" placeholder="请输入agent名称" />
        </el-form-item>
        <el-form-item label="连接设备" prop="device">
          <el-input v-model="form.device" placeholder="请输入连接设备" />
        </el-form-item>
        <el-form-item label="所属公司" prop="company">
          <el-input v-model="form.company" placeholder="请输入所属公司" />
        </el-form-item>
        <el-form-item label="所属车间" prop="workshop">
          <el-input v-model="form.workshop" placeholder="请输入所属车间" />
        </el-form-item>
        <el-form-item label="通信方式" prop="com">
          <el-input v-model="form.com" placeholder="请输入通信方式" />
        </el-form-item>
        <el-form-item label="状态" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态" />
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
import { listAgent, getAgent, delAgent, addAgent, updateAgent } from "@/api/system/agent";

import { listConfig, getConfig, delConfig, addconfig, updateConfig } from "@/api/system/agent-config";


export default {
  name: "Agent",
  data() {
    return {

      startType:'',
      startMsg:'',
      suspendType:'',
      suspendMsg:'',
      continueType:'',
      continueMsg:'',
      endType:'',
      endMsg:'',
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
      // 制造资源Agent表格数据
      agentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示配置config弹出层
      openConfig: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        agentid: null,
        agentname: null,
        type: null,
        device: null,
        company: null,
        workshop: null,
        com: null,
        state: null,
      },

       options: [{
          value: 'MESSAGE',
          label: '消息发送'
        }, {
          value: 'OPCUA',
          label: 'OPC-UA'
        }],
      // 表单参数
      form: {},
      // 配置表单数据
      formData:{},
      configData:{},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询制造资源Agent列表 */
    getList() {
      this.loading = true;
      listAgent(this.queryParams).then(response => {
        this.agentList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        agentid: null,
        agentname: null,
        type: null,
        device: null,
        company: null,
        workshop: null,
        com: null,
        state: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
    /** 更新配置操作 */
    handleConfig(row) {
      this.reset();
      const id = row.id || this.ids
 
      getConfig(id).then(response => {
        this.configData = response.data;

        this.startType = this.configData.startt.split("-")[0]
        this.startMsg = this.configData.startt.split("-")[1]
        this.suspendType = this.configData.suspendt.split("-")[0]
        this.suspendMsg = this.configData.suspendt.split("-")[1]
        this.continueType = this.configData.continuet.split("-")[0]
        this.continueMsg = this.configData.continuet.split("-")[1]
        this.endType = this.configData.endt.split("-")[0]
        this.endMsg = this.configData.endt.split("-")[1]

        console.log(response.data)
        this.openConfig = true;
        this.title = "配置Agent";
      });

      
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加制造资源Agent";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAgent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改制造资源Agent";
      });
    },

    submitConfigForm() {
      this.configData.startt = this.startType+"-"+this.startMsg
      this.configData.suspendt = this.suspendType+"-"+this.suspendMsg
      this.configData.continuet = this.continueType+"-"+this.continueMsg
      this.configData.endt = this.endType+"-"+this.endMsg
      updateConfig(this.configData).then(response => { 
          this.$modal.msgSuccess("修改成功");
          this.openConfig = false;
              // this.getList();
        });
    },

    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAgent(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAgent(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除制造资源Agent编号为"' + ids + '"的数据项？').then(function() {
        return delAgent(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/agent/export', {
        ...this.queryParams
      }, `agent_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
