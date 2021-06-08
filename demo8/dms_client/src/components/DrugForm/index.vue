<template>
    <div class="drug-form-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>药品管理</el-breadcrumb-item>
            <el-breadcrumb-item>添加药品</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 添加药品的表单 -->
        <el-form ref="drugForm" class="drug-form-info" :model="drugInfo" label-width="100px" label-position="left" :rules="rules">
            <el-form-item label="药品名称" prop="d_name">
                <el-col :span="12">
                    <el-input v-model="drugInfo.d_name" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="药品类别" prop="c_id">
                <el-col :span="8">
                    <el-select v-model="drugInfo.c_id" placeholder="请选择药品类别" style="width: 100%;" clearable>
                        <template v-for="(type, index) in drugCategory">
                            <el-option :label="type.c_name" :value="type.c_id" :key="index"></el-option>
                        </template>
                    </el-select>
                </el-col>
            </el-form-item>
            <el-form-item label="生产日期" prop="produce_date">
                <el-col :span="8">
                    <el-date-picker type="date" placeholder="选择日期" v-model="drugInfo.produce_date" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="有效期至" prop="expiration_date">
                <el-col :span="8">
                    <el-date-picker type="date" placeholder="选择日期" v-model="drugInfo.expiration_date" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="国药准字" prop="sfda">
                <el-col :span="12">
                    <el-input v-model="drugInfo.sfda" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="生产批号" prop="produce_batch">
                <el-col :span="12">
                    <el-input v-model="drugInfo.produce_batch" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="药品描述" prop="d_remarks">
                <el-input type="textarea" v-model="drugInfo.d_remarks" size="medium" rows="6"></el-input>
            </el-form-item>
            <el-form-item label="警告等级" prop="sv_id">
                    <el-col :span="8">
                        <el-select v-model="drugInfo.sv_id" placeholder="请选择警告等级" style="width: 100%;" clearable>
                            <template v-for="(type, index) in drugSvoList">
                                <el-option :label="'等级' + type.sv_id" :value="type.sv_id" :key="index"></el-option>
                            </template>
                        </el-select>
                    </el-col>
                </el-form-item>
            <el-form-item label="上架数量" required>
                <el-input-number v-model="drugInfo.rack_save" :min="1" :max="20" label="描述文字" size="small"></el-input-number>
            </el-form-item>
            <el-form-item label="库存量" required>
                <el-input-number v-model="drugInfo.inventory" :min="1" :max="500" label="描述文字" size="small" :step="10"></el-input-number>
            </el-form-item>
            <el-form-item label="进货价" prop="purchase_price">
                <el-col :span="12">
                    <el-input v-model="drugInfo.purchase_price" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="出售价" prop="sale_price">
                <el-col :span="12">
                    <el-input v-model="drugInfo.sale_price" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-button type="primary" style="width: 100%;" round plain @click="saveDrug('drugForm')">立即添加</el-button>
                </el-col>
                <el-col :span="10" :offset="4">
                    <el-button type="info" style="width: 100%;" round plain @click="resetDrug('drugForm')">重置信息</el-button>
                </el-col>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { reqDrugSave } from '@/api'
export default {
    data(){
        return {
            drugInfo: {
                d_name: '',
                c_id: null,
                produce_date: '',
                expiration_date: '',
                sfda: '',
                produce_batch: '',
                d_remarks: '',
                sv_id: null,
                rack_save: 1,
                inventory: 1,
                purchase_price: 0,
                sale_price: 0
            },
            rules: {
                d_name: [
                    { required: true, message: '输入药品名称', trigger: 'blur' }
                ],
                c_id: [
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
                sv_id: [
                    { required: true, message: '请选择库存警告等级', trigger: 'change' }
                ]
            }
        }
    },
    created() {
        this.getDrugCategory()
        this.getDrugSvo()
    },
    computed: {
        ...mapState([
            'drugCategory',
            'drugSvoList'
        ])
    },
    methods: {
        ...mapActions([
            'getDrugCategory',
            'getDrugSvo'
        ]),
        saveDrug(form) {
            this.$refs[form].validate((valid) => {
                if (valid) {
                    reqDrugSave(this.drugInfo).then(res => {
                        if( res.data.code === 200 ){
                            this.$message({
                                message: '提交信息成功！',
                                type: 'success',
                                center: true
                            });
                            this.$refs[form].resetFields();
                        } else {
                            this.$message({
                                message: '提交失败，请检查药品信息',
                                type: 'error',
                                center: true
                            });
                        }
                    }).catch(error => {
                        this.$message({
                            message: '提交失败，请检查药品信息',
                            type: 'error',
                            center: true
                        });
                        console.log(error);
                        
                    })
                } else {
                    this.$message({
                        message: '提交失败，请检查药品信息',
                        type: 'error',
                        center: true
                    });
                    return false;
                }
            });
        },
        resetDrug(form) {
            this.$refs[form].resetFields();
            this.$message({
                message: '药品信息已重置，请重新填写。',
                type: 'warning',
                center: true
            });
        }
    }
}
</script>

<style lang="scss">
.drug-form-component {
    .drug-form-info {
        width: 60%;
        padding: 30px 50px;
    }
}
</style>