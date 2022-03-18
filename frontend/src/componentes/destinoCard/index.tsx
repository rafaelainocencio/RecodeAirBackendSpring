import { Destino } from "componentes/types/destino";

type Props = {
    destino: Destino;
}

function DestinoCard({destino}:  Props) { 
    return ( 
        <div className="card destinos-card m-5 col-sm-6 col-lg-4 col-xl-3">
            <img className="card-img-top" src={destino.imagem} alt="Imagem de capa do card" />
            <div className="card-body">
                <h3 className="card-title">{destino.nome}</h3>
                <p className="card-text">{destino.descricao}</p>
                <h4>R${destino.preco}</h4>
                <button className="btn btn-primary">Comprar</button>
            </div>
        </div>
    );
}

export default DestinoCard;