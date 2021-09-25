import "./App.css";
import Navigation from "./pages/header/navigation";
import SearchBox from "./pages/header/search";
import HomePage from "./pages/home/home-page";
import { Switch, Route } from "react-router-dom";
import Login from "./pages/login/login";
import Signup from "./pages/signup/signup";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Navigation />
        <SearchBox />
      </header>
      <Switch>
        <Route path="/login">
          <Login />
        </Route>
        <Route path="/signup">
          <Signup />
        </Route>
        <Route path="/">
          <HomePage />
        </Route>
      </Switch>
      <footer>
        <div
          className="header-content"
          style={{ paddingTop: "4rem", textAlign: "right", fontSize: "1.4rem" }}
        >
          © Lazada 2021
        </div>
      </footer>
    </div>
  );
}

export default App;
