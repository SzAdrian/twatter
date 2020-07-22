import React from "react";
import styled from "styled-components";

export default function InputField(props) {
  let TextInput = styled.input`
    margin: 5px;
    font-size: 19px;

    background-color: rgba(0, 0, 0, 0);
    width: 100%;
    height: 20px;
    outline: none;
    color: white;

    border: none;
  `;
  let Label = styled.label`
    height: 100%;
    width: 100%;
    margin: 5px;
    color: rgb(136, 153, 166);
    font: 15px system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
      Ubuntu, "Helvetica Neue", sans-serif;
    :focus-within {
      color: rgb(29, 161, 242);
    }

    text-overflow: ellipsis;
    white-space: nowrap;

    div {
      overflow: hidden;
    }
  `;

  let Field = styled.div`
    padding-bottom: 10px;
    padding-top: 10px;
    padding-left: 15px;
    padding-right: 15px;

    display: flex;

    margin-left: auto;
    margin-right: auto;
    margin-bottom: 20px;
    height: 60px;
    background-color: rgb(25, 39, 52);
    box-sizing: border-box;
    border-radius: 2px;
    /*max-width: 375px;*/

    border-bottom-width: 2px;
    border-left-width: 0;
    border-right-width: 0;
    border-top-width: 0;

    border-style: solid;
    border-bottom-color: rgb(136, 153, 166);

    border-bottom-left-radius: 2px;
    border-bottom-right-radius: 2px;

    padding: 3px;
    :focus-within {
      border-bottom-color: rgb(29, 161, 242);
    }
  `;

  let FieldBody = styled.div``;

  let InputContainer = styled.div``;

  let { label, type, name } = props;
  return (
    <Field>
      <Label>
        <div>
          <span>{label}</span>
        </div>
        <FieldBody>
          <InputContainer>
            <TextInput type={type} name={name} />
          </InputContainer>
        </FieldBody>
      </Label>
    </Field>
  );
}
