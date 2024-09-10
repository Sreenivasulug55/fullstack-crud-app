import "./App.css";
import ProductListComponent from "./components/ProductstList";
import Header from "./components/Header";
import Footer from "./components/Footer";
import AddAndUpdateProduct from "./components/AddAndUpdateProduct";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./components/Home";

function App() {
  return (
    <>
      <Router>
        <Header></Header>
        <Routes>
          {"http://localhost:5173/Home"}
          <Route path="/Home" element={<Home />}></Route>
          {"http://localhost:5173/products"}
          <Route path="/products" element={<ProductListComponent />}></Route>
          {"http://localhost:5173/add-product"}
          <Route path="/add-product" element={<AddAndUpdateProduct />}></Route>
          {"http://localhost:5173/update-product/:id"}
          <Route
            path="/update-product/:id"
            element={<AddAndUpdateProduct />}
          ></Route>
        </Routes>
        <Footer></Footer>
      </Router>
    </>
  );
}

export default App;
