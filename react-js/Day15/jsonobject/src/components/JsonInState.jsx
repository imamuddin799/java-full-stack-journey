import jsondate from './MOCK_DATA.json'
import { Fragment, useState } from "react";

const JsonInState = () => {
  let [state, setState] = useState(jsondate);
  return (
    <>
      {
        state.map((element, index) => {
          let { id, first_name, last_name, email, gender, contact } = element;
          return <Fragment key={index}>
            <h1>{id}</h1>
            <h1>{first_name}</h1>
            <h1>{last_name}</h1>
            <h1>{email}</h1>
            <h1>{gender}</h1>
            <h1>{contact}</h1>
            <hr />
          </Fragment>
        })
      }
    </>
  )
}

export default JsonInState