import React from "react";
import styled from "styled-components";
import SearchBar from "../main-page/right-side-bar/SearchBar";
import TrendsForYou from "../main-page/right-side-bar/TrendsForYou";
import WhoToFollow from "../main-page/right-side-bar/WhoToFollow";
import SidebarFooter from "../main-page/right-side-bar/SidebarFooter";

const ProfileRightSideBarStyle = styled.div`

    grid-area: rightBar;
    margin-left: 30px;
    
    @media screen and (max-width: 1000px) {
        display: none;
    }
    

`


function ProfileRightSideBar() {

    return (
        <ProfileRightSideBarStyle>
            <SearchBar />
            <WhoToFollow title="You might like" />
            <TrendsForYou />
            <SidebarFooter />
        </ProfileRightSideBarStyle>
    )

}

export default ProfileRightSideBar;
