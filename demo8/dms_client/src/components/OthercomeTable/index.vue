<template>
    <div class="outcome-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>财务管理</el-breadcrumb-item>
            <el-breadcrumb-item>其他支出</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>

        <el-row class="staff-table-condition">
            <el-col :span="4" :offset="3">
                <el-input v-model="accountOther.ao_name" placeholder="请输入支出名称" clearable></el-input>
            </el-col>
            <el-col :span="4" :offset="3">
                <el-input v-model="accountOther.ao_date" placeholder="请输入时间" clearable></el-input>
            </el-col>
            <el-col :span="3" :offset="2">
                <el-button type="primary" round style="width: 100%;" @click="handleQueryCondition()" icon="el-icon-search">查询</el-button>
            </el-col>
        </el-row>
        <!-- 支出明细表 -->
        <el-table
            :data="accountOtherList"
            stripe
        >
            <el-table-column
            prop="ao_name"
            label="费用名称">
            </el-table-column>
            <el-table-column
            prop="ao_money"
            label="费用金额">
            </el-table-column>
            <el-table-column
            prop="ao_remarks"
            label="费用备注">
            </el-table-column>
            <el-table-column
            prop="ao_date"
            label="缴费时间"
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
                            @click="delete1(scope.row.ao_id)"
                            size="small">
                    </el-button>
                </template>
            </el-table-column>
        </el-table>




    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

import { deleteAccountOther  } from '@/api'
export default {
    data(){
        return{
            aoId:0,
            updateStaffVisible: false,
            accountOther:{
                ao_id:0,
                ao_name:'',
                ao_money:'',
                ao_remarks:'',
                ao_date:''
            }

        }
    },
    created(){
        this.getAllAccountOtherWithPage()
    },
    computed: {
        ...mapState([
            'accountOtherList'
        ])
    },
    methods: {
        ...mapActions([
            'getAllAccountOtherWithPage',
            'getAccountOtherByObject'
        ]),


        handleQueryCondition(){
            this.getAccountOtherByObject({ accountOther: this.accountOther})
        },
        delete1(id) {   // 删除操作

            this.$confirm('此操作将永久删除该记录, 是否继续?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                deleteAccountOther( id ).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '删除成功!',
                            center: true
                        });
                        this.getAllAccountOtherWithPage()
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
        },
    }
}
</script>

<style>

</style>