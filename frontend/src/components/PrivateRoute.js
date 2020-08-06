import React, { useState, useEffect, useContext } from "react";
import { Redirect, Route } from "react-router-dom";
import Axios from "axios";
import { AuthContext } from "./Context/AuthContext";

export default function PrivateRoute({ component: Component, ...rest }) {
  const { isLogged, isLoggedIn } = useContext(AuthContext);

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
