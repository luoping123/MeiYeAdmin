<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="服务名" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入服务名" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="二级服务名" prop="subName">
        <el-input v-model="queryParams.subName" placeholder="请输入二级服务名" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="服务项目分类" prop="cateId">
        <el-select v-model="queryParams.cateId" placeholder="请选择服务项目分类" clearable>
          <el-option v-for="cate in ServiceItemCateList" :key="cate.id" :label="cate.cateName" :value="cate.id" />
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
          v-hasPermi="['meiye:ServiceItem:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['meiye:ServiceItem:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['meiye:ServiceItem:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['meiye:ServiceItem:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ServiceItemList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="服务名" align="center" prop="name" />
      <el-table-column label="二级服务名" align="center" prop="subName" />
      <el-table-column label="图片" align="center" prop="imageSrc" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.imageSrc" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="原价" align="center" prop="olderPrice" />
      <el-table-column label="现价" align="center" prop="nowPrice" />
      <el-table-column label="类别" align="center" prop="cateName">
      </el-table-column>
      <el-table-column label="是否为秒杀" align="center" prop="isLimitKill">
        <template slot-scope="scope">
          <el-switch v-model="scope.row.isLimitKill" :active-value='1' :inactive-value='0' :disabled='true'></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['meiye:ServiceItem:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['meiye:ServiceItem:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改服务项目对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="服务项目分类" prop="subName">
          <el-select v-model="form.cateId" placeholder="请选择服务项目分类" clearable>
            <el-option v-for="cate in ServiceItemCateList" :key="cate.id" :label="cate.cateName" :value="cate.id" />
          </el-select>
        </el-form-item>
        <el-form-item label="服务名" prop="name">
          <el-input v-model="form.name" placeholder="请输入服务名" />
        </el-form-item>
        <el-form-item label="二级服务名" prop="subName">
          <el-input v-model="form.subName" placeholder="请输入二级服务名" />
        </el-form-item>
        <el-form-item label="图片">
          <image-upload v-model="form.imageSrc" />
        </el-form-item>
        <el-form-item label="原价" prop="olderPrice">
          <el-input v-model="form.olderPrice" placeholder="请输入原价" />
        </el-form-item>
        <el-form-item label="现价" prop="nowPrice">
          <el-input v-model="form.nowPrice" placeholder="请输入现价" />
        </el-form-item>
        <el-form-item label="是否为秒杀" prop="isLimitKill">
          <el-switch v-model="form.isLimitKill" :active-value='1' :inactive-value='0'></el-switch>
        </el-form-item>
        <!-- 详情 -->
        <el-form-item label="轮播图图片或视频地址">
          <image-upload v-model="form.swiperUrl"/>
        </el-form-item>
        <el-form-item label="轮播图对应的类型,image或video  用';'分割" prop="swiperType">
          <el-input v-model="form.swiperType" placeholder="请输入轮播图对应的类型" />
        </el-form-item>
        <el-form-item label="详情富文本">
          <editor v-model="form.content" :min-height="192"/>
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
  import {
    listServiceItem,
    getServiceItem,
    delServiceItem,
    addServiceItem,
    updateServiceItem
  } from "@/api/meiye/ServiceItem";
  import {
    listServiceItemCate
  } from "@/api/meiye/ServiceItemCate";
  export default {
    name: "ServiceItem",
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
        // 服务项目表格数据
        ServiceItemList: [],
        ServiceItemCateList: [], //服务项目分类
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          name: null,
          subName: null,
          cateId: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.getList();
      this.getServiceCateList();
    },
    computed: {
      serviceCate(cateId) {
        // 如果不存在，则 findResult 为 undefined；否则，为查找到的商品信息对象
        const findResult = this.ServiceItemCateList.find((x) => x.cateId === cateId)
        return findResult.cateName
      },
    },
    methods: {
      /** 查询服务项目列表 */
      getList() {
        this.loading = true;
        listServiceItem(this.queryParams).then(response => {
          this.ServiceItemList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      //查询服务项目分类列表
      getServiceCateList() {
        this.loading = true;
        listServiceItemCate().then(response => {
          this.ServiceItemCateList = response.rows;
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
          name: null,
          subName: null,
          imageSrc: null,
          olderPrice: null,
          nowPrice: null,
          cateId: null,
          isLimitKill: null,
          swiperUrl: null,
          swiperType: null,
          content: null
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
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加服务项目";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getServiceItem(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改服务项目";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateServiceItem(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addServiceItem(this.form).then(response => {
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
        this.$modal.confirm('是否确认删除服务项目编号为"' + ids + '"的数据项？').then(function() {
          return delServiceItem(ids);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('meiye/ServiceItem/export', {
          ...this.queryParams
        }, `ServiceItem_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
