import React from "react";
import styled from "styled-components";
import {Link} from "react-router-dom";


const SidebarFooterStyle = styled.div`
    
    
    
    width: 100%;
    height: 50px;
    display: flex;
    flex-direction: row;
    font-size: 1.3rem;
    justify-content: start;
    flex-wrap: wrap;
    padding: 0 15px;
    
    a {
        text-decoration: none;
        color: rgb(136, 153, 166);
        margin: 0 5px;
        outline: none;

    }
    
    a:hover {
        text-decoration: underline;
    }
    
    .more-button {
        display: flex;
        flex-direction: row;
        align-items: center;
        cursor: pointer;
        height: 19px;
        margin: 0 5px;
    }
    
    .more-button button {
        background-color: rgb(0, 0, 0, 0);
        border: none;
        height: 19px;
        color: rgb(136, 153, 166);
        outline: none;
    }
    
    .more-button button:hover {
        text-decoration: underline;
        cursor: pointer;
    }

    .more-button i {
        color: rgb(136, 153, 166);
    }
    
    .twatteroo {
       color: rgb(136, 153, 166);
    }

`


function SidebarFooter() {

    return (
        <SidebarFooterStyle>
            <Link>Terms</Link>
            <Link>Privacy Policy</Link>
            <Link>Cookies</Link>
            <Link>Ads info</Link>
            <div className="more-button">
                <button>More</button>
                <i className="fas fa-chevron-down"></i>
            </div>
            <div className="twatteroo">@ 2020 Twatter Inc.</div>

        </SidebarFooterStyle>
    )

}

export default SidebarFooter;
