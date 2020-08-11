import React, { useState } from "react";
import logo from "./gorillatwatter.png";
import styled, { ThemeConsumer } from "styled-components";

export default function TwatterLogo(props) {
  const [mode, setMode] = useState(null);
  let { width, height } = props;

  let TwatterLogoFilter = styled.img``;
  return (
    <ThemeConsumer>
      {(theme) => (
        <TwatterLogoFilter
          style={{
            filter: `${
              theme.mode == "light"
                ? "brightness(-1) invert(1)"
                : "brightness(0) invert(1)"
            }`,
          }}
          src={logo}
          width={width}
          height={height}
        />
      )}
    </ThemeConsumer>
  );
}
