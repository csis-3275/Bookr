import React, { Component } from 'react';
import { Form, InputGroup, Button, Col } from 'react-bootstrap';

class Register extends Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = { 
            firstname: "", 
            lastname: "", 
            email: "", 
            role: 3
         }
    }

    handleChange(e){
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    handleSubmit(e){
        e.preventDefault();
        const new_user = {
            firstname: this.state.firstname, 
            lastname: this.state.lastname, 
            email: this.state.email, 
            role: this.state.role
        };
        console.log(new_user);
    }

    render() { 
        

        return ( 
            // <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <Form noValidate onSubmit={this.onSubmit}>
                <Form.Row>
                    <Form.Group as={Col} md="4" controlId="validationCustom01">
                        <Form.Label>First name</Form.Label>
                        <Form.Control
                            required
                            type="text"
                            placeholder="First name"
                            value={this.state.firstname}
                            onChange={this.handleChange}
                            name="firstname"
                        />
                        <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group as={Col} md="4" controlId="validationCustom02">
                        <Form.Label>Last name</Form.Label>
                        <Form.Control
                            required
                            type="text"
                            placeholder="Last name"
                            value={this.state.lastname}
                            onChange={this.handleChange}
                            name="lastname"
                        />
                        <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group as={Col} md="4" controlId="validationCustomUsername">
                        <Form.Label>Username</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                            type="email"
                            placeholder="Email"
                            aria-describedby="inputGroupPrepend"
                            value={this.state.email}
                            onChange={this.handleChange}
                            name="email"
                            required
                            />
                            <Form.Control.Feedback type="invalid">
                                Please enter your email address.
                            </Form.Control.Feedback>
                        </InputGroup>
                    </Form.Group>
                </Form.Row>
                <Button type="submit" className="py-2 px-5">Register</Button>
            </Form>
         );
    }
}
 
export default Register;