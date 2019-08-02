import React, {useState} from 'react';
import { Form, InputGroup, Button, Col, Modal } from 'react-bootstrap';
import { faBuilding, faCalendarAlt } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import '../styles/update.css';

export default function ReserveUpdateForm (props){
    const [show, setShow] = React.useState(false); 
    
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true); 
  return(
    <>
        <Button variant="primary" onClick={handleShow} className="mt-3">
            Update Reservation
        </Button>
        <Modal show={show} onHide={handleClose}>
            <Form noValidate as={Col} sm="10" className="bg-light rounded bg-white mx-auto mt-5">
                {/* onSubmit={this.handleSubmit}> */}
                <Form.Row>
                    <Form.Group as={Col} sm="12">
                        <Form.Row className="justify-content-center">
                            <h3 className="text-dark">Update Reservation</h3>
                        </Form.Row>
                        <Form.Row className="justify-content-center mt-4">
                            <h5 className="text-muted font-weight-light justify-content-center ">Fill the form below to update reservations and hit <b>update</b> button to save updates</h5>
                        </Form.Row>
                    </Form.Group>
                    {/* <Form.Group as={Col} sm="5">
                        <FontAwesomeIcon icon={faUser} />
                    </Form.Group> */}
                </Form.Row>

                <Form.Row className="mt-2">
                <Form.Group as={Col} md="2" >
                </Form.Group>
                    <Form.Group as={Col} md="8"  controlId="validationCustomUsername">
                        <Form.Label className="text-dark">Reservation Numbers</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend  >
                                <InputGroup.Text  id="inputGroupPrepend"><FontAwesomeIcon icon={faBuilding} /></InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                            type="text"
                            placeholder="XXX.XXXX"
                            aria-describedby="inputGroupPrepend"
                            // value={this.state.username}
                            // onChange={this.handleChange}
                            name="reservnum"
                            required
                            />
                            <Form.Control.Feedback type="invalid">
                                Please enter reservation numbers
                            </Form.Control.Feedback>
                        </InputGroup>
                    </Form.Group>
                </Form.Row>

            <Form.Row className="mt-2">
            <Form.Group as={Col} md="2" >
                </Form.Group>
                    <Form.Group as={Col} md="8" controlId="validationCustomUsername">
                        <Form.Label className="text-dark">Start Date</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faCalendarAlt} /></InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                            type="text"
                            placeholder="YYYY.MM.DD"
                            aria-describedby="inputGroupPrepend"
                            // value={this.state.password}
                            // onChange={this.handleChange}
                            name="startdate"
                            required
                            />
                            <Form.Control.Feedback type="invalid">
                                Please enter reservation start date
                            </Form.Control.Feedback>
                        </InputGroup>
                    </Form.Group>
                </Form.Row>

            <Form.Row className="mt-2">
            <Form.Group as={Col} md="2" >
                </Form.Group>
                    <Form.Group as={Col} md="8" controlId="validationCustomUsername">
                        <Form.Label className="text-dark">End Date</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend>
                                <InputGroup.Text id="inputGroupPrepend"><FontAwesomeIcon icon={faCalendarAlt} /></InputGroup.Text>
                            </InputGroup.Prepend>
                            <Form.Control
                            type="text"
                            placeholder="YYYY.MM.DD"
                            aria-describedby="inputGroupPrepend"
                            // value={this.state.password}
                            // onChange={this.handleChange}
                            name="enddate"
                            required
                            />
                            <Form.Control.Feedback type="invalid">
                            Please enter reservation end date
                            </Form.Control.Feedback>
                        </InputGroup>
                    </Form.Group>
                </Form.Row>
                <Form.Row className="mt-3">
                <Form.Group as={Col} md="5" >
                </Form.Group>
                <Form.Group as={Col} md="2" >
                    <Button type="submit" className="py-2 px-5 btn-info">Update</Button>
                </Form.Group> 
                </Form.Row>
            </Form>
        </Modal>
    </>
  )
}