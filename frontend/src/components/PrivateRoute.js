import React, { useState, useEffect, useContext } from "react";
import { Redirect, Route } from "react-router-dom";
import Axios from "axios";

export default function PrivateRoute({ component: Component, ...rest }) {
  const [isLogged, setisLogged] = useState(null);

  const isLoggedIn = () => {
    return Axios.get("http://localhost:8080/api/auth/isloggedin", {
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

  useEffect(() => {
    isLoggedIn();
  }, []);

  return (
    <>
      {isLogged !== null && (
        <Route
          {...rest}
          render={(props) => {
            return isLogged ? (
              <Component {...props} />
            ) : (
              <Redirect
                to={{ pathname: "/login", state: { from: props.location } }}
              />
            );
          }}
        />
      )}
    </>
  );
}
