import React from "react";
import styled from "styled-components";

import LeftUpperPanel from "./LeftUpperPanel";
import LeftBottomPanel from "./LeftBottomPanel";

const LeftSideBarStyle = styled.div`
  grid-area: leftBar;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;

function LeftSideBar() {
  return (
    <LeftSideBarStyle>
      <LeftUpperPanel />
      <LeftBottomPanel />
    </LeftSideBarStyle>
  );
}

export default LeftSideBar;
