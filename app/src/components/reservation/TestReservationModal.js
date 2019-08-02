import React, { useState } from 'react';
import {
    Modal, Body, Button, Header, Form, Col, Row, DropdownButton, Dropdown, InputGroup
} from 'react-bootstrap';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import axios from 'axios';
import moment from 'moment';

export default function Example(props) {

    const [show, setShow] = React.useState(false);
    const [user] = React.useState(props.user);
    const [startDate, setStartDate] = React.useState(new Date());
    const [endDate, setEndDate] = React.useState(new Date());
    const [resNumber, setResNumber] = React.useState("");
    const [roomId, setRoomId] = React.useState(1);
    const [eventTitle, setEventTitle] = React.useState("");


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const genRand = () => setResNumber(`BOOKR${num}`);
    const newRoomId = (e) => setRoomId(e.target.value);
    const dateChange = (date) => setStartDate(date);
    const dateChange2 = (date) => setEndDate(date);
    const changeTitle = (e) => setEventTitle(e.target.value);

    var num = Math.floor(Math.random() * 999) + 1000;

    const onSubmit = (e) => {

        e.preventDefault();
        console.log();
        const res = {
            "_room_id": roomId,
            "_user_id": user.id,
            "_start_date": moment(startDate).format("YYYY-MM-DD"),
            "_end_date": moment(endDate).format("YYYY-MM-DD"),
            "_res_number": resNumber, 
            "_event_title": eventTitle
        }

        console.log(`New Reservation: ${JSON.stringify(res)}`);
        axios.post("http://localhost:8888/api/reservations/create_reservation", res);
        setShow(false);
    }

    console.log(resNumber);

    const rooms = props.rooms.map((room, index) => {
        if (room._availability === "1") {
            return <option as={Button} key={index} onClick={newRoomId} value={room._id}>{`${room._type} ${room._room_number}`}</option>;
        }
    })


    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                Book Now
            </Button>
            <Modal show={show} onHide={handleClose}>
                {/* <Modal.Header closeButton>
                    <Modal.Title>Modal heading</Modal.Title>
                </Modal.Header> */}
                <Modal.Body>
                    <Form.Row>
                        <Col >
                            <Form.Row className="justify-content-center">
                                <Form className="bg-white py-5 px-2 rounded" onSubmit={onSubmit}>
                                    <Col md="12">
                                        <Form.Row>
                                            <h1 className="text-dark">Schedule</h1>
                                        </Form.Row>

                                        <Form.Row>
                                            <Form.Group as={Col} controlId="formGridEmail">
                                                <Form.Label>Event Title</Form.Label>
                                                <Form.Control type="text" placeholder="Event Title" onChange={changeTitle} />
                                            </Form.Group>
                                        </Form.Row>
                                    
                                        <Form.Row>
                                            <Form.Group>
                                                <Form.Label className="text-dark">Select Start Date</Form.Label>
                                                <InputGroup>
                                                    <DatePicker
                                                        name="startDate"
                                                        selected={startDate}
                                                        onChange={dateChange}
                                                        dateFormat="yyyy/MM/dd"
                                                        className="p-1"
                                                    />
                                                </InputGroup>
                                            </Form.Group>
                                        </Form.Row>

                                        <Form.Row>
                                            <Form.Group>
                                                <Form.Label className="text-dark">Select End Date</Form.Label>
                                                <InputGroup>
                                                    <DatePicker
                                                        name="endDate"
                                                        selected={endDate}
                                                        onChange={dateChange2}
                                                        dateFormat="yyyy/MM/dd"
                
                                                    />
                                                </InputGroup>
                                            </Form.Group>
                                        </Form.Row>
                                        <Form.Row>
                                            <Form.Group as={Col} controlId="formGridState">
                                                <Form.Label>Select Room</Form.Label>
                                                <Form.Control as="select">
                                                    {rooms}
                                                </Form.Control>
                                            </Form.Group>
                                        </Form.Row>
                                        <Form.Row>
                                            <Button type="submit" onClick={() => genRand()}>Confirm Booking</Button>
                                        </Form.Row>
                                    </Col>
                                </Form>
                            </Form.Row>
                        </Col>

                    </Form.Row>
                </Modal.Body>
                {/* <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
            </Button>
                    <Button variant="primary" onClick={handleClose}>
                        Save Changes
            </Button>
                </Modal.Footer> */}
            </Modal>


        </>
    );
}