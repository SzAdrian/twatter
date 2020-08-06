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

  return (
    <AuthContext.Provider value={{ isLogged, isLoggedIn }}>
      {props.children}
    </AuthContext.Provider>
  );
}

export default AuthContextProvider;
