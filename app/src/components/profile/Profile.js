import React, { Component } from 'react'
import { Form, InputGroup, Button, Col } from 'react-bootstrap';

class Profile extends Component {

    state = {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        password: "",
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
            <form className="bg-light py-5 px-5 rounded">
                <input
                    name="firstName"
                    placeholder="First Name"
                    value={this.state.firstName}
                    onChange={e => this.change(e)}
                />
                <br />
                <input
                    name="lastName"
                    placeholder="Last Name"
                    value={this.state.lastName}
                    onChange={e => this.change(e)}
                />
                <br />
                <input
                    name="email"
                    placeholder="Email"
                    value={this.state.email}
                    onChange={e => this.change(e)}
                />
                <br />
                <input
                    name="phone"
                    placeholder="Phone Number"
                    value={this.state.phone}
                    onChange={e => this.change(e)}
                />
                <br />
                <input
                    name="password"
                    type="password"
                    placeholder="Password"
                    value={this.state.password}
                    onChange={e => this.change(e)}
                />
                <br />
                <button onClick={e => this.onSubmit(e)}>Update</button>
            </form>
        );
    }
}

export default Profile