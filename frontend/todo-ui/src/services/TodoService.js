import axios from "axios";
import { getToken } from "./AuthService";

const BASE_REST_API_URL = "http://localhost:8080/api/todos"

// Add a request interceptor
axios.interceptors.request.use(function (config) {
    config.headers['Authorization'] = getToken()
    return config;
  }, function (error) {
    return Promise.reject(error);
  });
 
export const getAllTodos = (userId) => axios.get(BASE_REST_API_URL + '/' + userId)

export const addTodo = (userId, todo) => axios.post(BASE_REST_API_URL + '/' + userId, todo)

export const getTodo = (id, userId) => axios.get(BASE_REST_API_URL + '/' + userId + '/' + id)

export const updateTodo = (id, userId, todo) => axios.put(BASE_REST_API_URL + '/' + userId + '/' + id, todo)

export const deleteTodo = (id, userId) => axios.delete(BASE_REST_API_URL + '/' + userId + '/' + id)

export const completeTodo = (id, userId) => axios.patch(BASE_REST_API_URL + '/' + userId + '/' + id + '/complete')

export const inCompleteTodo = (id, userId) => axios.patch(BASE_REST_API_URL + '/' + userId + '/' + id + '/in-complete')

