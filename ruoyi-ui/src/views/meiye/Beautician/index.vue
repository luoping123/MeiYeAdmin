<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="美容师姓名" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入美容师姓名" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="美容师性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择美容师性别" clearable>
          <el-option v-for="dict in dict.type.sys_user_sex" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['meiye:Beautician:add']">新增美容师</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['meiye:Beautician:edit']">修改美容师</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleTimeAdd"
          v-hasPermi="['meiye:Beautician:add']">新增美容师排班</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleTimeUpdate"
          v-hasPermi="['meiye:Beautician:edit']">修改排班</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['meiye:Beautician:remove']">删除美容师</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleTimeDelete"
          v-hasPermi="['meiye:Beautician:remove']">删除排班</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['meiye:Beautician:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="BeauticianAndTimeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="美容师姓名" align="center" prop="name" />
      <el-table-column label="美容师性别" align="center" prop="sex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.sex" />
        </template>
      </el-table-column>
      <el-table-column label="美容师年龄" align="center" prop="age" />
      <el-table-column label="美容师照片" align="center" prop="img" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.img" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="可预约时间" align="center" prop="beauticianTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.beauticianTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="该时间可预约数量" align="center" prop="number" width="180" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleTimeUpdate(scope.row)"
            v-hasPermi="['meiye:Beautician:edit']">修改排班</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleTimeDelete(scope.row)"
            v-hasPermi="['meiye:Beautician:remove']">删除排班</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 新增或修改美容师对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="美容师姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入美容师姓名" />
        </el-form-item>
        <el-form-item label="美容师性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择美容师性别">
            <el-option v-for="dict in dict.type.sys_user_sex" :key="dict.value" :label="dict.label" :value="dict.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="美容师年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入美容师年龄" />
        </el-form-item>
        <el-form-item label="美容师家庭地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入美容师家庭地址" />
        </el-form-item>
        <el-form-item label="美容师电话" prop="tel">
          <el-input v-model="form.tel" placeholder="请输入美容师电话" />
        </el-form-item>
        <el-form-item label="美容师照片">
          <image-upload v-model="form.img" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 新增或修改排班对话框 -->
    <el-dialog :title="timeTitle" :visible.sync="timeOpen" width="500px" append-to-body>
      <el-form ref="timeForm" :model="timeForm" :rules="rules" label-width="80px">
        <el-form-item label="美容师姓名" prop="beauticianId">
          <el-select v-model="timeForm.beauticianId" placeholder="请选择美容师">
            <el-option v-for="(item,index) in BeauticianList" :key="index" :label="item.name" :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="可预约时间[保证分钟为00]" prop="beauticianTime">
          <el-date-picker clearable v-model="timeForm.beauticianTime" format="yyyy-MM-dd HH:mm" type="datetime"
            value-format="yyyy-MM-dd HH:mm" placeholder="请选择排班时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="该时间可预约数量" prop="number">
          <el-input v-model="timeForm.number" placeholder="请输入该时间可预约数量" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitTimeForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>
  import {
    listBeautician,
    getBeautician,
    listBeauticianAndTime,
    getBeauticianAndTime,
    delBeautician,
    addBeautician,
    updateBeautician
  } from "@/api/meiye/Beautician";

  import {
    delBeauticianTime,
    addBeauticianTime,
    updateBeauticianTime
  } from "@/api/meiye/BeauticianTime";

  export default {
    name: "Beautician",
    dicts: ['sys_user_sex'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        timeIds: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 美容师表格数据
        BeauticianList: [],
        //美容师排班数据
        BeauticianAndTimeList: [],
        // 美容师弹出层标题
        title: "",
        // 是否显示美容师弹出层
        open: false,
        // 排班弹出层标题
        timeTitle: "",
        // 是否显示排班弹出层
        timeOpen: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          name: null,
          sex: null,
          age: null,
          address: null,
          tel: null,
          img: null,
        },
        // 表单参数
        form: {},
        //排班表单参数
        timeForm: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.getList();
      this.getBeautianList();
    },
    methods: {
      /** 查询美容师排班列表 */
      getList() {
        this.loading = true;
        listBeauticianAndTime(this.queryParams).then(response => {
          this.BeauticianAndTimeList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      /** 查询美容师列表 */
      getBeautianList() {
        this.loading = true;
        listBeautician().then(response => {
          this.BeauticianList = response.rows;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.timeOpen = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          id: null,
          name: null,
          sex: null,
          age: null,
          address: null,
          tel: null,
          img: null,
          starSum: null
        };
        this.resetForm("form");
        this.timeForm = {
          timeId: null,
          beauticianId: null,
          beauticianTime: null,
          number: null,
        };
        this.resetForm("timeForm");
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
        this.timeIds = selection.map(item => item.timeId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增美容师按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加美容师";
      },
      /** 修改美容师按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids;
        getBeautician(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改美容师";
        });
      },
      /** 新增或修改美容师提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateBeautician(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addBeautician(this.form).then(response => {
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
        this.$modal.confirm('是否确认删除美容师编号为"' + ids + '"的数据项？').then(function() {
          return delBeautician(ids);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },

      /** 新增排班按钮操作 */
      handleTimeAdd() {
        this.reset();
        this.timeOpen = true;
        this.timeTitle = "添加排班";
      },
      /** 修改排班按钮操作 */
      handleTimeUpdate(row) {
        this.reset();
        const id = row.id || this.ids;
        const timeId = row.timeId || this.timeIds;
        getBeauticianAndTime(timeId).then(response => {
          this.timeForm = response.data;
          this.timeOpen = true;
          this.timeTitle = "修改排班";
        });
      },
      /** 新增或修改排班提交按钮 */
      submitTimeForm() {
        this.$refs["timeForm"].validate(valid => {
          if (valid) {
            if (this.timeForm.timeId != null) {
              updateBeauticianTime(this.timeForm).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.timeOpen = false;
                this.getList();
              });
            } else {
              addBeauticianTime(this.timeForm).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.timeOpen = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除排班按钮操作 */
      handleTimeDelete(row) {
        const ids = row.id || this.ids;
        const timeIds = row.timeId || this.timeIds;
        this.$modal.confirm('是否确认删除排班编号为"' + timeIds + '"的数据项？').then(function() {
          return delBeauticianTime(timeIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },


      /** 导出按钮操作 */
      handleExport() {
        this.download('meiye/Beautician/export', {
          ...this.queryParams
        }, `Beautician_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
