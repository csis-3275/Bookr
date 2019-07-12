import React, { Component } from 'react';
import './styles/styles.css';
import classnames from 'classnames';
import Header from '../partials/Header';


class Home extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            username: "", 
            password: ""
         };
    }

    handleChange(e){
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    handleSubmit(e){
        e.preventDefault();
        const user = {
            username: this.state.username, 
            password: this.state.password 
        };
    }

    render() { 
        return ( 
            <div className="main-bg">
                <Header />
            </div>
            );
    }
}
 
export default Home;