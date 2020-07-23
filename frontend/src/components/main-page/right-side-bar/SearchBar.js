import React from "react";
import styled from "styled-components";

const SearchBarStyle = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 42px;
    background-color: rgb(37, 51, 65);
    border-radius: 2rem;
    margin: 5px 5px 15px 0;

    i {
        color: rgb(136, 153, 166);
        font-size: 25px;
        height: 25px;
        margin: 17px;
        
    }
    
    .search-input {
        font-size: 1.7rem;
        font-weight: 100;
        font-family: Arial,serif;
        background-color: rgb(0, 0, 0, 0);
        border: none;
        width: 100%;
        height: 100%;
        color: rgb(136, 153, 166);
        outline: none;
    }

`


function SearchBar() {

    const inputFocus = e => {
        console.log(e.target)
    }

    return (
        <SearchBarStyle>
            <i className="fas fa-search"></i>
            <input onFocus={inputFocus} className="search-input" type="text" placeholder="Search Twatter"/>
        </SearchBarStyle>
    )

}

export default SearchBar;
