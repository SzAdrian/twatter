import React from "react";
import styled from "styled-components";
import profilepic from "../../shared/defaultprofilepic.jpg";
import icons from "../../shared/icons";

const TwtStyle = styled.div`
  font-size: 1.8rem;
  cursor: pointer;

  img {
    height: 40px;
    width: 40px;
    border-radius: 60%;
  }

  :hover {
    background-color: rgba(50, 130, 242, 0.1);
    transition: 0.24s;
  }
`;

const TweetHeaderStyle = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 10px 10px 10px 10px;
`;

const TweetBodyStyle = styled.div`
  display: flex;
  padding: 0px 10px 10px 10px;
`;

const TweetFooterStyle = styled.div`
  display: flex;
  justify-content: space-evenly;
  border-bottom: 1px solid rgb(56, 68, 77);
  div{
      width: 25px;
      height: 25px;
  }
`;

export default function tweet() {
  return (
    <TwtStyle>
      <TweetHeaderStyle>
        <div>
          <img src={profilepic} alt="" />
          Username @Username | Date
        </div>
        <div>Arrow Icon</div>
      </TweetHeaderStyle>
      <TweetBodyStyle>
        Lorem ipsum dolor sit amet, sed do eiusmod videus chatum incididunt ut
        labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu
        tortor lowlightena capturum nulla. Eget blurtutate bokehus at tellus at
        urna condimentum mattis pellentesque.
      </TweetBodyStyle>
      <TweetFooterStyle>
        <div>{icons.replies}</div>
        <div>{icons.retweets}</div>
        <div>{icons.likes}</div>
        <div>{icons.shareTweet}</div>
      </TweetFooterStyle>
    </TwtStyle>
  );
}
