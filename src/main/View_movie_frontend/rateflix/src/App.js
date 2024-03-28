
import './App.css';
import AddMovie from './components/AddMovie';
import MovieList from './components/MovieList';


function App() {
  return (
    <div className="App">
      <MovieList/>
      <AddMovie/>
    </div>
  );
}

export default App;
