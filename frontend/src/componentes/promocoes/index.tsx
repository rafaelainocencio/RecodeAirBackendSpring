import listaDePromocoes from "Assets/listaDePromocoes"
import './style.css'

export default function Promocoes() {
    const cards = listaDePromocoes.map((card) => {
        return (

            <div key={card.id} className="card destinos-card m-5 col-sm-6 col-lg-4 col-xl-3 m-5">
                <img className="card-img-top" src={card.imagem} alt="Imagem de capa do card" />
                <div className="card-body">
                    <h2 className="card-title">{card.cidade}</h2>
                    <p className="card-text">{card.descricao}</p>
                    <h4>{card.preco}</h4>
                    <button className="btn btn-primary">Comprar</button>
                </div>
            </div>
        )
    })

    return (
        <div className="container prom">
            <div className="promocoes-container">
                {cards}
            </div>
            <div className="container">
                <h2 > Lorem Ipsum</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus molestias et esse quidem cum, sint quaerat harum tempora inventore debitis! Explicabo illum optio molestiae, libero beatae perferendis accusantium quisquam aliquam?</p>
                
                <h2 className="mt-5"> Lorem Ipsum</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus molestias et esse quidem cum, sint quaerat harum tempora inventore debitis! Explicabo illum optio molestiae, libero beatae perferendis accusantium quisquam aliquam?</p>

                <h2 className="mt-5"> Lorem Ipsum</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus molestias et esse quidem cum, sint quaerat harum tempora inventore debitis! Explicabo illum optio molestiae, libero beatae perferendis accusantium quisquam aliquam?</p>

            </div>
        </div>
    )
}