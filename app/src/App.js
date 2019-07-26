import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import Home from "./components/home/Home";
import Reservation from './components/reservation/Reservation';
import Profile from './components/profile/Profile';
import Schedule from './components/schedule/Schedule';
import Reschedule from './components/schedule/Reschedule';
import UserProfile from './components/profile/UserProfile';
import Dashboard from "./components/dashboard/Dashboard";
import { Provider } from 'react-redux';
import store from './store';
import Support from "./components/support/Support";



function App() {
  return(
    <Provider store={store}>
        <BrowserRouter>
            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/dashboard" component={Dashboard} />
                <Route path="/support" component={Support}  />
                <Route path="/reservation" component={Reservation} />
                <Route path="/profile" component={Profile} />
                <Route path="/userprofile" component={UserProfile} />
                <Route path="/schedule" component={Schedule} />
                <Route path="/reschedule" component={Reschedule} />
            </Switch>
        </BrowserRouter>
    </Provider>
  );
}

export default App;
