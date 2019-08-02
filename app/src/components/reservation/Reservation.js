import React, { Component } from 'react'
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';
import ReservationModal from './TestReservationModal';
import "react-datepicker/dist/react-datepicker.css";
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
                console.log(response.data)
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
            <div className="main-bg">
                <Header user={user} />
                <Container className="mt-5">
                    <Row noGutters={true} className="justify-content-around">

                        <Col sm="7" className="bg-white py-5 ">
                            <Row>
                                <Col sm={{ span: 10, offset: 1 }}>
                                    <Row className="justify-content-start">
                                        <h3 className="text-dark">Your Reservations</h3>
                                    </Row>
                                    <Row>
                                        <ReservationModal user={this.state.user} rooms={this.state.rooms} />
                                    </Row>
                                </Col>
                                <Col>
                                    <ul className="list-style-none">
                                        <li className="px-0 py-0 ">
                                            <h5 className="text-dark mt-2">Quarterly Tech Expo</h5>
                                            <p className="text-dark mb-0">2019-09-2019</p>
                                            <p className="text-dark mb-0">Convention Hall A</p>
                                            <p className="text-muted mb-2">Reservation Number Bookr2435</p>
                                            <hr></hr>
                                        </li>
                                        <li className="px-0 py-0 ">
                                            <h5 className="text-dark mt-2">Annual Aviation Enthusiasts Meet</h5>
                                            <p className="text-dark mb-0">2019-07-22</p>
                                            <p className="text-dark mb-0">Convention Hall B</p>
                                            <p className="text-muted mb-2">Reservation Number Bookr2437</p>
                                            <hr></hr>
                                        </li>
                                        <li className="px-0 py-0 ">
                                            <h5 className="text-dark mt-2">Capsule Corporation Quarterly Meeting</h5>
                                            <p className="text-dark mb-0">2019-07-22</p>
                                            <p className="text-dark mb-0">Boardroom D</p>
                                            <p className="text-muted mb-2">Reservation Number Bookr2550</p>
                                            <hr></hr>
                                        </li>
                                        <li className="px-0 py-0 ">
                                            <h5 className="text-dark mt-2">Capsule/ CyberDyne Merger Meeting</h5>
                                            <p className="text-dark mb-0">2019-07-22</p>
                                            <p className="text-dark mb-0">Boardroom C</p>
                                            <p className="text-muted mb-2">Reservation Number Bookr2551</p>
                                            <hr></hr>
                                        </li>
                                    </ul>
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