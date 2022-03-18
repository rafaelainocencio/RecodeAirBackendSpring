import axios from "axios";
import DestinoCard from "componentes/destinoCard";
import Pagination from "componentes/pagination";
import { DestinoPage } from "componentes/types/destino";
import { useEffect, useState } from "react";
import { BASE_URL } from "Utils/requests";
import "../../index.css";

function Destinos() {


    const [pageNumber, setPageNumber] = useState(0);
    const [page, setPage] = useState<DestinoPage>({

        "content": [],
        "last": true,
        "totalElements": 0,
        "totalPages": 0,
        "size": 2,
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
            <div className="container desContainer">

                <div className="container destino-contanainer row">
                    {page.content.map(destino => (

                        <DestinoCard key={destino.id} destino={destino} />
                    ))}
                </div>

            </div>
            <div className="container pagination-container">
                <Pagination page={page} onChange={handlePageChange} />
            </div>
        </div>
    );
}

export default Destinos;