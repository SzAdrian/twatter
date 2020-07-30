import { createGlobalStyle } from "styled-components";
import style from "styled-theming";

const getBackground = style("mode", {
  light: "white",
  dim: "rgb(21, 32, 43)",
  black: "black",
});
const getForeground = style("mode", {
  dim: "white",
  light: "rgb(21, 32, 43)",
  black: "rgb(217, 217, 217)",
});

const getSecondary = style("secondary", {
  blue: "rgb(29,161,242)",
  yellow: "rgb(255, 173, 31)",
  pink: "rgb(224, 36, 94)",
  purple: "rgb(121, 75, 196)",
  orange: "rgb(244, 93, 34)",
  green: "rgb(23, 191, 99)",
});
const getSecondaryHover = style("secondary", {
  blue: "rgb(29,161,242)",
  yellow: "rgb(255, 173, 31)",
  pink: "rgb(224, 36, 94)",
  purple: "rgb(121, 75, 196)",
  orange: "rgb(244, 93, 34)",
  green: "rgb(21, 172, 89)",
});

const GlobalStyle = createGlobalStyle`
    *, *::before, *::after {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }
    
    html {
        font-size: 10px;
        font-family: "Lato", Arial, sans-serif;
    }
    
    body {
        height: 100vh;
        width: 100%;
        background-color: ${getBackground};
        color: ${getForeground};
        fill: ${getForeground};
        
    }

    .secondary-bg{
        background-color: ${getSecondary}
    }
    .secondary-bg:hover{
        background-color: ${getSecondaryHover}
    }
    
`;

export default GlobalStyle;
