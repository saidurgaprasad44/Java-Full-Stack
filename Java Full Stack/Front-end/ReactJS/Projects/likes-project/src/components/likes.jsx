import React, { useEffect } from "react";
import { useState } from "react";

function Likes(){
    const [likes, setLikes] = useState(333); 
    useEffect(()=>{
        console.log("Component is mounted")
    },[])
    
    useEffect(()=>{
        console.log("likes are updated")
    },[likes])
    
    useEffect(()=>{
        console.log("Component is rendered")
    })
    
    return(
        <span>
            <p>Likes: {likes}</p>
            <button onClick={()=>setLikes(likes+1)}>Like</button>
            <button onClick={()=>setLikes(likes-1)}>Dislike</button>
            {likes<340? <p>People are liking the video</p>:<p>People are loving the video</p>}            
        </span>
    )
}

export default Likes;