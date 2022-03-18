import { type } from "os"



export type Destino =  {
    "id": number;
    "nome": string;
    "descricao": string;
    "imagem": string;
    "preco": string;
}

export type DestinoPage = {
    "content": Destino[];
    "last": boolean;
    "totalElements": number;
    "totalPages": number,
    "size": number;
    "number": number;
    "first": boolean;
    "numberOfElements": number;
    "empty": boolean;
}





