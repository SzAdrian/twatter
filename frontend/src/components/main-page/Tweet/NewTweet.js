import React from "react";
import styled from "styled-components";

const NewTweetStyle = styled.div`


    
    width: 100%;
    height: 100px;
    input {
        background-color: var(--background);
        color: white;
        border: 0;
        width: 500px;
        font-size: 2.5rem;
    }

`


function NewTweet() {

    return (
        <NewTweetStyle>
            <input type="text" placeholder="What's happening"/>
        </NewTweetStyle>

    )

}

export default NewTweet;