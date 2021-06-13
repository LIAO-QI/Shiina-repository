<template>
    <div class="outcome-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>财务管理</el-breadcrumb-item>
            <el-breadcrumb-item>支出信息</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 支出明细表 -->
        <el-table
            :data="outcomeDetail"
            stripe
        >
            <el-table-column
            prop="ra_id"
            label="补货单号">
            </el-table-column>
            <el-table-column
            prop="stock_id"
            label="申请流水号">
            </el-table-column>
            <el-table-column
            prop="po_date"
            label="进货日期">
            </el-table-column>
            <el-table-column
            prop="money"
            label="进货金额">
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
    data(){
        return{}
    },
    created(){
        this.getOutcomeDetail()
    },
    computed: {
        ...mapState([
            'outcomeDetail'
        ])
    },
    methods: {
        ...mapActions([
            'getOutcomeDetail'
        ])
    }
}
</script>

<style>

</style>