import React, { Component } from "react";
import { connect } from "react-redux";
import Dashboard from "./Dashboard";


// import Footer from './footer/footer';

class DashboardController extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: {}
        };
    }
    render() {
        return (
            <div>
                <Dashboard />
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        user: state.auth.user
    };
};
export default connect(mapStateToProps)(DashboardController);
