import React, { Component } from 'react';
import { Nav, Navbar, NavDropdown, Button } from 'react-bootstrap';
import "./styles/header.css";
import Logo from '../img/spiral_dixed.png';
import { NavLink, Redirect } from 'react-router-dom';
import { logoutUser } from '../../actions/appActions';
import propTypes from 'prop-types';
import { connect } from 'react-redux';


class Header extends Component {
    constructor(props) {
        super(props);
        this.redirect = this.redirect.bind(this);
        this.state = {
            user: {}
        }
    }

    componentWillMount() {
        console.log("local storage --> "+localStorage.getItem('user'));
        console.log("props ---> "+JSON.stringify(this.props.user));
        this.setState({
            user: JSON.parse(localStorage.getItem('user'))
        })
    }

    redirect = () => {
        this.props.logoutUser();
        if(!localStorage.getItem('user'))
        {
            this.setState({
                loggedIn: false
            });
        }
        if(this.state.loggedIn === false)
        {
            return <Redirect to={{
                pathname: '/'
            }}/>
        }
    }

    render() {
        console.log(this.props.user);
        return (
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                <Navbar.Brand href="/" className="pl-2 font_big clear-fix"><img src={Logo} className="pull-left small-logo" alt="Bookr Logo" /><span className="text-teal">Bookr</span></Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">

                    </Nav>
                    <Nav>
                        <Nav.Link as={NavLink} 
                            to={{
                                pathname: "/dashboard", 
                                state: {
                                    user: this.state.user
                                }
                            }} 
                            className="text-white pr-4"
                        >
                            Welcome <span className="text-name">
                                {this.state.user._firstname} {this.state.user._lastname}
                            </span>
                        </Nav.Link>
                        <NavDropdown title="Options" id="collasible-nav-dropdown" className="pr-5">
                            <NavDropdown.Item as={NavLink} to={{
                                pathname: "/reservation", 
                                state: {
                                    user: this.state.user
                                }
                            }}>
                                Reservations
                            </NavDropdown.Item>
                            <NavDropdown.Item as={NavLink} to={{
                                pathname: "/userprofile", 
                                state: {
                                    user: this.state.user
                                }
                            }}>
                                Manage Account
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/contact_support">Contact Support</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item as={Button} onClick={this.redirect}>Logout</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}

// export default Header;

Header.propTypes = {
    logoutUser: propTypes.func.isRequired, 
    errors: propTypes.object.isRequired
};

const mapStateToProps = state => ({
    errors: state.errors
});

export default connect(mapStateToProps, {logoutUser})(Header);