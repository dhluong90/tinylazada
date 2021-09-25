import React from "react";
import TopBrand from "./top-brand.js";
import Category from "./category.js";
import JustForMe from "./JustForMe";
import Hero from "./hero";

export default class HomePage extends React.Component {
  render() {
    return (
      <section className="page">
        <Hero />
        <TopBrand />
        <Category />
        <JustForMe />
      </section>
    );
  }
}
