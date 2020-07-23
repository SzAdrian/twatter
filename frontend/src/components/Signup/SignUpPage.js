import React from "react";
import LoginPage from "components/login/LoginPage";
import styled from "styled-components";
import InputField from "components/login/InputField";
import TwatterLogo from "components/shared/TwatterLogo";
import { Redirect } from "react-router-dom";

function SignUp() {
  let SignUpPageStyle = styled.div`
    display: flex;
    flex-direction: column;

    .container {
      z-index: 1;
      width: 100vw;
      height: 100%;
      align-items: center;
      justify-content: center;
      display: flex;
      flex-direction: row;
      position: absolute;
      top: 0;
      .modal {
        z-index: 1000;
        display: flex;
        flex-direction: column;
        position: fixed;

        width: 600px;
        height: 650px;
        min-height: 400px;
        max-width: 80vw;
        max-height: 90vh;
        overflow: hidden;
        border-bottom-left-radius: 15px;
        border-bottom-right-radius: 15px;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
        background-color: rgb(21, 32, 43);
      }
      .modal-content {
        display: flex;
        flex-direction: column;
      }
      .logo {
        margin-top: 10px;
        align-self: center;
      }
      .close {
        color: #aaaaaa;
        position: absolute;
        right: 0;
        font-size: 28px;
        font-weight: bold;
      }

      .close:hover,
      .close:focus {
        color: #000;
        text-decoration: none;
        cursor: pointer;
      }
      .form {
        margin: 10px 30px;
      }
      h1 {
        color: white;
        font-size: 23px;
        margin: 20px 0px;
      }
      h2 {
        color: white;
        font-size: 18px;
        margin: 20px 0px;
      }
      p {
        color: rgb(136, 153, 166);
        font-size: 15px;
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Ubuntu, "Helvetica Neue", sans-serif;
      }
      a {
        color: rgb(27, 149, 224);
        font-size: 15px;
      }
      a:hover {
        cursor: pointer;
        text-decoration: underline;
      }
      .background {
        background-color: rgba(110, 118, 125, 0.4);
        width: 100vw;
        height: 100vh;
        z-index: 500;
      }
    }
  `;

  return (
    <>
      <LoginPage />
      <SignUpPageStyle>
        <div className="container">
          <div
            className="background"
            onClick={() => {
              window.location.href = "/login";
            }}
          ></div>
          <div className="modal">
            <div className="modal-content">
              <span className="logo">
                <TwatterLogo width="28px" height="23px" />
              </span>
              <div className="form">
                <h1>Create your account</h1>
                <InputField withCounter label="Name" type="text" name="name" />
                <InputField
                  label="Phone Number"
                  type="text"
                  name="phone_number"
                />
                <a>Use email instead</a>
                <h2>Date of birth</h2>
                <p>
                  This will not be shown publicly. Confirm your own age, even if
                  this account is for a business, a pet, or something else.
                </p>

                <div>
                  <select></select>
                  <select></select>
                  <select></select>
                </div>
              </div>
            </div>
          </div>
        </div>
      </SignUpPageStyle>
    </>
  );
}

export default SignUp;
