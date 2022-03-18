
import axios from "axios";
import { Destino } from "componentes/types/destino";
import { FiEdit, FiTrash2 } from "react-icons/fi";
import { Link } from "react-router-dom";



type Props = {
    destino: Destino;
    id: number
}

function deleteDestino(id: number) {
        console.log(id)
        axios.delete(`https://recodeair.netlify.app//destinos/${id}`)
        window.location.reload()
}

export default function CRUDCard ({destino}:  Props) {

    const rota = `/crud/update/${destino.id}`

    return (
        <div className="card destinos-card m-5 col-sm-6 col-lg-4 col-xl-3">
            <img className="card-img-top" src={destino.imagem} alt="Imagem de capa do card" />
            <div className="card-body">
                <h3 className="card-title">{destino.nome}</h3>
                <p className="card-text">{destino.descricao}</p>
                <h4>R${destino.preco}</h4>
                <button className="btn btn-primary m-1" >
                    <Link to={rota}><FiEdit size={20} color="white" /></Link>
                </button>
                <button 
                    onClick={() => deleteDestino(destino.id)}
                    className="btn btn-primary m-1" >
                    <FiTrash2  size={20} color="white"  />
                </button>
            </div>
        </div>
    )
}


