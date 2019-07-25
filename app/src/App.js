import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import Home from "./components/home/Home";
import Reservation from './components/reservation/Reservation';
import Profile from './components/profile/Profile';
import Schedule from './components/schedule/Schedule';
import Reschedule from './components/schedule/Reschedule';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Switch>
          <Route path="/" component={Home} exact />
          <Route path="/reservation" component={Reservation} />
          <Route path="/profile" component={Profile} />
          <Route path="/schedule" component={Schedule} />
          <Route path="/reschedule" component={Reschedule} />>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
