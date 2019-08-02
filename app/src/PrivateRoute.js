import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import Home from './components/home/Home';

export const PrivateRoute = ( {component: Component, isLoggedIn, ...rest}) => (
    <Route exact {...rest} render={props => (
        isLoggedIn === true
        ? <Component {...props} />
        : <Home />
    )} />
)