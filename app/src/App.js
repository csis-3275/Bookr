import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import Home from "./components/home/Home";
import Support from "./components/support/Support"

function App() {
  return (
    <div>
        <BrowserRouter>
            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/support" component={Support}  />
            </Switch>
        </BrowserRouter>
    </div>
  );
}

export default App;
