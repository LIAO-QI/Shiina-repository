<template>
    <div class="drug-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>药品管理</el-breadcrumb-item>
            <el-breadcrumb-item>药品列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 条件查询 -->
        <el-row class="drug-table-condition">
            <el-col :span="4" :offset="1">
                <el-input v-model="selectCondition['d_name']" placeholder="请输入药品名称" clearable></el-input>
            </el-col>
            <el-col :span="4" :offset="2">
                <el-select v-model="selectCondition['category.c_id']" placeholder="选择类别" clearable>
                    <el-option
                    v-for="(item,index) in drugCategory"
                    :key="index"
                    :label="item.c_name"
                    :value="item.c_id">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span="4" :offset="2">
                <el-select v-model="selectCondition['svoLevel.sv_id']" placeholder="警告等级" clearable>
                    <el-option
                    v-for="(item,index) in drugSvoList"
                    :key="index"
                    :label="'等级' + item.sv_id"
                    :value="item.sv_id">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span="3" :offset="2">
                <el-button type="primary" round style="width: 100%;" @click="handleQueryCondition()" icon="el-icon-search">查询</el-button>
            </el-col>
        </el-row>
        <!-- 药品列表 -->
        <el-table
            :data="drugList"
            stripe
            style="width: 100%"
        >
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="drug-table-expand">
                        <el-form-item label="药品编号">
                            <span>{{ props.row.d_id }}</span>
                        </el-form-item>
                        <el-form-item label="药品名称">
                            <span>{{ props.row.d_name }}</span>
                        </el-form-item>
                        <el-form-item label="国药准字">
                            <span>{{ props.row.sfda }}</span>
                        </el-form-item>
                        <el-form-item label="药品类别">
                            <span>{{ props.row.category.c_name }}</span>
                        </el-form-item>
                        <el-form-item label="使用说明">
                            <span>{{ props.row.d_remarks }}</span>
                        </el-form-item>
                        <el-form-item label="生产批号">
                            <span>{{ props.row.produce_batch }}</span>
                        </el-form-item>
                        <el-form-item label="生产日期">
                            <span>{{ props.row.produce_date }}</span>
                        </el-form-item>
                        <el-form-item label="有效期至">
                            <span>{{ props.row.expiration_date }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                prop="d_id"
                label="#"
                width="100"
            >
            </el-table-column>
            <el-table-column
                prop="d_name"
                label="药品名称"
                width="200"
            >
            </el-table-column>
            <el-table-column
                prop="category.c_name"
                label="类别"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="svoLevel.sv_id"
                label="警报等级"
                width="120"
            >
            </el-table-column>
            <el-table-column
                prop="rack_save"
                label="上架数"
                width="120"
            >
            </el-table-column>
            <el-table-column
                prop="inventory"
                label="库存量"
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
                        @click="viewDrug(scope.row.d_id)" 
                        class="drugs-table-opera-btn">
                    </el-button>
                    <el-button 
                        icon="el-icon-edit" 
                        type="warning" 
                        plain 
                        circle 
                        size="small"
                        @click="updateDrug(scope.row.d_id)"
                        class="drugs-table-opera-btn">
                    </el-button>
                    <el-button 
                        icon="el-icon-delete" 
                        type="danger" 
                        plain 
                        circle
                        @click="deleteDrug(scope.row.d_id)"
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
            :total="drugCount"
            class="drug-table-pagination"
        >
        </el-pagination>
        <!-- 查看详情的模态框 -->
        <el-dialog title="药品详情" :visible.sync="viewDrugVisible" center width="35%" top="6vh">
            <el-divider><i class="el-icon-reading"></i></el-divider>
            <el-form :model="currentDrug" class="drug-table-info" label-width="80px" label-position="left">
                <el-form-item label="药品编号">
                    <span>{{ currentDrug.d_id }}</span>
                </el-form-item>
                <el-form-item label="药品名称">
                    <span>{{ currentDrug.d_name }}</span>
                </el-form-item>
                <el-form-item label="药品类别">
                    <span>{{ currentDrug.category.c_name }}</span>
                </el-form-item>
                <el-form-item label="生产日期">
                    <span>{{ currentDrug.produce_date }}</span>
                </el-form-item>
                <el-form-item label="有效期至">
                    <span>{{ currentDrug.expiration_date }}</span>
                </el-form-item>
                <el-form-item label="国药准字">
                    <span>{{ currentDrug.sfda }}</span>
                </el-form-item>
                <el-form-item label="生产批号">
                    <span>{{ currentDrug.produce_batch }}</span>
                </el-form-item>
                <el-form-item label="药品描述">
                    <el-col :span="18">
                        <span>{{ currentDrug.d_remarks }}</span>
                    </el-col>
                </el-form-item>
                <el-form-item label="警告等级">
                    <span>{{ currentDrug.svoLevel.sv_id }}</span>
                </el-form-item>
                <el-form-item label="上架数量">
                    <span>{{ currentDrug.rack_save }}</span>
                </el-form-item>
                <el-form-item label="库存量">
                    <span>{{ currentDrug.inventory }}</span>
                </el-form-item>
                <el-form-item label="进货价">
                    <span>{{ currentDrug.purchase_price }}</span>
                </el-form-item>
                <el-form-item label="售出价">
                    <span>{{ currentDrug.sale_price }}</span>
                </el-form-item>
            </el-form>
        </el-dialog>
        <!-- 修改详情的模态框 -->
        <el-dialog title="药品详情" :visible.sync="updateDrugVisible" center width="40%" top="6vh">
            <el-divider><i class="el-icon-edit"></i></el-divider>
            <el-form :model="currentDrug" class="drug-table-update" label-width="80px" label-position="left" :rules="rules">
                <el-form-item label="药品编号">
                    <el-col :span="6">
                        <el-input v-model="currentDrug.d_id" clearable disabled></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="药品名称" prop="d_name">
                    <el-col :span="12">
                        <el-input v-model="currentDrug.d_name" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="药品类别" prop="category">
                    <el-col :span="8">
                        <el-select v-model="currentDrug.category.c_id" placeholder="请选择药品类别" style="width: 100%;" clearable>
                            <template v-for="(type, index) in drugCategory">
                                <el-option :label="type.c_name" :value="type.c_id" :key="index"></el-option>
                            </template>
                        </el-select>
                    </el-col>
                </el-form-item>
                <el-form-item label="生产日期" prop="produce_date">
                    <el-col :span="8">
                        <el-date-picker type="date" placeholder="选择日期" v-model="currentDrug.produce_date" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="有效期至" prop="expiration_date">
                    <el-col :span="8">
                        <el-date-picker type="date" placeholder="选择日期" v-model="currentDrug.expiration_date" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="国药准字" prop="sfda">
                    <el-col :span="12">
                        <el-input v-model="currentDrug.sfda" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="生产批号" prop="produce_batch">
                    <el-col :span="12">
                        <el-input v-model="currentDrug.produce_batch" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="药品描述" prop="d_remarks">
                    <el-input type="textarea" v-model="currentDrug.d_remarks" size="medium" rows="6"></el-input>
                </el-form-item>
                <el-form-item label="警告等级" prop="svoLevel">
                    <el-col :span="8">
                        <el-select v-model="currentDrug.svoLevel.sv_id" placeholder="请选择库存警告等级" style="width: 100%;" clearable>
                            <template v-for="(type, index) in drugSvoList">
                                <el-option :label="'等级' + type.sv_id" :value="type.sv_id" :key="index"></el-option>
                            </template>
                        </el-select>
                    </el-col>
                </el-form-item>
                <el-form-item label="上架数量">
                    <el-input-number v-model="currentDrug.rack_save" :min="1" :max="20" label="描述文字" size="mini"></el-input-number>
                </el-form-item>
                <el-form-item label="库存量">
                    <el-input-number v-model="currentDrug.inventory" :min="1" :max="500" label="描述文字" size="mini" :step="10"></el-input-number>
                </el-form-item>
                <el-form-item label="进货价" prop="purchase_price">
                    <el-col :span="12">
                        <el-input v-model="currentDrug.purchase_price" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="出售价" prop="sale_price">
                    <el-col :span="12">
                        <el-input v-model="currentDrug.sale_price" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item>
                    <el-col :span="6">
                        <el-button type="success" style="width: 100%;" round @click="handleUpdate()">修改信息</el-button>
                    </el-col>
                    <el-col :span="6" :offset="6">
                        <el-button type="warning" style="width: 100%;" round @click="updateDrugVisible = false">取消修改</el-button>
                    </el-col>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { reqDrugDelete, reqDrugById, reqDrugUpdate } from '@/api'
export default {
    data(){
        return {
            pageNum: 1,
            pageSize: 3,
            total: 0,
            viewDrugVisible: false,
            updateDrugVisible: false,
            currentDrug: {
                d_id: 0,
                d_name: '',
                category: {
                    c_id: 0,
                    c_name: '',
                    c_remarks: ''
                },
                produce_date: '',
                expiration_date: '',
                sfda: '',
                produce_batch: '',
                d_remarks: '',
                svoLevel: {
                    sv_id: 0,
                    r_number: 0,
                    y_number: 0
                },
                inventory: '',
                rack_save: '',
                purchase_price: 0,
                sale_price: 0
            },
            rules: {
                d_name: [
                    { required: true, message: '输入药品名称', trigger: 'blur' }
                ],
                category: [
                    { required: true, message: '请选择类别', trigger: 'change' }
                ],
                produce_date: [
                    { required: true, message: '确认生产日期', trigger: 'blur' }
                ],
                expiration_date: [
                    { required: true, message: '确认有效期', trigger: 'blur' }
                ],
                sfda: [
                    { required: true, message: '输入国药准字', trigger: 'blur' }
                ],
                produce_batch: [
                    { required: true, message: '输入生产批号', trigger: 'blur' }
                ],
                d_remarks: [
                    { required: true, message: '输入药品描述', trigger: 'blur' }
                ],
                svoLevel: [
                    { required: true, message: '请选择库存警告等级', trigger: 'change' }
                ]
            },
            selectCondition: {
                d_name: '',
                'category.c_id': '',
                'svoLevel.sv_id': ''
            }
        }
    },
    created(){
        this.getDrugByCondition({pageNum: 1, pageSize: 3, selectCondition: this.selectCondition})
        this.getDrugCount({})
        this.getDrugCategory()
        this.getDrugSvo()
    },
    methods: {
        ...mapActions([
            'getDrugCount',
            'getDrugCategory',
            'getDrugSvo',
            'getDrugByCondition'
        ]),
        viewDrug (id) { // 查看药品详情
            reqDrugById(id).then(res => {
                console.log(res)
                if(res.data.code === 200){
                    this.currentDrug = res.data.data[0]
                    this.viewDrugVisible = true
                    return true
                } else {
                    this.$message({
                        type: 'danger',
                        message: '查看详情失败，数据不存在或正在被操作。',
                        center: true
                    });
                    this.viewDrugVisible = false
                    return false
                }
            })
            
        },
        handleSizeChange(size){
            this.pageSize = size
            this.getDrugByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition})
        },
        handleCurrentChange(page){
            this.pageNum = page
            this.getDrugByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition})
        },
        deleteDrug(id) {    // 删除药品操作
            this.$confirm('此操作将永久删除该记录, 是否继续?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                reqDrugDelete(id).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '删除成功!',
                            center: true
                        });
                        this.getDrugCount({selectCondition: {}})
                        if(this.drugCount % this.pageSize === 1){
                            this.pageNum = this.pageNum - 1
                        }
                        this.getDrugByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition})
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
        updateDrug(id) {    // 更新药品（先查看）
            reqDrugById(id).then(res => {
                if(res.data.code === 200){
                    this.currentDrug = res.data.data[0]
                    this.updateDrugVisible = true
                } else {
                    this.$message({
                        type: 'danger',
                        message: '修改失败，当前记录正在被操作或不存在。',
                        center: true
                    });
                    this.updateDrugVisible = false
                    return false
                }
            })
        },
        handleUpdate(){
            let current = this.currentDrug
            let drug = {
                d_id: current.d_id,
                d_name: current.d_name,
                c_id: current.category.c_id,
                produce_date: current.produce_date,
                expiration_date: current.expiration_date,
                sfda: current.sfda,
                produce_batch: current.produce_batch,
                d_remarks: current.d_remarks,
                sv_id: current.svoLevel.sv_id,
                inventory: current.inventory,
                rack_save: current.rack_save,
                purchase_price: current.purchase_price,
                sale_price: current.sale_price
            }
            reqDrugUpdate(drug).then(res => {
                if(res.data.code === 200){
                    this.$message({
                        type: 'success',
                        message: '修改成功',
                        center: true
                    });
                    this.getDrugByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition})
                    this.updateDrugVisible = false
                } else {
                    this.$message({
                        type: 'warning',
                        message: '修改失败，当前记录异常。',
                        center: true
                    });
                    this.updateDrugVisible = false
                }
            })
        },
        handleQueryCondition() {    // 通过条件查询
            this.pageNum = 1
            this.pageSize = 3
            this.getDrugByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.selectCondition})
            this.getDrugCount({
                d_name: this.selectCondition['d_name'],
                c_id: this.selectCondition['category.c_id'],
                sv_id: this.selectCondition['svoLevel.sv_id']
            })
        }
    },
    computed: {
        ...mapState([
            'drugList',
            'drugCount',
            'drugCategory',
            'drugSvoList'
        ])
    }
}
</script>

<style lang="scss">
.drug-table-component  {
    .drug-table-info, .drug-table-expand {
        padding-left: 20px; 
        font-size: 14px;
        display: flex;
        flex-direction: column;
        .el-form-item {
            margin: 0;
            label {
                color: rgba(0, 0, 0, 0.3);
                margin-right: 20px;
            }
        }
    }
    .drug-table-info {
        padding: 0;
    }
    .drugs-table-opera-btn {
        margin-right: 10px;
    }
    .drug-table-pagination {
        margin-top: 20px;
    }
    .el-dialog__body {
        padding-top: 0;
        padding-left: 50px;
    }
    .drug-table-condition {
        margin: 40px 0;
    }
}
</style>