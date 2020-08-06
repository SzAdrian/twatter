import React from "react";
import theme from "styled-theming";
import styled, { ThemeConsumer } from "styled-components";

let ChangeTheme = styled.div`
  :hover {
    cursor: pointer;
  }
`;

export default function ChangeMode(props) {
  return (
    <ThemeConsumer>
      {(theme) => (
        <ChangeTheme
          onClick={(e) => theme.setTheme({ ...theme, mode: props.mode })}
        >
          {props.label}
        </ChangeTheme>
      )}
    </ThemeConsumer>
  );
}
