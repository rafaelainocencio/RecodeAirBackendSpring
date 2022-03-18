import { Destino, DestinoPage } from "componentes/types/destino";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi"

type Props = {
    page: DestinoPage
    onChange: Function;
}

function Pagination({page, onChange}: Props){
    return(
        <div className="pagination">
            <button className="btn btn-primary" disabled={page.first} 
            onClick={() => onChange(page.number - 1)}><FiArrowLeft /></button>
            <h1>{`${page.number + 1} de ${page.totalPages}`}</h1>
            <button className="btn btn-primary" disabled={page.last} onClick={() => onChange(page.number + 1)}><FiArrowRight/></button>
        </div>
    );
}

export default Pagination;