<template>
    <div class="stock-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>库存管理</el-breadcrumb-item>
            <el-breadcrumb-item>购进列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 条件查询 -->
        <el-row class="stock-table-condition">

            <el-col :span="4" :offset="3">
                <el-input v-model="stock_id" placeholder="请输入流水号" clearable></el-input>
            </el-col>
            <el-col :span="4" :offset="2">
                <el-select v-model="produce_firm" placeholder="请选择公司" clearable>
                    <el-option
                            v-for="(item,index) in stockList"
                            :key="index"
                            :label="item.produce_firm"
                            :value="item.produce_firm">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span="3" :offset="2">
                <el-button type="primary" round style="width: 100%;" @click="handleQueryCondition()" icon="el-icon-search">查询</el-button>
            </el-col>
        </el-row>
        <!-- 进货列表 -->
        <el-table
            :data="stockList"
            stripe
            style="width: 100%"
        >
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-row class="stock-expend-header">
                        <el-col :span="4" :offset="2">药品名</el-col>
                        <el-col :span="4" :offset="2">国药准字</el-col>
                        <el-col :span="4" :offset="2">购进数量</el-col>
                        <el-col :span="4" :offset="2">库存</el-col>
                    </el-row>
                    <template v-for="(items,index) in props.row.drugs">
                        <el-row :key="index" class="stock-expend-item">
                            <el-col :span="4" :offset="2">{{items.drug.d_name}}</el-col>
                            <el-col :span="4" :offset="2">{{items.drug.sfda}}</el-col>
                            <el-col :span="4" :offset="2">{{items.num}}</el-col>
                            <el-col :span="4" :offset="2">{{items.drug.inventory}}</el-col>
                        </el-row>
                    </template>
                </template>
            </el-table-column>
            <el-table-column
                prop="ra_id"
                label="#"
                width="100"
            >
            </el-table-column>
            <el-table-column
                prop="stock_id"
                label="进货流水号"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="po_date"
                label="日期"
                width="250"
            >
            </el-table-column>
            <el-table-column
                prop="produce_area"
                label="产地"
                width="120"
            >
            </el-table-column>
            <el-table-column
                prop="produce_firm"
                label="公司"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="po_remarks"
                label="备注"
                width="120"
            >
            </el-table-column>
            <el-table-column
                prop="singleMoney"
                label="金额"
                width="100"
            >
            </el-table-column>
            <el-table-column
                fixed="right"
                label="操作"
            >
                <template slot-scope="scope">
                    <el-button
                            icon="el-icon-delete"
                            type="danger"
                            plain
                            circle
                            @click="deleteStock(scope.row.po_id)"
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
            :total="stockCount"
            class="stock-table-pagination"
        >
        </el-pagination>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import { deleteStockById } from '@/api'
export default {
    data(){
        return {
            pageNum: 1,
            pageSize: 3,
            stock_id:'',
            produce_firm:''
        }
    },
    created(){
        //this.getStocks({pageNum: 1, pageSize: 3})
        this.getStocksAny({pageNum: this.pageNum, pageSize: this.pageSize, stock_id: this.stock_id, produce_firm: this.produce_firm})
        this.getStockCount({})
    },
    computed: {
        ...mapState([
            'stockList',
            'stockCount'
        ])
    },
    methods: {
        ...mapActions([
            'getStocks',
            'getStocksAny',
            'getStockCount'
        ]),
        handleSizeChange(size){
            this.pageSize = size
            //this.getStocks({pageNum: this.pageNum, pageSize: this.pageSize})
            this.getStocksAny({pageNum: this.pageNum, pageSize: this.pageSize, stock_id: this.stock_id, produce_firm: this.produce_firm})
        },
        handleCurrentChange(page){
            this.pageNum = page
            //this.getStocks({pageNum: this.pageNum, pageSize: this.pageSize})
            this.getStocksAny({pageNum: this.pageNum, pageSize: this.pageSize, stock_id: this.stock_id, produce_firm: this.produce_firm})
        },
        handleQueryCondition(){
            this.getStocksAny({pageNum: this.pageNum, pageSize: this.pageSize, stock_id: this.stock_id, produce_firm: this.produce_firm})
            this.getStockCount({stock_id: this.stock_id, produce_firm: this.produce_firm})
        },

        deleteStock(id) {   // 删除进货订单操作
            this.$confirm('此操作将永久删除该记录, 是否继续?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                deleteStockById(id).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '删除成功!',
                            center: true
                        });
                        this.getStockCount({stock_id: this.stock_id, produce_firm: this.produce_firm})
                        if(this.stockCount % this.pageSize === 1){
                            this.pageNum = this.pageNum - 1
                        }
                        this.getStocks({pageNum: this.pageNum, pageSize: this.pageSize})
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

<style lang="scss" scoped>
.stock-table-component {
    .stock-expend-header{
        font-size: 14px;
        font-weight: 700;
        color: #999;
    }
    .stock-expend-item {
        margin: 15px 0;
    }
    .stock-table-pagination {
        margin-top: 20px;
    }
}

</style>