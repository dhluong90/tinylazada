import React from "react";
import { Link } from "react-router-dom";
import "./login.css";
import TextField from "../../common/form/text-field";

export default class Login extends React.Component {
  constructor(pros) {
    super(pros);
  }
  render() {
    return (
      <section className="page login-page">
        <div className="title-box">
          <h1 className="first-header">Welcome to Lazada! Please login.</h1>
          <span style={{ fontSize: "1.2rem", fontWeight: 600 }}>
            New member?{" "}
            <Link to="/sign-up" className="link blue-link">
              Register
            </Link>{" "}
            here
          </span>
        </div>
        <form>
          <div className="login-form">
            <div className="left-form">
              <TextField
                label="Phone number or Email*"
                name="PhoneNumber"
                type="text"
                placeholder="Please enter your Phone Number or Email"
              />

              <TextField
                label="Password*"
                type="password"
                name="password"
                placeholder="Minimum 6 characters with a number and a letter"
              />
            </div>
            <div className="right-form">
              <button className="organe-btn btn">LOGIN</button>
              <p style={{ fontSize: "1.4rem" }}>or, login with</p>
              <button className="btn fb-btn">Facebook</button>
              <button className="btn google-btn">Google</button>
            </div>
          </div>
        </form>
      </section>
    );
  }
}
