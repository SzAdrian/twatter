import React from "react";
import styled from "styled-components";
import icons from "../../shared/icons";
const TrendsForYouStyle = styled.div`
  background-color: var(--offSetBackground);
  width: 100%;
  min-height: 200px;
  border-radius: 1.5rem;
  margin-bottom: 15px;

  .trend-title-container {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    height: 45px;
    padding: 10px 15px;
    border-bottom: 1px solid rgb(56, 68, 77);
  }

  .trend-title-name {
    font-size: 2rem;
    font-weight: 900;
  }

  .trend-title-container i {
    font-size: 2rem;
    color: rgb(29, 161, 242);
    padding: 5px 10px;
    border-radius: 5rem;
    cursor: pointer;
  }

  .trend-title-container i:hover {
    background-color: rgba(68, 110, 163, 0.2);
  }

  .trend-items {
    position: relative;
    padding: 10px 15px;
    border-bottom: 1px solid rgb(56, 68, 77);
    transition: background-color 0.25s ease;
    cursor: pointer;
  }

  .trend-items:hover {
    background-color: rgba(125, 134, 146, 0.2);
  }

  .trend-items i {
    position: absolute;
    top: 7px;
    right: 10px;
    font-size: 1.4rem;
    color: rgb(136, 153, 166);
    padding: 8px;
    border-radius: 3rem;
    transition: background-color 0.24s ease;
    cursor: pointer;
  }

  .trend-items i:hover {
    background-color: var(--secondaryTransparent);
  }

  .trend-types {
    color: rgb(136, 153, 166);
    font-size: 1.3rem;
  }

  .trend-titles {
    font-size: 1.5rem;
    font-weight: 700;
  }

  .trend-tweet-numbers {
    color: rgb(136, 153, 166);
    font-size: 1.2rem;
    padding-top: 10px;
  }

  .show-more {
    display: flex;
    justify-content: start;
    align-items: center;
    font-size: 1.5rem;
    color: var(--secondary);
    padding: 13px 15px;
    transition: background-color 0.24s ease;
    cursor: pointer;
    border-bottom-left-radius: 1.5rem;
    border-bottom-right-radius: 1.5rem;
  }
  .show-more:hover {
    background-color: rgba(125, 134, 146, 0.2);
  }

  .settings svg {
    transition: background-color 0.24s ease;

    height: 33px;
    fill: var(--secondary);
    border-radius: 50%;
    padding: 5px;
    cursor: pointer;
  }

  .settings:hover svg {
    background-color: var(--secondaryTransparent);
  }
`;

function TrendsForYou() {
  return (
    <TrendsForYouStyle>
      <div className="trend-title-container">
        <div className="trend-title-name">Trend for you</div>
        <span className="settings">{icons.settings}</span>
      </div>
      <div className="trend-container">
        <div className="trend-items">
          <div className="trend-types">Trending in Hungary</div>
          <i className="fas fa-chevron-down"></i>
          <div className="trend-titles">Magyarország</div>
          <div className="trend-tweet-numbers">8,012 Tweets</div>
        </div>
        <div className="trend-items">
          <div className="trend-types">Trending in Hungary</div>
          <i className="fas fa-chevron-down"></i>
          <div className="trend-titles">Budapest</div>
          <div className="trend-tweet-numbers">266k Tweets</div>
        </div>
        <div className="trend-items">
          <div className="trend-types">Trending in Hungary</div>
          <i className="fas fa-chevron-down"></i>
          <div className="trend-titles">Köszi</div>
          <div className="trend-tweet-numbers">81,012 Tweets</div>
        </div>
      </div>
      <div className="show-more">Show more</div>
    </TrendsForYouStyle>
  );
}

export default TrendsForYou;