// 修改状态信息

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

export default {
    [RECEIVE_DRUGS](state, {drugs}) {
        state.drugList =  drugs
    },
    [RECEIVE_STAFFS](state, {staffs}) {
        state.staffList = staffs
    },
    [RECEIVE_DRUG_COUNT](state, {drugCount}) {
        state.drugCount = drugCount
    },
    [RECEIVE_STAFF_COUNT](state, {staffCount}) {
        state.staffCount = staffCount
    },
    [RECEIVE_DRUG_CATEGORY](state, {drugCategory}) {
        state.drugCategory = drugCategory
    },
    [RECEIVE_DEPARTMENT](state, {department}) {
        state.staffDepartment = department
    },
    [RECEIVE_DRUG_SVO](state, {drugSvoList}) {
        state.drugSvoList = drugSvoList
    },
    [RECEIVE_ORDER](state, {orderList}){
        state.orderList = orderList
    },
    [RECEIVE_OPERATOR](state, {operatorList}){
        state.operatorList = operatorList
    },
    [RECEIVE_ORDER_COUNT](state, {orderCount}){
        state.orderCount = orderCount
    },
    [RECEIVE_APPLY_NO](state, {applyNoList}){
        state.applyNoList = applyNoList
    },
    [TOGGLE_LOGIN_LOGOUT](state, {logState}){
        state.isLogin = logState
    },
    [RECEIVE_INCOME](state, {income}){
        state.income = income
    },
    [RECEIVE_OUTCOME](state, {outcome}){
        state.outcome = outcome
    },
    [RECEIVE_SALE](state, {sale}){
        state.sale = sale
    },
    [RECEIVE_STOCK](state, {stock}){
        state.stock = stock
    },
    [RECEIVE_INCOME_DETAIL](state, {incomeDetail}){
        state.incomeDetail = incomeDetail
    },
    [RECEIVE_OUTCOME_DETAIL](state, {outcomeDetail}){
        state.outcomeDetail = outcomeDetail
    },
    [RECEIVE_STOCKS](state, {stockList}){
        state.stockList = stockList
    },
    [RECEIVE_STOCK_COUNT](state, {stockCount}){
        state.stockCount = stockCount
    },
    [RECEIVE_ACCOUNTOTHER](state, {accountOtherList}){
        state.accountOtherList = accountOtherList
    },
    [RECEIVE_ACCOUNTOTHER_BYANY](state, {accountOtherList}){
        state.accountOtherList = accountOtherList
    }
}