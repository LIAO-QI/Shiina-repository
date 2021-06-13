<template>
    <div class="apply-form-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>库存管理</el-breadcrumb-item>
            <el-breadcrumb-item>补货录入</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 添加补货的表单 -->
        <el-form ref="applyForm" class="apply-form-info" :model="apply" label-width="100px" label-position="left" :rules="rules">
            <el-form-item label="申请流水号" prop="apply_id">
                <el-col :span="12">
                    <el-input v-model="apply.apply_id" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="生产产地" prop="produce_area">
                <el-col :span="12">
                    <el-input v-model="apply.produce_area" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="生产公司" prop="produce_firm">
                <el-col :span="12">
                    <el-input v-model="apply.produce_firm" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="申请日期" prop="ra_date">
                <el-col :span="8">
                    <el-date-picker type="date" placeholder="选择日期" v-model="apply.ra_date" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="补货备注" prop="ra_remarks">
                <el-col :span="12">
                    <el-input v-model="apply.ra_remarks" clearable></el-input>
                </el-col>
            </el-form-item>

            <el-form-item 
                v-for="(drug, index) in apply.drugs"
                :key="index"
                :label="'@ 药品'+index"
            >
                <el-select v-model="drug.d_id" placeholder="选择药品" clearable>
                    <el-option
                    v-for="item in drugList"
                    :key="item.d_id"
                    :label="item.d_name"
                    :value="item.d_id"
                    >
                    </el-option>
                </el-select>
                <el-input-number v-model="drug.num" :min="1" :max="20" label="描述文字" size="small" class="drugCount"></el-input-number>
                <el-button type="danger" circle icon="el-icon-close" size="small" @click="removeDomin(index)" class="drugRemove"></el-button>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" round plain @click="saveApply('applyForm')">立即添加</el-button>
                <el-button round @click="addDomin()">添加药品</el-button>
                <el-button type="info" round plain @click="resetApply('applyForm')">重置信息</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import { insertApply } from '@/api'
export default {
    data(){
        return {
            apply: {
                ra_id: 0,
                apply_id: '',
                produce_area: '',
                produce_firm: '',
                approve: '1',
                ra_remarks: '',
                drugs: [{
                    d_id: '',
                    num: 1
                }],
                ra_date: ''
            },
            rules: {
                apply_id: [
                    { required: true, message: '请输入申请流水号', trigger: 'blur' }
                ],
                produce_area: [
                    { required: true, message: '请输入生产产地', trigger: 'blur' }
                ],
                produce_firm: [
                    { required: true, message: '请输入生产公司', trigger: 'blur' }
                ],
                ra_date: [
                    { required: true, message: '请选择申请日期', trigger: 'blur' }
                ],
                ra_remarks: [
                    { required: true, message: '确认补货备注', trigger: 'blur' }
                ]
            }
        }
    },
    created () {
        this.getDrugs()
    },
    computed: {
        ...mapState([
            'drugList'
        ])
    },
    methods: {
        ...mapActions([
            'getDrugs'
        ]),
        addDomin() {
            this.apply.drugs.push({
                d_id: '',
                num: 1,
                key: new Date().toTimeString()
            })
        },
        removeDomin(index) {
            if (index !== -1 && this.apply.drugs.length > 1) {
                this.apply.drugs.splice(index, 1)
            } else {
                this.$message({
                    message: '至少包含一个药品！',
                    type: 'error',
                    center: true
                });
            }
        },
        saveApply(form) {
            console.log(this.apply);
            this.$refs[form].validate((valid) => {
                if (valid) {
                    insertApply(this.apply).then(res => {
                        if( res.data.code === 200 ){
                            this.$message({
                                message: '提交信息成功！',
                                type: 'success',
                                center: true
                            });
                            this.apply = {
                                drugs: [{
                                    d_id: '',
                                    num: 1
                                }]
                            }
                            this.$refs[form].resetFields();
                        } else {
                            this.$message({
                                message: '提交失败，响应码非200成功',
                                type: 'error',
                                center: true
                            });
                        }
                    }).catch(error => {
                        this.$message({
                            message: '提交失败，系统错误',
                            type: 'error',
                            center: true
                        });
                        console.log(error);
                    })

                } else {
                    this.$message({
                        message: '提交失败，补货申请单信息填写不完整',
                        type: 'error',
                        center: true
                    });
                    return false;
                }
            });
        },
        resetApply(form) {
            this.apply = {
                drugs: [{
                    d_id: '',
                    num: 1
                }]
            }
            this.$refs[form].resetFields();
            this.$message({
                message: '补货信息已重置，请重新填写。',
                type: 'warning',
                center: true
            });
        }
    }
}
</script>

<style lang="scss">
.apply-form-component {
    .apply-form-info {
        padding: 30px 50px;
    }
    .drugCount,.drugRemove {
        margin-left: 50px;
    }
}
</style>