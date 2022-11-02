<script setup lang="ts">
import AddPessoa from '../components/AddPessoa.vue'
import ListarPessoa from '../components/ListarPessoa.vue'
</script>

<template>
  <main>
    <b-container fluid>
      <h1>Cadastro de Pessoas</h1>

      <ListarPessoa />
      <AddPessoa />
    </b-container>
  </main>
</template>
