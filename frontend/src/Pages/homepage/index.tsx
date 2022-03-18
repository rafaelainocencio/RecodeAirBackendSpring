import Lorem from "componentes/lorem";
import Promocoes from "componentes/promocoes";
import RecebaOfertas from "componentes/RecebaOfertas";
import './style.css'

function Homepage() {
    return (
        <div>
            <div className="container banner">
                <RecebaOfertas></RecebaOfertas>
                <Lorem></Lorem>
            </div>
            <h3 className="mt-5">Confira nossas promoções:</h3>
            <Promocoes></Promocoes>
        </div>
    );
}

export default Homepage;