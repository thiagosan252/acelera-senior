<script setup lang="ts">
import type { Pessoa } from '@/model/Pessoa';
import router from '@/router';
import { PessoaService } from '@/service/pessoa.service';
import { onMounted, reactive } from 'vue';

const obj: Pessoa = reactive({
  id: '',
  nome: '',
  idade: '',
  profissao: '',
})

const loadData = async (id: string) => {
  try {
    const resp = await PessoaService.getById(id)
    obj.idade = resp.data.idade || ''
    obj.nome = resp.data.nome || ''
    obj.profissao = resp.data.profissao || ''
  } catch (error) {

  }
}

const editar = async () => {
  try {
    console.log(obj)
    await PessoaService.save(obj)
    router.push('/')
  } catch (error) {

  }
}

onMounted(() => {
  obj.id = router.currentRoute.value.params.id as string
  loadData(obj.id)
})

</script>

<template>
  <h3>Editar{{ }}</h3>

  <b-form-input v-model="obj.nome" placeholder="Nome"></b-form-input>
  <b-form-input v-model="obj.idade" placeholder="Idade"></b-form-input>
  <b-form-input v-model="obj.profissao" placeholder="Profissao"></b-form-input>

  <b-button variant="outline-primary" @click="editar">Editar</b-button>

</template>