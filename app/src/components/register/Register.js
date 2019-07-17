import React, { Component } from 'react';
import { Form, InputGroup, Button, Col } from 'react-bootstrap';
import { faUser, faKey } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import './styles/register.css';

class Register extends Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = { 
            firstname: "", 
            lastname: "", 
            email: "",
            reg_password: "",  
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
            role: this.state.role, 
            reg_password: this.state.reg_password
        };
        console.log(new_user);
    }

    render() { 
        

        return ( 
            // <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <Form noValidate onSubmit={this.onSubmit} className="bg-glass-blur py-5 px-5 rounded text-white">
                <Form.Row>
                    <Form.Group as={Col} sm="12">
                        <Form.Row>
                            <h2 className="text-white">Signup now!</h2>
                        </Form.Row>
                        <Form.Row>
                            <h5 className="text-light font-weight-light">Fill the form below to start booking</h5>
                        </Form.Row>
                    </Form.Group>
                </Form.Row>
                <Form.Row>
                    <Form.Group as={Col} md="6" controlId="validationCustom01">
                        <Form.Label>First name</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faUser} /></InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                                required
                                type="text"
                                placeholder="First name"
                                value={this.state.firstname}
                                onChange={this.handleChange}
                                name="firstname"
                            />
                        </InputGroup>
                        <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group as={Col} md="6" controlId="validationCustom02">
                        <Form.Label>Last name</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faUser} /></InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                                required
                                type="text"
                                placeholder="Last name"
                                value={this.state.lastname}
                                onChange={this.handleChange}
                                name="lastname"
                            />
                        </InputGroup>
                        <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                    </Form.Group>
                </Form.Row>
                <Form.Row>
                    <Form.Group as={Col} md="6" controlId="validationCustomUsername">
                        <Form.Label>Username</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend"><b>@</b></InputGroup.Text>
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
                    <Form.Group as={Col} md="6" controlId="validationCustomUsername">
                        <Form.Label>Password</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faKey} /></InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                                type="password"
                                placeholder="Password..."
                                aria-describedby="inputGroupPrepend"
                                value={this.state.reg_password}
                                onChange={this.handleChange}
                                name="reg_password"
                                required
                            />
                            <Form.Control.Feedback type="invalid">
                                Please enter your password
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