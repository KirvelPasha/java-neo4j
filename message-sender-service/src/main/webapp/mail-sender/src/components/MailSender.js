import React from 'react';
import axios from 'axios';

import {Button, Form} from "react-bootstrap";


class MailSender extends React.Component {
    MAIL_SENDER_API_URL = 'http://localhost:8082/mails?';

    constructor(props) {
        super(props);
        this.state = {
            mail: '',
            mark: ''
        }
    }

    handleChange = e => {
        this.setState({
            mail: e.target.value,
            mark: e.target.value,
        })
    };

    handleSubmit = e => {
        e.preventDefault();
        console.log(this.state);
        axios.get(this.MAIL_SENDER_API_URL);
    };

    render() {
        return(
            <Form className="joinForm" onSubmit={this.handleSubmit}>
                <Form.Group controlId="formGroupEmail">
                    <Form.Label className="text-white">Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" name="email" autoComplete="off"
                                  onChange={this.handleChange}/>
                </Form.Group>
                <Form.Group controlId="formGroupMark">
                    <Form.Label className="text-white">Mark</Form.Label>
                    <Form.Control type="name" placeholder="Enter mark" name="mark" autoComplete="off"
                                  onChange={this.handleChange}/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Get
                </Button>
            </Form>
        );
    }

}

export default MailSender;