import React, { Component } from 'react'
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';
import ReservationModal from './TestReservationModal';
import "react-datepicker/dist/react-datepicker.css";
import ReservationList from './ReservationList';
import Axios from 'axios';

class Reservation extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: {},
            isOpen: false,
            startDate: new Date(),
            endDate: new Date(),
            resNumber: "",
            rooms: []
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

    componentWillMount() {
        this.setState({
            user: this.props.location.state.user
        });

        Axios.get("http://localhost:8888/api/rooms/all")
            .then((response) => {
                this.setState({
                    rooms: response.data
                })
            })
    }

    render() {
        // const user = this.props.location.state;
        console.log(this.state.user);
        console.log(typeof this.state.user);
        console.log(this.props.location.state.user);

        const user = this.state.user;


        return (
            <div>
                <Header user={user} />
                <Container className="mt-5">
                    <Row noGutters={true} className="justify-content-around">

                        <Col xs="7">
                            <Row className="bg-white shadow-below">
                                <Col sm={{ span: 8, offset: 1 }} className="">
                                    <Row className="justify-content-start my-2">
                                        <Col md="8">
                                            <h2 className="text-dark">Reservations</h2>
                                        </Col>
                                        <Col md="4">
                                            <ReservationModal user={this.state.user} rooms={this.state.rooms} />
                                        </Col>
                                    </Row>
                                </Col>
                            </Row>
                            <Row className="bg-white">
                                <Col sm={{ span: 12 }} className="px-3">
                                    <ReservationList userId={user.id} />
                                </Col>
                            </Row>
                        </Col>

                    </Row>
                </Container>
            </div>
        )
    }
}

export default Reservation