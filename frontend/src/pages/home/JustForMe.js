import React from "react";
import "./just-for-me.css";
class JustForMe extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
        {
          prodImage:
            "https://sg-test-11.slatic.net/p/d5e0dae0f1b83eb81a2c91177b70a1e6.png_400x400Q100.jpg_.webp",
          name: "S5 Supra Racing Simulator Wheelstand for G27 G29 T300RS T500RS FANATEC / Racing Wheel stand / SIM Racing Wheelstand / Racing seat rig / Racing driving simulator wheel stand / Racing Stand",
          price: 138.55,
          star: 5,
          reviewers: 67,
        },
      ],
    };
  }

  renderProduct(prod) {
    return (
      <div className="product-card">
        <img src={prod.prodImage} alt={prod.name} />
        <div className="prod-info">
          <p className="prod-name">{prod.name}</p>
          <p className="prod-price">${prod.price}</p>
          <div className="star-section">
            {[...Array(prod.star)].map((item, index) => (
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="star-icon full-star"
                viewBox="0 0 20 20"
                fill="currentColor"
              >
                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
              </svg>
            ))}
            {[...Array(5 - prod.star)].map((item, index) => (
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class=" star-icon empty-star"
                viewBox="0 0 20 20"
                fill="currentColor"
              >
                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
              </svg>
            ))}
            <span>({prod.reviewers})</span>
          </div>
        </div>
      </div>
    );
  }
  render() {
    return (
      <div className="product-section header-content home-page-section">
        <h1 className="first-header">Just For You</h1>
        <div className="product-card-list">
          {this.state.products.map((prod) => this.renderProduct(prod))}
        </div>

        <button className="pagination-btn">LOAD MORE</button>
      </div>
    );
  }
}

export default JustForMe;
