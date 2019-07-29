import React, { Component } from 'react'
import Header from '../partials/Header';
import '../home/styles/styles.css';
import { Container, Row, Col } from 'react-bootstrap';

class UserProfile extends Component {

    constructor(props) {
        super(props);
        this.state = {
            user: {}, 
            id: 0, 
            firstName: "",
            lastName: "",
            email: "",
            phone: "",
            password: "",
            role_id: 0
        };
    }

    componentWillMount(){
        this.setState({
            user: this.props.location.state.user, 
            id: this.props.location.state.user.id, 
            firstName: this.props.location.state.user._firstname, 
            lastName: this.props.location.state.user._lastname, 
            email: this.props.location.state.user._email, 
            password: this.props.location.state.user._password, 
            role_id: this.props.location.state.user._role_id
        })
    }

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
            <div className="main-bg">
                <Header user={this.state.user} />
                <Container className="cm-top">
                    <Row className="elm-top">
                        <Col sm={{ span: 10, offset: 1 }}>
                            <Row className="justify-content-center">
                                <form className="bg-light py-5 px-5 rounded">
                                    <h1 className="text-dark">Profile</h1>
                                    <input
                                        name="firstName"
                                        placeholder="First Name"
                                        value={this.state.firstName}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <input
                                        name="lastName"
                                        placeholder="Last Name"
                                        value={this.state.lastName}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <input
                                        name="email"
                                        placeholder="Email"
                                        value={this.state.email}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <input
                                        name="password"
                                        type="password"
                                        placeholder="Password"
                                        value={this.state.password}
                                        onChange={e => this.change(e)}
                                    />
                                    <br />
                                    <br />
                                    <button onClick={e => this.onSubmit(e)}>Update</button>
                                </form>
                            </Row>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default UserProfile