import './App.css'
import ListTodoComponent from './components/ListTodoComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import TodoComponent from './components/TodoComponent'

function App() {
  return (
    <BrowserRouter>
      <HeaderComponent />
      <Routes>
        <Route path='/add-todo' element = { <TodoComponent /> }></Route>
        <Route path='/update-todo/:id' element = { <TodoComponent /> }></Route>
        <Route path='/' element = { <ListTodoComponent /> }></Route>
        <Route path='/todos' element = { <ListTodoComponent /> }></Route>
      </Routes>
      <FooterComponent />
    </BrowserRouter>
  )
}

export default App
