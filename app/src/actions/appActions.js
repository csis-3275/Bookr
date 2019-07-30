import axios from "axios";
import { 
    GET_ERRORS, 
    USER_CREATED, 
    USER_UPDATED, 
    RESERVATION_CREATED, 
    RESERVATION_CANCELLED, 
    LOGOUT_SUCCESS, 
    LOGIN_SUCCESS, 
    LOGGING_IN, 
    LOGGING_OUT
} from "./types";

export const createNewUser = (new_user, history) => async dispatch => {
    try {
        await axios.post("http://localhost:8888/api/users/create_user", new_user);

        dispatch({
            type: USER_CREATED, 
            payload: {}
        });

    } catch (err) {
        dispatch({
            type: GET_ERRORS, 
            payload: err
        });        
    }
}

export const loginUser = (login_details, history) => async dispatch => {
    try {

        dispatch({
            type: LOGGING_IN
        });

        const response  = await axios.post("http://localhost:8888/api/users/login", login_details);
        

        if(response.data !== null)
        {
            dispatch({
                type: LOGIN_SUCCESS, 
                payload: response.data
            });
            localStorage.setItem('user', JSON.stringify(response.data));
        }


    } catch (err) {   
        dispatch({
            type: GET_ERRORS, 
            payload: err
        })
    }
}

export const logoutUser = () => async dispatch => {
    try {
        dispatch({
            type: LOGGING_OUT
        });

        localStorage.removeItem('user');

        dispatch({
            type: LOGOUT_SUCCESS
        });

    } 
    catch (err) {
        dispatch({
            type: GET_ERRORS, 
            payload: err
        })
    }
}