import React from "react";
import styled from "styled-components";
import image from "../../../gorillatwatter.png";


const WhoToFollowStyle = styled.div`
    
    background-color: rgb(25, 39, 52);
    width: 350px;
    height: 235px;
    border-radius: 1.5rem;
    margin-bottom: 15px;
    
    .who-to-follow-title {
        font-size: 2rem;
        color: white;
        font-weight: 900;
        width: 350px;
        height: 45px;
        padding: 10px 15px;
        border-bottom: 1px solid rgb(56, 68, 77);
    }
    
    
    
    
    .who-to-follow-items img {
        width: 40px;
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


        </WhoToFollowStyle>
    )

}

export default WhoToFollow;
