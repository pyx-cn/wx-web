import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import Index from '../views/Index.vue'
import Appointment from '../views/Appointment.vue'
import Hospital from '../views/Hospital.vue'
import Setmeal from '../views/Setmeal.vue'
import Selectdate from '@/views/Selectdate.vue'
import Confirmorder from '@/views/Confirmorder.vue'
import Appointmentsuccess from '@/views/Appointmentsuccess.vue'
import Appointmentlist from '@/views/Appointmentlist.vue'
import Appointmentcancel from '@/views/Appointmentcancel.vue'
import Personal from '@/views/Personal.vue'
import Report from '@/views/Report.vue'
import ReportList from '@/views/ReportList.vue'
import Test from '@/views/Test.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/index',
      name: 'index',
      component: Index
    },
    {
      path: '/appointment',
      name: 'appointment',
      component: Appointment
    },
    {
      path: '/hospital',
      name: 'hospital',
      component: Hospital
    },
    {
      path: '/setmeal',
      name: 'setmeal',
      component: Setmeal
    },
    {
      path: '/selectdate',
      name: 'selectdate',
      component: Selectdate
    },
    {
      path: '/confirmorder',
      name: 'confirmorder',
      component: Confirmorder
    },
    {
      path: '/appointmentsuccess',
      name: 'appointmentsuccess',
      component: Appointmentsuccess
    },
    {
      path: '/appointmentlist',
      name: 'appointmentlist',
      component: Appointmentlist
    },
    {
      path: '/appointmentcancel',
      name: 'appointmentcancel',
      component: Appointmentcancel
    },
    {
      path: '/personal',
      name: 'personal',
      component: Personal
    },
    {
      path: '/test',
      name: 'test',
      component: Test
    },
    {
      path: '/report',
      name: 'report',
      component: Report
    },
    {
      path: '/reportList',
      name: 'reportList',
      component: ReportList
    }
  ]
})

export default router
