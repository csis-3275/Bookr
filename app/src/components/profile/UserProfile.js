import React, { Component } from 'react'
import { Form, Row, InputGroup, Button, Col } from 'react-bootstrap';
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { faUser, faKey } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import Axios from 'axios';

class UserProfile extends Component {

    constructor(props) {
        super(props);
        this.state = {
            user: {},
            id: 0,
            firstName: "",
            lastName: "",
            email: "",
            phone: "",
            password: "",
            role_id: 0
        };
    }

    componentWillMount() {
        this.setState({
            user: this.props.location.state.user,
            id: this.props.location.state.user.id,
            firstName: this.props.location.state.user._firstname,
            lastName: this.props.location.state.user._lastname,
            email: this.props.location.state.user._email,
            password: this.props.location.state.user._password,
            role_id: this.props.location.state.user._role_id
        })
    }

    change = e => {
        this.setState({
            [e.target.name]: e.target.value
        });
    };

    onSubmit = e => {
        e.preventDefault();
        console.log(this.state);
        const user_to_update = {
            id: this.state.id,
            _firstname: this.state.firstName,
            _lastname: this.state.lastName,
            _email: this.state.email,
            _password: this.state.password,
            _role_id: this.state.role_id
        }
        Axios.post("http://localhost:8888/api/users/create_user", user_to_update);
    }

    render() {
        return (
            <div>
                <Header user={this.state.user} />
                <Row className="mt-5">
                    <Col md={{ span: 4, offset: 4 }}>
                        <Form className="bg-glass-blur py-5 px-5 rounded text-white mt-5">

                            <Form.Row>
                                <Form.Group as={Col} sm="12">
                                    <Form.Row>
                                        <h2 className="text-white">Update Profile</h2>
                                    </Form.Row>

                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} md="12">
                                    <Form.Label>First Name:</Form.Label>

                                    <InputGroup>
                                        <InputGroup.Prepend>
                                            <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faUser} /></InputGroup.Text>
                                        </InputGroup.Prepend>
                                        <Form.Control
                                            type="text"
                                            aria-describedby="inputGroupPrepend"
                                            value={this.state.firstName}
                                            onChange={this.change}
                                            name="firstName"
                                            required
                                        />
                                        <Form.Control.Feedback type="invalid">
                                            Please enter your firstname.
                                        </Form.Control.Feedback>
                                    </InputGroup>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} md="12">
                                    <Form.Label>Last Name:</Form.Label>
                                    <InputGroup>
                                        <InputGroup.Prepend>
                                            <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faUser} /></InputGroup.Text>
                                        </InputGroup.Prepend>
                                        <Form.Control
                                            type="text"
                                            aria-describedby="inputGroupPrepend"
                                            value={this.state.lastName}
                                            onChange={this.change}
                                            name="lastName"
                                            required
                                        />
                                        <Form.Control.Feedback type="invalid">
                                            Please enter your lastname.
                                        </Form.Control.Feedback>
                                    </InputGroup>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} md="12">
                                    <Form.Label>Email: </Form.Label>
                                    <InputGroup>
                                        <InputGroup.Prepend>
                                            <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faUser} /></InputGroup.Text>
                                        </InputGroup.Prepend>
                                        <Form.Control
                                            type="email"
                                            aria-describedby="inputGroupPrepend"
                                            value={this.state.email}
                                            onChange={this.change}
                                            name="email"
                                            required
                                        />
                                        <Form.Control.Feedback type="invalid">
                                            Please enter your email.
                                        </Form.Control.Feedback>
                                    </InputGroup>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} md="12">
                                    <Form.Label>Password: </Form.Label>
                                    <InputGroup>
                                        <InputGroup.Prepend>
                                            <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faUser} /></InputGroup.Text>
                                        </InputGroup.Prepend>
                                        <Form.Control
                                            type="password"
                                            aria-describedby="inputGroupPrepend"
                                            value={this.state.password}
                                            onChange={this.change}
                                            name="password"
                                            required
                                        />
                                        <Form.Control.Feedback type="invalid">
                                            Please enter your password.
                                        </Form.Control.Feedback>
                                    </InputGroup>
                                </Form.Group>
                            </Form.Row>
                            <Button type="submit" className="py-2 px-5 btn-primary" onClick={e => this.onSubmit(e)}>Update</Button>
                        </Form>
                    </Col>
                </Row>
            </div >
        );
    }
}

export default UserProfile