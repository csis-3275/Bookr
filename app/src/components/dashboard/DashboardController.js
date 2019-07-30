import React, { Component } from "react";
import { connect } from "react-redux";
import Header from '../partials/Header';
import UserDashboard from "./UserDashboard";
import SupportDashboard from "../dashboard/SupportDashboard";


// import Footer from './footer/footer';

class DashboardController extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: {}
        };
    }
    componentWillMount(){
        this.setState({
            user: this.props.location.state.user
        })
    }

    render() { 
        const user = this.state.user;

        const Dashboard = user._role_id === 1 || user._role_id === 2 ? <SupportDashboard user={user} /> : <UserDashboard user={this.state.user} />;

        return ( 
            <div>
                <Header user={user} />
                { Dashboard }
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
