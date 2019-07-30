import {
    USER_CREATED, 
    USER_UPDATED, 
    LOGGING_IN, 
    LOGGING_OUT, 
    LOGOUT_FAILURE, 
    LOGOUT_SUCCESS,
    LOGIN_FAILURE,  
    LOGIN_SUCCESS, 
    AUTH_ERROR, 
    CREATING_USER, 
    CREATING_USER_FAILED, 
    CLEAR_ERRORS
} from '../actions/types';

const initialState = {
    isAuthenticated: null, 
    isLoading: false, 
    user: null
}

export default function (state=initialState, action)
{
    switch(action.type) {
        case LOGGING_IN: 
            return {
                ...state, 
                isLoading: true
            };

        case LOGIN_SUCCESS: 
            return{
                ...state, 
                isAuthenticated: true, 
                isLoading: false, 
                user: action.payload
            };

        case USER_CREATED: 
            return {
                ...state, 
                ...action.payload, 
                isAuthenticated: true, 
                isLoading: false
            };

        case LOGIN_FAILURE:
        case LOGOUT_SUCCESS:
        case AUTH_ERROR:
        case CREATING_USER_FAILED: 
            return {
                ...state, 
                user: null, 
                isAuthenticated: false, 
                isLoading: false
            };

        default:
            return state;

    }
}