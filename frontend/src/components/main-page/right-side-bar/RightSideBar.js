import React from "react";
import styled from "styled-components";
import SearchBar from "./SearchBar";
import TrendsForYou from "./TrendsForYou";
import WhoToFollow from "./WhoToFollow";
import SidebarFooter from "./SidebarFooter";

const RightSideBarStyle = styled.div`

    grid-area: rightBar;
    margin-left: 20px;

`


function RightSideBar() {

    return (
        <RightSideBarStyle>
            <SearchBar />
            <TrendsForYou />
            <WhoToFollow />
            <SidebarFooter />
        </RightSideBarStyle>
    )

}

export default RightSideBar;
