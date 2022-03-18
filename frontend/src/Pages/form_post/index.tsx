import React, {useState} from "react";
import { Link, useParams } from "react-router-dom";

import axios, { AxiosRequestConfig } from "axios";
import { Destino } from "componentes/types/destino";
import { BASE_URL } from "Utils/requests";


type Props = {
    destino : Destino;
}

function FormPost() {
    
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        
        event.preventDefault();

        const nome = (event.target as any).nome.value;
        const descricao = (event.target as any).descricao.value;
        const imagem = (event.target as any).imagem.value;
        const preco = (event.target as any).preco.value;

        window.location.reload()
        
        

        const config: AxiosRequestConfig = {
            baseURL: "https://recodeair.netlify.app/",
            method: 'POST',
            url: '/destinos',
            data:{
                nome: nome,
                descricao: descricao,
                imagem: imagem,
                preco: preco
            }
        }    

        axios(config).then(response => {
            alert("O destino: " + nome + " foi adicionado com sucesso.");
            
        });
    }
    

    return (
        <div className="card container mt-5">
            <div className="card-header">
                Cadastrar Destino
            </div>
            <div className="card-body">
                 <form className="adicionar-form-container" onSubmit={handleSubmit} >
                    <div className="form-group recodeair-form-group">
                        <label htmlFor="formGroupExampleInput">Nome do destino</label>
                        <input type="destino" className="form-control" id="nome" 
              
                        />
                    </div>
                    <div className="form-group recodeair-form-group">
                        <label htmlFor="description">Descrição</label>
                        <input type="descricao" className="form-control" id="descricao" 
                      
                        />
                    </div>
                    <div className="form-group recodeair-form-group">
                        <label htmlFor="image">URL da imagem</label>
                        <input type="imagem" className="form-control" id="imagem" 
           
                        />
                    </div>
                    <div className="form-group recodeair-form-group">
                        <label htmlFor="price">Preço</label>
                        <input type="preco" className="form-control" id="preco" 
         
                        />
                    </div>
                    <button type="submit"  className="btn btn-primary m-5">Salvar</button>
                </form>
                <Link to="/destinos"><button type="button" className="btn btn-primary">Cancelar</button></Link>
                
            </div>
        </div>)
}

export default FormPost;

