import React, { Component } from 'react';
import Header from '../partials/Header';
import { Container, Row, Col } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import './styles/dashboard.css';
import { faUserCog, faCalendarAlt } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

class Dashboard extends Component {
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
                <Container className="center-container">
                    <Row className="justify-content-center">
                        <div className="circle-div">
                            <span>{user._firstname.substr(0,1)}</span>
                        </div>
                    </Row>
                    <Row className="justify-content-center mt-4">
                        <h3 className="text-center font-weight-normal text-white">Welcome, {user._firstname} {user._lastname}</h3>
                    </Row>
                    <Row className="justify-content-center mt-2">
                        <h5 className="text-center font-weight-light text-white">Manage your account, reservations and messages from here</h5>
                    </Row>
                    <Row className="mt-5">
                        <Col md="6" className="p-5 ">
                            <Row className="p-5 border border-dark shadow bg-white"> 
                                <Col sm="10">
                                    <h4 className="font-weight-normal">Manage Account & Privacy</h4>
                                    <h5 className="font-weight-light mb-5">You can manage your account setting and update your profile from here</h5>
                                    <NavLink className="mt-5" to={{
                                        pathname: "/userprofile", 
                                        state: {
                                            user: this.state.user
                                        }
                                    }}>Manage your account and privacy</NavLink>
                                </Col>
                                <Col sm="2">
                                    <FontAwesomeIcon className="display-4" icon={faUserCog} />
                                </Col>
                            </Row>
                        </Col>
                        <Col md="6" className="p-5 ">
                            <Row className="p-5 border border-dark shadow bg-white"> 
                                <Col sm="10">
                                    <h4 className="font-weight-normal">Reservations</h4>
                                    <h5 className="font-weight-light mb-5">You can schedule, re-schedule, cancel and track your reservations here</h5>
                                    <NavLink className="mt-5" to={{
                                        pathname: "/reservation", 
                                        state: {
                                            user: this.state.user
                                        }
                                    }}>Manage your reservations</NavLink>
                                </Col>
                                <Col sm="2">
                                    <FontAwesomeIcon className="display-4" icon={faCalendarAlt} />
                                </Col>
                            </Row>
                        </Col>
                    </Row>
                </Container>
            </div>
         );
    }
}
 
export default Dashboard;