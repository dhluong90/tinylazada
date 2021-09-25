import React from "react";
import logo from "../../asset/lazada-logo.png";
import "./search.css";
import { Link } from "react-router-dom";

class SearchBox extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isSearchHistoryOpen: false,
    };

    this.onSearchInputBlur = this.onSearchInputBlur.bind(this);
    this.onSearchInputFocus = this.onSearchInputFocus.bind(this);
  }

  onSearchInputFocus() {
    //todo history dialog will develop later
    this.setState((currentState) => ({
      isSearchHistoryOpen: false,
    }));
  }
  onSearchInputBlur() {
    this.setState((currentSate) => ({
      isSearchHistoryOpen: false,
    }));
  }

  render() {
    return (
      <section className="search-bar header-content">
        <div className="logo-wrapper">
          <Link to="/">
            <img className="logo" alt="Lazada logo" src={logo} />
          </Link>
        </div>
        <div className="search-form-cart-wrapper">
          <form autoComplete="off">
            <div className="search-form-box">
              <input
                type="text"
                id="q"
                name="q"
                placeholder="Search in Lazada"
                onFocus={this.onSearchInputFocus}
                onBlur={this.onSearchInputBlur}
              />
              <div className="search-icon-wrapper">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  class="search-icon"
                  viewBox="0 0 20 20"
                  fill="currentColor"
                >
                  <path
                    fill-rule="evenodd"
                    d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                    clip-rule="evenodd"
                  />
                </svg>
              </div>
              {this.state.isSearchHistoryOpen && (
                <div className="search-history-box">
                  <div className="search-history-box-header">
                    <h3 className="header-3">Search History</h3>
                    <button>Clear</button>
                  </div>
                  <ul className="history-list">
                    <li>Playstation camera</li>
                    <li>PS4 camera</li>
                  </ul>
                </div>
              )}
            </div>
          </form>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="cart-icon"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"
            />
          </svg>
        </div>
      </section>
    );
  }
}

export default SearchBox;
