import { USER_CREATED, LOGIN_SUCCESS, LOGOUT_SUCCESS } from "../actions/types";

const initialState = {
    loggedIn: false, 
    currentUser: {}
};

export default function(state = initialState, action) {
    switch(action.type) {
        case LOGIN_SUCCESS:
            return  {
                ...state, 
                loggedIn: true, 
                currentUser: action.payload
            };

        case LOGOUT_SUCCESS:
            return  {
                ...state, 
                loggedIn: false, 
                currentUser: action.payload
            };

        case USER_CREATED:
            return {
                ...state,
                newUser: action.payload,
                createdUser: true
            };

        default: 
            return state;
    }
}