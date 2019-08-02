import React, { Component } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import NavLink from 'react-bootstrap/NavLink';

class ErrorPage extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return ( 
            <Container className="m-0 bg-white w-50 float-right" style={{height: '100vh'}}>
                <Row>
                    <Col className="mt-5">
                        <h1 className="display-3 text-center">Error!</h1>
                    </Col>
                </Row>
                <Row className="mt-5">
                    <Col>
                        <h1 className="display-5 text-center">404 Not Found!</h1>
                    </Col>
                </Row>
                <Row className="mt-5">
                    <Col>
                        <h1 className="display-5 text-center font-weight-light">This page does not exist</h1>
                    </Col>
                </Row>
                <Row className="mt-5">
                    <Col>
                        <h4 className="text-center font-weight-light">Return to <NavLink href="/">Homepage</NavLink></h4>
                    </Col>
                </Row>
            </Container>
         );
    }
}
 
export default ErrorPage;