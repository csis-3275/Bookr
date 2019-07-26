import React, { Component } from 'react';
import { Form, InputGroup, Button, Col } from 'react-bootstrap';
import { faUser, faKey } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import './styles/login.css';

class Login extends Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.state = { 
            username: "", 
            password: ""
         }
    }

    handleChange(e){
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    handleSubmit(e){
        e.preventDefault();
        const user = {
            username: this.state.username, 
            password: this.state.password 
        };
        console.log(user);
    }

    render() { 
        

        return ( 
            // <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <Form noValidate className="bg-glass-blur py-5 px-5 rounded text-white" onSubmit={this.handleSubmit}>
                <Form.Row>
                    <Form.Group as={Col} sm="12">
                        <Form.Row>
                            <h2 className="text-white">Login now!</h2>
                        </Form.Row>
                        <Form.Row>
                            <h5 className="text-light font-weight-light">Fill the form below to gain access</h5>
                        </Form.Row>
                    </Form.Group>
                </Form.Row>
                <Form.Row>
                    <Form.Group as={Col} md="10" controlId="validationCustomUsername">
                        <Form.Label>Username</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faUser} /></InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                            type="text"
                            placeholder="Username..."
                            aria-describedby="inputGroupPrepend"
                            value={this.state.username}
                            onChange={this.handleChange}
                            name="username"
                            required
                            />
                            <Form.Control.Feedback type="invalid">
                                Please enter your email.
                            </Form.Control.Feedback>
                        </InputGroup>
                    </Form.Group>
                </Form.Row>
               <Form.Row>
                    <Form.Group as={Col} md="10" controlId="validationCustomUsername">
                        <Form.Label>Password</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faKey} /></InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                            type="password"
                            placeholder="Password..."
                            aria-describedby="inputGroupPrepend"
                            value={this.state.password}
                            onChange={this.handleChange}
                            name="password"
                            required
                            />
                            <Form.Control.Feedback type="invalid">
                                Please enter your password
                            </Form.Control.Feedback>
                        </InputGroup>
                    </Form.Group>
                </Form.Row>
                <Button type="submit" className="py-2 px-5">Login</Button>
            </Form>
         );
    }
}
 
export default Login;