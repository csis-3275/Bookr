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
        await axios.post("http://localhost:8888/api/users/create_user", new_user).then(
            dispatch({
                type: USER_CREATED, 
                payload: {}
            })
        );

        

    } catch (err) {
        dispatch({
            type: GET_ERRORS, 
            payload: err.response.data
        });        
    }
}

export const loginUser = (login_details, history) => async dispatch => {
    try {

        dispatch({
            type: LOGGING_IN
        });

        const response  = await axios.post("http://localhost:8888/api/users/login", login_details);
        

        if(response.data !== null || response.data !== "")
        {
            localStorage.setItem('user', JSON.stringify(response.data));
            
            dispatch({
                type: LOGIN_SUCCESS, 
                payload: response.data
            });
            
        }


    } catch (err) {   
        dispatch({
            type: GET_ERRORS, 
            payload: err.response
        })
    }
}

export const logoutUser = () => async dispatch => {
    try {
        dispatch({
            type: LOGGING_OUT
        });

        await localStorage.removeItem('user');

        await dispatch({
            type: LOGOUT_SUCCESS
        });

    } 
    catch (err) {
        dispatch({
            type: GET_ERRORS, 
            payload: err.response
        })
    }
}