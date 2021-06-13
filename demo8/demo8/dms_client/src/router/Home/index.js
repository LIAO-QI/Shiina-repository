export default {
    path: '/home',
    name: 'home',
    component: () => import('@/views/Home'),
    children: [
      {
        path: 'index',
        name: 'index',
        component: () => import('@/components/HomeIndex'),
      },
      {
        path: 'drugTable',
        name: 'drugTable',
        component: () => import('@/components/DrugTable'),
      },
      {
        path: 'drugForm',
        name: 'drugForm',
        component: () => import('@/components/DrugForm'),
      },
      {
        path: 'staffTable',
        name: 'staffTable',
        component: () => import('@/components/StaffTable'),
      },
      {
        path: 'staffForm',
        name: 'staffForm',
        component: () => import('@/components/StaffForm'),
      },
      {
        path: 'departmentTable',
        name: 'departmentTable',
        component: () => import('@/components/DepartmentTable'),
      },
      {
        path: 'categoryTable',
        name: 'categoryTable',
        component: () => import('@/components/CategoryTable'),
      },
      {
        path: 'orderTable',
        name: 'orderTable',
        component: () => import('@/components/OrderTable'),
      },
      {
        path: 'orderForm',
        name: 'orderForm',
        component: () => import('@/components/OrderForm'),
      },
      {
        path: 'applyTable',
        name: 'applyTable',
        component: () => import('@/components/ApplyTable'),
      },
      {
        path: 'applyForm',
        name: 'applyForm',
        component: () => import('@/components/ApplyForm'),
      },
      {
        path: 'incomeTable',
        name: 'incomeTable',
        component: () => import('@/components/IncomeTable'),
      },
      {
        path: 'outcomeTable',
        name: 'outcomeTable',
        component: () => import('@/components/OutcomeTable'),
      },
      {
        path: 'othercomeTable',
        name: 'othercomeTable',
        component: () => import('@/components/OthercomeTable'),
      },
      {
        path: 'stockTable',
        name: 'stockTable',
        component: () => import('@/components/StockTable'),
      },
      {
        path: 'stockForm',
        name: 'stockForm',
        component: () => import('@/components/StockForm'),
      },
      {
        path: 'insertother',
        name: 'insertother',
        component: () => import('@/components/InsertOther'),
      },
    ],
    meta: {
      isLogin: true
    }
  }