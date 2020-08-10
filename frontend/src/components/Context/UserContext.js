import React, { createContext, useState, useEffect } from "react";
import Axios from "axios";
import storage from "local-storage-fallback";

export const UserContext = createContext();

function UserContextProvider(props) {
  const [user, setUser] = useState({});
  useEffect(() => {
    let savedUser = storage.getItem("user");
    let parsedUser = user ? JSON.parse(savedUser) : { username: "no user" };
    setUser(parsedUser);
  }, []);
  return (
    <UserContext.Provider value={{ user, setUser }}>
      {props.children}
    </UserContext.Provider>
  );
}

export default UserContextProvider;
