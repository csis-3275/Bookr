import React, { Component } from 'react';
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';

class Support extends Component {
  render() {
    return (
      <div className="main-bg" fluid={true}>
        <Header />
        <Container className="cm-top" fluid={true}>
          <Row noGutters={true} className="justify-content-around">

            <Col sm="6" className="bg-white py-5 px-2">
              <Row>
                <Col sm={{ span: 8, offset: 1 }}>
                  <Row className="justify-content-start">
                    <h3 className="text-dark">DashBoard</h3>
                  </Row>
                </Col>
              </Row>

              <Row className="elm-top">
                <Col sm={{span: 10, offset: 1}}>
                    <Row className="justify-content-center">
                      <p className="text-secondary">This is your dashboard area. You can view your most recent reservations here. Please do not hesitate to contact support if you have any issues with our service. Unfortunatel, this web app is still in development so features are limited. Thank you and have a nice day.</p>
                    </Row>
                </Col>
              </Row>

              <Row>
                <Col sm={{span: 10, offset: 1}}>
                    <Row className="justify-content-end">
                      <p className="text-secondary">- The Team</p>
                    </Row>
                </Col>
              </Row>

            </Col>
            <Col sm="3" className="bg-white">
              <Row className="justify-content-start">
                    <h4 className="text-dark">Reservations</h4>
              </Row>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default Support;
