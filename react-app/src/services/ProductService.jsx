import axios from "axios";

const GET_ALL_PRODUCTS = "http://localhost:8080/products";
const SAVE_PRODUCT_URL = "http://localhost:8080/add-product";
const GET_PRODUCT_URL = "http://localhost:8080/get-product";
const UPDATE_PRODUCT_URL = "http://localhost:8080/update-product";
const DELETE_PRODUCT_URL = "http://localhost:8080/delete-product";

export const productsList = () => axios.get(GET_ALL_PRODUCTS);
export const saveProduct = (product) => axios.post(SAVE_PRODUCT_URL, product);
export const getProductById = (productId) =>
  axios.get(GET_PRODUCT_URL + "/" + productId);
export const updateProduct = (product) =>
  axios.put(UPDATE_PRODUCT_URL, product);
export const deleteProduct = (productId) =>
  axios.delete(DELETE_PRODUCT_URL + "/" + productId);
