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
import ErrorPage from './components/error/Error';

class App extends Component {
  render(){
    return (
      <Switch>
        <Route  path="/" component={Home} exact /> {/**make inaccessible to logged in users */}
        <PrivateRoute isLoggedIn={this.props.loggedIn} path="/dashboard" component={DashboardController} exact />    
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/support" component={Support}  exact />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/reservation" component={Reservation} exact />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/profile" component={Profile} exact />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/userprofile" component={UserProfile} exact />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/schedule" component={Schedule} exact />
        <PrivateRoute isLoggedIn={this.props.loggedIn}  path="/reschedule" component={Reschedule} exact />

        <Route component={ErrorPage} />
      </Switch>
    );
  }
}



export default App;
