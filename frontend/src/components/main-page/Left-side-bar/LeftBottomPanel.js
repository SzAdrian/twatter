import React, { useContext } from "react";
import styled from "styled-components";

import profilepic from "./defaultprofilepic.jpg";
import { UserContext } from "components/Context/UserContext";
import icons from "components/shared/icons";
import { AuthContext } from "components/Context/AuthContext";

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
  font-weight: 700;
  font-size: 1.3rem;
  align-items: center;
  .email {
      color: rgb(136, 153, 166);
      font-weight: 500;
  }
`;

const Logout = styled.div`
  svg {
    fill: var(--foreground);
  }
  padding: 9px;
  border-radius: 50%;
  :hover {
    background-color: var(--secondaryTransparent);
  }
`;

export default function LeftBottomPanel() {
  const { user } = useContext(UserContext);
  const { logout } = useContext(AuthContext);
  return (
    <LeftBottomPanelStyle>
      <img src={profilepic} alt="" />
      <UserNameStyle>
        <div>{user.username}</div>
        <div className="email">@{user.username}</div>
      </UserNameStyle>
      <Logout onClick={logout}>{icons.logout}</Logout>
    </LeftBottomPanelStyle>
  );
}
