import React from 'react';

import {Col, Container, Row} from "react-bootstrap";
import MailSender from "./components/MailSender";


function App() {

  const marginTop = {
    marginTop: "20px"
  };

  return (
      <Container>
        <Row>
          <Col lg={12} style={marginTop}>
    <MailSender/>
          </Col>
        </Row>
      </Container>
  );

}

export default App;
