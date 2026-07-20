import React, { useRef, useState } from "react";




function TaskList({task}){
    const [buttontoggle, setButtontoggle] = useState(true);
    const taskref = useRef(null)
    const deletebuttonhandler = ()=>{
        setButtontoggle(!buttontoggle)
        taskref.current.remove();
    }

    return(
        <>
            <li ref={taskref}><span>{task}</span><button style={{ float: "center" }} onClick = {deletebuttonhandler}>Delete</button></li>
            
        </>
    )
}
export default TaskList;