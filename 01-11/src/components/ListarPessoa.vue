<script setup lang="ts">
import type { Pessoa } from "@/model/Pessoa";
import router from '@/router';
import { PessoaService } from '@/service/pessoa.service';
import { AxiosError } from 'axios';
import { onMounted, reactive } from 'vue';

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
        { key: 'profissao', label: 'Profissão' },
        { key: 'options', label: 'Opções' }
    ]
})

const getPessoas = async () => {
    const resp = await PessoaService.getAll()
    obj.pessoas = resp.data
}

const alterar = async (id: number) => {
    console.log("alterar", id)
    router.push('/editar/' + id)
}

const deletar = async (id: number) => {
    try {
        await PessoaService.del(id)
        getPessoas()
    } catch (error) {
        if (error instanceof AxiosError)
            console.log(error.response)
    }
}


onMounted(() => {
    getPessoas()
})
</script>

<template>
    <div>
        <b-table striped hover responsive="sm" :items="obj.pessoas" :fields="obj.fields" show-empty>
            <template #cell(options)="row">
                <b-button-group>
                    <b-button size="sm" @click="alterar(row.item.id)" variant="primary">
                        ALTERAR
                    </b-button>
                    <b-button size="sm" @click="deletar(row.item.id)" variant="danger">
                        DELETAR
                    </b-button>
                </b-button-group>
            </template>
            <template #empty="scope">
                <h4 style="text-align: center;">Nenhum item encontrado</h4>
            </template>
        </b-table>
    </div>
</template>
