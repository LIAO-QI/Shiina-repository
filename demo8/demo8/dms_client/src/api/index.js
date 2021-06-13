import ajax from './ajax'
const BASE_URL = '/api'

/* 
 
    ****************登录模块****************
 
*/

// 请求登录
export const reqLogin = (admin) => ajax(`${BASE_URL}/login/login`, admin)
// 请求登出
export const reqLogout = () => ajax(`${BASE_URL}/login/logout`)



/* 
 
    ****************主页模块****************
 
*/

// 请求收入
export const reqIncome = () => ajax(`${BASE_URL}/accountEntry/getAllEntryMoney`)
// 请求支出
export const reqOutcome = () => ajax(`${BASE_URL}/accountOut/getAllOutMoney`)
// 请求销售量
export const reqSale = () => ajax(`${BASE_URL}/statistic/selectTotalSaleNum`)
// 请求库存
export const reqStock = () => ajax(`${BASE_URL}/statistic/selectTotalInventory`)
// 请求收入明细
export const resIncomeDetail = () => ajax(`${BASE_URL}/accountEntry/selectAllAcc`)
// 请求支出明细
export const reqOutComeDetail = () => ajax(`${BASE_URL}/accountOut/selectAllOut`)



/* 
 
    ****************药品管理模块****************
 
*/

// 请求所有药品
export const reqDrugs = () => ajax(`${BASE_URL}/drug/drugSelectAll`)
// 请求药品数量
export const reqDrugCount = (condition) => ajax(`${BASE_URL}/drug/drugCountAny`, condition)
// 请求删除药品
export const reqDrugDelete = (d_id) => ajax(`${BASE_URL}/drug/drugDeleteById`, {
    d_id
})
// 请求添加药品
export const reqDrugSave = (drug) => ajax(`${BASE_URL}/drug/insertDrugById`, drug)
// 请求某个 id 的药品
export const reqDrugById = (d_id) => ajax(`${BASE_URL}/drug/drugSelectAllById`, {
    d_id
})
// 请求所有药品库存警告等级
export const reqDrugSvo = () => ajax(`${BASE_URL}/svo/selectSvoLevelAll`)
// 请求修改药品
export const reqDrugUpdate = (drug) => ajax(`${BASE_URL}/drug/upDateById`, drug)
// 条件查询药品
export const reqDrugCondition = (pageNum, pageSize, condition) => ajax(`${BASE_URL}/drug/drugSelectByAnyPage`, {
    ...condition,
    pageNum,
    pageSize
})

// 请求所有药品类别
export const reqDrugCategory = () => ajax(`${BASE_URL}/drugCategory/selectDrugCategory`)
// 请求添加药品类别
export const reqCategorySave = (category) => ajax(`${BASE_URL}/drugCategory/insertDrugCategory`, category)
// 请求删除分类
export const reqCategoryDelete = (c_id) =>  ajax(`${BASE_URL}/drugCategory/deleteDrugCategory`, {
    c_id
})
// 请求根据id查询类别
export const reqCategoryById = (c_id) => ajax(`${BASE_URL}/drugCategory/selectDrugCategoryById`, {
    c_id
})
// 请求修改类别信息
export const reqCategoryUpdate = (category) => ajax(`${BASE_URL}/drugCategory/updateDrugCategory`, category)



/* 
 
    ****************人员管理模块****************
 
*/

// 请求所有人员
export const reqStaffs = () => ajax(`${BASE_URL}/staff/selectAllStaff`)
// 请求人员数量
export const reqStaffCount = (condition) => ajax(`${BASE_URL}/staff/selectStaffNumProperties`, condition)
// 请求分页人员
export const reqStaffsPage = (pageNum, pageSize) => ajax(`${BASE_URL}/staff/selectAllByPage`, {
    pageNum,
    pageSize
}, 'GET')
// 请求删除人员
export const reqStaffDelete = (s_id) => ajax(`${BASE_URL}/staff/deleteStaffById`, {
    s_id
}, 'GET')
// 条件查询员工
export const reqStaffCondition = (pageNum, pageSize, condition) => ajax(`${BASE_URL}/staff/selectAllByPageProperties`, {
    ...condition,
    pageNum,
    pageSize
})
// 请求某个id的员工
export const reqStaffById = (s_id) => ajax(`${BASE_URL}/staff/selectStaffById`, {
    s_id
}, 'GET')
// 请求添加员工
export const reqStaffSave = (staff) => ajax(`${BASE_URL}/staff/insertStaff`, staff)
// 请求修改员工信息
export const reqStaffUpdate = (staff) => ajax(`${BASE_URL}/staff/updateStaffAll`, staff)

// 请求所有部门
export const reqStaffDepartment = () => ajax(`${BASE_URL}/department/selectAllDepartment`)
// 请求添加部门
export const reqDepartmentSave = (department) => ajax(`${BASE_URL}/department/insertDepartment`, department)
// 请求删除部门
export const reqDepartmentDelete = (de_id) => ajax(`${BASE_URL}/department/deleteDepartmentById`, {
    de_id
})
// 请求修改部门
export const reqDepartmentUpdate = (department) => ajax(`${BASE_URL}/department/updateDepartmentById`, department)
// 请求根据 id 查询部门
export const reqDepartmentById = (de_id) => ajax(`${BASE_URL}/department/selectDepartmentByid`, {
    de_id
})



/* 
 
    ****************订单管理模块****************
 
*/

// 请求所有订单
export const reqOrdersCondition = (pageNum, pageSize, condition) => ajax(`${BASE_URL}/order/selectAllByPageProperties`, {
    ...condition,
    pageNum,
    pageSize
})
// 请求所有订单操作员
export const reqOrderOperator = () => ajax(`${BASE_URL}/order/selectAllSid`)
// 请求符合条件的订单数量
export const reqOrderCount = (condition) => ajax(`${BASE_URL}/order/selectOrderNumProperties`, condition)
// 根据 id 查看订单信息
export const reqOrderById = (so_id) => ajax(`${BASE_URL}/order/selectOrderById`, {
    so_id
})
// 根据 id 删除订单
export const reqOrderDelete = (so_id) => ajax(`${BASE_URL}/order/deleteOrder`, {
    so_id
})
// 添加订单信息
export const reqOrderSave = (order) => ajax(`${BASE_URL}/order/insertOrder`, order, 'POST')



/* 
 
    ****************库存管理模块****************
 
*/

// 请求所有未通过的补货申请
export const reqApplyNo = () => ajax(`${BASE_URL}/purApply/selectNoApply`)
// 根据id查看补货申请信息
export const reqApplyById = (ra_id) => ajax(`${BASE_URL}/purApply/selectPurApplyById`, {
    ra_id
})
// 根据id请求删除补货申请订单
export const reqApplyDelete = (ra_id) => ajax(`${BASE_URL}/purApply/deletePurApplyById`, {
    ra_id
})
// 根据id修改补货申请订单状态
export const reqApplyUpdate = (ra_id) => ajax(`${BASE_URL}/purApply/UpdatePurApplyById`, {
    ra_id
})
// 添加补货申请订单
export const insertApply = (apply) => ajax(`${BASE_URL}/purApply/insertPurApply`, apply, 'POST')

// 请求所有进货单
export const reqStockList = (pageNum, pageSize) => ajax(`${BASE_URL}/stock/selectAllByPageProperties`, {
    pageNum,
    pageSize
})
// 请求进货单数量
export const reqStockCount = (stock_id, produce_firm) => ajax(`${BASE_URL}/stock/selectStockNum`, {
    stock_id,
    produce_firm
})
// 请求自定义进货单
export const reqStockListAny = (pageNum, pageSize, stock_id, produce_firm) => ajax(`${BASE_URL}/stock/selectStockByAny`, {
    pageNum,
    pageSize,
    stock_id,
    produce_firm
})
// 根据id删除进货订单
export const deleteStockById = (po_id) => ajax(`${BASE_URL}/stock/deleteStockById`, {
    po_id
})
// 添加进货订单信息
export const insertStock = (stock) => ajax(`${BASE_URL}/stock/insertStock`, stock)



/* 
 
    ****************财务管理模块（与订单模块/库存模块有关联）****************
 
*/

export const selectAllAccountOtherWithPage = () => ajax(`${BASE_URL}/AccountOtherController/selectAllAccountOtherWithPage`, {
})
export const queryAccountOtherByObject = (accountOther) => ajax(`${BASE_URL}/AccountOtherController/queryAccountOtherByObject`, {
    ...accountOther
},'POST')
export const insertAccountOther = (accountOther) => ajax(`${BASE_URL}/AccountOtherController/insertAccountOther`, {...accountOther},'POST')
export const deleteAccountOther = (aoId) => ajax(`${BASE_URL}/AccountOtherController/deleteAccountOther`, {
    aoId
})