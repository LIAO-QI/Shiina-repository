// 处理异步请求
import {
    TOGGLE_LOGIN_LOGOUT,
    RECEIVE_DRUGS,
    RECEIVE_DRUG_CATEGORY,
    RECEIVE_STAFFS,
    RECEIVE_DRUG_COUNT,
    RECEIVE_STAFF_COUNT,
    RECEIVE_DEPARTMENT,
    RECEIVE_DRUG_SVO,
    RECEIVE_ORDER,
    RECEIVE_OPERATOR,
    RECEIVE_ORDER_COUNT,
    RECEIVE_APPLY_NO,
    RECEIVE_INCOME,
    RECEIVE_OUTCOME,
    RECEIVE_SALE,
    RECEIVE_STOCK,
    RECEIVE_INCOME_DETAIL,
    RECEIVE_OUTCOME_DETAIL,
    RECEIVE_STOCKS,
    RECEIVE_STOCK_COUNT,
    RECEIVE_ACCOUNTOTHER,
    RECEIVE_ACCOUNTOTHER_BYANY
} from './mutations_type'

import {
    reqDrugCategory,
    reqDrugSvo,
    reqStaffs,
    reqStaffsPage,
    reqDrugCount,
    reqStaffCount,
    reqStaffDepartment,
    reqDrugCondition,
    reqStaffCondition,
    reqOrdersCondition,
    reqOrderOperator,
    reqOrderCount,
    reqDrugs,
    reqApplyNo,
    reqIncome,
    reqOutcome,
    reqSale,
    reqStock,
    resIncomeDetail,
    reqOutComeDetail,
    reqStockList,
    reqStockCount,
    reqStockListAny,
    selectAllAccountOtherWithPage,
    queryAccountOtherByObject
} from '../api'

// {commit. state}
export default {
    // 获取收入
    async getIncome({ commit }){
        const result =await reqIncome()
        const code = result.data.code
        if(code === 200) {
            const income = result.data.data
            commit(RECEIVE_INCOME, {income})
        }
    },
    // 获取支出
    async getOutcome({ commit }){
        const result = await reqOutcome()
        const code = result.data.code
        if(code === 200) {
            const outcome = result.data.data
            commit(RECEIVE_OUTCOME, {outcome})
        }
    },
    // 获取销售量
    async getSale({ commit }){
        const result = await reqSale()
        const code = result.data.code
        if(code === 200) {
            const sale = result.data.data
            commit(RECEIVE_SALE, {sale})
        }
    },
    // 获取库存量
    async getStock({ commit }){
        const result = await reqStock()
        const code = result.data.code
        if(code === 200) {
            const stock = result.data.data
            commit(RECEIVE_STOCK, {stock})
        }
    },
    // 获取收入明细
    async getIncomeDetail({ commit }){
        const result =await resIncomeDetail()
        const code = result.data.code
        if(code === 200) {
            const incomeDetail = result.data.data
            commit(RECEIVE_INCOME_DETAIL, {incomeDetail})
        }
    },
    // 获取支出明细
    async getOutcomeDetail({ commit }){
        const result =await reqOutComeDetail()
        const code = result.data.code
        if(code === 200) {
            const outcomeDetail = result.data.data
            commit(RECEIVE_OUTCOME_DETAIL, {outcomeDetail})
        }
    },
    login({ commit }){
        commit(TOGGLE_LOGIN_LOGOUT, true)
    },
    logout({ commit }){
        commit(TOGGLE_LOGIN_LOGOUT, false)
    },
    async getDrugs({ commit }){
        const result = await reqDrugs()
        const code = result.data.code
        if(code === 200){
            const drugs = result.data.data
            commit(RECEIVE_DRUGS, {drugs})
        }
    },
    // 获取全部员工
    async getStaffs({ commit }){
        const result = await reqStaffs()
        const code = result.data.code
        if(code === 200){
            const staffs = result.data.data
            commit(RECEIVE_STAFFS, {staffs})
        }
    },
    // 获取药品所有类别
    async getDrugCategory({ commit }) {
        const result = await reqDrugCategory()
        console.log(result)
        const code = result.data.code
        if(code === 200){
            const drugCategory = result.data.data
            commit(RECEIVE_DRUG_CATEGORY, {drugCategory})
        }
    },
    // 获取药品数量
    async getDrugCount({ commit }, conditions){
        const result = await reqDrugCount(conditions)
        const code = result.data.code
        if(code === 200){
            const drugCount = result.data.data
            commit(RECEIVE_DRUG_COUNT, {drugCount})
        } 
    },
    // 获取药品库存警告等级列表
    async getDrugSvo({ commit }){
        const result = await reqDrugSvo()
        const code = result.data.code
        if(code === 200){
            const drugSvoList = result.data.data
            commit(RECEIVE_DRUG_SVO, {drugSvoList})
        } 
    },
    // 获取人员数量
    async getStaffCount({ commit }, condition){
        const result = await reqStaffCount(condition)
        const code = result.data.code
        if(code === 200){
            const staffCount = result.data.data
            commit(RECEIVE_STAFF_COUNT, {staffCount})
        } 
    },
    // 分页获取人员
    async getStaffsPage({ commit }, page){
        const result = await reqStaffsPage(page.pageNum, page.pageSize)
        const code = result.data.code
        if(code === 200){
            const staffs = result.data.data.list
            commit(RECEIVE_STAFFS, {staffs})
        }
    },
    // 获取所有部门信息
    async getDepartment({ commit }){
        const result = await reqStaffDepartment()
        const code = result.data.code
        if(code === 200){
            const department = result.data.data
            commit(RECEIVE_DEPARTMENT, {department})
        }
    },
    // 获取药品信息
    async getDrugByCondition({ commit }, conditions){
        const result = await reqDrugCondition(conditions.pageNum, conditions.pageSize, conditions.selectCondition)
        const code = result.data.code
        if(code === 200){
            const drugs = result.data.data.list
            commit(RECEIVE_DRUGS, {drugs})
        }
    },
    // 获取员工信息
    async getStaffByCondition({ commit }, conditions){
        const result = await reqStaffCondition(conditions.pageNum, conditions.pageSize, conditions.selectCondition)
        const code = result.data.code
        if(code === 200){
            const staffs = result.data.data.list
            commit(RECEIVE_STAFFS, {staffs})
        }
    },
    // 获取所有订单信息
    async getOrderByCondition({ commit }, conditions){
        const result = await reqOrdersCondition(conditions.pageNum, conditions.pageSize, conditions.selectCondition)
        const code = result.data.code
        if(code === 200){
            const orderList = result.data.data.list
            commit(RECEIVE_ORDER, {orderList})
        } 
    },
    // 获取所有订单操作员
    async getOrderOperator({ commit }){
        const result = await reqOrderOperator()
        const code = result.data.code
        if(code === 200){
            const operatorList = result.data.data
            commit(RECEIVE_OPERATOR, {operatorList})
        } 
    },
    // 获取订单数量
    async getOrderCount({ commit }, condition){
        const result = await reqOrderCount(condition)
        const code = result.data.code
        if(code === 200){
            const orderCount = result.data.data
            commit(RECEIVE_ORDER_COUNT, {orderCount})
        } 
    },
    // 获取未同意的补货申请
    async getApplyNo({ commit }){
        const result = await reqApplyNo()
        const code = result.data.code
        if(code === 200){
            const applyNoList = result.data.data
            commit(RECEIVE_APPLY_NO, {applyNoList})
        }
    },
    // 获取所有进货单
    async getStocks({ commit }, page){
        const result = await reqStockList(page.pageNum, page.pageSize)
        const code = result.data.code
        if(code === 200){
            const stockList = result.data.data.list
            console.log(stockList)
            commit(RECEIVE_STOCKS, {stockList})
        }
    },
    // 获取进货单数量
    async getStockCount({ commit },page){
        const result = await reqStockCount(page.stock_id,page.produce_firm)
        const code = result.data.code
        if(code === 200){
            const stockCount = result.data.data
            commit(RECEIVE_STOCK_COUNT, {stockCount})
        }
    },
    // 获取自定义进货单
    async getStocksAny({ commit }, page){
        const result = await reqStockListAny(page.pageNum, page.pageSize,page.stock_id,page.produce_firm)
        console.log(result)
        const code = result.data.code
        if(code === 200){
            const stockList = result.data.data.list
            commit(RECEIVE_STOCKS, {stockList})
            console.log(stockList);
        }
    },



    // 获取所有进货单
    async getAllAccountOtherWithPage({ commit }){
        const result = await selectAllAccountOtherWithPage()
        const code = result.data.code
        if(code === 200){
            const accountOtherList = result.data.data
            commit(RECEIVE_ACCOUNTOTHER, {accountOtherList})
        }
    },
    // 获取自定义进货单
    async getAccountOtherByObject({ commit }, page){
        const result = await queryAccountOtherByObject(page.accountOther)
        const code = result.data.code
        if(code === 200){
            const accountOtherList = result.data.data
            commit(RECEIVE_ACCOUNTOTHER_BYANY, {accountOtherList})
        }
    },


}