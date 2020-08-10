import React from "react";
import styled from "styled-components";
import SearchBar from "./SearchBar";
import TrendsForYou from "./TrendsForYou";
import WhoToFollow from "./WhoToFollow";
import SidebarFooter from "./SidebarFooter";

const RightSideBarStyle = styled.div`

    grid-area: rightBar;
    margin-left: 30px;
    
    @media screen and (max-width: 1000px) {
        display: none;
    }
    

`


function RightSideBar() {

    return (
        <RightSideBarStyle>
            <SearchBar />
            <TrendsForYou />
            <WhoToFollow title="Who to follow" />
            <SidebarFooter />
        </RightSideBarStyle>
    )

}

export default RightSideBar;
