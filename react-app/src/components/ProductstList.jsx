import React, { useEffect, useState } from "react";
import { deleteProduct, productsList } from "../services/ProductService";
import { useNavigate } from "react-router-dom";
const ProductListComponent = () => {
  const [products, setProducts] = useState([]);
  const navigator = useNavigate();

  useEffect(() => {
    getAllProducts();
  }, []);

  function getAllProducts() {
    productsList()
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function addNewProduct() {
    navigator("/add-product");
  }
  function updateProduct(id) {
    navigator(`/update-product/${id}`);
  }
  function removeProduct(id) {
    console.log(id);

    deleteProduct(id)
      .then((response) => getAllProducts())
      .catch((error) => console.error(error));
  }

  return (
    <div className="container content">
      <h2 className="text-center">List of Products Data</h2>
      <button className="btn btn-primary mb-2" onClick={addNewProduct}>
        Add Product
      </button>
      <table
        className="table table-striped table-bordered table-hover"
        style={{ textAlign: "left" }}
      >
        <thead>
          <tr>
            <th>Product Id</th>
            <th>Model Name</th>
            <th>Company Name</th>
            <th>Category</th>
            <th>CategoryId</th>
            <th>Price</th>
            <th className="text-center">Action</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr key={index}>
              {/* i keep sequence numbers */}
              <td>{index+1}</td>
              <td>{product.modelName}</td>
              <td>{product.companyName}</td>
              <td>{product.category}</td>
              <td>{product.categoryId}</td>
              <td>{product.price}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateProduct(product.id)}
                >
                  Update
                </button>
                <button
                  className="btn btn-danger "
                  style={{ marginLeft: "10px" }}
                  onClick={() => removeProduct(product.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ProductListComponent;
