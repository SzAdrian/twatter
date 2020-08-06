import React from "react";
import styled from "styled-components";
import ChangeMode from "../../Theming/ChangeMode";
import MainPage from "../MainPage";
import {Link} from "react-router-dom";

const DisplayModalStyled = styled.div`
    
    position: fixed;
    z-index: 50;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 600px;
    height: 660px;
    background-color: var(--background);
    border-radius: 4rem;
    display: grid;
    grid-template-rows: 3fr 1fr 2fr 2fr 1fr ;
    padding: 2rem;
    
    .modes {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
        background-color: var(--offSetBackground);
        border-radius: 2rem;
        padding: 2rem;
    }
    
    .modes div {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 73px;
        margin: 1.5rem;
        
    }
    .dim div {
        color: white;
        background-color: rgb(21, 32, 43);
        
    }
    .light div {
        color: black;
        background-color: white;
        
    }
    .black div {
        color: white;
        background-color: black;
        
    }

    .button-div {
        display: flex;
        align-items: center;
        justify-content: center;
        
    }
    
    .button-div a {
        color: white;
        font-size: 1.4rem;
        font-weight: 900;
        text-decoration: none;
        background-color: var(--secondary);
        border: none;
        border-radius: 3rem;
        padding: 10px;
        transition: opacity .25s ease;
        :hover {
            opacity: .8;
        }
    }

`

function DisplayModal() {

    return (
        <>
            <MainPage />
            <DisplayModalStyled>
                <div className="Custom-text">

                </div>
                <div className="font-sizes"></div>
                <div className="secondaries"></div>
                <div className="modes">
                    <div className="dim"><ChangeMode  label="dim" mode="dim"/></div>
                    <div className="light"><ChangeMode label="light" mode="light"/></div>
                    <div className="black"><ChangeMode label="black" mode="black"/></div>
                </div>
                <div className="button-div">
                    <Link to="/home">
                        Done
                    </Link>
                </div>
            </DisplayModalStyled>
        </>
    )
}

export default DisplayModal;