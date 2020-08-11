import React from "react";
import styled from "styled-components";
import profilepic from "../../shared/defaultprofilepic.jpg";

const NewTweetStyle = styled.div`
  
    width: inherit;
    height: 100px;
    display: grid;
    grid-template-columns: 50px 1fr;
    padding: 0 10px;
    
    .tweet-user-picture {
        position: relative;
    }
    
    .user-picture {
        position: absolute;
        top: 0;
        height: 40px;
        width: 40px;
        border-radius: 60%;
    }
    
    .tweet-container {
        width: 100%;
    }
    
    input {
        outline: none;
        background-color: var(--background);
        color: rgb(136, 153, 166);
        border: 0;
        resize: horizontal;
        width: 100%;
        height: 50px;
        font-weight: 300;
        font-size: 2.2rem;
    }
    
    .tweet-buttons-container {
        height: 50px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
    }
    
    .tweet-button-placeholders {
        height: 25px;
        width: 25px;
        border-radius: 60%;
        margin: 0 12px 0 0;
    }
    
    .tweet-submit-button {
        width: 73px;
        height: 35px;
        font-weight: 600;
        color: white;
        font-size: 1.6rem;
        display: flex;
        cursor: pointer;
        justify-content: center;
        align-items: center;
        background-color: var(--secondary);
        border: none;
        border-radius: 28px;
    }

`


function NewTweet() {

    return (
        <NewTweetStyle>
            <div className="tweet-user-picture">
                <img className="user-picture" src={profilepic} alt="" />
            </div>
            <div className="tweet-container">
                <input type="text" placeholder="What's happening"/>
                <div className="tweet-buttons-container">
                    <div className="tweet-buttons">
                        <img className="tweet-button-placeholders" src={profilepic} alt="" />
                        <img className="tweet-button-placeholders" src={profilepic} alt="" />
                        <img className="tweet-button-placeholders" src={profilepic} alt="" />
                        <img className="tweet-button-placeholders" src={profilepic} alt="" />
                        <img className="tweet-button-placeholders" src={profilepic} alt="" />
                    </div>
                    <button className="tweet-submit-button">Tweet</button>
                </div>
            </div>

        </NewTweetStyle>

    )

}

export default NewTweet;