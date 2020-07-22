import React from "react";
import styled from "styled-components";
import image from "../../../gorillatwatter.png";


const WhoToFollowStyle = styled.div`
    
    background-color: rgb(25, 39, 52);
    width: 100%;
    min-height: 200px;
    border-radius: 1.5rem;
    margin-bottom: 15px;
    
    .who-to-follow-title {
        font-size: 2rem;
        color: white;
        font-weight: 900;
        width: 100%;
        height: 45px;
        padding: 10px 15px;
        border-bottom: 1px solid rgb(56, 68, 77);
    }
    
    .who-to-follow-items {
        position: relative;
        display: grid;
        grid-template-columns: 1fr 5fr;
        padding: 10px 15px;
        border-bottom: 1px solid rgb(56, 68, 77);
        transition: background-color .24s ease;
        cursor: pointer;
    }
    
    .who-to-follow-items:hover {
         background-color: rgba(125,134,146,0.2);
    }
   
    
    
    .who-to-follow-items img {
        width: 50px;
        background-color: white;
        border-radius: 3rem;
    }


    .who-to-follow-items-content {
        margin-left: 10px;
    }
    
    .who-to-follow-item-names {
        display: flex;
        flex-direction: row;
        color: white;
        font-size: 1.5rem;
        font-weight: 700;
    }
    
    .who-to-follow-item-tags {
        color: rgb(136, 153, 166);
        font-size: 1.3rem;
    }
    
    .follow-button {
        position: absolute;
        top: 15px;
        right: 20px;
        background-color: rgb(0, 0, 0, 0);
        border: 1px solid rgb(29, 161, 242);
        width: 75px;
        height: 30px;
        border-radius: 3rem;
        color: rgb(29, 161, 242);
        font-size: 1.4rem;
        font-weight: 600;
        font-family: Arial,serif;
        transition: background-color .24s ease;
        cursor: pointer;
    }
    
    .follow-button:hover {
        background-color: rgba(58,92,135,0.2);
    }
    
    .show-more {
        display: flex;
        justify-content: start;
        align-items: center;
        font-size: 1.5rem;
        color: rgb(29, 161, 242);
        padding: 13px 15px;
        transition: background-color .24s ease;
        cursor: pointer;
    }
    
    .show-more:hover {
        background-color: rgba(125,134,146,0.2);
    }
`


function WhoToFollow() {

    return (
        <WhoToFollowStyle>
            <div className="who-to-follow-title">Who To follow</div>
            <div className="who-to-follow-container">
                <div className="who-to-follow-items">
                    <img src={image} alt=""/>
                    <div className="who-to-follow-items-content">
                        <div className="who-to-follow-item-names">
                            <div>Formula 1</div>
                            <i className="fas fa-check"></i>
                        </div>
                        <div className="who-to-follow-item-tags">@F1</div>
                    </div>
                    <button className="follow-button"> Follow</button>
                </div>
                <div className="who-to-follow-items">
                    <img src={image} alt=""/>
                    <div className="who-to-follow-items-content">
                        <div className="who-to-follow-item-names">
                            <div>PC Gamer</div>
                            <i className="fas fa-check"></i>
                        </div>
                        <div className="who-to-follow-item-tags">@pcgamer</div>
                    </div>
                    <button className="follow-button"> Follow</button>
                </div>
            </div>
            <div className="show-more">Show more</div>


        </WhoToFollowStyle>
    )

}

export default WhoToFollow;
