import React from "react";
import styled from "styled-components";
import LeftSideBar from "../main-page/Left-side-bar/LeftSideBar";
import ProfileMidlebar from "./ProfileMidlebar";
import ProfileRightSideBar from "./ProfileRightSideBar";

const ProfileStyle = styled.div`
  
    width: 1225px;
    height: 100vh;
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    display: grid;
    grid-template-columns: 275px 600px 350px;
    grid-template-areas: 'leftBar middleBar rightBar';
    
    
    @media screen and (max-width: 1100px) {
        grid-template-columns: 275px 600px 290px;
    }
    
     @media screen and (max-width: 1000px) {
        grid-template-columns: 275px 600px;
        grid-template-areas: 'leftBar middleBar';
    }
  
`

function Profile() {

    return (
        <ProfileStyle>
            <LeftSideBar />
            <ProfileMidlebar />
            <ProfileRightSideBar />

        </ProfileStyle>
    )

}

export default Profile;