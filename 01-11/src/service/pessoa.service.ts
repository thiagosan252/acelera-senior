import type { Pessoa } from "@/model/Pessoa";
import type { AxiosResponse } from "axios";
import api from "./api.service";

export class PessoaService {

    static getAll(): Promise<AxiosResponse<Pessoa[], any>> {
        return api.get('/pessoas');
    }

    static save(data: Pessoa): Promise<AxiosResponse<Pessoa, any>> {
        return api.post('/pessoas', data);
    }
}