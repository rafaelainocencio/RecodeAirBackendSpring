import './style.css'

function Contato(){
    return(
        <div className="container-contatos">
                <h3 id="titContato" >Contato</h3>
                <p>11 1234 5678</p>
                <p>Segunda à Sexta: 09h às 20h</p>
                <p className="mb-5">Sábado e feriados: 09h às 18h</p>

                <p>11 9876 5432</p>
                <p>Segunda à Sexta: 09h às 20h</p>
                <p>Sábado e feriados: 09h às 16h</p>
            </div>
    );
}
export default Contato;