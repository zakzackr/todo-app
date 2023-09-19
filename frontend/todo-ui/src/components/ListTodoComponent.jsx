import React, { useEffect, useState } from 'react'
import { completeTodo, deleteTodo, getAllTodos, inCompleteTodo } from '../services/TodoService'
import { useNavigate } from 'react-router'
import { func } from 'prop-types'

const ListTodoComponent = () => {

    const [todos, setTodos] = useState([])
    const nav = useNavigate()

    useEffect(() => {
        listTodos()
    }, [])

    function listTodos(){
        getAllTodos().then(response => {
            setTodos(response.data)
        }).catch(error => {
            console.error(error)
        })
    }

    function addNewTodo(){
        nav('/add-todo')
    }

    function updateTodo(id){
        console.log(id)
        nav(`/update-todo/${id}`)
    }

    function removeTodo(id){
        deleteTodo(id).then((response) => {
            console.log(response)
            listTodos()
        }).catch(error => {
            console.error(error)
        })
    }

    function finishedTodo(id){
        completeTodo(id).then((response) => {
            console.log(response)
            listTodos()
        }).catch(error => 
            console.error(error))
    }

    function unfinishedTodo(id){
        inCompleteTodo(id).then((response) => {
            console.log(response)
            // console.log(response.data)
            listTodos()
        }).catch(error => {
            console.error(error)
        })
    }

    return (
        <div className='container'>
            <h2 className='text-center'>To do Tasks</h2>
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
                                        <button className='btn btn-info' onClick={() => updateTodo(todo.id)} style={ { marginRight:'10px' }} >Update</button>
                                        <button className='btn btn-danger' onClick={() => removeTodo(todo.id)} style={ { marginRight:'10px' }}>Delete</button>
                                        <button className='btn btn-success' onClick={() => finishedTodo(todo.id)} style={ { marginRight:'10px' }}>Complete</button>
                                        <button className='btn btn-warning' onClick={() => unfinishedTodo(todo.id)}>In-Complete</button>
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