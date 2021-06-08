<template>
    <div class="income-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>财务管理</el-breadcrumb-item>
            <el-breadcrumb-item>收入信息</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 收入明细表 -->
        <el-table
            :data="incomeDetail"
            stripe
        >
            <el-table-column
            prop="so_id"
            label="销售订单号">
            </el-table-column>
            <el-table-column
            prop="order_id"
            label="订单流水号">
            </el-table-column>
            <el-table-column
            prop="so_date"
            label="销售日期">
            </el-table-column>
            <el-table-column
            prop="money"
            label="订单金额">
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
export default {
    data(){
        return {}
    },
    created(){
        this.getIncomeDetail()
    },
    computed: {
        ...mapState([
            'incomeDetail'
        ])
    },
    methods: {
        ...mapActions([
            'getIncomeDetail'
        ])
    }
}
</script>

<style>

</style>