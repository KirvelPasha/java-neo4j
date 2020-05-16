import React from 'react';
import axios from 'axios';

import {Button, Form} from "react-bootstrap";


class MailResetSender extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            correctMail: '',
            wrongMail: ''
        }
    }

    handleCorrectMailChange = e => {
        this.setState({
            correctMail: e.target.value
        })
    };

    handleWrongMailChange = e => {
        this.setState({
            wrongMail: e.target.value
        })
    };

    handleSubmit = e => {
        e.preventDefault();
        let mailUrl = 'http://localhost:8082/mails/reset?correctMail=' + this.state.correctMail + '&wrongMail=' + this.state.wrongMail;
        axios.get(mailUrl);
    };

    render() {
        return(
            <Form className="joinForm" onSubmit={this.handleSubmit}>
                <Form.Group controlId="formGroupCorrectEmail">
                    <Form.Label className="text-black">Correct email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter correct email" name="correctMail" autoComplete="off"
                                  onChange={this.handleCorrectMailChange}/>
                </Form.Group>
                <Form.Group controlId="formGroupWrongEmail">
                    <Form.Label className="text-black">Wrong email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter wrong email" name="wrongMail" autoComplete="off"
                                  onChange={this.handleWrongMailChange}/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Reset
                </Button>
            </Form>
        );
    }
}

export default MailResetSender;