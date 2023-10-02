import { useEffect, useState } from 'react'
import { addTodo, getTodo, updateTodo } from '../services/TodoService'
import { useNavigate, useParams } from 'react-router'
import { getUserId } from '../services/AuthService'

const TodoComponent = () => {

    const [title, setTitle] = useState('')
    const [description, setDescription] = useState('')
    const [completed, setCompleted] = useState(false)
    const nav = useNavigate()
    const { id } = useParams();
    const userId = getUserId();

    useEffect(() => {
        
        if (id){
            getTodo(id, userId).then((response) => {
                console.log(response.data)
                setTitle(response.data.title)
                setDescription(response.data.description)
                setCompleted(response.data.completed)
            }).catch(error => {
                console.error(error)
            })
        } 

    }, [id])

    function saveOrUpdateTodo(e){
        e.preventDefault()

        const todo = {title, description, completed}

        if (id){
            updateTodo(id, userId, todo).then((response) => {
                console.log(response)
                nav(`/todos/${userId}`)
            }).catch(error => {
                console.error(error)
            })
        } else {
            addTodo(userId, todo).then((response) => {
                console.log(response)
                nav(`/todos/${userId}`)
            }).catch(error => {
                console.error(error)
            })
        }
    }

    function pageTitle(){
        if (id){
            return <h2 className='text-center mt-4'>Update task</h2>
        } else {
            return <h2 className='text-center mt-4'>Add new task</h2>
        }
    }

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    { pageTitle() }
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Task:</label>
                                <input 
                                    type='text'
                                    className='form-control'
                                    placeholder='Enter new task'
                                    name='title'
                                    value={title}
                                    onChange={(e) => setTitle(e.target.value)}
                                >
                                </input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'>Task description:</label>
                                <input 
                                    type='text'
                                    className='form-control'
                                    placeholder='Enter task description'
                                    name='description'
                                    value={description}
                                    onChange={(e) => setDescription(e.target.value)}
                                >
                                </input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'>Task completed:</label>
                                <select
                                    className='form-control'
                                    value={completed}
                                    onChange={(e) => setCompleted(e.target.value)}
                                >
                                    <option value="false">No</option>
                                    <option value="true">Yes</option>
                                </select>
                            </div>
                            <button className='btn btn-success' onClick={(e) => saveOrUpdateTodo(e)}>Submit</button>
                        </form>
                    </div>
                </div>
            </div>
            
        </div>
    )
}

export default TodoComponent