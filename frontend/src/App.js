import React from 'react';
import GlobalStyle from "./components/style-components/global/GlobalStyle";
import {BrowserRouter as Router, Route} from "react-router-dom"
import MainPage from "./components/main-page/MainPage";

function App() {
    return (
        <div className="App">
            <GlobalStyle />

                <Router>
                    <Route exact path="/" component={MainPage} />
                </Router>

        </div>
    );
}

export default App;
