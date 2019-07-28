import React, { Component } from 'react';
import { Nav, Navbar, NavDropdown } from 'react-bootstrap';
import "./styles/header.css";

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                <Navbar.Brand href="/" className="text-info pl-2 font_big">Bookr</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">

                    </Nav>
                    <Nav>
                        <Nav.Link href="#deets" className="text-white pr-4">Welcome <span className="text-name">{this.props.firstname} {this.props.lastname}</span></Nav.Link>
                        <NavDropdown title="Dashboard" id="collasible-nav-dropdown" className="pr-5">
                            <NavDropdown.Item href="#action/3.1">Book Rooms</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Update Reservation</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Cancel Booking</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}

export default Header;