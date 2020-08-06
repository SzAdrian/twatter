import React from "react";
import styled from "styled-components";
import TwatterLogo from "components/shared/TwatterLogo";
import icons from "../../shared/icons";
import { Link } from "react-router-dom";

const LeftUpperPanelStyle = styled.div`
  grid-area: leftBar;

  div {
    padding: 10px;
    border-radius: 28px;
  }

  svg {
    height: 20px;
    width: 20px;
    margin-right: 15px;
  }
`;

const MenuStyle = styled(Link)`
  padding: 10px;
  border-radius: 28px;
  text-decoration: none;
  width: max-content;
  font-weight: bold;
  color: var(--getForeground);
  fill: var(--getForeground);

  font-size: 1.8rem;
  margin: 15px;
  display: flex;
  cursor: pointer;
  align-items: center;
  :hover {
    background-color: var(--secondaryTransparent);
    fill: var(--secondary);
    color: var(--secondary);
    transition: 0.24s;
  }

  :active {
    fill: var(--secondary);
    color: var(--secondary);
  }
`;

const TweetButtonStyle = styled.div`
  font-weight: bold;
  color: white;
  font-size: 1.8rem;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
  background-color: var(--secondary);
  border-radius: 28px;
  :hover {
    transition: 0.24s;
  }
`;

export default function LeftUpperPanel() {
  return (
    <LeftUpperPanelStyle>
      <MenuStyle>
        <TwatterLogo width="28px" heigth="28px" />
      </MenuStyle>
      <MenuStyle to="/home">
        {icons.home}
        Home
      </MenuStyle>
      <MenuStyle>
        {icons.explore}
        Explore
      </MenuStyle>
      <MenuStyle>
        {icons.notifications}
        Notifications
      </MenuStyle>
      <MenuStyle>
        {icons.messages}
        Messages
      </MenuStyle>
      <MenuStyle>
        {icons.bookmarks}
        Bookmarks
      </MenuStyle>
      <MenuStyle>
        {icons.lists}
        Lists
      </MenuStyle>
      <MenuStyle to="/profile">
        {icons.profile}
        Profile
      </MenuStyle>
      <MenuStyle>
        {icons.more}
        More
      </MenuStyle>
      <TweetButtonStyle>Tweet</TweetButtonStyle>
    </LeftUpperPanelStyle>
  );
}
