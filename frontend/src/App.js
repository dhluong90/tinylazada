import "./App.css";
import Navigation from "./common/components/navigation";
import SearchBox from "./common/components/search";
import Hero from "./common/components/hero";
import TopBrand from "./common/components/top-brand";
import Category from "./common/components/category";
import JustForMe from "./common/components/JustForMe";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Navigation />
        <SearchBox />
        <Hero />
      </header>
      <section className="page">
        <TopBrand />
        <Category />
        <JustForMe />
      </section>
      <footer>
        <div className="contact-info"></div>
      </footer>
    </div>
  );
}

export default App;
