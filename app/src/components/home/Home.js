import React, { Component } from 'react';
import './styles/styles.css';
import classnames from 'classnames';
import Header from '../partials/Header';
import { Container, Row, Col, Button } from 'react-bootstrap';
import Login from '../login/Login';
import Register from '../register/Register';


class Home extends Component {
    constructor(props) {
        super(props);

        this.handleSwap= this.handleSwap.bind(this);

        this.state = { 
            is_login_form: true
         };
    }

    handleSwap = () => {
        this.setState({
            is_login_form: !this.state.is_login_form
        })
    }

    render() { 
        const swapForms = this.state.is_login_form ? <Login /> : <Register />;

        return ( 
            <div className="main-bg">
                <Header />
                <Container className="cm-top" fluid={true}>
                    <Row noGutters={true} className="justify-content-around">
                        <Col sm="6">
                            <Row>
                                <Col sm={{span: 8, offset: 2}}>
                                    <Row className="justify-content-center">
                                        <h1 className="text-center">You can book your room <span className="text-primary">now!</span></h1>
                                    </Row>
                                </Col>
                            </Row>
                            <Row className="elm-top">
                                <Col sm={{span: 10, offset: 1}}>
                                    <Row>
                                        <h4 className="font-weight-light text-center">
                                            We have been working very hard to create the new version of our project. It comes with a lot of new features which are easy to follow. Check it out now!
                                        </h4>
                                    </Row>
                                </Col>
                            </Row>
                            <Row className="elm-top">
                                <Col sm={{span: 10, offset: 1}}>
                                    <Row className="justify-content-center">
                                        <h4 className="font-weight-light text-center">
                                            Click the button below!
                                        </h4>
                                    </Row>
                                </Col>
                            </Row>
                            <Row className="elm-top">
                                <Col sm={{span: 10, offset: 1}}>
                                    <Row className="justify-content-center">
                                        <Button className="py-2 px-5" onClick={this.handleSwap}>Start now</Button>
                                    </Row>
                                </Col>
                            </Row>

                        </Col>
                        <Col md="4">
                            { swapForms }
                        </Col>
                    </Row>
                </Container>
            </div>
            );
    }
}
 
export default Home;