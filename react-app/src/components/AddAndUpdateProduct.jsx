import React, { useState, useEffect } from "react";
import {
  getProductById,
  saveProduct,
  updateProduct,
} from "../services/ProductService";
import { useNavigate, useParams } from "react-router-dom";

const AddAndUpdateProduct = () => {
  const [product, setProducts] = useState({
    id: 0,
    modelName: "",
    companyName: "",
    price: 0,
    categoryId: 0,
    category: "",
  });

  // capture the Response after Add Product
  // after the data Submission just Green Message Print Below The Form
  const [responseData, setResponseData] = useState(null);

  // useparam to capture Id of the updated Employee
  // it return an Object of the Key value pair
  const { id } = useParams();

  //Navigate the Page Address
  const navigator = useNavigate();

  // assign to the data  to the Products method
  useEffect(() => {
    if (id) {
      getProductById(id)
        .then((response) => {
          setProducts(response.data);
          console.log(product);
        })
        .catch((error) => console.log(error));
    }
  }, [id]);

  const handleProduct = (e) => {
    const { name, value } = e.target;
    setProducts({
      ...product,
      [name]: value,
    });
  };

  const submitHandler = (e) => {
    e.preventDefault();
    if (product.id) {
      console.log(product);
      updateProduct(product)
        .then((response) => setResponseData(response.data))
        .catch((error) => console.error(error));
    } else {
      console.log(product);
      saveProduct(product)
        .then((response) => setResponseData(response.data))
        .catch((error) => console.error(error));
    }
  };
  // Title
  function pageTitle() {
    if (id) {
      return <h2 className="text-center">Update Product</h2>;
    } else {
      return <h2 className="text-center">Add Product</h2>;
    }
  }

  return (
    <div className="container ">
      <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {pageTitle()}
          <div className="card-body">
            <form onSubmit={submitHandler}>
              {/*Input Field: 1 */}
              <div className="form-group mb-2">
                <label htmlFor="modelName" className="form-label">
                  Model Name:
                </label>
                <input
                  className="form-control"
                  type="text"
                  placeholder="Enter Modelname"
                  name="modelName"
                  value={product.modelName}
                  onChange={handleProduct}
                  required
                />
              </div>

              {/* {Input Field : 1 } */}
              <div className="form-group mb-2">
                <label htmlFor="companyName" className="form-label">
                  product Company Name:
                </label>
                <input
                  className="form-control"
                  type="text"
                  placeholder="Enter CompanyName"
                  name="companyName"
                  value={product.companyName}
                  onChange={handleProduct}
                  required
                />
              </div>
              {/* {Inpput Field : 3} */}
              <div className="form-group mb-2">
                <label htmlFor="category" className="form-label">
                  Category:
                </label>
                <input
                  className="form-control"
                  type="number"
                  placeholder="Enter category"
                  name="categoryId"
                  value={product.categoryId}
                  onChange={handleProduct}
                  required
                />
              </div>
              {/* {Input Field : 4} */}
              <div className="form-group mb-2">
                <label htmlFor="price" className="form-label">
                  Price:
                </label>
                <input
                  className="form-control"
                  type="number"
                  placeholder="Enter Price"
                  name="price"
                  value={product.price}
                  onChange={handleProduct}
                  required
                />
              </div>
              {/* {Button Field} */}
              <button className="btn btn-success mb-3">Submit</button>
              {/* Display response data */}
              {responseData && (
                <div className="alert alert-success ">
                  Product saved successfully! Response:{" "}
                  {JSON.stringify(responseData)}
                </div>
              )}
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddAndUpdateProduct;
