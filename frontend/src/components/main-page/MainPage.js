import React from "react";
import styled from "styled-components";
import LeftSideBar from "./Left-side-bar/LeftSideBar";
import MiddleBar from "./middle-bar/MiddleBar";
import RightSideBar from "./right-side-bar/RightSideBar";
import MediaQuery from "react-responsive";

const MainPageStyle = styled.div`

    width: 1200px;
    height: 100vh;
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    display: grid;
    grid-template-columns: 275px 660px 380px;
    grid-template-areas: 'leftBar middleBar rightBar';
    
    
    @media screen and (max-width: 1100px) {
        grid-template-columns: 275px 660px 300px;
    }
    
     @media screen and (max-width: 1000px) {
        grid-template-columns: 275px 660px;
        grid-template-areas: 'leftBar middleBar';
    }
    
`


function MainPage() {

    return (
        <MainPageStyle>
            <LeftSideBar />
            <MiddleBar />
            <RightSideBar />

        </MainPageStyle>
    )

}

export default MainPage;
