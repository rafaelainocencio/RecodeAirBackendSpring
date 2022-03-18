import Navbar from './componentes/navbar/index';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Homepage from 'Pages/homepage';
import Crud from 'Pages/crud';
import Destinos from 'Pages/destinos';
import Contato from 'Pages/contato';
import Footer from 'componentes/footer';
import './index.css';
import Form from 'Pages/form_post';

import FormPut from 'Pages/form_put';



function App() {
  return (
    <div className="main">
      <BrowserRouter>
      <Navbar />
      <main className='principal container'>
        <Routes>
          <Route path='/' element={<Homepage />}></Route>
          <Route path='/crud' element={<Crud />}></Route>

          <Route path='/crud/update'>
            <Route path=':id' element={<FormPut/>} />
          </Route>

          <Route path='/destinos' element={<Destinos />}></Route>
          <Route path='/contato' element={<Contato />}></Route>
          <Route path='/crud/post' element={<Form />}></Route>
        </Routes>
      </main>
      <Footer />
    </BrowserRouter>
    </div>
  );
}

export default App;
