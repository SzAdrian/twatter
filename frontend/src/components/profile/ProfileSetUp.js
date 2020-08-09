import React from "react";
import styled from "styled-components";

const ProfileSetUpStyle = styled.div`
    
    height: 390px;
    display: grid;
    grid-template-rows: 200px 145px 45px;
    grid-template-areas:  'top'
                          'middle'
                          'bottom';
    
    .top-part {
        grid-area: top;
        background-color: rgb(61, 84, 102);
    }
  
  
`


function ProfileSetUp() {

    return (
        <ProfileSetUpStyle>
            <div className="top-part"></div>
            <div className="middle-container">

            </div>

        </ProfileSetUpStyle>
    )

}

export default ProfileSetUp;