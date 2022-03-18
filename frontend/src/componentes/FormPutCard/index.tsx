import axios, { AxiosRequestConfig } from "axios";
import { Destino } from "componentes/types/destino";
import { useEffect } from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { BASE_URL } from "Utils/requests";
 

type Props = {
    id: string
}


function FormCardPut({id}: Props){

    const navigate = useNavigate();

    const[destino, setDestino] = useState<Destino>();

    useEffect(() => {
        axios.get(`${BASE_URL}/destinos/${id}`)
        .then(response =>
            setDestino(response.data)
            )
    }, [id])

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();


        var nomeAntigo = destino?.nome
        var descricaoAntiga = destino?.descricao
        var imagemAntiga = destino?.imagem
        var precoAntigo = destino?.preco



        var nome = (event.target as any).nome.value
        var descricao = (event.target as any).descricao.value;
        var imagem = (event.target as any).imagem.value;
        var preco = (event.target as any).preco.value;
        
        nome = (nome == "" ? nome = nomeAntigo : nome = nome)
        descricao = (descricao == "" ? descricao = descricaoAntiga : descricao = descricao)
        imagem = (imagem == "" ? imagem = imagemAntiga : imagem = imagem)
        preco = (preco == "" ? preco = precoAntigo : preco = preco)
        


        window.location.reload()
        

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: 'PUT',
            url: `/destinos/${id}`,
            data:{
                nome: nome,
                descricao: descricao,
                imagem: imagem,
                preco: preco
            }
        }

        axios(config).then(response => {
            console.log(response.data)
        })

    }

    return(
        <div className="card container mt-5">
            <div className="card-header">
                Atualizar
            </div>
            <h1>{destino?.id}</h1>
            <div className="card-body">
                 <form className="adicionar-form-container" onSubmit={handleSubmit} >
                    <div className="form-group recodeair-form-group">
                        <label htmlFor="formGroupExampleInput"></label>
                        <input type="destino" placeholder={destino?.nome} className="form-control" id="nome"
                        />
                    </div>
                    <div className="form-group recodeair-form-group">
                        <label htmlFor="description">Descrição</label>
                        <input type="descricao" placeholder={destino?.descricao} className="form-control" id="descricao"

                        />
                    </div>
                    <div className="form-group recodeair-form-group">
                        <label htmlFor="image">URL da imagem</label>
                        <input type="imagem" placeholder={destino?.imagem}   className="form-control" id="imagem"

                        />
                    </div>
                    <div className="form-group recodeair-form-group">
                        <label htmlFor="price">Preço</label>
                        <input type="preco" placeholder={destino?.preco}  className="form-control" id="preco"

                        />
                    </div>
                    <button type="submit"  className="btn btn-primary m-5">Salvar</button>
                </form>
                <Link to="/crud"><button type="button" className="btn btn-primary">Cancelar</button></Link>

            </div>
        </div>
    )
}

export default FormCardPut;