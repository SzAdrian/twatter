import React, { createContext, useState } from "react";
import Axios from "axios";
import storage from "local-storage-fallback";

export const AuthContext = createContext();

function AuthContextProvider(props) {
  const [isLogged, setisLogged] = useState(null);

  const signup = (values) => {
    Axios.post(
      process.env.REACT_APP_API_URL +
        ":" +
        process.env.REACT_APP_PORT +
        "/api/auth/register",
      {
        username: values.name,
        password: values.password,
      }
    ).then((resp) => {
      if (resp.data) {
        login(values);
      }
    });
  };

  const login = (values) => {
    Axios.post(
      process.env.REACT_APP_API_URL +
        ":" +
        process.env.REACT_APP_PORT +
        "/api/auth/login",
      {
        username: values.username,
        password: values.password,
      },
      { withCredentials: true }
    ).then(({ data }) => {
      data == -1
        ? (window.location.href = "/login")
        : Axios.get(
            `${
              process.env.REACT_APP_API_URL + ":" + process.env.REACT_APP_PORT
            }/api/users/${data}`,
            {
              withCredentials: true,
            }
          ).then(({ data }) => {
            storage.setItem("user", JSON.stringify(data));
            window.location.href = "/home";
          });
    });
  };

  const isLoggedIn = () => {
    Axios.get(
      process.env.REACT_APP_API_URL +
        ":" +
        process.env.REACT_APP_PORT +
        "/api/auth/isloggedin",
      {
        withCredentials: true,
      }
    )
      .then((resp) => {
        console.log(resp);
        setisLogged(resp.data);
      })
      .catch((resp) => {
        return console.log(resp);
      });
  };

  const logout = () => {
    storage.removeItem("user");
    Axios.post(
      process.env.REACT_APP_API_URL +
        ":" +
        process.env.REACT_APP_PORT +
        "/api/auth/logout",
      {},
      {
        withCredentials: true,
      }
    ).then(() => {
      window.location.href = "/login";
    });
  };
  return (
    <AuthContext.Provider
      value={{ isLogged, isLoggedIn, logout, login, signup }}
    >
      {props.children}
    </AuthContext.Provider>
  );
}

export default AuthContextProvider;
