import React from "react";
import LoginPage from "components/login/LoginPage";
import styled from "styled-components";
import InputField from "components/login/InputField";
import TwatterLogo from "components/shared/TwatterLogo";
import { Redirect } from "react-router-dom";
import { useForm } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";

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
    .button {
      background-color: rgb(29, 161, 242);
      min-width: 78.89px;
      min-height: 49px;
      width: 100%;
      outline-style: none;
      transition-property: background-color, box-shadow;
      display: flex;
      justify-content: center;
      flex-direction: column;

      padding-left: 30px;
      padding-right: 30px;
      margin-bottom: 10px;
      margin-top: 10px;

      border-bottom-color: rgba(0, 0, 0, 0);
      border-left-color: rgba(0, 0, 0, 0);
      border-right-color: rgba(0, 0, 0, 0);
      border-top-color: rgba(0, 0, 0, 0);

      border-bottom-width: 1px;
      border-left-width: 1px;
      border-right-width: 1px;
      border-top-width: 1px;

      border-bottom-style: solid;
      border-left-style: solid;
      border-right-style: solid;
      border-top-style: solid;

      border-bottom-left-radius: 9999px;
      border-bottom-right-radius: 9999px;
      border-top-left-radius: 9999px;
      border-top-right-radius: 9999px;
    }
    .button:hover {
      cursor: pointer;
    }
    .button > span {
      color: rgb(255, 255, 255);
      line-height: 1;
      font-weight: bold;
      font-size: 15px;
      font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
        Roboto, Ubuntu, "Helvetica Neue", sans-serif;
      overflow-wrap: break-word;
      min-width: 0px;
      -webkit-box-align: center;
      align-items: center;
      -webkit-box-pack: center;
      justify-content: center;
      text-align: center;
      align-self: center;
    }

    .error {
      color: #bf1650;
    }

    .error::before {
      display: inline;
      content: "⚠ ";
    }
  }
`;

function SignUp() {
  const { handleSubmit, register, errors } = useForm();
  const onSubmit = (values) => console.log(values);

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
              <form className="form" onSubmit={handleSubmit(onSubmit)}>
                <h1>Create your account</h1>
                <InputField
                  refi={register({
                    required: "Required",
                  })}
                  withCounter
                  label="Name*"
                  type="text"
                  name="name"
                />
                <ErrorMessage
                  className="error"
                  errors={errors}
                  name="name"
                  as="h3"
                />
                <InputField
                  refi={register({
                    required: "Required",
                    pattern: {
                      value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                      message: "Invalid email address",
                    },
                  })}
                  label="Email address*"
                  type="text"
                  name="email"
                />
                <ErrorMessage
                  className="error"
                  errors={errors}
                  name="email"
                  as="h3"
                />
                <InputField
                  refi={register({
                    required: "Required",
                  })}
                  label="Password*"
                  type="password"
                  name="password"
                />
                <ErrorMessage
                  className="error"
                  errors={errors}
                  name="password"
                  as="h3"
                />

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

                <button className="button" type="submit">
                  <span>Submit</span>
                </button>
              </form>
            </div>
          </div>
        </div>
      </SignUpPageStyle>
    </>
  );
}

export default SignUp;
