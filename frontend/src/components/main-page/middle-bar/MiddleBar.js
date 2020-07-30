import React from "react";
import styled from "styled-components";
import NewTweet from "../Tweet/NewTweet";

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
        <div className="stars-button">
          <svg viewBox="0 0 24 24">
            <g>
              <path d="M22.772 10.506l-5.618-2.192-2.16-6.5c-.102-.307-.39-.514-.712-.514s-.61.207-.712.513l-2.16 6.5-5.62 2.192c-.287.112-.477.39-.477.7s.19.585.478.698l5.62 2.192 2.16 6.5c.102.306.39.513.712.513s.61-.207.712-.513l2.16-6.5 5.62-2.192c.287-.112.477-.39.477-.7s-.19-.585-.478-.697zm-6.49 2.32c-.208.08-.37.25-.44.46l-1.56 4.695-1.56-4.693c-.07-.21-.23-.38-.438-.462l-4.155-1.62 4.154-1.622c.208-.08.37-.25.44-.462l1.56-4.693 1.56 4.694c.07.212.23.382.438.463l4.155 1.62-4.155 1.622zM6.663 3.812h-1.88V2.05c0-.414-.337-.75-.75-.75s-.75.336-.75.75v1.762H1.5c-.414 0-.75.336-.75.75s.336.75.75.75h1.782v1.762c0 .414.336.75.75.75s.75-.336.75-.75V5.312h1.88c.415 0 .75-.336.75-.75s-.335-.75-.75-.75zm2.535 15.622h-1.1v-1.016c0-.414-.335-.75-.75-.75s-.75.336-.75.75v1.016H5.57c-.414 0-.75.336-.75.75s.336.75.75.75H6.6v1.016c0 .414.335.75.75.75s.75-.336.75-.75v-1.016h1.098c.414 0 .75-.336.75-.75s-.336-.75-.75-.75z"></path>
            </g>
          </svg>
        </div>
      </div>
      <div className="middle-bar-container">
        <NewTweet />
        <div className="csiik"></div>
      </div>
    </MiddleBarStyle>
  );
}

export default MiddleBar;
