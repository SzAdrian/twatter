import React from "react";
import styled from "styled-components";

import profilepic from "./defaultprofilepic.jpg";

const LeftBottomPanelStyle = styled.div`
  grid-area: leftBar;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  border-radius: 28px;
  height: 50px;
  cursor: pointer;
  align-items: center;
  transition: background-color 0.24s ease;

  :hover {
    background-color: var(--secondaryTransparent);
  }

  img {
    height: 40px;
    width: 40px;
    border-radius: 60%;
  }

  svg {
    fill: white;
    height: 20px;
    width: 20px;
  }
`;

const UserNameStyle = styled.div`
  display: flex;
  flex-direction: column;
  font-weight: bold;
  color: white;
  font-size: 1.3rem;
  align-items: center;
`;

export default function LeftBottomPanel() {
  return (
    <LeftBottomPanelStyle>
      <img src={profilepic} alt="" />
      <UserNameStyle>
        <div>UserName</div>
        <div>@UserName</div>
      </UserNameStyle>
      <div>
        <svg viewBox="0 0 24 24">
          <g>
            <path d="M20.207 8.147c-.39-.39-1.023-.39-1.414 0L12 14.94 5.207 8.147c-.39-.39-1.023-.39-1.414 0-.39.39-.39 1.023 0 1.414l7.5 7.5c.195.196.45.294.707.294s.512-.098.707-.293l7.5-7.5c.39-.39.39-1.022 0-1.413z"></path>
          </g>
        </svg>
      </div>
    </LeftBottomPanelStyle>
  );
}
