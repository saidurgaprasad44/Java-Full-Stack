import React, { useState, useEffect, useRef } from "react";

function VideoPlayer() {
  // 1. useState: Manages the "play/pause" UI state (triggers re-render)
  const [isPlaying, setIsPlaying] = useState(false);
  const [timer, setTimer] = useState(0);

  // 2. useRef: Accesses the <video> DOM element directly
  const videoRef = useRef(null);

  // 3. useEffect: Syncs the UI state with the actual video DOM element
  useEffect(() => {
    if (isPlaying) {
        videoRef.current.play(); // Direct DOM interaction via useRef
    } else {
        videoRef.current.pause();
    }
  }, [isPlaying]); // Only re-runs if 'isPlaying' changes

  // 4. useEffect: A simple timer that runs while the video is playing
  useEffect(() => {
    let interval;
    if (isPlaying) {
      interval = setInterval(() => {
        setTimer((prev) => prev + 1);
      }, 1000);
    }
    // Cleanup: Stops the timer when the component unmounts or pauses
    return () => clearInterval(interval);
  }, [isPlaying]);

  return (
    <div style={{ textAlign: "center" }}>
      <h2>Video Timer: {timer}s</h2>
      
      {/* Attaching the ref to the element */}
      <video 
        ref={videoRef} 
        width="300" 
        src="https://www.youtube.com/watch?v=oRdxUFDoQe0" 
      />

      <div style={{ marginTop: "10px" }}>
        <button onClick={() => setIsPlaying(!isPlaying)}>
          {isPlaying ? "Pause" : "Play"}
        </button>
      </div>
    </div>
  );
}

export default VideoPlayer;
