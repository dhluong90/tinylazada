import React from "react";
import "./hero.css";

class Hero extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      caroseulItems: [
        {
          img: "https://icms-image.slatic.net/images/ims-web/2371613b-3e05-4ed2-a075-ba8dfbfd6e4e.jpg",
          color: " rgb(230, 230, 230)",
        },
        {
          img: "https://icms-image.slatic.net/images/ims-web/09dd7c14-449d-47ef-825c-28eff3168cd5.jpg",
          color: " rgb(3, 60,136)",
        },
        {
          color: " rgb(205, 200, 196)",
          img: "https://icms-image.slatic.net/images/ims-web/fedb80d0-4617-4bcc-bc44-e165572ae4f9.jpg",
        },
        {
          color: " rgb(156, 30, 35)",
          img: "https://icms-image.slatic.net/images/ims-web/5a1f4e7a-6e9e-4cf9-a75b-69d989e251d6.jpg",
        },
        {
          color: " rgb(246, 217, 196)",
          img: "https://icms-image.slatic.net/images/ims-web/a9ceb3fe-0934-4dbb-835c-a3bc2441adf9.jpg",
        },
        {
          color: " rgb(157, 28, 32)",
          img: "https://icms-image.slatic.net/images/ims-web/c273fb8c-9e55-4720-8116-e0bef243e8d4.jpg",
        },
        {
          color: " rgb(157, 32, 37)",
          img: "https://icms-image.slatic.net/images/ims-web/e11bcd78-d9ac-4b1d-a920-83a2a79b0427.jpg",
        },
      ],
    };

    this.state.currentItemIndex = 0;
  }

  componentDidMount() {
    this.caroseulTimeout = setInterval(() => {
      this.setState((prev) => ({
        currentItemIndex:
          (prev.currentItemIndex + 1) % this.state.caroseulItems.length,
      }));
    }, 5000);
  }

  componentWillUnmount() {
    clearInterval(this.caroseulTimeout);
  }
  render() {
    const currentItem = this.state.caroseulItems[this.state.currentItemIndex];

    return (
      <section className="hero" style={{ backgroundColor: currentItem.color }}>
        <div className="caroseul-wrapper header-content">
          <div className="catalog">
            <ul>
              <li>Electronic Devices</li>
              <li>Electronic Accessories</li>
              <li>TV & Home Appliances</li>
            </ul>
          </div>
          <div className="caroseul">
            {this.state.caroseulItems.map((item, index) => (
              <img
                alt="caroseul"
                src={item.img}
                style={{
                  display:
                    index === this.state.currentItemIndex ? "block" : "none",
                  opacity: index === this.state.currentItemIndex ? 1 : 0,
                }}
              />
            ))}
            <ul className="caroseul-nav">
              {[...Array(this.state.caroseulItems.length)].map(
                (item, index) => (
                  <li
                    style={
                      index === this.state.currentItemIndex
                        ? {
                            backgroundColor: "#fff",
                          }
                        : {}
                    }
                  ></li>
                )
              )}
            </ul>
          </div>
        </div>
      </section>
    );
  }
}

export default Hero;
