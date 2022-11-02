<script setup lang="ts">
import { reactive, onMounted } from 'vue'
import type { Pessoa } from "@/model/Pessoa";
import { PessoaService } from '@/service/pessoa.service'

interface ListarPessoas {
    pessoas: Pessoa[]
    fields: { key: string, label: string }[]
}

const obj: ListarPessoas = reactive({
    pessoas: [],
    fields: [
        { key: 'id', label: 'ID' },
        { key: 'nome', label: 'Nome' },
        { key: 'idade', label: 'Idade' },
        { key: 'profissao', label: 'Profissão' }
    ]
})

const getPessoas = async () => {
    const resp = await PessoaService.getAll()
    obj.pessoas = resp.data
}

onMounted(() => {
    getPessoas()
})
</script>

<template>
    <b-table striped hover :items="obj.pessoas" :fields="obj.fields"></b-table>
</template>
