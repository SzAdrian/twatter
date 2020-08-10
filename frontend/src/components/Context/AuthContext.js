import React, { createContext, useState } from "react";
import Axios from "axios";

export const AuthContext = createContext();

function AuthContextProvider(props) {
  const [isLogged, setisLogged] = useState(null);

  const isLoggedIn = () => {
    Axios.get("http://localhost:8080/api/auth/isloggedin", {
      withCredentials: true,
    })
      .then((resp) => {
        console.log(resp);
        setisLogged(resp.data);
      })
      .catch((resp) => {
        return console.log(resp);
      });
  };

  const logout = () => {
    Axios.post(
      "http://localhost:8080/api/auth/logout",
      {},
      {
        withCredentials: true,
      }
    ).then(() => {
      window.location.href = "/login";
    });
  };
  return (
    <AuthContext.Provider value={{ isLogged, isLoggedIn, logout }}>
      {props.children}
    </AuthContext.Provider>
  );
}

export default AuthContextProvider;
