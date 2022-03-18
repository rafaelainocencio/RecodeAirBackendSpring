export type Assinante = {
    "id": number;
    "nome": string;
    "email": string;
}

export type AssinantePage = {
    "content": Assinante[];
    "last": boolean;
    "totalElements": number;
    "totalPages": number,
    "size": number;
    "number": number;
    "first": boolean;
    "numberOfElements": number;
    "empty": boolean;
}