import React from "react";
import "./hero.css";
import caroseul_1 from "../../asset/caroseul/caroseul_1.jpg";

class Hero extends React.Component {
  render() {
    return (
      <section className="hero">
        <div className="caroseul-wrapper header-content">
          <div className="catalog">
            <ul>
              <li>Electronic Devices</li>
              <li>Electronic Accessories</li>
              <li>TV & Home Appliances</li>
            </ul>
          </div>
          <div className="caroseul">
            <img alt="caroseul" src={caroseul_1} />
            <ul className="caroseul-nav">
              <li></li>
            </ul>
          </div>
        </div>
      </section>
    );
  }
}

export default Hero;
