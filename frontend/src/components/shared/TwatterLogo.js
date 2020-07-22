import React from "react";
import logo from "./gorillatwatter.png";
import styled from "styled-components";

function TwatterLogo(props) {
  let { width, height } = props;

  let TwatterLogoFilter = styled.img`
    filter: brightness(0) invert(1);
  `;

  return <TwatterLogoFilter src={logo} width={width} height={height} />;
}

export default TwatterLogo;
