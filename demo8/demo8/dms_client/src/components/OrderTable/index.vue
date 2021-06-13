<template>
    <div class="order-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>订单管理</el-breadcrumb-item>
            <el-breadcrumb-item>订单列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 条件查询 -->
        <el-row class="order-table-condition">
            <el-col :span="4" :offset="3">
                <el-date-picker 
                    type="date" 
                    placeholder="选择日期" 
                    v-model="selectCondition['so_date']" 
                    style="width: 100%;" 
                    value-format="yyyy-MM-dd"
                ></el-date-picker>
            </el-col>
            <el-col :span="4" :offset="2">
                <el-select v-model="selectCondition['s_id']" placeholder="选择操作员" clearable>
                    <el-option
                    v-for="(item,index) in operatorList"
                    :key="index"
                    :label="'操作员' + item"
                    :value="item">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span="3" :offset="2">
                <el-button type="primary" round style="width: 100%;" @click="handleQueryCondition()" icon="el-icon-search">查询</el-button>
            </el-col>
        </el-row>
        <!-- 订单列表 -->
        <el-table
            :data="orderList"
            stripe
            style="width: 100%"
        >
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-row class="order-expend-header">
                        <el-col :span="6" :offset="2">药品名</el-col>
                        <el-col :span="6" :offset="2">价格</el-col>
                        <el-col :span="6" :offset="2">数量</el-col>
                    </el-row>
                    <template v-for="(items,index) in props.row.drugs">
                        <el-row :key="index" class="order-expend-item">
                            <el-col :span="6" :offset="2">{{items.drug_name}}</el-col>
                            <el-col :span="6" :offset="2">{{items.drug_price}}</el-col>
                            <el-col :span="6" :offset="2">X{{items.drug_num}}</el-col>
                        </el-row>
                    </template>
                </template>
            </el-table-column>
            <el-table-column
                prop="so_id"
                label="#"
            >
            </el-table-column>
            <el-table-column
                prop="order_id"
                label="流水号"
            >
            </el-table-column>
            <el-table-column
                prop="so_date"
                label="订单日期"
                width="250"
            >
            </el-table-column>
            <el-table-column
                prop="s_id"
                label="操作员"
            >
            </el-table-column>
            <el-table-column
                prop="totalMoney"
                label="总金额"
            >
            </el-table-column>
            <el-table-column
                fixed="right"
                label="操作"
            >
                <template slot-scope="scope">
                    <el-button 
                        icon="el-icon-view" 
                        type="primary" 
                        plain 
                        circle 
                        size="small" 
                        @click="viewOrder(scope.row.so_id)"
                    >
                    </el-button>
                    <el-button 
                        icon="el-icon-delete" 
                        type="danger" 
                        plain 
                        circle
                        @click="deleteOrder(scope.row.so_id)"
                        size="small">
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 分页组件 -->
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[3, 5, 8]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="orderCount"
            class="order-table-pagination"
        >
        </el-pagination>
        <!-- 查看详情的模态框 -->
        <el-dialog title="订单详情" :visible.sync="viewOrderVisible" center width="35%" top="6vh">
            <el-divider><i class="el-icon-reading"></i></el-divider>
            <el-form :model="currentOrder" class="order-table-info" label-width="80px" label-position="left" v-if="currentOrder">
                <el-form-item label="订单号">
                    <span>{{ currentOrder.so_id }}</span>
                </el-form-item>
                <el-form-item label="流水号">
                    <span>{{ currentOrder.order_id }}</span>
                </el-form-item>
                <el-form-item label="订单日期">
                    <span>{{ currentOrder.so_date }}</span>
                </el-form-item>
                <el-form-item label="操作员">
                    <span>{{ '操作员' + currentOrder.s_id }}</span>
                </el-form-item>
                <el-form-item label="药品清单">
                    <template>
                        <el-row class="order-expend-header">
                            <el-col :span="6" :offset="2">药品名</el-col>
                            <el-col :span="6" :offset="2">价格</el-col>
                            <el-col :span="6" :offset="2">数量</el-col>
                        </el-row>
                        <template v-for="(items,index) in currentOrder.drugs">
                            <el-row :key="index" class="order-expend-item">
                                <el-col :span="6" :offset="2">{{items.drug_name}}</el-col>
                                <el-col :span="6" :offset="2">{{items.drug_price}}</el-col>
                                <el-col :span="6" :offset="2">X{{items.drug_num}}</el-col>
                            </el-row>
                        </template>
                    </template>
                </el-form-item>
                <el-form-item label="总价格">
                    <span>{{ currentOrder.totalMoney }}</span>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { reqOrderById, reqOrderDelete } from '@/api'
export default {
    data(){
        return {
            pageNum: 1,
            pageSize: 3,
            viewOrderVisible: false,
            selectCondition: {
                so_date: '',
                s_id: ''
            },
            currentOrder: {
                so_id: '',
                order_id: '',
                so_date: '',
                s_id: '',
                drugs: [],
                totalMoney: ''
            }
        }
    },
    created(){
        this.getOrderByCondition({ pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition })
        this.getOrderOperator()
        this.getOrderCount({})
    },
    computed: {
        ...mapState([
            'orderList',
            'operatorList',
            'orderCount'
        ])
    },
    methods: {
        ...mapActions([
            'getOrderByCondition',
            'getOrderOperator',
            'getOrderCount'
        ]),
        handleQueryCondition(){
            this.getOrderByCondition({ pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition })
            this.getOrderCount(this.selectCondition)
        },
        handleSizeChange(size){
            this.pageSize = size
            this.getOrderByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition})
        },
        handleCurrentChange(page){
            this.pageNum = page
            this.getOrderByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition})
        },
        viewOrder(id){
            reqOrderById(id).then(res => {
                console.log(res)
                if(res.data.code === 200){
                    this.viewOrderVisible = true
                    this.currentOrder = res.data.data[0]
                } else {
                    this.viewOrderVisible = false
                    this.$message({
                        type: 'danger',
                        message: '当前数据异常，请刷新重试。',
                        center: true
                    });
                }
            })
        },
        deleteOrder(id){
            this.$confirm('此操作将永久删除该记录, 是否继续?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                reqOrderDelete(id).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '删除成功!',
                            center: true
                        });
                        this.getOrderCount(this.selectCondition)
                        if(this.orderCount % this.pageSize === 1){
                            this.pageNum = this.pageNum - 1
                        }
                        this.getOrderByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition})
                    } else {
                        this.$message({
                            type: 'danger',
                            message: '删除失败!（权限不够或未知原因）',
                            center: true
                        });
                    }
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除',
                    center: true
                });
            });
        }
    }
}
</script>

<style lang="scss">
.order-table-component{
    .order-expend-header{
        font-size: 14px;
        font-weight: 700;
        color: #999;
    }
    .order-expend-item {
        margin: 15px 0;
    }
    .order-table-condition, .order-table-pagination {
        margin: 20px 0;
    }
    .el-dialog__body {
        padding-top: 0;
        padding-bottom: 10px;
        padding-left: 50px;
    }
}
</style>