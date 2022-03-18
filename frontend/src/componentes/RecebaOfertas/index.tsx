import axios, { AxiosRequestConfig } from "axios";
import { Assinante } from "componentes/types/assinante";
import { BASE_URL } from "Utils/requests";

type Props = {
    assinante : Assinante;
}

export default function RecebaOfertas() {

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {

        event.preventDefault();

        const nome = (event.target as any).nome.value;
        const email = (event.target as any).email.value;

        window.location.reload()


        const config: AxiosRequestConfig = {
            baseURL: "https://recodeair.netlify.app",
            method: 'POST',
            url: '/assinantes',
            data: {
                nome: nome,
                email: email
            }
        }

        axios(config).then(response => {
            alert("O destino: " + nome + " foi adicionado com sucesso.");
            console.log("funcionando normal aqui")
        });
    }

    return (
        <div className="cardForm janela">
            <h1>Assine e receba as ofertas da RecodeAir!</h1>
            <form className="adicionar-form-container" onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="formGroupExampleInput">Digite seu nome:</label>
                    <input type="text" className="form-control" id="nome" placeholder="Ex: João Silva" />
                </div>
                <div className="form-group">
                    <label htmlFor="formGroupExampleInput2">Digite seu email:</label>
                    <input type="text" className="form-control" id="email" placeholder="Ex: jaosilva@gmail.com" />
                </div>
                <button type="submit" className="btn btn-primary">Assinar</button>
            </form>
        </div>
    )
}

function assinar() {
    alert("Assinado com sucesso!")
}