import React, { Component } from 'react'
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';

class Reschedule extends Component {

    constructor(props) {
        super(props);
        this.state = {
            res_number: "",
            message: ""
        };
    }

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
            <div className="main-bg">
                <Header />
                <Container className="cm-top">
                    <Row className="elm-top">
                        <Col sm={{ span: 10, offset: 1 }}>
                            <Row className="justify-content-center">
                                <form className="bg-light py-5 px-5 rounded">
                                    <h1 className="text-dark">Reschedule</h1>
                                    <input
                                        name="res_number"
                                        placeholder="Enter Reservation Number"
                                        value={this.state.res_number}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <input
                                        name="message"
                                        placeholder="Enter New Schedule Info"
                                        value={this.state.message}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
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

export default Reschedule