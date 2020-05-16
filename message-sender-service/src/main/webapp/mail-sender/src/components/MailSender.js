import React from 'react';
import axios from 'axios';

import {Button, Form} from "react-bootstrap";


class MailSender extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            mail: '',
            mark: ''
        }
    }

    handleMailChange = e => {
        this.setState({
            mail: e.target.value
        })
    };

    handleMarkChange = e => {
        this.setState({
            mark: e.target.value
        })
    };

    handleSubmit = e => {
        e.preventDefault();
        let mailUrl = 'http://localhost:8082/mails?mail=' + this.state.mail + '&mark=' + this.state.mark;
        axios.get(mailUrl);
    };

    render() {
        return(
            <Form className="joinForm" onSubmit={this.handleSubmit}>
                <Form.Group controlId="formGroupEmail">
                    <Form.Label className="text-black">Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" name="email" autoComplete="off"
                                  onChange={this.handleMailChange}/>
                </Form.Group>
                <Form.Group controlId="formGroupMark">
                    <Form.Label className="text-black">Mark</Form.Label>
                    <Form.Control type="name" placeholder="Enter mark" name="mark" autoComplete="off"
                                  onChange={this.handleMarkChange}/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Get
                </Button>
            </Form>
        );
    }
}

export default MailSender;