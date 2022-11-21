<script setup lang="ts">
import type { Pessoa } from '@/model/Pessoa';
import { PessoaService } from '@/service/pessoa.service';
import { reactive } from 'vue';

const obj: Pessoa = reactive({
  nome: '',
  idade: '',
  profissao: '',
})

const addPessoa = async () => {
  try {
    await PessoaService.save({
      nome: obj.nome,
      idade: obj.idade,
      profissao: obj.profissao
    })
    location.reload()
  } catch (error) {

  }
}

</script>

<template>
  <h3>Adicionar</h3>

  <b-form-input v-model="obj.nome" placeholder="Nome"></b-form-input>
  <b-form-input v-model="obj.idade" placeholder="Idade"></b-form-input>
  <b-form-input v-model="obj.profissao" placeholder="Profissao"></b-form-input>

  <b-button variant="outline-primary" @click="addPessoa">Cadastrar</b-button>

</template>