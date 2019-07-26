import axios from "axios";
import { 
    GET_ERRORS, 
    GET_ACCOUNT_INFO, 
    USER_CREATED, 
    USER_UPDATED, 
    USER_LOGGED_IN, 
    USER_LOGGED_OUT, 
    RESERVATION_CREATED, 
    RESERVATION_CANCELLED 
} from "./types";

export const createNewUser = (new_user, history) => async dispatch => {
    try {
        await axios.post("http://localhost:8888/api/users/create_user", new_user);
        history.push("/");

        dispatch({
            type: USER_CREATED, 
            payload: {}
        });

    } catch (err) {
        dispatch({
            type: GET_ERRORS, 
            payload: err.response.data
        });        
    }
}

export const loginUser = (new_user, history) => async dispatch => {
    try {
        await axios.post("http://localhost:8888/api/users/login", new_user);
        history.push("/");

        dispatch({
            type: USER_CREATED, 
            payload: {}
        });

    } catch (err) {
        dispatch({
            type: GET_ERRORS, 
            payload: err.response.data
        });        
    }
}