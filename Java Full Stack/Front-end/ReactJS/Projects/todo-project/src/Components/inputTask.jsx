import React, { useRef, useState } from "react";
import TaskList from "./taskList";

function InputTask(){
    const inputref = useRef(null);
    const [tasks, setTasks] = useState([]); 
    const addbuttonhandler = () => {
        const newtask=inputref.current.value;
        if(newtask!==""){
            setTasks([...tasks, newtask]);
            inputref.current.value=''
        }
        else{
            alert("Enter a task")
        }
    }

    return(
        <>
            <div>
                <input type="Text" placeholder="Enter your Task" ref={inputref}/> <button onClick = {addbuttonhandler}>Add</button>
                <ol>
                    {
                        tasks.map(task => {
                            return(
                                <TaskList task = {task}/>
                            )
                        })
                    }
                </ol>
            </div>
        </>
    )
}
export default InputTask;
