import React from "react";
import styled from "styled-components";
import NewTweet from "../Tweet/NewTweet";
import Twt from "../Tweet/Twt";
import icons from "../../shared/icons";

const MiddleBarStyle = styled.div`
  grid-area: middleBar;
  display: flex;
  flex-direction: column;
  position: relative;
  border-style: solid;
  width: 100%;
  border-width: 0 1.5px;
  border-color: rgb(37, 51, 65);

  .home-bar {
    position: sticky;
    top: 0;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    padding-left: 15px;
    padding-right: 15px;
    width: inherit;
    height: 53px;
    border-bottom: 1px solid rgb(56, 68, 77);
  }

  .home-button {
    font-size: 2rem;
    font-weight: 800;
  }
  .stars-button {
    line-height: 1;
    border-radius: 50%;
    padding: 8px;
  }
  .stars-button svg {
    fill: var(--secondary);
    font-size: 3rem;

    height: 22px;
  }
  .stars-button:hover {
    background-color: var(--secondaryTransparent);
  }
  .middle-bar-container {
    position: relative;
    top: 54px;
  }

  .csiik {
    width: 100%;
    height: 10px;
    background-color: rgb(56, 68, 77);
  }
`;

function MiddleBar() {
  return (
    <MiddleBarStyle>
      <div className="home-bar">
        <div className="home-button">Home</div>
        <div className="stars-button">{icons.stars}</div>
      </div>
      <div className="middle-bar-container">
        <NewTweet />
        <div className="csiik"></div>
        <Twt />
      </div>
    </MiddleBarStyle>
  );
}

export default MiddleBar;
