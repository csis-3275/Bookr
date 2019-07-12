import React, { Component } from 'react';
import { Form, InputGroup, Button, Col } from 'react-bootstrap';
import { faUser, faKey } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

class Login extends Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {  }
    }

    handleSubmit(e){

    }

    render() { 
        

        return ( 
            // <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <Form noValidate className="bg-light py-5 px-5 rounded">
                <Form.Row>
                    <Form.Group as={Col} sm="7">
                        <Form.Row>
                            <h2 className="text-dark">Login now!</h2>
                        </Form.Row>
                        <Form.Row>
                            <h5 className="text-muted font-weight-light">Fill the form below to gain access</h5>
                        </Form.Row>
                    </Form.Group>
                    <Form.Group as={Col} sm="5">
                        <FontAwesomeIcon icon={faUser} />
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