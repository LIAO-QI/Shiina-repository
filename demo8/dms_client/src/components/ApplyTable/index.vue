<template>
    <div class="apply-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>库存管理</el-breadcrumb-item>
            <el-breadcrumb-item>补货列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 补货申请列表 -->
        <el-table
            :data="applyNoList"
            stripe
            style="width: 100%"
        >
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-row class="apply-expend-header">
                        <el-col :span="4" :offset="2">药品名</el-col>
                        <el-col :span="4" :offset="2">类别</el-col>
                        <el-col :span="4" :offset="2">库存</el-col>
                        <el-col :span="4" :offset="2">补货</el-col>
                    </el-row>
                    <template v-for="(items,index) in props.row.drugs">
                        <el-row :key="index" class="apply-expend-item">
                            <el-col :span="4" :offset="2">{{items.drug.d_name}}</el-col>
                            <el-col :span="4" :offset="2">{{items.drug.category.c_name}}</el-col>
                            <el-col :span="4" :offset="2">{{items.drug.inventory}}</el-col>
                            <el-col :span="4" :offset="2">{{items.num}}</el-col>
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
                prop="apply_id"
                label="申请流水号"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="ra_date"
                label="申请日期"
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
                prop="ra_remarks"
                label="备注"
                width="120"
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
                        @click="viewApply(scope.row.ra_id)" 
                        style="margin-right: 10px">
                    </el-button>
                    <el-button 
                        icon="el-icon-check" 
                        type="warning" 
                        plain 
                        circle 
                        size="small"
                        @click="updateApply(scope.row.ra_id)"
                        class="apply-table-opera-btn">
                    </el-button>
                    <el-button 
                        icon="el-icon-delete" 
                        type="danger" 
                        plain 
                        circle
                        @click="deleteApply(scope.row.ra_id)"
                        size="small">
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 查看详情的模态框 -->
        <el-dialog title="补货申请详情" :visible.sync="viewApplyVisible" center width="35%" top="6vh">
            <el-divider><i class="el-icon-reading"></i></el-divider>
            <el-form :model="currentApply" style="padding: 0;margin-left:30px;" label-width="80px" label-position="left" v-if="currentApply">
                <el-form-item label="申请编号">
                    <span>{{ currentApply.ra_id }}</span>
                </el-form-item>
                <el-form-item label="流水号">
                    <span>{{ currentApply.apply_id }}</span>
                </el-form-item>
                <el-form-item label="生产产地">
                    <span>{{ currentApply.produce_area }}</span>
                </el-form-item>
                <el-form-item label="生产公司">
                    <span>{{ currentApply.produce_firm }}</span>
                </el-form-item>
                <el-form-item label="说明">
                    <span>{{ currentApply.ra_remarks }}</span>
                </el-form-item>
                <el-form-item label="申请日期">
                    <span>{{ currentApply.ra_date }}</span>
                </el-form-item>
                <el-form-item label="待补药品">
                    <template v-for="(item,index) in currentApply.drugs">
                        <div :key="index">{{ item.drug.d_name }}：{{ item.num }}</div>
                    </template>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { reqApplyById, reqApplyDelete, reqApplyUpdate } from '@/api'
export default {
    data() {
        return {
            viewApplyVisible: false,
            currentApply: {
                ra_id: 0,
                apply_id: 0,
                produce_area: '',
                produce_firm: '',
                approve: '1',
                ra_remarks: '',
                ra_date: '',
                drugs: [{
                    d_id: '',
                    num: 1,
                    drug: {
                        d_name: ''
                    }
                }],
            }
        }
    },
    created(){
        this.getApplyNo()
    },
    computed: {
        ...mapState([
            'applyNoList'
        ])
    },
    methods: {
        ...mapActions([
            'getApplyNo'
        ]),
        viewApply (id) { // 查看补货申请订单详情
            reqApplyById(id).then(res => {
                if(res.data.code === 200){
                    console.log(res)
                    this.currentApply = res.data.data
                    console.log(this.currentApply)
                    this.viewApplyVisible = true
                    return true
                } else {
                    this.$message({
                        type: 'danger',
                        message: '查看详情失败，数据不存在或正在被操作。',
                        center: true
                    });
                    this.viewApplyVisible = false
                    return false
                }
            })
        },
        deleteApply(id) {    // 删除补货申请订单操作
            this.$confirm('此操作将永久删除该订单, 是否继续?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                reqApplyDelete(id).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '删除成功!',
                            center: true
                        });
                        this.getApplyNo()
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
        updateApply(id) {
            this.$confirm('确定已完成进货吗？', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                reqApplyUpdate(id).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '操作成功!',
                            center: true
                        });
                        this.getApplyNo()
                    } else {
                        this.$message({
                            type: 'danger',
                            message: '操作失败!（权限不够或未知原因）',
                            center: true
                        });
                    }
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消操作',
                    center: true
                });
            })
        }
    }
}
</script>

<style lang="scss" scoped>
.apply-table-component{
    .apply-expend-header{
        font-size: 14px;
        font-weight: 700;
        color: #999;
    }
    .apply-expend-item {
        margin: 15px 0;
    }
    .el-dialog__body {
        padding-top: 0;
        padding-left: 50px;
    }
    .apply-table-opera-btn {
        margin-right: 10px;
    }
}
</style>