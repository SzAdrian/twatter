import React from "react";
import GlobalStyle from "./components/style-components/global/GlobalStyle";
import { BrowserRouter as Router, Route } from "react-router-dom";
import MainPage from "./components/main-page/MainPage";
import LoginPage from "./components/login/LoginPage";
import SignUp from "components/Signup/SignUpPage";
import Profile from "./components/profile/Profile";

function App() {
  return (
    <div className="App">
      <GlobalStyle />

      <Router>
        <Route exact path="/" component={MainPage} />
        <Route exact path="/login" component={LoginPage} />
        <Route exact path="/signup" component={SignUp} />
        <Route exact path="/profile" component={Profile} />
      </Router>
    </div>
  );
}

export default App;
