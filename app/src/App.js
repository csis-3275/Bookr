import React, {Component} from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import Home from "./components/home/Home";
import Reservation from './components/reservation/Reservation';
import Profile from './components/profile/Profile';
import Schedule from './components/schedule/Schedule';
import Reschedule from './components/schedule/Reschedule';
import UserProfile from './components/profile/UserProfile';
import Support from "./components/support/Support";
import {PrivateRoute} from './PrivateRoute';
import DashboardController from './components/dashboard/DashboardController';

class App extends Component {
  render(){
    return (
      <Switch>
        <Route isLoggedIn={this.props.loggedIn}  path="/" component={Home} exact />
        <PrivateRoute isLoggedIn={this.props.loggedIn} path="/dashboard" component={DashboardController} />    
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/support" component={Support}  />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/reservation" component={Reservation} />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/profile" component={Profile} />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/userprofile" component={UserProfile} />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/schedule" component={Schedule} />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/reschedule" component={Reschedule} />
      </Switch>
    );
  }
}



export default App;
