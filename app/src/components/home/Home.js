import React, { Component } from 'react';
import './styles/styles.css';
import classnames from 'classnames';
import Header from '../partials/Header';
import { Container, Row, Col, Button } from 'react-bootstrap';
import Login from '../login/Login';


class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: ""
        };
    }

    handleChange(e) {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    handleSubmit(e) {
        e.preventDefault();
        const user = {
            username: this.state.username,
            password: this.state.password
        };
    }

    render() {
        return (
            <div className="main-bg">
                <Header />
                <Container className="cm-top" fluid={true}>
                    <Row noGutters={true} className="justify-content-between">
                        <Col sm="6">
                            <Row>
                                <Col sm={{ span: 8, offset: 2 }}>
                                    <Row className="justify-content-center">
                                        <h1 className="text-center">You can book your room <span className="text-primary">now!</span></h1>
                                    </Row>
                                </Col>
                            </Row>
                            <Row className="elm-top">
                                <Col sm={{ span: 10, offset: 1 }}>
                                    <Row>
                                        <h4 className="font-weight-light text-center">
                                            We have been working very hard to create the new version of our project. It comes with a lot of new features which are easy to follow. Check it out now!
                                        </h4>
                                    </Row>
                                </Col>
                            </Row>
                            <Row className="elm-top">
                                <Col sm={{ span: 10, offset: 1 }}>
                                    <Row className="justify-content-center">
                                        <h4 className="font-weight-light text-center">
                                            Click the button below!
                                        </h4>
                                    </Row>
                                </Col>
                            </Row>
                            <Row className="elm-top">
                                <Col sm={{ span: 10, offset: 1 }}>
                                    <Row className="justify-content-center">
                                        <Button className="py-2 px-5">Register</Button>
                                    </Row>
                                </Col>
                            </Row>

                        </Col>
                        <Col sm="5">
                            <Login />
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default Home;