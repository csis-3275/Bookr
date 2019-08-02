import React, { useState } from 'react';
import {
    Modal, Body, Button, Header, Row, Col, Form, DropdownButton, Dropdown
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


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const genRand = () => setResNumber(`BOOKR${num}`);
    const newRoomId = (e) => setRoomId(e.target.value);
    const dateChange = (date) => setStartDate(date);
    const dateChange2 = (date) => setEndDate(date);

    var num = Math.floor(Math.random() * 999) + 1000;

    const onSubmit = (e) => {

        e.preventDefault();
        console.log();
        const res = {
            "_room_id": roomId,
            "_user_id": user.id,
            "_start_date": moment(startDate).format("YYYY-MM-DD"),
            "_end_date": moment(endDate).format("YYYY-MM-DD"),
            "_res_number": resNumber
        }

        console.log(`New Reservation: ${JSON.stringify(res)}`);
        axios.post("http://localhost:8888/api/reservations/create_reservation", res);
        setShow(false);
    }

    console.log(resNumber);

    const rooms = props.rooms.map((room, index) => {
        if (room._availability === "1") {
            return <Dropdown.Item as={Button} key={index} onClick={newRoomId} value={room._id}>{`${room._type} ${room._room_number}`}</Dropdown.Item>;
        }
    })


    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                New Reservations
            </Button>
            <Modal show={show} onHide={handleClose}>
                {/* <Modal.Header closeButton>
                    <Modal.Title>Modal heading</Modal.Title>
                </Modal.Header> */}
                <Modal.Body>
                    <Row>
                        <Col >
                            <Row className="justify-content-center">
                                <Form className="bg-white py-5 px-5 rounded" onSubmit={onSubmit}>
                                    <h1 className="text-dark">Schedule</h1>
                                    <span className="text-dark">Select Start Date</span>
                                    <DatePicker
                                        name="startDate"
                                        selected={startDate}
                                        onChange={dateChange}
                                        dateFormat="yyyy/MM/dd"

                                    />
                                    <br />
                                    <br />
                                    <span className="text-dark">Select End Date</span>
                                    <DatePicker
                                        name="endDate"
                                        selected={endDate}
                                        onChange={dateChange2}
                                        dateFormat="yyyy/MM/dd"

                                    />
                                    <br />
                                    <br />
                                    <DropdownButton id="dropdown-item-button" title="Select Room">
                                        {rooms}
                                    </DropdownButton>
                                    <br />
                                    <Button type="submit" onClick={() => genRand()}>Confirm Booking</Button>
                                </Form>
                            </Row>
                        </Col>

                    </Row>
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