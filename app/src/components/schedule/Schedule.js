import React, { Component } from 'react'
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";

class Schedule extends Component {
    constructor(props) {
        super(props);
        this.state = {
            startDate: new Date(),
            endDate: new Date(),
            // room_number: "",
            resNumber: ""

        };
    }

    change = e => {
        this.setState({
            [e.target.name]: e.target.value,
        });
        console.log(e.target.value);
    };

    dateChange = (date) => {
        this.setState({
            startDate: date
        });
        console.log(date);
    }

    dateChange2 = (date2) => {
        this.setState({
            endDate: date2
        });
        console.log(date2);
    }

    onSubmit = e => {
        e.preventDefault();
        this.randomRes();
        const reservation = {
            "_room_id": 1,
            "_user_id": 1,
            "_start_date": this.state.startDate,
            "_end_date": this.state.endDate,
            "_res_number": this.state.resNumber

        }
        console.log(reservation);
    }

    randomRes = () => {
        var num = Math.floor(Math.random() * 999) + 1000;
        var resNumber = "BOOKR" + num;
        this.setState({
            resNumber
        });
        console.log(resNumber);
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
                                    <h1 className="text-dark">Schedule</h1>
                                    <span className="text-dark">Select Start Date</span>
                                    <DatePicker
                                        name="startDate"
                                        selected={this.state.startDate}
                                        onChange={this.dateChange}

                                    />
                                    <br />
                                    <br />
                                    <span className="text-dark">Select End Date</span>
                                    <DatePicker
                                        name="endDate"
                                        selected={this.state.endDate}
                                        onChange={this.dateChange2}

                                    />
                                    <br />
                                    <br />
                                    {/* <span className="text-dark">Select Room Number</span>
                                    <input
                                        name="room_number"
                                        value={this.state.room_number}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br /> */}
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