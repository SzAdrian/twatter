import React, { useState, useEffect } from "react";
import styled from "styled-components";

let TextInput = styled.input`
  margin: 5px;
  font-size: 19px;

  background-color: rgba(0, 0, 0, 0);
  width: 100%;
  height: 20px;
  outline: none;
  color: var(--foreground);

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
    color: var(--secondary);
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
  background-color: var(--offSetBackground);
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
    border-bottom-color: var(--secondary);
  }
`;

let Counter = styled.div`
  float: right;
`;

let FieldBody = styled.div``;

let InputContainer = styled.div``;
export default function InputField(props) {
  let isCounter = props.withCounter || false;
  let maxCounter = props.maxCount || 50;

  const [value, setValue] = useState("");

  let { label, type, name } = props;
  return (
    <Field>
      <Label>
        <div>
          <span>{label}</span>
        </div>
        <FieldBody>
          <InputContainer>
            <TextInput
              ref={props.refi}
              maxLength={maxCounter}
              type={type}
              name={name}
              value={value}
              onChange={(e) => {
                setValue(e.target.value);
              }}
            />
          </InputContainer>
          {isCounter && (
            <Counter>
              {value.length}/{maxCounter}
            </Counter>
          )}
        </FieldBody>
      </Label>
    </Field>
  );
}
