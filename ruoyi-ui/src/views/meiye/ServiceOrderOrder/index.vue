<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单号" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="请输入订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二维码号码" prop="qrcodeNumber">
        <el-input
          v-model="queryParams.qrcodeNumber"
          placeholder="请输入二维码号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单状态" prop="orderStatus">
        <el-select v-model="queryParams.orderStatus" placeholder="请选择订单状态" clearable>
          <el-option v-for="(item,index) in orderStatusList" :key="index" :label="item.orderStatus" :value="item.orderStatus" />
        </el-select>
      </el-form-item>
      <el-form-item label="到期时间" prop="endDate">
        <el-date-picker clearable
          v-model="queryParams.endDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择到期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="预约时间" prop="serviceOrderDatetime">
        <el-date-picker clearable
          v-model="queryParams.serviceOrderDatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预约时间">
        </el-date-picker>
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
          icon="el-icon-check"
          size="mini"
          @click="handleHeYan"
          v-hasPermi="['meiye:ServiceOrderOrder:edit']"
        >核验券码</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['meiye:ServiceOrderOrder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ServiceOrderOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键订单号" align="center" prop="orderId" width="100"/>
      <el-table-column label="二维码号码" align="center" prop="qrcodeNumber" width="100" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="服务项目名称" align="center" prop="sName" width="120" />
      <el-table-column label="美容师姓名" align="center" prop="bName" width="100"/>
      <el-table-column label="客户微信昵称" align="center" prop="uName"  width="120"/>
      <el-table-column label="到期时间" align="center" prop="endDate" />
      <el-table-column label="服务方式" align="center" prop="serviceType" />
      <el-table-column label="预约时间" align="center" prop="orderTime" />
      <el-table-column label="订单总价" align="center" prop="sumPrice" />
      <el-table-column label="实付款" align="center" prop="realPay" />
      <el-table-column label="订单状态" align="center" prop="orderStatus" />
      <el-table-column label="付款方式" align="center" prop="payType" />
      <el-table-column label="付款时间" align="center" prop="payTime" />

    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 核验券码弹出框 -->
    <el-dialog title="核验券码" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="扫描二维码或手动输入" prop="swiperType">
          <el-input v-model="form.qrcodeNumber" placeholder="请输入券码号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">核验</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listServiceOrderOrder, getServiceOrderOrder, delServiceOrderOrder, addServiceOrderOrder, updateServiceOrderOrder } from "@/api/meiye/ServiceOrderOrder";

export default {
  name: "ServiceOrderOrder",
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
      // 服务项目订单表格数据
      ServiceOrderOrderList: [],
      //服务项目订单状态
      orderStatusList:[{
          orderStatus:'待付款'
        },{
          orderStatus:'待使用'
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
        orderId: null,
        qrcodeNumber: null,
        serviceItemId: null,
        beauticianId: null,
        endDate: null,
        serviceType: null,
        orderTime: null,
        serviceOrderDatetime: null,
        orderStatus: null,
      },
      // 新增或修改 表单参数
      form: {},
      // 核验券码 表单参数
      heYanForm:{},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询服务项目订单列表 */
    getList() {
      this.loading = true;
      listServiceOrderOrder(this.queryParams).then(response => {
        this.ServiceOrderOrderList = response.rows;
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
        orderId: null,
        qrcodeNumber: null,
        remarks: null,
        createTime: null,
        serviceItemId: null,
        dateId: null,
        timeId: null,
        beauticianId: null,
        uid: null,
        openId: null,
        endDate: null,
        serviceType: null,
        orderTime: null,
        serviceOrderDatetime: null,
        sumPrice: null,
        realPay: null,
        payType: null,
        payTime: null,
        orderStatus: "0",
        isDeleted: null
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
      this.ids = selection.map(item => item.orderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加服务项目订单";
    },
    /** 核验券码按钮操作 */
    handleHeYan() {
      this.reset();
      this.open = true;
    },
    /** 提交按钮 */
    submitForm() {
      this.loading = true;
      const queryParams = {
        pageNum: 1,
        pageSize: 10,
        qrcodeNumber: this.form.qrcodeNumber,
        orderStatus: '待使用',
      }
      listServiceOrderOrder(queryParams).then(response => {
        var list = response.rows;
        const order = list[0];
        if(list.length !=0 && order.qrcodeNumber == this.form.qrcodeNumber && order.orderStatus == '待使用'){
          this.form.orderId = order.orderId;
          this.form.orderStatus = '待评价';
          updateServiceOrderOrder(this.form).then(response => {
            this.$modal.msgSuccess("核验成功");
            this.open = false;
            this.getList();
          });
        }else{
          this.$modal.msgSuccess("券码有误");
        }
        this.loading = false;
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('meiye/ServiceOrderOrder/export', {
        ...this.queryParams
      }, `ServiceOrderOrder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
