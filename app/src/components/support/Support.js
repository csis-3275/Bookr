import React, { Component } from 'react';
import Header from '../partials/Header';
import '../home/styles/styles.css';
import './styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';
import { Form, InputGroup, Button } from 'react-bootstrap';
import { faUser, faKey } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import moment from 'moment';
import Axios from 'axios';

class Support extends Component {

  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = {
      user: {}, 
      title: "", 
      message: "", 
      date_sent: ""
    }
  }

  componentWillMount(){
    this.setState({
      user: this.props.location.state.user
    })
  }

  handleChange(e){
    this.setState({
        [e.target.name]: e.target.value
    });
  }

  handleSubmit(e){
      e.preventDefault();
      const new_request = {
        _user_id: this.state.user.id, 
        _title: this.state.title, 
        _message: this.state.message, 
        _date_sent: moment(new Date()).format("YYYY-MM-DD")
      };

      console.log(new_request);
      Axios.post("http://localhost:8888/api/requests/create_request", new_request);
  }

  render() {
    const user = this.state.user;
    return (
      <div>
        <Header />
        <Container className="" fluid>
          <Row noGutters={true} className="justify-content-around mt-5">

            <Col sm="6" className="bg-glass-blur rounded">
              <Form noValidate className="text-dark py-5 px-5" onSubmit={this.handleSubmit}>
                <Form.Row>
                    <Form.Group as={Col} md="10">
                        <Form.Row>
                            <h2 className="text-white">We are here to help!</h2>
                        </Form.Row>
                        <Form.Row>
                            <h5 className="text-light font-weight-light">Fill the form below an we will get back to you asap!</h5>
                        </Form.Row>
                    </Form.Group>
                </Form.Row>
                <Form.Row>
                  <Form.Group as={Col} md="10" controlId="validationCustomUsername">
                    <Form.Label className="text-white">Message Title</Form.Label>
                      <InputGroup>
                          <Form.Control
                          type="text"
                          placeholder="Message Title..."
                          aria-describedby="inputGroupPrepend"
                          value={this.state.title}
                          onChange={this.handleChange}
                          name="title"
                          required
                          />
                          <Form.Control.Feedback type="invalid">
                              Please enter the title of your message.
                          </Form.Control.Feedback>
                      </InputGroup>
                    </Form.Group>
                  </Form.Row>
                <Form.Row>
                  <Form.Group as={Col} md="10" controlId="validationCustomUsername">
                    <Form.Label className="text-white">Messsage Body</Form.Label>
                    <InputGroup>
                        <Form.Control
                        as="textarea"
                        placeholder="What's the issue?"
                        aria-describedby="inputGroupPrepend"
                        value={this.state.message}
                        onChange={this.handleChange}
                        name="message"
                        rows="5"
                        required
                        />
                        <Form.Control.Feedback type="invalid">
                            Please state your request and make sure to include relevant details like reservation numbers
                        </Form.Control.Feedback>
                    </InputGroup>
                  </Form.Group>
                </Form.Row>
                <Button type="submit" className="py-2 px-5">Submit</Button>
            </Form>
            </Col>

          </Row>
        </Container>

      </div>
    );
  }
}

export default Support;
