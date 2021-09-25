import React from "react";
import { Link } from "react-router-dom";
import "./signup.css";
import TextField from "../../common/form/text-field";

export default class Signup extends React.Component {
  constructor(pros) {
    super(pros);
    this.state = {
      signupMode: "mobile", //can signup either mobile or email.
    };
  }
  render() {
    const signupMode = this.state.signupMode;
    return (
      <section className="page signup-page">
        <div className="title-box">
          <h1 className="first-header">Create your Lazada Account.</h1>
          <span style={{ fontSize: "1.2rem", fontWeight: 600 }}>
            Already member?{" "}
            <Link to="/sign-up" className="link blue-link">
              Register
            </Link>{" "}
            here
          </span>
        </div>
        <form>
          <div className="login-form">
            <div className="left-form">
              {signupMode === "mobile" ? (
                <TextField
                  label="Phone number*"
                  placeholder="Please endter your phone number"
                  name="PhoneNumber"
                  type="text"
                />
              ) : (
                <TextField
                  label="Email *"
                  placeholder="Please endter your email"
                  name="email"
                  type="text"
                />
              )}
              <TextField
                label="Password*"
                type="password"
                name="password"
                placeholder="Minimum 6 characters with a number and a letter"
              />
              {/*
              <div className="birthday-panel">
                <p className="input-label" style={{ marginTop: "2rem" }}>
                  Birthday *
                </p>
                <select name="month" placeholder="month">
                  <option>January</option>
                  <option>February</option>
                  <option>March</option>
                  <option>April</option>
                  <option>May</option>
                  <option>June</option>
                  <option>Jully</option>
                  <option>August</option>
                  <option>September</option>
                  <option>October</option>
                  <option>December</option>
                </select>
                <select name="day" placeholder="day">
                  {[...Array(31)].map((item, index) => (
                    <option value={index}> {index}</option>
                  ))}
                </select>
                <select name="Year" placeholder="Year">
                  {Array.from({ length: 2021 - 1900 }, (u, v) => 2021 - v).map(
                    (item) => (
                      <option value={item}> {item}</option>
                    )
                  )}
                </select>
              </div>
              <p className="input-label" style={{ marginTop: "2rem" }}>
                Gender *
              </p>
              <select name="Gender" placeholder="Gender">
                <option value="0"> Male</option>
                <option value="1">Female</option>
              </select>
                    */}
              <TextField
                label="Full Name*"
                type="text"
                name="fullName"
                placeholder="First Last "
              />
            </div>
            <div className="right-form">
              <button className="organe-btn btn">SIGNUP</button>
              <p style={{ fontSize: "1.2rem" }}>
                By clicking "SIGN UP", I agree to Lazada's{" "}
                <Link to="/" className="link blue-link">
                  {" "}
                  Terms of Use{" "}
                </Link>{" "}
                and{" "}
                <Link to="/" className="link blue-link">
                  Privacy Policy
                </Link>
              </p>
              <br />
              <p style={{ fontSize: "1.2rem" }}>Or, sign up with</p>
              <button className="white-btn btn">
                {signupMode === "mobile"
                  ? "Signup with Email"
                  : "Signup with Mobile"}
              </button>
              <div className="social-btn-wrapper">
                <button className="btn fb-btn">Facebook</button>
                <button className="btn google-btn">Google</button>
              </div>
            </div>
          </div>
        </form>
      </section>
    );
  }
}
