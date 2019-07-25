import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import Home from "./components/home/Home";
import Reservation from './components/reservation/Reservation';
import Profile from './components/profile/Profile';
import Schedule from './components/schedule/Schedule';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Switch>
          <Route path="/" component={Home} exact />
          <Route path="/reservation" component={Reservation} />
          <Route path="/profile" component={Profile} />
          <Route path="/schedule" component={Schedule} />
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
