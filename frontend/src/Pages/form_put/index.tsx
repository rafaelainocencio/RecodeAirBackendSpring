import {  useParams } from "react-router-dom";
import FormCardPut from "componentes/FormPutCard";




function FormPut() {

    const params = useParams();

    return (
        <div>
            <h1>Atualizar dados</h1>
            <FormCardPut id={`${params.id}`} />
        </div>)
}

export default FormPut;