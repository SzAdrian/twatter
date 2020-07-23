import React from "react";
import styled from "styled-components";

const NewTweetStyle = styled.div`


    
    width: 100%px;
    height: 100px;
    input {
        background-color: rgb(21, 32, 43);
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