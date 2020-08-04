import React from "react";
import styled from "styled-components";
import NewTweet from "../Tweet/NewTweet";
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
    color: dodgerblue;
    font-size: 3rem;
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
  svg {
    padding-left: 15px;

    height: 22px;
    fill: rgb(175, 175, 175);
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
      </div>
    </MiddleBarStyle>
  );
}

export default MiddleBar;