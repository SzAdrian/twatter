import React from "react";
import styled from "styled-components";
import WhoToFollow from "../main-page/right-side-bar/WhoToFollow";
import ProfileSetUp from "./ProfileSetUp";

const ProfileMidlebarStyle = styled.div`
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
        align-items: center;
        padding-left: 60px;
        padding-right: 15px;
        width: inherit;
        height: 53px;
        border-bottom: 1px solid rgb(56, 68, 77);
    }
    
    .arrow {
        color: rgb(29, 161, 242);
        position: absolute;
        left: 20px;
        top: 50%;
        transform: translateY(-50%);
        font-size: 2rem;
        transition: background-color .24s ease;
        padding: 5px;
        border-radius: 50%;
        :hover {
            background-color: rgba(58,92,135,0.2);
        }
    }
    
    
    .user-name {
        color: white;
        font-size: 1.4rem;
        font-weight: 800;
    }
    
    .user-tweet-counter {
        color: rgb(136, 153, 166);
        font-size: 1.2rem;
    }
    
    
    
    
`

function ProfileMidlebar() {

    return (
        <ProfileMidlebarStyle>
            <div className="home-bar">
                <div className="arrow"><i className="fas fa-arrow-left"></i></div>
                <div className="home-bar-content">
                    <div className="user-name">UserName</div>
                    <div className="user-tweet-counter">0 Tweets</div>
                </div>
            </div>
            <ProfileSetUp />
            <WhoToFollow />

        </ProfileMidlebarStyle>
    )

}

export default ProfileMidlebar;