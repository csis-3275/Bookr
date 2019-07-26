import React, { Component } from 'react';
import Header from '../partials/Header';
import '../home/styles/styles.css';
import './styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';
import Messages from './Messages';
import ReserveUpdateForm from './update/ReserveUpdateForm';

class Support extends Component {
  render() {
    return (
      <div className="main-bg" fluid={true} >
        <Header />
        {/* <Container className="cm-top" fluid={true}>
          <Row noGutters={true} className="justify-content-around">

            <Col sm="7" className="bg-white py-5 ">
              <Row>
                <Col sm={{ span: 10, offset: 1 }}>
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
                    <Row className="justify-content-end elm-top">
                      <p className="text-secondary">- The Team</p>
                    </Row>
                </Col>
              </Row>

            </Col>

            <Col sm="2" className="bg-white">
              <Row className="theme-bg-color shadow">
                <Col sm={{ span: 8, offset: 1 }} className="">
                  <Row className="justify-content-start my-2">
                    <h4 className="text-white">Messages</h4>
                  </Row>
                </Col>
              </Row>
              <Row>
                <Col sm={{ span: 12, offset: 1 }} className="px-0">
                  <Messages/>
                </Col>
              </Row>
            </Col>

          </Row>
        </Container> */}

        <ReserveUpdateForm />

      </div>
    );
  }
}

export default Support;
