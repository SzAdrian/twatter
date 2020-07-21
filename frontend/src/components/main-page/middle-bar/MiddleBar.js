import React from "react";
import styled from "styled-components";
import NewTweet from "../Tweet/NewTweet";

const MiddleBarStyle = styled.div`
    
    grid-area: middleBar;
    position: relative;

    .home-bar {
        position: fixed;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
        padding-left: 15px;
        padding-right: 15px;
        width: 100%;
        max-width: 660px;
        height: 53px;
        border-bottom: 1px solid rgb(56, 68, 77);;
        
    }
    
    .home-button {
        color: white;
        font-size: 2rem;
        font-weight: 800;
    }
    
    .stars-button {
        color: dodgerblue;
        font-size: 3rem;
    }

    .middle-bar-container {
        position: relative;
        top: 53px;
    }
    
    .csiik {
        width: 660px;
        height: 10px;
        background-color: rgb(37, 51, 65);
    }

`


function MiddleBar() {

    return (
        <MiddleBarStyle>
            <div className="home-bar">
                <div className="home-button" >Home</div>
                <div className="stars-button"><i className="fab fa-jedi-order"></i></div>
            </div>
            <div className="middle-bar-container">
                <NewTweet />
                <div className="csiik"></div>
            </div>
        </MiddleBarStyle>
    )

}

export default MiddleBar;
