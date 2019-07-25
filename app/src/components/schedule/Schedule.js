import React, { Component } from 'react'
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';

class Schedule extends Component {

    state = {
        date: "",
        time: "",
        room_number: "",
        guests: "",
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
                                    <span className="text-dark">Select Date</span>
                                    <input
                                        name="date"
                                        value={this.state.date}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <span className="text-dark">Select Time</span>
                                    <input
                                        name="time"
                                        value={this.state.time}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <span className="text-dark">Select Room Number</span>
                                    <input
                                        name="room_number"
                                        value={this.state.room_number}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <span className="text-dark">Enter Number of Guests</span>
                                    <input
                                        name="guests"
                                        value={this.state.guests}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <button onClick={e => this.onSubmit(e)}>Confirm Booking</button>
                                </form>
                            </Row>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default Schedule