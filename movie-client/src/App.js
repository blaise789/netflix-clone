import api from './api/axiosConfig'
import './App.css';
import { Route, Routes } from 'react-router-dom';
import { useEffect, useState } from 'react';
import Layout from './components/Layouts';
import Trailer from './components/trailer/Trailer';
import Home from './components/home/Home';

function App() {
  const [movies,setMovies]=useState();
  const [movie,setMovie]=useState();
  const [reviews,setReviews]=useState([])
  const getMovies=async ()=>{
    try{
      const response= await  api.get("/api/v1/movies")
      setMovies(response.data)
      console.log(movies)
    }
    catch(err){
      console.log(err)
    }

  }
  const getSingleMovie=async (movieId)=>{
    try{
      const response= await  api.get(`/api/v1/movies/${movieId}`)
      setMovie(response.data)
    }
    catch(err){
      console.log(err)
    }
  }
  useEffect(()=>{
    getMovies();
  },[])
  return (
    <div className="App">
      <Routes>
        <Route  path="/" element={<Layout/>}>
           <Route  path="/"  element={<Home movies={movies}/>}></Route>
           <Route  path="/Trailer:ytTrailerId"  element={<Trailer/>}></Route>
        </Route>
       
      </Routes>
      
    </div>
  );
}

export default App;
