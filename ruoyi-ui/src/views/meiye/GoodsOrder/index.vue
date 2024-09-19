<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单编号" prop="goodsOrderId">
        <el-input
          v-model="queryParams.goodsOrderId"
          placeholder="请输入订单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="快递单号" prop="postalNumber">
        <el-input
          v-model="queryParams.postalNumber"
          placeholder="请输入订单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单状态" prop="orderStatus">
        <el-select v-model="queryParams.orderStatus" placeholder="请选择订单状态" clearable>
          <el-option v-for="(item,index) in orderStatusList" :key="index" :label="item.orderStatus" :value="item.orderStatus" />
        </el-select>
      </el-form-item>
      <el-form-item label="付款时间" prop="payTime">
        <el-date-picker clearable
          v-model="queryParams.payTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择付款时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="收件人姓名" prop="receiverName">
        <el-input
          v-model="queryParams.receiverName"
          placeholder="请输入收件人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收件人电话" prop="receiverPhone">
        <el-input
          v-model="queryParams.receiverPhone"
          placeholder="请输入收件人电话"
          clearable
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
          type="success"
          plain
          icon="el-icon-truck"
          size="mini"
          :disabled="single"
          @click="handleFaHuo"
          v-hasPermi="['meiye:GoodsOrder:edit']"
        >发货</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['meiye:GoodsOrder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="GoodsOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单编号" align="center" prop="goodsOrderId" />
      <el-table-column label="客户微信昵称" align="center" prop="uName" width="120" />
      <el-table-column label="商品名称" align="center" prop="goodsList">
        <template slot-scope="scope">
          <span v-for="(item,index) in scope.row.goodsList" :key="index">【{{index+1}} 】 {{item.name}}<br /><br /></span>
        </template>
      </el-table-column>
      <el-table-column label="商品图片" align="center" prop="goodsList">
        <template slot-scope="scope">
          <image-preview  :src="item.imageSrc" v-for="(item,index) in scope.row.goodsList" :key="index" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="留言" align="center" prop="remark" />
      <el-table-column label="订单总金额" align="center" prop="priceSum" width="100"/>
      <el-table-column label="实际金额" align="center" prop="realPrice" />
      <el-table-column label="订单状态" align="center" prop="orderStatus" />
      <el-table-column label="快递单号" align="center" prop="postalNumber" />
      <el-table-column label="付款方式" align="center" prop="payType" />
      <el-table-column label="付款时间" align="center" prop="payTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.payTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="收件人姓名" align="center" prop="receiverName" width="120"/>
      <el-table-column label="收件人地址" align="center" prop="receiverAddress" width="120"/>
      <el-table-column label="收件人电话" align="center" prop="receiverPhone" width="120"/>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改商品订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="快递单号" prop="postalNumber">
          <el-input v-model="form.postalNumber" placeholder="请输入快递单号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">发 货</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listGoodsOrder, getGoodsOrder, delGoodsOrder, addGoodsOrder, updateGoodsOrder } from "@/api/meiye/GoodsOrder";

export default {
  name: "GoodsOrder",
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
      // 商品订单表格数据
      GoodsOrderList: [],
      //商品订单状态
      orderStatusList:[{
          orderStatus:'待付款'
        },{
          orderStatus:'待发货'
        },{
          orderStatus:'待收货'
        },{
          orderStatus:'待评价'
        },{
          orderStatus:'已完成'
        }
      ],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        goodsOrderId: null,
        userId: null,
        openId: null,
        goodsIdList: null,
        intergralSum: null,
        priceSum: null,
        realPrice: null,
        useCoupon: null,
        orderStatus: null,
        payType: null,
        payTime: null,
        payDeadline: null,
        isOutTime: null,
        receiverName: null,
        receiverAddress: null,
        receiverPhone: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商品订单列表 */
    getList() {
      this.loading = true;
      listGoodsOrder(this.queryParams).then(response => {
        this.GoodsOrderList = response.rows;
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
        goodsOrderId: null,
        userId: null,
        openId: null,
        goodsIdList: null,
        remark: null,
        intergralSum: null,
        priceSum: null,
        realPrice: null,
        useCoupon: null,
        orderStatus: null,
        payType: null,
        payTime: null,
        createTime: null,
        payDeadline: null,
        isDeleted: null,
        isOutTime: null,
        receiverName: null,
        receiverAddress: null,
        receiverPhone: null
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
      const status = selection.map(item => item.orderStatus);
      this.single = selection.length!==1 || status[0] !== '待发货'
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品订单";
    },
    /** 发货按钮操作 */
    handleFaHuo(row) {
      this.reset();
      const id = row.goodsOrderId || this.ids
      this.form.id = id[0];
      this.form.orderStatus = '待收货';
      this.open = true;
      this.title = "商品订单发货";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateGoodsOrder(this.form).then(response => {
            this.$modal.msgSuccess("发货成功");
            this.open = false;
            this.getList();
          });
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除商品订单编号为"' + ids + '"的数据项？').then(function() {
        return delGoodsOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('meiye/GoodsOrder/export', {
        ...this.queryParams
      }, `GoodsOrder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
