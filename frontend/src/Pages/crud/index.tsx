import axios from "axios";
import CRUDCard from "componentes/CRUDCard";
import Pagination from "componentes/pagination";
import { Destino, DestinoPage } from "componentes/types/destino";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { BASE_URL } from "Utils/requests";
import "../../index.css";

function DestinosCrud() {




    const [pageNumber, setPageNumber] = useState(0);
    const [page, setPage] = useState<DestinoPage>({

        "content": [],
        "last": true,
        "totalElements": 0,
        "totalPages": 0,
        "size": 50,
        "number": 0,
        "first": true,
        "numberOfElements": 0,
        "empty": true

    });

    useEffect(() => {
        axios.get(`${BASE_URL}/destinos?size=6&page=${pageNumber}`)
            .then(response => {
                const data = response.data as DestinoPage;
                setPage(data)
            })
    }, [pageNumber])

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber)
    }



    return (
        <div >
            <h1>CRUD</h1>
            <Link className="btn btn-primary" to="/crud/post">Adicionar destino</Link>
            <div className="container desContainer">

                <div className="container destino-contanainer row">
                    {page.content.map(destino => (
                        <CRUDCard key={destino.id} destino={destino} id={destino.id} />
                    ))}
                </div>

            </div>
            <div className="container pagination-container">
                <Pagination page={page} onChange={handlePageChange} />
            </div>
        </div>
    );
}

export default DestinosCrud;