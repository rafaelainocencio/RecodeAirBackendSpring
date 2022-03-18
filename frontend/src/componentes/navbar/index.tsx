import { Link } from "react-router-dom";

function Navbar() {
    return (
        <header>
            <nav className="container navbar navbar-expand-lg navbar-light ">
                <Link className="nav-item nav-link" to="/">
                    RecodeAir
                </Link>
                <div className='opcoes'>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navegação">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div className="navbar-nav">

                            <Link className="nav-item nav-link" to="/destinos">
                                Destinos
                            </Link>

                            <Link className="nav-item nav-link" to="/contato">
                                Contato
                            </Link>
    
                            <Link className="nav-item nav-link" to="/crud">
                                CRUD
                            </Link>

                        </div>
                    </div>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;