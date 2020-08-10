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
const getSearchBackground = style("mode", {
  dim: "rgb(37, 51, 65)",
  light: "rgb(230, 236, 240)",
  black: "rgb(32, 35, 39)",
});
const getSecondary = style("secondary", {
  blue: "rgb(29,161,242)",
  yellow: "rgb(255, 173, 31)",
  pink: "rgb(224, 36, 94)",
  purple: "rgb(121, 75, 196)",
  orange: "rgb(244, 93, 34)",
  green: "rgb(23, 191, 99)",
});
const getOffSetBackground = style("mode", {
  dim: "rgb(25, 39, 52)",
  light: "rgb(245, 248, 250)",
  black: "rgb(21, 24, 28)",
});
const getSecondaryHover = style("secondary", {
  blue: "rgb(29,161,242)",
  yellow: "rgb(255, 173, 31)",
  pink: "rgb(224, 36, 94)",
  purple: "rgb(121, 75, 196)",
  orange: "rgb(244, 93, 34)",
  green: "rgb(21, 172, 89)",
});
const getSecondaryTransparent = style("secondary", {
  blue: "rgba(29,161,242,0.1)",
  yellow: "rgba(255, 173, 31,0.1)",
  pink: "rgba(224, 36, 94,0.1)",
  purple: "rgba(121, 75, 196,0.1)",
  orange: "rgba(244, 93, 34,0.1)",
  green: "rgba(21, 172, 89,0.1)",
});

const GlobalStyle = createGlobalStyle`
:root {
  --secondary: ${getSecondary};
  --secondaryTransparent: ${getSecondaryTransparent};
  --foreground:${getForeground};
  --offSetBackground:${getOffSetBackground};
  --searchBackground:${getSearchBackground};
  --background:${getBackground};
}

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

    
`;

export default GlobalStyle;
