import React from "react";
import styled from "styled-components";
import LeftSideBar from "./Left-side-bar/LeftSideBar";
import MiddleBar from "./middle-bar/MiddleBar";
import RightSideBar from "./right-side-bar/RightSideBar";

const MainPageStyle = styled.div`

    width: 1200px;
    height: 100vh;
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    display: grid;
    grid-template-columns: 275px 660px 350px;
    grid-template-areas: 'leftBar middleBar rightBar' ;
    
    
    
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
