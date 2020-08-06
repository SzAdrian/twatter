import React from "react";
import theme from "styled-theming";
import styled, { ThemeConsumer } from "styled-components";

export default function ChangeSecondary(props) {
  const getSecondary = (color) => {
    switch (color) {
      case "blue":
        return "rgb(29,161,242)";
      case "yellow":
        return "rgb(255, 173, 31)";
      case "pink":
        return "rgb(224, 36, 94)";
      case "purple":
        return "rgb(121, 75, 196)";
      case "orange":
        return "rgb(244, 93, 34)";
      case "green":
        return "rgb(23, 191, 99)";
    }
  };
  let ChangeColor = styled.div`
    background-color: ${getSecondary(props.secondary)};

    :hover {
      cursor: pointer;
    }
  `;
  return (
    <ThemeConsumer>
      {(theme) => (
        <ChangeColor
          onClick={(e) =>
            theme.setTheme({ ...theme, secondary: props.secondary })
          }
        ></ChangeColor>
      )}
    </ThemeConsumer>
  );
}
