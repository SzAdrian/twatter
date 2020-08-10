import React from "react";
import GlobalStyle from "./components/style-components/global/GlobalStyle";
import { BrowserRouter as Router, Route } from "react-router-dom";
import MainPage from "./components/main-page/MainPage";
import LoginPage from "./components/login/LoginPage";
import SignUp from "components/Signup/SignUpPage";
import { ThemeProvider } from "styled-components";
import Profile from "./components/profile/Profile";
import useTheme from "./components/hooks/useTheme";
import PrivateRoute from "components/PrivateRoute";
import AuthContextProvider from "./components/Context/AuthContext";
import UserContextProvider from "components/Context/UserContext";
import ChangeMode from "./components/Theming/ChangeMode";
import DisplayModal from "./components/main-page/Left-side-bar/DisplayModal";

function App() {
  const theme = useTheme();

  return (
    <ThemeProvider theme={theme}>
      <AuthContextProvider>
        <UserContextProvider>
          <GlobalStyle />
          <Router>
            <div className="App">
              <PrivateRoute exact path={["/home", "/"]} component={MainPage} />
              <Route exact path="/login" component={LoginPage} />
              <Route exact path="/signup" component={SignUp} />
              <Route exact path="/profile" component={Profile} />
              <Route exact path="/i/display" component={DisplayModal} />
            </div>
          </Router>
        </UserContextProvider>
      </AuthContextProvider>
    </ThemeProvider>
  );
}

export default App;
