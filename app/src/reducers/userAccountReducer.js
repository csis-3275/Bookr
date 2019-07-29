import { GET_ACCOUNT_INFO, USER_LOGGED_IN, USER_CREATED, USER_LOGGED_OUT } from "../actions/types";

const initialState = {
    user: []
};

export default function(state = initialState, action) {
    switch(action.type) {
        case GET_ACCOUNT_INFO:
            return  {
                ...state, 
                user: action.payload
            };

        case USER_LOGGED_IN:
            return  {
                ...state, 
                loggedIn: true, 
                user: action.payload
            };

        case USER_LOGGED_OUT:
            return  {
                ...state, 
                loggedIn: false, 
                user: action.payload
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