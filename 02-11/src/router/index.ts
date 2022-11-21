import EditarPessoaVue from '@/components/EditarPessoa.vue'
import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/editar/:id',
      name: 'editar',
      component: EditarPessoaVue
    },
  ]
})

export default router
