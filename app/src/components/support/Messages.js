import React, { Component } from 'react';
import Header from '../partials/Header';
import { Container, Row, Col } from 'react-bootstrap';
import MessagesList from './MessagesList';
import ReserveUpdateForm from './update/ReserveUpdateForm';

class Messages extends Component {
  constructor(props) {
    super(props);
    this.state = { 
        user: {}
     }
  }

  componentWillMount(){
      this.setState({
          user: this.props.location.state.user
      })
  }


  render() {    
    const user = this.state.user;
    return (
      <div>
        <Header user={user} />
          <Container className="mt-5">
              <Row noGutters={true} className="justify-content-around">

                  <Col xs="10">
                      <Row className="bg-white">
                          <Col sm={{ span: 8 }} className="">
                              <Row className="justify-content-start my-2">
                                  <Col md="12">
                                      <h2 className="text-dark pl-3">Reading: </h2>
                                      <h5 className="text-dark pl-3 font-weight-light">Opened messages will show here</h5>
                                  </Col>
                              </Row>
                          </Col>
                          <Col sm="4">
                            <ReserveUpdateForm />
                          </Col>
                      </Row>
                      <Row className="bg-white">
                          <Col sm={{ span: 12 }} className="px-3">
                            <MessagesList />
                          </Col>
                      </Row>
                  </Col>

                  {/*<Col xs="4">
                      <Row className="bg-white">
                          <Col sm={{ span: 8 }} className="">
                              <Row className="justify-content-start my-2">
                                  <Col md="12">
                                      <h2 className="text-dark px-3">User Requests </h2>
                                  </Col>
                              </Row>
                          </Col>
                      </Row>
                      <Row className="bg-white">
                          <Col sm={{ span: 12 }} className="px-3">
                          </Col>
                      </Row>
                    </Col>*/}

              </Row>
          </Container>
      </div>
    )
  }
}

export default Messages;
