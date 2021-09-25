import React from "react";
import lazMall from "../../asset/lazada-mall-logo.png";
import redmart from "../../asset/redmart-logo.png";
import taobao from "../../asset/taobao-logo.png";
import "./top-brand.css";
class TopBrand extends React.Component {
  render() {
    return (
      <section className="top-brand header-content home-page-section">
        <div className="brand-item">
          <a className="brand-link" href="#" aria-label="catalog">
            <img
              src={lazMall}
              alt="Lazada Mall Logo"
              className="brand-logo"
            ></img>
            <div className="brand-description header-3">
              100% Authentic Brands
            </div>
          </a>
        </div>
        <div className="brand-item">
          <a className="brand-link" href="#" aria-label="catalog">
            <img
              src={taobao}
              alt="taobao Mall Logo"
              className="brand-logo"
            ></img>
            <div className="brand-description header-3">Global Products</div>
          </a>
        </div>
        <div className="brand-item">
          <a className="brand-link" href="#" aria-label="catalog">
            <img
              src={redmart}
              alt="Redmart Mall Logo"
              className="brand-logo"
            ></img>
            <div className="brand-description header-3">Online Grocer</div>
          </a>
        </div>
        <div className="brand-item">
          <a className="brand-link" href="#" aria-label="catalog">
            <h2 className="brand-title">Vouchers</h2>
            <div className="brand-description header-3">
              Vouchers information
            </div>
          </a>
        </div>
        <div className="brand-item">
          <a className="brand-link" href="#" aria-label="catalog">
            <h2 className="brand-title">Digital & Services</h2>
            <div className="brand-description header-3">Digital & Sevices</div>
          </a>
        </div>
      </section>
    );
  }
}

export default TopBrand;
