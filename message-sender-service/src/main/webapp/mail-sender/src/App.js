import React from 'react';

import {Col, Container, Row} from "react-bootstrap";
import HideBlock from "./components/HideBlock";


function App() {

  const marginTop = {
    marginTop: "20px"
  };

  return (
      <Container>
        <Row>
          <Col lg={12} style={marginTop}>
              <HideBlock/>
          </Col>
        </Row>
      </Container>
  );

}

export default App;
