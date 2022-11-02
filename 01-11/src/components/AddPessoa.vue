<script setup lang="ts">
import { PessoaService } from '@/service/pessoa.service'
import { reactive } from 'vue';

interface AddPessoas {
  nome: string,
  idade: string,
  profissao: string,
}

const obj: AddPessoas = reactive({
  nome: '',
  idade: '',
  profissao: '',
})

const addPessoa = async () => {
  const resp = await PessoaService.save({
    nome: obj.nome,
    idade: obj.idade,
    profissao: obj.profissao
  })
  location.reload()
}

</script>

<template>
  <h3>Adicionar</h3>

  <b-form-input v-model="obj.nome" placeholder="Nome"></b-form-input>
  <b-form-input v-model="obj.idade" placeholder="Idade"></b-form-input>
  <b-form-input v-model="obj.profissao" placeholder="Profissao"></b-form-input>

  <b-button variant="outline-primary" @click="addPessoa">Cadastrar</b-button>

</template>