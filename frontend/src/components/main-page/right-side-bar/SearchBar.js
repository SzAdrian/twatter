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
    font-size: 1.5rem;
    font-weight: 100;
    font-family: Arial, serif;
    background-color: rgb(0, 0, 0, 0);
    border: none;
    width: 100%;
    height: 100%;
    color: white;
    outline: none;
  }
  .search-input::placeholder {
    color: rgb(175, 175, 175);
  }

  svg {
    padding-left: 15px;
    padding-right: 15px;
    height: 23px;
    fill: rgb(175, 175, 175);
  }
`;

function SearchBar() {
  const inputFocus = (e) => {
    console.log(e.target);
  };

  return (
    <SearchBarStyle>
      <svg viewBox="0 0 24 24">
        <g>
          <path d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z"></path>
        </g>
      </svg>
      <input
        onFocus={inputFocus}
        className="search-input"
        type="text"
        placeholder="Search Twatter"
      />
    </SearchBarStyle>
  );
}

export default SearchBar;
