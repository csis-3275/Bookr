import React, { Component } from 'react'
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';

class Profile extends Component {

    state = {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        password: "",
    };

    change = e => {
        this.setState({
            [e.target.name]: e.target.value
        });
    };

    onSubmit = e => {
        e.preventDefault();
        console.log(this.state);
    }

    render() {
        return (
            <div div className="main-bg" fluid={true}>
                <Header />
                <Container className="cm-top" fluid={true}>
                    <Row className="elm-top">
                        <Col sm={{ span: 10, offset: 1 }}>
                            <Row className="justify-content-center">
                                <form className="bg-light py-5 px-5 rounded">
                                    <h1 className="text-dark">Update Profile</h1>
                                    <input
                                        name="firstName"
                                        placeholder="First Name"
                                        value={this.state.firstName}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <input
                                        name="lastName"
                                        placeholder="Last Name"
                                        value={this.state.lastName}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <input
                                        name="email"
                                        placeholder="Email"
                                        value={this.state.email}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <input
                                        name="phone"
                                        placeholder="Phone Number"
                                        value={this.state.phone}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <input
                                        name="password"
                                        type="password"
                                        placeholder="Password"
                                        value={this.state.password}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <button onClick={e => this.onSubmit(e)}>Update</button>
                                </form>
                            </Row>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default Profile