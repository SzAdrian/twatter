import React from "react";
import styled from "styled-components";
import SearchBar from "./SearchBar";

const RightSideBarStyle = styled.div`

    grid-area: rightBar;
    margin-left: 20px;

`


function RightSideBar() {

    return (
        <RightSideBarStyle>
            <SearchBar />
            {/*<TreandsForYou />*/}
            {/*<WhoToFollow />*/}
            {/*<SidebarFooter />*/}
        </RightSideBarStyle>
    )

}

export default RightSideBar;
