import React, { useEffect, useState } from 'react'
import { completeTodo, deleteTodo, getAllTodos, inCompleteTodo } from '../services/TodoService'
import { useNavigate } from 'react-router'
import { getUserId, isAdminUser } from '../services/AuthService'

const ListTodoComponent = () => {

    const [todos, setTodos] = useState([])
    const nav = useNavigate()
    const isAdmin = isAdminUser()
    const userId = getUserId();

    useEffect(() => {
        listTodos(userId)
    }, [])

    function listTodos(userId){
        getAllTodos(userId).then(response => {
            setTodos(response.data)
        }).catch(error => {
            console.error(error)
        })
    }

    function addNewTodo(userId){
        nav(`/add-todo/${userId}`)
    }

    // id: todoId
    function updateTodo(id, userId){
        console.log(id)
        nav(`/update-todo/${userId}/${id}`)
    }

    function removeTodo(id, userId){
        deleteTodo(id, userId).then((response) => {
            console.log(response)
            listTodos(userId)
        }).catch(error => {
            console.error(error)
        })
    }

    function finishedTodo(id, userId){
        completeTodo(id,userId).then((response) => {
            console.log(response)
            listTodos(userId)
        }).catch(error => 
            console.error(error))
    }

    function unfinishedTodo(id){
        inCompleteTodo(id, userId).then((response) => {
            console.log(response)
            // console.log(response.data)
            listTodos(userId)
        }).catch(error => {
            console.error(error)
        })
    }

    return (
        <div className='container'>
            <h2 className='text-center mt-2'>Todo List</h2>
            <button className='btn btn-primary mb-2' onClick={addNewTodo}>Add task</button>

            <div>
                <table className='table table-bordered table-striped'>
                    <thead>
                        <tr>
                            <th>Task</th>
                            <th>Description</th>
                            <th>Completed</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(todo => 
                                <tr key={todo.id}>
                                    <td>{todo.title}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.completed ? 'Yes' : 'No'}</td>
                                    <td>
                                        {
                                            isAdmin &&
                                            <button className='btn btn-info' onClick={() => updateTodo(todo.id)} style={ { marginRight:'10px' }} >Update</button>
                                        }
                                        <button className='btn btn-danger' onClick={() => removeTodo(todo.id, userId)} style={ { marginRight:'10px' }}>Delete</button>
                                        <button className='btn btn-success' onClick={() => finishedTodo(todo.id, userId)} style={ { marginRight:'10px' }}>Complete</button>
                                        <button className='btn btn-warning' onClick={() => unfinishedTodo(todo.id, userId)}>In-Complete</button>
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ListTodoComponent