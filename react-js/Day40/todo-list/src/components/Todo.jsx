import { Fragment, useState } from "react"
import json from '../data/todo.json'

const Todo = () => {

    const [todo, setTodo] = useState(json)
    const [text, setText] = useState({
        "text": ""
    })

    const handleAddText = () => {
        setTodo([...todo, {'text': text}]);
        setText({
            text: ""
        })
    }

    const handleDeleteText = (index) => {
        const newTodo = todo.filter((element, i) => i !== index);   
        setTodo(newTodo);
    }

    return <>
        <div className="w-screen h-screen flex justify-center items-center no-scrollbar overflow-y-auto">
            <div className="border-2 p-4 flex flex-col ">
                <div className="flex flex-col">
                    <label htmlFor="text">Add Text</label>
                    <input type="text" name="text" id="text" value={text.text} onChange={(e) => setText(e.target.value)} className="outline-0 border py-1 px-2 " />
                </div>
                <button onClick={handleAddText} className="mt-3 border py-1 px-5 bg-blue-500 text-white rounded">Add</button>
                <div className="flex flex-col justify-between items-center">
                    {
                        todo.map((item, index) => {
                            return <Fragment key={index}>
                                <div className="w-full flex justify-between items-center">
                                    <div className="w-80% ">
                                        <h1>{item.text}</h1>
                                    </div>
                                    <div className="w-20%">
                                        <button onClick={() => handleDeleteText(index)} className="mt-3 border py-1 px-5 bg-blue-500 text-white rounded">Delete</button>
                                    </div>
                                </div>
                            </Fragment>
                        })
                    }
                </div>
            </div>
        </div>
    </>
}

export default Todo