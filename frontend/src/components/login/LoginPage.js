import React, { useContext } from "react";
import InputField from "./InputField";
import TwatterLogo from "../shared/TwatterLogo";
import styled from "styled-components";
import { useForm } from "react-hook-form";
import Axios from "axios";
import { UserContext } from "components/Context/UserContext";
import storage from "local-storage-fallback";
import { AuthContext } from "components/Context/AuthContext";

export default function LoginPage() {
  const { handleSubmit, register, errors } = useForm();
  const { user, setUser } = useContext(UserContext);
  const { login } = useContext(AuthContext);
  const onSubmit = (values) => {
    login(values);
  };

  let LoginStyle = styled.div`
    max-width: 600px;
    width: 100%;
    padding-left: 15px;
    padding-right: 15px;
    margin-left: auto;
    margin-right: auto;
    display: flex;
    flex-direction: column;

    .h1 {
      color: white;
      margin-top: 30px;
      margin-bottom: 10px;
      overflow-wrap: break-word;

      text-align: center;
    }
    h1 > span {
      font-weight: bold;
      font-size: 23px;
    }
    .logo {
      margin-top: 20px;
      margin-bottom: 30px;
      text-align: center;
      position: relative;
      max-width: 100%;
    }
    .span {
      color: white;
    }
    form {
      margin-top: 20px;
      width: 100%;
      display: block;
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
    .links {
      font-weight: 400;
      margin-top: 20px;
      color: rgb(255, 255, 255);
      font-size: 15px;
      overflow-wrap: break-word;
      text-align: center;
    }
    .links span {
      margin-left: 5px;
      margin-right: 5px;
    }

    .links a {
      color: rgb(27, 149, 224);
      text-decoration: none;
    }
    .links a:hover {
      text-decoration: underline;
    }
  `;

  return (
    <LoginStyle className="container">
      <div className="logo">
        <TwatterLogo width="37px" height="30px" />
      </div>
      <h1 className="h1">
        <span className="span">Log in to Twatter</span>
      </h1>
      <form onSubmit={handleSubmit(onSubmit)}>
        <InputField
          refi={register({
            required: "Required",
          })}
          type="text"
          name="username"
          label="Phone, e-mail, or username"
        />

        <InputField
          refi={register({
            required: "Required",
          })}
          type="password"
          name="password"
          label="Password"
        />
        <button className="button" type="submit">
          <span>Log in</span>
        </button>
      </form>
      <div className="links">
        <a href="#">Forgot password?</a>
        <span>·</span>
        <a href="/signup">Sign up for Twatter</a>
      </div>
    </LoginStyle>
  );
}
