import { combineReducers } from 'redux';
import errorsReducer from './errorsReducer';
import userAccountReducer from './userAccountReducer';
import authReducer from './authReducer';

export default combineReducers({
    errors: errorsReducer, 
    // users: userAccountReducer, 
    auth: authReducer
});
