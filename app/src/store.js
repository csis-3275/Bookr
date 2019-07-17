import { createStore, applyMiddleware, compose } from 'redux';
import thunk from 'redux-thunk';
import rootReducer from './reducers';

const intialState = {};
const middleWare = [thunk];

const ReactReduxDevTools = window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__();

let store;

if(window.navigator.userAgent.includes("Chrome") && ReactReduxDevTools){
    store = createStore(
        rootReducer, 
        intialState, 
        compose(applyMiddleware(...middleWare), ReactReduxDevTools)
    );
}
else{
    store = createStore(
        rootReducer, 
        intialState, 
        compose(applyMiddleware(...middleWare))
    );
}

export default store;

